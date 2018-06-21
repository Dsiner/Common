------ NoticeLayout使用 ------

1.Xml布局中添加
    <com.d.lib.common.view.BadgeView
        android:id="@+id/bv_badge"
        android:layout_width="wrap_content"
        android:layout_height="20dp"
        android:gravity="center"
        android:minWidth="20dp"
        android:paddingLeft="4dp"
        android:paddingRight="4dp"
        android:textColor="@color/lib_pub_color_white"
        android:textSize="10dp"
        app:lib_pub_badgev_color="@color/lib_pub_color_red" />

2.获取引用
    @Bind(R.id.bv_badge)
    BadgeView bvBadge;

3.方法
    1).setText(CharSequence text)
    2).setTextAdj(CharSequence text)

4.对照表(属性-描述)
    lib_pub_badgev_color     |  角标背景色
    lib_pub_badgev_circle    |  是否限定圆形
    lib_pub_badgev_radius    |  椭圆圆角弧度
    lib_pub_badgev_max       |  最大显示限定数
