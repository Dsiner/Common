-keep class com.d.lib.common.** {*;}

# ----- ButterKnife -----
-keep class butterknife.** {*;}
-dontwarn butterknife.internal.**
-keep class **$$ViewBinder {*;}
-keepclasseswithmembernames class * {
    @butterknife.* <fields>;
}
-keepclasseswithmembernames class * {
    @butterknife.* <methods>;
}

# ----- nineoldandroids -----
-keep class com.nineoldandroids.** {*;}
-dontwarn com.nineoldandroids.*

# ----- xrv -----
-keep class com.d.lib.xrv.** {*;}
