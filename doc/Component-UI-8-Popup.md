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
