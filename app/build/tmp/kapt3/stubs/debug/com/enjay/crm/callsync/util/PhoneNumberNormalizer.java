package com.enjay.crm.callsync.util;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004J\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00112\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\f\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0015"}, d2 = {"Lcom/enjay/crm/callsync/util/PhoneNumberNormalizer;", "", "()V", "DEFAULT_REGION", "", "phoneNumberUtil", "Lcom/google/i18n/phonenumbers/PhoneNumberUtil;", "getPhoneNumberUtil", "()Lcom/google/i18n/phonenumbers/PhoneNumberUtil;", "phoneNumberUtil$delegate", "Lkotlin/Lazy;", "digitsOnly", "value", "isViable", "", "lookupKeyBlob", "lookupKeys", "", "normalize", "parse", "Lcom/google/i18n/phonenumbers/Phonenumber$PhoneNumber;", "app_debug"})
public final class PhoneNumberNormalizer {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String DEFAULT_REGION = "IN";
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy phoneNumberUtil$delegate = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.enjay.crm.callsync.util.PhoneNumberNormalizer INSTANCE = null;
    
    private PhoneNumberNormalizer() {
        super();
    }
    
    private final com.google.i18n.phonenumbers.PhoneNumberUtil getPhoneNumberUtil() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String normalize(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
        return null;
    }
    
    public final boolean isViable(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String lookupKeyBlob(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Set<java.lang.String> lookupKeys(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
        return null;
    }
    
    private final com.google.i18n.phonenumbers.Phonenumber.PhoneNumber parse(java.lang.String value) {
        return null;
    }
    
    private final java.lang.String digitsOnly(java.lang.String value) {
        return null;
    }
}