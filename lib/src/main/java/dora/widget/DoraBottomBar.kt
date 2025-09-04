
package dora.widget

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView
import dora.widget.bottombar.R

class DoraBottomBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    interface OnTabSelectedListener {
        fun onTabSelected(index: Int)
    }

    private var tabCount: Int = 2
    private var normalRes: IntArray = intArrayOf()
    private var selectedRes: IntArray = intArrayOf()
    private var titles: Array<String> = arrayOf()
    private var colorNormal: Int = 0
    private var colorSelected: Int = 0
    private var currentIndex: Int = -1
    private var textSize: Float = 12f
    private var iconTextMargin: Int = 4

    private val iconViews = mutableListOf<LottieAnimationView>()
    private val titleViews = mutableListOf<TextView>()
    private var listener: OnTabSelectedListener? = null

    init {
        orientation = HORIZONTAL
        gravity = Gravity.CENTER
        LayoutInflater.from(context)
            .inflate(R.layout.dview_layout_bottom_bar, this, true)

        attrs?.let {
            val ta = context.obtainStyledAttributes(it, R.styleable.DoraBottomBar)
            tabCount = ta.getInt(R.styleable.DoraBottomBar_dview_bb_tabCount, 2)
                .coerceIn(2, 6)
            normalRes = getResIdArray(ta, R.styleable.DoraBottomBar_dview_bb_lottieNormal)
            selectedRes = getResIdArray(ta, R.styleable.DoraBottomBar_dview_bb_lottieSelected)
            titles = getStringArray(ta, R.styleable.DoraBottomBar_dview_bb_tabTitles)
            colorNormal = ta.getColor(
                R.styleable.DoraBottomBar_dview_bb_textColorNormal,
                0xFF888888.toInt()
            )
            colorSelected = ta.getColor(
                R.styleable.DoraBottomBar_dview_bb_textColorSelected,
                0xFF000000.toInt()
            )
            currentIndex = ta.getInt(R.styleable.DoraBottomBar_dview_bb_defaultIndex, 0)
            textSize = ta.getDimension(
                R.styleable.DoraBottomBar_dview_bb_textSize,
                12f * resources.displayMetrics.scaledDensity
            )
            iconTextMargin = ta.getDimensionPixelSize(
                R.styleable.DoraBottomBar_dview_bb_iconTextMargin,
                (4 * resources.displayMetrics.density).toInt()
            )
            ta.recycle()
        }

        createTabs()
        selectTab(currentIndex, notify = false)
    }

    private fun createTabs() {
        removeAllViews()
        iconViews.clear()
        titleViews.clear()

        for (i in 0 until tabCount) {
            // 容器：垂直排列图标和文字
            val container = LinearLayout(context).apply {
                orientation = VERTICAL
                gravity = Gravity.CENTER
                layoutParams = LayoutParams(0, LayoutParams.WRAP_CONTENT, 1f)
                setOnClickListener { selectTab(i, notify = true) }
            }

            // Lottie 图标
            val icon = LottieAnimationView(context).apply {
                setAnimation(normalRes.getOrNull(i) ?: 0)
                repeatCount = 0
            }

            // 文本
            val titleView = TextView(context).apply {
                text = titles.getOrNull(i) ?: ""
                setTextColor(if (i == currentIndex) colorSelected else colorNormal)
                setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize)
            }
            // 设置图标与文字间距
            val params = MarginLayoutParams(
                MarginLayoutParams.WRAP_CONTENT,
                MarginLayoutParams.WRAP_CONTENT
            ).apply {
                topMargin = iconTextMargin
            }
            titleView.layoutParams = params

            container.addView(icon)
            container.addView(titleView)
            addView(container)

            iconViews += icon
            titleViews += titleView
        }
    }

    private fun selectTab(index: Int, notify: Boolean) {
        // 如果是首次初始化，currentIndex 还没设置好，允许播放动画
        if (index == currentIndex && currentIndex >= 0) return

        // 如果有上一个 tab，就恢复成未选中状态
        if (currentIndex in 0 until tabCount) {
            iconViews[currentIndex].apply {
                setAnimation(normalRes.getOrNull(currentIndex) ?: 0)
                playAnimation()
            }
            titleViews[currentIndex].setTextColor(colorNormal)
        }

        // 新选中的 tab
        iconViews[index].apply {
            setAnimation(selectedRes.getOrNull(index) ?: 0)
            playAnimation()
        }
        titleViews[index].setTextColor(colorSelected)

        currentIndex = index
        if (notify) listener?.onTabSelected(index)
    }

    fun setCurrentTab(index: Int) {
        if (index in 0 until tabCount) selectTab(index, notify = false)
    }

    fun setOnTabSelectedListener(l: OnTabSelectedListener) {
        listener = l
    }

    private fun getResIdArray(ta: TypedArray, attr: Int): IntArray {
        val id = ta.getResourceId(attr, 0)
        if (id == 0) return intArrayOf()
        val arr = resources.obtainTypedArray(id)
        val result = IntArray(arr.length()) { arr.getResourceId(it, 0) }
        arr.recycle()
        return result
    }

    private fun getStringArray(ta: TypedArray, attr: Int): Array<String> {
        val id = ta.getResourceId(attr, 0)
        return if (id == 0) arrayOf()
        else resources.getStringArray(id)
    }
}