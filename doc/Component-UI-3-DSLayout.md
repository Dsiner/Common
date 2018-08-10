## ------ DSLayout默认态使用 ------

#### 1. Xml布局中添加
```xml
    <com.d.lib.common.view.DSLayout
        android:id="@+id/dsl_ds"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
```

#### 2. 获取引用
```xml
    @Bind(R.id.dsl_ds)
    DSLayout dslDs;
```

#### 3. 设置默认态
```xml
    1).dslDs.setState(DSLayout.STATE_LOADING);
    ------DSLayout.GONE：隐藏默认态
        ------DSLayout.STATE_LOADING：正在加载...
                ------DSLayout.STATE_EMPTY：暂无数据
                        ------DSLayout.STATE_NET_ERROR：网络错误
```

#### 4. 更改默认内容（可选）
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

#### 5. 矫正垂直比例（可选，默认垂直居中）
| Attrs                         | Description               |
| ----------------------------- |:----------------:|
|    lib_pub_dsl_adjustHeightT  |  顶部矫正高度    |
|    lib_pub_dsl_adjustHeightB  |  底部矫正高度    |

#### 6. 替换默认布局样式（可选）
```xml
    1).拷贝 R.layout.layout_ds 为 R.layout.layout_ds_style_custom，
    2).仅允许更改属性（大小、相对位置、色值、背景等），禁止更改id、布局结构
    3).app:lib_pub_dsl_layout="@layout/layout_dsl_style_custom"
```
