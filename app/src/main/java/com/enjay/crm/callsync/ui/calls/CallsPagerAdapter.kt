package com.enjay.crm.callsync.ui.calls

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class CallsPagerAdapter(
    fragment: Fragment,
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        val tab = if (position == POSITION_BUSINESS) CallsTab.BUSINESS else CallsTab.PERSONAL
        return CallsPageFragment.newInstance(tab)
    }

    companion object {
        const val POSITION_PERSONAL = 0
        const val POSITION_BUSINESS = 1
    }
}
