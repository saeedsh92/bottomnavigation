# BottomNavigation
Bottom navigation inspired by google material design guideline.
<img src="https://github.com/saeedsh92/bottomnavigation/blob/master/demo_banner.png?raw=false" width="700">
## Phone Mode
<img src="https://github.com/saeedsh92/bottomnavigation/blob/master/port_dynamic.png?raw=false" width="350">
<img src="https://github.com/saeedsh92/bottomnavigation/blob/master/port_fixed.png?raw=false" width="350">
## Tablet Mode
<img src="https://github.com/saeedsh92/bottomnavigation/blob/master/land_dynamic.png?raw=false" width="700">
<img src="https://github.com/saeedsh92/bottomnavigation/blob/master/land_fixed.png?raw=false" width="700">
## How to download
### Gradle: 
add this line to your module build.gradle dependecies block:

    compile 'com.ss.bottomnavigation:bottomnavigation:1.5.2'

### Maven
    <dependency>
      <groupId>com.ss.bottomnavigation</groupId>
      <artifactId>bottomnavigation</artifactId>
      <version>1.5.2</version>
      <type>pom</type>
    </dependency>

## How use this lib
### XML
Currenly the only way to customize bottom navigation is using xml. you can add bottom navigation to your activity like this:
```xml
         <com.ss.bottomnavigation.BottomNavigation
            android:id="@+id/bottom_navigation"
            android:layout_width="match_parent"
            android:layout_height="56dp"
            android:layout_alignParentBottom="true"
            android:background="@color/colorPrimary">
            <com.ss.bottomnavigation.TabItem
                android:id="@+id/tab_home"
                android:layout_width="0dp"
                android:layout_height="match_parent"
                android:layout_weight="1"
                app:tab_text="Home"
                app:tab_icon="@drawable/ic_home_white_24dp"
                />
            <com.ss.bottomnavigation.TabItem
                android:id="@+id/tab_images"
                android:layout_width="0dp"
                android:layout_height="match_parent"
                android:layout_weight="1"
                app:tab_text="Images"
                app:tab_icon="@drawable/ic_image_black_24dp"
                />
            <com.ss.bottomnavigation.TabItem
                android:id="@+id/tab_camera"
                android:layout_width="0dp"
                android:layout_height="match_parent"
                android:layout_weight="1"
                app:tab_text="Camera"
                app:tab_icon="@drawable/ic_camera_white_24dp"
                />
            <com.ss.bottomnavigation.TabItem
                android:id="@+id/tab_products"
                android:layout_width="0dp"
                android:layout_height="match_parent"
                android:layout_weight="1"
                app:tab_text="Products"
                app:tab_icon="@drawable/ic_products_white_24dp"
                />
            <com.ss.bottomnavigation.TabItem
                android:id="@+id/tab_more"
                android:layout_width="0dp"
                android:layout_height="match_parent"
                android:layout_weight="1"
                app:tab_text="More"
                app:tab_icon="@drawable/ic_more_white_24dp"
                />
         </com.ss.bottomnavigation.BottomNavigation>
```
if you want change bottom navigation mode, you must change it like below:

    app:mode="phone"
    
or

    app:mode="tablet"
    
### Examples
Phone Mode:

 ```xml
    <com.ss.bottomnavigation.BottomNavigation
        android:id="@+id/bottom_navigation"
        android:layout_width="match_parent"
        android:layout_height="56dp"
        android:layout_alignParentBottom="true"
        android:background="@color/colorPrimary"
        app:mode="phone">
```
Tablet Mode:

```xml
    <com.ss.bottomnavigation.BottomNavigation
        android:id="@+id/bottom_navigation"
        android:layout_width="match_parent"
        android:layout_height="56dp"
        android:layout_alignParentBottom="true"
        android:background="@color/colorPrimary"
        app:mode="tablet">
```

### Java
You can set onSelectedItemChangeListener in java like this:

notice: all tab items in xml must have id to determinate which item is selected.

```java
BottomNavigation bottomNavigation=(BottomNavigation)findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnSelectedItemChangeListener(new OnSelectedItemChangeListener() {
            @Override
            public void onSelectedItemChanged(int itemId) {
                switch (itemId){
                    case R.id.tab_home:
                        transaction=getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_fragment_containers,new FragmentA());
                        break;
                    case R.id.tab_images:
                        transaction=getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_fragment_containers,new FragmentB());
                        break;
                    case R.id.tab_camera:
                        transaction=getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_fragment_containers,new FragmentF());
                        break;
                    case R.id.tab_products:
                        transaction=getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_fragment_containers,new FragmentC());
                        break;
                    case R.id.tab_more:
                        transaction=getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_fragment_containers,new FragmentD());
                        break;
                }
                transaction.commit();
            }
        });
```
### Change default item
you can change default selected tab item by add this line to your code (before setOnSelectedItemChangeListener):

```java
    bottomNavigation.setDefaultItem(1); // change default selected tab item by position
```

### Set custom font
for set custom font on bottom navigation, you simply need add this line to your code:
```java
    bottomNavigation.setTypeface(myTypeface);
```

## License
Copyright 2016 Saeed shahini

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

## Author
Saeed shahini

email: saeedshahiniit@gmail.com

github: https://github.com/saeedsh92
