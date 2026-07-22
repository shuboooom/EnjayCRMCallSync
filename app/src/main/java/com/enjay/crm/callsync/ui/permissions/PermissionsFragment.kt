package com.enjay.crm.callsync.ui.permissions

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.enjay.crm.callsync.EnjayCallSyncApp
import com.enjay.crm.callsync.R
import com.enjay.crm.callsync.databinding.FragmentPermissionsBinding
import com.enjay.crm.callsync.ui.common.AppViewModelFactory
import kotlinx.coroutines.launch

class PermissionsFragment : Fragment(R.layout.fragment_permissions) {

    private var _binding: FragmentPermissionsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PermissionsViewModel by viewModels {
        AppViewModelFactory(requireActivity().application)
    }

    private val permissionStateProvider by lazy {
        (requireActivity().application as EnjayCallSyncApp).appContainer.permissionStateProvider
    }

    private var pendingPermission: String? = null

    private val permissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission(),
    ) { granted ->
        val permission = pendingPermission ?: return@registerForActivityResult
        if (!granted && permissionStateProvider.isPermanentlyDenied(this, permission)) {
            showSettingsDialog()
        }
        pendingPermission = null
        viewModel.refreshPermissions()
        updateContinueState()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentPermissionsBinding.bind(view)

        val adapter = PermissionItemAdapter(
            onAllowClicked = { permission ->
                pendingPermission = permission
                viewModel.markRequested(permission)
                permissionLauncher.launch(permission)
            },
        )

        binding.permissionsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.permissionsRecyclerView.adapter = adapter
        binding.continueButton.setOnClickListener {
            if (viewModel.areAllGranted()) {
                findNavController().navigate(R.id.action_permissionsFragment_to_callsFragment)
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.permissions.collect { items ->
                    adapter.submitList(items)
                    updateContinueState()
                    if (viewModel.areAllGranted() && findNavController().currentDestination?.id == R.id.permissionsFragment) {
                        binding.continueButton.post {
                            if (isAdded && findNavController().currentDestination?.id == R.id.permissionsFragment) {
                                findNavController().navigate(R.id.action_permissionsFragment_to_callsFragment)
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.refreshPermissions()
        updateContinueState()
    }

    private fun updateContinueState() {
        binding.continueButton.isEnabled = viewModel.areAllGranted()
    }

    private fun showSettingsDialog() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(R.string.permission_settings_title)
            .setMessage(R.string.permission_settings_message)
            .setPositiveButton(R.string.action_open_settings) { _, _ ->
                val uri = Uri.fromParts("package", requireContext().packageName, null)
                startActivity(Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, uri))
            }
            .setNegativeButton(android.R.string.cancel, null)
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
