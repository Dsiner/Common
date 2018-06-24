# Common for Android

[![License](https://img.shields.io/badge/license-Apache%202-green.svg)](https://www.apache.org/licenses/LICENSE-2.0)
[![API](https://img.shields.io/badge/API-9%2B-green.svg?style=flat)](https://android-arsenal.com/api?level=9)

>**Common**  一个基于 `MVP` 的开发框架

- [x] MVP
- [x] UI Components
- [x] Auto Loader
- [x] Pager
- [x] Tools

## UI Components

##  =============================
##  ==== TitleLayout标题栏使用 ===
##  =============================
<p>
   <img src="https://github.com/Dsiner/Resouce/blob/master/lib/Common/component-ui-title.png" width="320" alt="Screenshot"/>
</p>

#### 1. Xml布局中添加
```xml
    <com.d.lib.common.view.TitleLayout
        android:id="@+id/tl_title"
        android:layout_width="match_parent"
        android:layout_height="@dimen/lib_pub_dimen_title_height"
        android:background="@color/lib_pub_color_main"
        app:lib_pub_tl_leftDrawable="@drawable/lib_pub_ic_title_back"
        app:lib_pub_tl_middleText="Title" />
```

#### 2. 方法
```xml
    1).findViewById(...)
    2).setOnClickListener(...)
    3).setVisibility(int resId, int visibility)
    4).setText(int resId, CharSequence text)
    5).setOnClickListener(int resId, OnClickListener l)
```

#### 3. 对照表(属性-Id)
| Attrs                         | Id               |
| ----------------------------- |:----------------:|
|    lib_pub_tl_leftText        |  tv_title_left   |
|    lib_pub_tl_leftDrawable    |  iv_title_left   |
|    lib_pub_tl_leftRes         |  reference       |
|    lib_pub_tl_rightText       |  tv_title_right  |
|    lib_pub_tl_rightDrawable   |  iv_title_right  |
|    lib_pub_tl_rightRes        |  reference       |
|    lib_pub_tl_middleText      |  tv_title_title  |
|    lib_pub_tl_middleDrawable  |  iv_title_middle |
|    lib_pub_tl_middleRes       |  reference       |



## =============================
## ==== DSLayout默认态使用 ===
## =============================
<p>
   <img src="https://github.com/Dsiner/Resouce/blob/master/lib/Common/component-ui-ds.gif" width="320" alt="Screenshot"/>
</p>

#### 1. Xml布局中添加
```xml
    <com.d.lib.common.view.DSLayout
        android:id="@+id/dsl_ds"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
```

#### 2. 设置默认态
```xml
    1).dslDs.setState(DSLayout.STATE_LOADING);
    ------DSLayout.GONE：隐藏默认态
        ------DSLayout.STATE_LOADING：正在加载...
                ------DSLayout.STATE_EMPTY：暂无数据
                        ------DSLayout.STATE_NET_ERROR：网络错误
```

#### 3. 更改默认内容（可选）
```xml
    dslDs.setState(DSLayout.STATE_NET_ERROR)
        .icon(R.drawable.ic_net_failed)
        .desc("暂无网络")
        .button("点击重试",View.VISIBLE);

        ------------ 对照表(Func-Desc) -----------
        .gif(...)     |  加载Gif图：本地或网络
        .icon(...)    |  加载Png图: 本地或网络
        .desc(...)    |  状态描述内容
        .button(...)  |  按钮文本内容、按钮是否显示
```

#### 4. 矫正垂直比例（可选，默认垂直居中）
| Attrs                         | Description               |
| ----------------------------- |:----------------:|
|    lib_pub_dsl_adjustHeightT  |  顶部矫正高度    |
|    lib_pub_dsl_adjustHeightB  |  底部矫正高度    |

#### 5. 替换默认布局样式（可选）
```xml
    1).拷贝 R.layout.layout_ds 为 R.layout.layout_ds_style_custom，
    2).仅允许更改属性（大小、相对位置、色值、背景等），禁止更改id、布局结构
    3).app:lib_pub_dsl_layout="@layout/layout_dsl_style_custom"
```



## =============================
## ==== RowLayout设置行使用 ===
## =============================
<p>
   <img src="https://github.com/Dsiner/Resouce/blob/master/lib/Common/component-ui-row.png" width="320" alt="Screenshot"/>
</p>

#### 1. Xml布局中添加
```xml
    <com.d.lib.common.view.RowLayout
        android:id="@+id/rl_row"
        android:layout_width="match_parent"
        android:layout_height="@dimen/lib_pub_dimen_row_height"
        android:background="@color/lib_pub_color_bg_main"
        app:lib_pub_rl_gotoVisibility="visible"
        app:lib_pub_rl_icon="@color/lib_pub_color_red"
        app:lib_pub_rl_text="@string/component_ui_dialog_title"
        app:lib_pub_rl_toggleVisibility="gone" />
```

#### 2. 设置文本内容(app:lib_pub_rl_text)
```xml
    1).rlRow.setText("content");
```

#### 3. 设置红点文本内容
```xml
    rlRow.setNumber("9", View.VISIBLE)
```

#### 4. Toggle按钮(app:lib_pub_rl_toggleVisibility)
```xml
    1).setOpen() ------设置开闭
    2).isOpen() ------开闭状态
    3).setOnToggleListener() ------监听toggle开闭状态
```



## =============================
## ==== Tab使用 ===
## =============================
<p>
   <img src="https://github.com/Dsiner/Resouce/blob/master/lib/Common/component-ui-tab.gif" width="320" alt="Screenshot"/>
</p>

### 一、SegementView
----------------------------------------------------------------------------------------------------
#### 1. Xml布局中添加
```xml
    <com.d.lib.common.view.SegementView
        android:id="@+id/sv_tab"
        android:layout_width="match_parent"
        android:layout_height="27dp"
        android:layout_marginTop="@dimen/lib_pub_dimen_margin"
        app:lib_pub_segementv_borderWidth="1dp"
        app:lib_pub_segementv_colorMain="@color/lib_pub_color_main"
        app:lib_pub_segementv_colorSub="@color/lib_pub_color_white"
        app:lib_pub_segementv_divideWidth="1dp"
        app:lib_pub_segementv_radius="4dp"
        app:lib_pub_segementv_textSize="@dimen/lib_pub_dimen_text_small"
        app:lib_pub_segementv_titles="标签一;标签二;标签三;标签四" />
```

#### 2. 方法
```xml
    1).setTitle(String[] title)
    2).select(int index)
    3).setOnSelectedListener(OnSelectedListener listener)
```

### 二、ScrollTab
----------------------------------------------------------------------------------------------------
#### 1. Xml布局中添加
```xml
    <com.d.lib.common.view.tab.ScrollTab
        android:id="@+id/stab_tab"
        android:layout_width="match_parent"
        android:layout_height="40dp"
        android:layout_marginTop="@dimen/lib_pub_dimen_margin"
        android:background="#F9F9F9"
        android:orientation="vertical"
        app:lib_pub_stab_avag="true"
        app:lib_pub_stab_indicatorColor="@color/lib_pub_color_main"
        app:lib_pub_stab_indicatorRadius="0dp"
        app:lib_pub_stab_indicatorType="none"
        app:lib_pub_stab_indicatorWeight="2dp"
        app:lib_pub_stab_indicatorWidth="65dp"
        app:lib_pub_stab_titles="@string/component_ui_labels"
        app:lib_pub_stab_type="view_group" />
```

#### 2. 方法
```xml
    1).setTitles(List<String> ts)
    2).setViewPager(ViewPager viewPager)
    3).setNumber(int position, String text, int visibility)
    4).setOnTabListener(OnTabListener l)
```



## =============================
## ==== Alert使用 ===
## =============================
<p>
   <img src="https://github.com/Dsiner/Resouce/blob/master/lib/Common/component-ui-alert.gif" width="320" alt="Screenshot"/>
</p>

#### 1. Loading...
----------------------------------------------------------------------------------------------------
```xml
        AlertDialogFactory.createFactory(activity).getLoadingDialog("Loading...");
```

#### 2. AlertDialog
----------------------------------------------------------------------------------------------------
```xml
        AlertDialogFactory.createFactory(activity).getAlertDialog("Title",
                "Content",
                "Ok", "Cancel",
                new AlertDialogFactory.OnClickListener() {
                    @Override
                    public void onClick(AlertDialog dlg, View v) {

                    }
                }, new AlertDialogFactory.OnClickListener() {
                    @Override
                    public void onClick(AlertDialog dlg, View v) {

                    }
                });
```

#### 3. AlertSubDialog
----------------------------------------------------------------------------------------------------
```xml
        AlertDialogFactory.createFactory(activity).getAlertSubDialog("Title",
                "Content",
                "Sub tips",
                true, new AlertSubDialog.OnCheckListener() {
                    @Override
                    public void onSubmit(Dialog dlg, boolean isChecked) {

                    }

                    @Override
                    public void onCancel(Dialog dlg) {

                    }
                });
```

#### 4. EditDialog
----------------------------------------------------------------------------------------------------
```xml
        AlertDialogFactory.createFactory(activity).getEditDialog("Title",
                "Content",
                new EditDialog.OnEditListener() {
                    @Override
                    public void onSubmit(Dialog dlg, String content) {

                    }

                    @Override
                    public void onCancel(Dialog dlg) {

                    }
                });
```

#### 5. InfoDialog
----------------------------------------------------------------------------------------------------
```xml
        AlertDialogFactory.createFactory(activity).getInfoDialog("Title",
                Arrays.asList(new InfoDialog.Bean("1", "" + 1111111),
                        new InfoDialog.Bean("2", "" + 2222222),
                        new InfoDialog.Bean("3", "" + 3333333),
                        new InfoDialog.Bean("4", "" + 4444444),
                        new InfoDialog.Bean("5", "" + 5555555)));
```

#### 6. OperationDialog
----------------------------------------------------------------------------------------------------
```xml
        AlertDialogFactory.createFactory(activity).getOperationDialog("Content",
                Arrays.asList(new OperationDialog.Bean("普通操作1", R.color.lib_pub_color_main, false),
                        new OperationDialog.Bean("普通操作2", R.color.lib_pub_color_main, false)),
                new AbsSheetDialog.OnItemClickListener() {
                    @Override
                    public void onClick(Dialog dlg, int position, String item) {

                    }

                    @Override
                    public void onCancel(Dialog dlg) {

                    }
                });
```



## =============================
## ==== Sheet使用 ===
## =============================
<p>
   <img src="https://github.com/Dsiner/Resouce/blob/master/lib/Common/component-ui-sheet.gif" width="320" alt="Screenshot"/>
</p>

#### 1. BottomVerDialog
----------------------------------------------------------------------------------------------------
```xml
        AlertDialogFactory.createFactory(this).getBottomVerDialog("告知当前状态，信息和解决方案单行",
                Arrays.asList(new BottomVerSheetDialog.Bean("普通操作1", R.color.lib_pub_color_text_main, false),
                        new BottomVerSheetDialog.Bean("普通操作2", R.color.lib_pub_color_text_main, false),
                        new BottomVerSheetDialog.Bean("普通操作3", R.color.lib_pub_color_text_main, false),
                        new BottomVerSheetDialog.Bean("危险操作", R.color.lib_pub_color_red, false),
                        new BottomVerSheetDialog.Bean("不可用操作", R.color.lib_pub_color_text_hint, false)),
                new AbsSheetDialog.OnItemClickListener() {
                    @Override
                    public void onClick(Dialog dlg, int position, String item) {

                    }

                    @Override
                    public void onCancel(Dialog dlg) {

                    }
                });
```

#### 2. BottomHorDialog
----------------------------------------------------------------------------------------------------
```xml
        AlertDialogFactory.createFactory(this).getBottomHorDialog("分享",
                Arrays.asList(new BottomHorSheetDialog.Bean("QQ", R.drawable.lib_pub_circle_msg_number),
                        new BottomHorSheetDialog.Bean("微信", R.drawable.lib_pub_circle_msg_number),
                        new BottomHorSheetDialog.Bean("朋友圈", R.drawable.lib_pub_circle_msg_number),
                        new BottomHorSheetDialog.Bean("微博", R.drawable.lib_pub_circle_msg_number),
                        new BottomHorSheetDialog.Bean("短信", R.drawable.lib_pub_circle_msg_number)),
                new AbsSheetDialog.OnItemClickListener() {
                    @Override
                    public void onClick(Dialog dlg, int position, String item) {

                    }

                    @Override
                    public void onCancel(Dialog dlg) {

                    }
                });
```

#### 3. BottomShareDialog
----------------------------------------------------------------------------------------------------
```xml
        AlertDialogFactory.createFactory(this).getBottomShareDialog("文件名",
                Arrays.asList(new BottomShareSheetDialog.Bean("链接地址: ", "https://www.baidu.com/link?url=eZH1yw2u1h-CNrpm7Q3jD_EfVnUxwUuBHlTGhLlA_KfhwtG0TGSl4a7kPsJNMqE8&wd=&eqid=f50ccdfc00009400000000065b232f14"),
                        new BottomShareSheetDialog.Bean("提取密码: ", "3854", false)));
```



<p>
   <img src="https://github.com/Dsiner/Resouce/blob/master/lib/Common/component-ui-status.png" width="320" alt="Screenshot"/>
</p>

## =============================
## ==== Popup使用 ===
## =============================

#### 1. MenuPopup
----------------------------------------------------------------------------------------------------
```xml
        PopupWindowFactory.createFactory(this)
                .getMenuPopup(Arrays.asList(new MenuPopup.Bean("添加", R.color.lib_pub_color_text_hint, false),
                        new MenuPopup.Bean("删除", R.color.lib_pub_color_main, false)), new MenuPopup.OnMenuListener() {
                    @Override
                    public void onClick(PopupWindow popup, int position, String item) {

                    }
                }).showAsDropDown(ivMenu);
```



## =============================
## ==== NoticeLayout使用 ===
## =============================

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

#### 2. 方法
```xml
    1).findViewById(...)
    2).setOnClickListener(...)
    3).setVisibility(int resId, int visibility)
    4).setText(int resId, CharSequence text)
    5).setOnClickListener(int resId, OnClickListener l)
```



## =============================
## ==== NoticeLayout使用 ===
## =============================

#### 1. Xml布局中添加
```xml
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
```

#### 2. 方法
```xml
    1).setText(CharSequence text)
    2).setTextAdj(CharSequence text)
```

#### 3. 对照表(属性-描述)
| Attrs                         | Description      |
| ----------------------------- |:----------------:|
|    lib_pub_badgev_color       |  角标背景色      |
|    lib_pub_badgev_circle      |  是否限定圆形    |
|    lib_pub_badgev_radius      |  椭圆圆角弧度    |
|    lib_pub_badgev_max         |  最大显示限定数  |



## Auto Loader & Pager
<p>
   <img src="https://github.com/Dsiner/Resouce/blob/master/lib/Common/common.gif" width="320" alt="Screenshot"/>
</p>

More usage see [Wiki](https://github.com/Dsiner/Common/wiki)

## Licence

```txt
Copyright 2018 D

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
