------ PermissionCompat Runtime permissions ------

1. Check permissions

```java
PermissionCompat.hasSelfPermissions(activity, permissions)
```

2. Request permissions

```java
        PermissionCompat.with(activity)
                .requestEachCombined(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribeOn(PermissionSchedulers.io())
                .observeOn(PermissionSchedulers.mainThread())
                .requestPermissions(new PermissionCallback<Permission>() {
                    @Override
                    public void onNext(Permission permission) {
                        if (permission.granted) {
                            // All permissions are granted !
                            Toast.makeText(getApplicationContext(), "All permissions are granted", Toast.LENGTH_SHORT).show();
                        } else if (permission.shouldShowRequestPermissionRationale) {
                            // At least one denied permission without ask never again
                            Toast.makeText(getApplicationContext(), "Permission without ask never again", Toast.LENGTH_SHORT).show();
                        } else {
                            // At least one denied permission with ask never again
                            // Need to go to the settings
                            Toast.makeText(getApplicationContext(), "Need to go to the settings", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
```

3. Request permissions in asynchronous thread

```java
PermissionCompat.checkSelfPermissions(activity, new WeakRefSimpleCallback(activity), PERMISSIONS);
```