## ------ Tab使用 ------

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

#### 2. 获取引用
```xml
    @Bind(R.id.sv_tab)
    SegementView svTab;
```

#### 3. 方法
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

#### 2. 获取引用
```xml
    @Bind(R.id.stab_tab)
    ScrollTab stabTab;
```

#### 3. 方法
```xml
    1).setTitles(List<String> ts)
    2).setViewPager(ViewPager viewPager)
    3).setNumber(int position, String text, int visibility)
    4).setOnTabListener(OnTabListener l)
```
