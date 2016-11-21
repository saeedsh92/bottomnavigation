# BottomNavigation
Bottom navigation inspired by google material design guideline.

<img src="https://github.com/saeedsh92/bottomnavigation/blob/master/Screenshot_1479215016.png?raw=false" width="350">
<img src="https://github.com/saeedsh92/bottomnavigation/blob/master/Screenshot_1479541545.png?raw=false" width="350">

## How to download
### Gradle: 
add this line to your module build.gradle dependecies block:

    compile 'com.ss.bottomnavigation:bottomnavigation:1.0'

## How use this lib
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

## Author
Saeed shahini

email: saeedshahiniit@gmail.com

github: https://github.com/saeedsh92
