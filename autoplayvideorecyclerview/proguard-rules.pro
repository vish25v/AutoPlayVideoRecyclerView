-optimizationpasses 5
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-dontpreverify
-verbose


-keep class rx.schedulers.Schedulers {
    public static <methods>;
}
-keep class rx.schedulers.ImmediateScheduler {
    public <methods>;
}
-keep class rx.schedulers.TestScheduler {
    public <methods>;
}
-keep class rx.schedulers.Schedulers {
    public static ** test();
}
-keepclassmembers class rx.internal.util.unsafe.*ArrayQueue*Field* {
    long producerIndex;
    long consumerIndex;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueProducerNodeRef {
    long producerNode;
    long consumerNode;
}

-keep public class com.hoanganhtuan95ptit.autoplayvideorecyclerview.** {*; }

-keep, allowobfuscation class com.hoanganhtuan95ptit.autoplayvideorecyclerview.*
-keepclassmembers, allowobfuscation class * {
    *;
}

-keepnames class com.hoanganhtuan95ptit.autoplayvideorecyclerview.AutoPlayVideoRecyclerView
-keepclassmembernames class com.hoanganhtuan95ptit.autoplayvideorecyclerview.AutoPlayVideoRecyclerView{
    public <methods>;
    public <fields>;
}