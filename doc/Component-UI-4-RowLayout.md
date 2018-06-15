------ RowLayout设置行使用 ------

1.Xml布局中添加
    <com.d.lib.common.view.RowLayout
        android:id="@+id/rl_row"
        android:layout_width="match_parent"
        android:layout_height="@dimen/lib_pub_dimen_row_height"
        android:background="@color/lib_pub_color_bg_main"
        app:lib_pub_rl_gotoVisibility="visible"
        app:lib_pub_rl_icon="@color/lib_pub_color_red"
        app:lib_pub_rl_text="@string/component_ui_dialog_title"
        app:lib_pub_rl_toggleVisibility="gone" />

2.获取引用
    @Bind(R.id.rl_row)
    TitleLayout rlRow;

3.设置文本内容(app:lib_pub_rl_text)
    1).rlRow.setText("content");

4.设置红点文本内容
    rlRow.setNumber("9", View.VISIBLE)

5.Toggle按钮(app:lib_pub_rl_toggleVisibility)
    1).setOpen() ------设置开闭
    2).isOpen() ------开闭状态
    3).setOnToggleListener() ------监听toggle开闭状态
