# BottomNavigation
Bottom navigation inspired by google material design guideline.

<img src="https://github.com/saeedsh92/bottomnavigation/blob/master/Screenshot_1479215016.png?raw=false" width="350">
<img src="https://github.com/saeedsh92/bottomnavigation/blob/master/Screenshot_1479541545.png?raw=false" width="350">

## How to download
### Gradle: 
add this line to your module build.gradle dependecies block:

    compile 'com.ss.bottomnavigation:bottomnavigation:1.4'

### Maven
    <dependency>
      <groupId>com.ss.bottomnavigation</groupId>
      <artifactId>bottomnavigation</artifactId>
      <version>1.4</version>
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
## Author
Saeed shahini

email: saeedshahiniit@gmail.com

github: https://github.com/saeedsh92
