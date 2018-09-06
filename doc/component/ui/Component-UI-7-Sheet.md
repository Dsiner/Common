## ------ Sheet使用 ------

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
