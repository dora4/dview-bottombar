dview-bottombar
![Release](https://jitpack.io/v/dora4/dview-bottombar.svg)
--------------------------------

#### 卡片
![DORA视图 界面传送门](https://github.com/user-attachments/assets/4474df90-817e-48a5-9dfb-0efca43f68b8)

#### Gradle依赖配置

```groovy
// 添加以下代码到项目根目录下的build.gradle
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
// 添加以下代码到app模块的build.gradle
dependencies {
    implementation 'com.github.dora4:dview-bottombar:1.0'
}
```

#### 使用方式
```xml
<resources>
    <array name="tab_lottie_normal">
        <item>@raw/tab_one_normal</item>
        <item>@raw/tab_two_normal</item>
        <item>@raw/tab_three_normal</item>
        <item>@raw/tab_four_normal</item>
    </array>
    <array name="tab_lottie_selected">
        <item>@raw/tab_one_selected</item>
        <item>@raw/tab_two_selected</item>
        <item>@raw/tab_three_selected</item>
        <item>@raw/tab_four_selected</item>
    </array>
    <string-array name="tab_titles">
        <item>Tab1</item>
        <item>Tab2</item>
        <item>Tab3</item>
        <item>Tab4</item>
    </string-array>
</resources>
```

```xml
<dora.widget.DoraBottomBar
    android:id="@+id/doraBottomBar"
    android:layout_width="match_parent"
    android:layout_height="56dp"
    app:dview_bb_tabCount="4"
    app:dview_bb_lottieNormal="@array/tab_lottie_normal"
    app:dview_bb_lottieSelected="@array/tab_lottie_selected"
    app:dview_bb_tabTitles="@array/tab_titles"
    app:dview_bb_textColorNormal="#888888"
    app:dview_bb_textColorSelected="#FF0000"
    app:dview_bb_defaultIndex="0" />
```

```kotlin
bottomBar.setOnTabSelectedListener(object : DoraBottomBar.OnTabSelectedListener {
    override fun onTabSelected(index: Int) {
        when (index) {
            0 -> showTabOne()
            1 -> showTabTwo()
            2 -> showTabThree()
            3 -> showTabFour()
        }
    }
})
```

