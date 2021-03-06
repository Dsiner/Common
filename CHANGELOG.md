# Changelog #
--------------------------------

## Version 2.0.0 ##
--------------------------------
### Build Changes ###
- Migrate to AndroidX
- Updated target SDK to 26
- Update `Glide` to 4.11.0
- Update `PullLayout` to 2.0.0



## Version 1.2.1 ##
--------------------------------
### Build Changes ###
- Update `PullLayout` to 1.0.4



## Version: 1.2.0 ##
--------------------------------
### Changes ###

There are too many changes to list individually, but here's a few highlights:

- package `com.d.lib.common.view` --> package `com.d.lib.common.widget`
- package `com.d.lib.common.component.loader.v4`
  - `AbsFragment` --> `BaseLoaderFragment`
  - `AbsLazyFragment` --> `BaseLazyLoaderFragment`
  - `AbsPageFragment` --> `BasePagerFragment`
  - `AbsPageFragmentActivity` --> `BasePagerFragmentActivity`
- package `com.d.lib.common.component.loader.v7`
  - `AbsAppCompatActivity` --> `BasePagerAppCompatActivity`
- package `com.d.lib.common.component.loader`
  - `IAbsView` --> `MvpBaseLoaderView`
  - `AbsPresenter` --> `MvpBaseLoaderPresenter`
- R
  - `R.layout.lib_pub_activity_abs` --> `R.layout.lib_pub_activity_loader`
  - `R.layout.lib_pub_activity_abs_content` --> `R.layout.lib_pub_activity_loader_content`
  - `R.layout.lib_pub_activity_abs_frg` --> `R.layout.lib_pub_activity_loader_fragment`
  - `R.layout.lib_pub_activity_abs_page` --> `R.layout.lib_pub_activity_pager`
  - `R.layout.lib_pub_fragment_abs` --> `R.layout.lib_pub_fragment_loader`
  - `R.layout.lib_pub_fragment_abs_page` --> `R.layout.lib_pub_fragment_pager`

### Build Changes ###
- Update `Gson` to 2.8.5
- Update `Glide` to 4.9.0
- Update `PullLayout` to 1.0.3
- Update `PermissionCompat` to 1.0.3



## Version 1.1.1 ##
--------------------------------
### Changes ###
#### Rename
- `ViewHelper.findView()` --> `ViewHelper.findViewById()`
- `ViewHelper.setOnClick()` --> `ViewHelper.setOnClickListener()`

### Build Changes ###
- Update `PullLayout` to 1.0.1



## Version 1.1.0 ##
--------------------------------
### Changes ###
#### Rename
- `MvpBaseView.showLoading()` --> `MvpBaseView.showLoadingDialog()`
- `MvpBaseView.closeLoading()` --> `MvpBaseView.dismissLoadingDialog()`
- `IAbsView.setData()` --> `IAbsView.loadSuccess()`

### Build Changes ###
- Update `minSdkVersion` to 11
- Update `PullLayout` to 1.0.0



## Version 1.0.0 ##
--------------------------------
- Initial Build