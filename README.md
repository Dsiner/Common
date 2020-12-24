# Common for Android

[![License](https://img.shields.io/badge/license-Apache%202-green.svg)](https://www.apache.org/licenses/LICENSE-2.0)
[![API](https://img.shields.io/badge/API-9%2B-green.svg?style=flat)](https://android-arsenal.com/api?level=11)
[![Download](https://api.bintray.com/packages/dsiner/maven/common/images/download.svg) ](https://bintray.com/dsiner/maven/common/_latestVersion)
[![Wiki-Guide](https://img.shields.io/badge/Wiki-Guide-brightgreen.svg)](https://github.com/Dsiner/Common/wiki)

>Common is a basic component library for android.

## Set up
Maven:
```xml
<dependency>
  <groupId>com.dsiner.lib</groupId>
  <artifactId>common</artifactId>
  <version>1.2.0</version>
</dependency>
```
or Gradle:
```groovy
implementation 'com.dsiner.lib:common:1.2.0'
```

## Module
- `lib`  -  Core
- `app`  -  Guide module
- `module_ui`  - Business module
- `module_mvp`  - Business module
- `module_loader`  - Business module

`lib` is the core library that contains the basic components.

`module_ui`, `module_mvp`, `...` are business modules, you can also call them business subcontracting, here are examples of the use of each component in `lib` .

## Framework
- [x] **UI**
    - [x] UI Components
    - [x] MVP Base
    - [x] MVP Customization
    - [x] Auto Loader
    - [x] Auto Pager
- [x] **Data**
    - [x] Data
    - [x] SharePreference
    - [x] [DataBase](https://github.com/Dsiner/AndroidOrm)
- [x] **Event**
    - [x] Bus
    - [x] [EventBus](https://github.com/greenrobot/EventBus)
- [x] **Network**
    - [x] [Aster](https://github.com/Dsiner/Aster)
- [x] **Thread**
    - [x] [TaskScheduler](https://github.com/Dsiner/TaskScheduler)
    - [x] [RxJava](https://github.com/ReactiveX/RxJava)
- [x] **Components**
    - [x] [PullLayout](https://github.com/Dsiner/PullLayout) - Pull down refresh, load more
    - [x] [Cache](https://github.com/Dsiner/Cache) - Cache
    - [x] [Glide](https://github.com/bumptech/glide) - Image Loading
    - [x] [PermissionCompat](https://github.com/Dsiner/PermissionCompat) - Runtime permissions
- [x] **Tools**

## Screenshot
<p>
   <img src="https://github.com/Dsiner/Resouce/blob/master/lib/Common/common.gif" width="320" alt="Screenshot"/>
</p>

More usage see [Wiki.](https://github.com/Dsiner/Common/wiki)

## Latest Changes
- [Changelog.md](CHANGELOG.md)

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
