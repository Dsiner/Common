------ Popup使用 ------
1.MenuPopup
----------------------------------------------------------------------------------------------------
        PopupWindowFactory.createFactory(activity)
                .getMenuPopup(Arrays.asList(new MenuPopup.Bean("添加", R.color.lib_pub_color_text_hint, false),
                        new MenuPopup.Bean("删除", R.color.lib_pub_color_main, false)))
                .showAsDropDown(ivMenu);
