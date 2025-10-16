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
    implementation 'com.github.dora4:dview-bottombar:1.10'
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

#### 附录 ⦁ 20套模板设计图
<img width="750" height="750" alt="1" src="https://github.com/user-attachments/assets/347e1ba4-9929-4706-9531-e04f0f217b31" />
<img width="750" height="750" alt="2" src="https://github.com/user-attachments/assets/acf78a49-4fca-4364-a1af-a16fb11c825b" />
<img width="750" height="750" alt="3" src="https://github.com/user-attachments/assets/f8d39aef-9e12-4f39-a505-9777cb741c8e" />
<img width="750" height="750" alt="4" src="https://github.com/user-attachments/assets/abfd8b17-ca52-48af-846b-43298fd26100" />
<img width="750" height="750" alt="5" src="https://github.com/user-attachments/assets/77fcbd3f-f5c1-4624-a100-459211a64ae9" />
<img width="750" height="750" alt="6" src="https://github.com/user-attachments/assets/e4db139e-c51e-4166-8b71-6f705b5bf8aa" />
<img width="750" height="750" alt="7" src="https://github.com/user-attachments/assets/c3570b2d-695a-477c-9238-e5291162c1eb" />
<img width="750" height="750" alt="8" src="https://github.com/user-attachments/assets/03ad0deb-c17c-48c3-99db-284b27c6b97f" />
<img width="750" height="750" alt="9" src="https://github.com/user-attachments/assets/7756a6b8-b7c0-414b-a607-7eb4ab7b22f0" />
<img width="750" height="750" alt="10" src="https://github.com/user-attachments/assets/022071f2-0753-4151-9761-f1f6095cc438" />
<img width="750" height="750" alt="11" src="https://github.com/user-attachments/assets/b1b75766-d12b-4ba6-bcac-a51d888bb3f1" />
<img width="750" height="750" alt="12" src="https://github.com/user-attachments/assets/9dcabfb2-0523-446e-9601-aecf3dcc6669" />
<img width="750" height="750" alt="13" src="https://github.com/user-attachments/assets/505e92fe-01dc-49e7-b4e6-e56b167cb93d" />
<img width="750" height="750" alt="14" src="https://github.com/user-attachments/assets/0646bf76-e07e-4b14-b6a1-e3bf2f85dd54" />
<img width="750" height="750" alt="15" src="https://github.com/user-attachments/assets/f14ebe96-dc2b-4a27-a9df-dc282cf43479" />
<img width="750" height="750" alt="16" src="https://github.com/user-attachments/assets/51fdeb90-8d47-443a-bf6d-dfc7a6295d0a" />
<img width="750" height="750" alt="17" src="https://github.com/user-attachments/assets/b80fb428-3c34-40a9-8478-f8c854b8eae3" />
<img width="750" height="750" alt="18" src="https://github.com/user-attachments/assets/8a60e1e9-8186-4f28-8339-4850640d0eaf" />
<img width="750" height="750" alt="19" src="https://github.com/user-attachments/assets/f81f3fc6-cf0a-46f7-9230-dbfe27ea931c" />
<img width="750" height="750" alt="20" src="https://github.com/user-attachments/assets/82648a9f-a164-46a4-bc2f-cef3339739d6" />



