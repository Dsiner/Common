## ------ NoticeLayout使用 ------

#### 1.Xml布局中添加
```xml
    <com.d.lib.common.view.NoticeLayout
        android:id="@+id/notice_tips"
        android:layout_width="match_parent"
        android:layout_height="40dp"
        android:layout_marginLeft="@dimen/lib_pub_dimen_margin"
        android:layout_marginRight="@dimen/lib_pub_dimen_margin"
        app:lib_pub_noticel_exitVisibility="gone"
        app:lib_pub_noticel_gotoVisibility="visible"
        app:lib_pub_noticel_text="@string/component_ui_notice_type1" />
```

#### 2. 获取引用
```xml
    @Bind(R.id.notice_tips)
    NoticeLayout noticeTips;
```

#### 3. 方法
```xml
    1).findViewById(...)
    2).setOnClickListener(...)
    3).setVisibility(int resId, int visibility)
    4).setText(int resId, CharSequence text)
    5).setOnClickListener(int resId, OnClickListener l)
```
