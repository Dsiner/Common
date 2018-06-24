## =============================
## ==== Alert使用 ===
## =============================

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
