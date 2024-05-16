package com.luis.luisgoogleproject.ui.view

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.text.TextUtils
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.xuexiang.xui.R
import com.xuexiang.xui.utils.ResUtils
import com.xuexiang.xui.utils.ThemeUtils

/**
 * 自定义组合view
 * 1.定义构造方法，引入属性配置
 *
 */
class TitleMenu: LinearLayout {
    private var mMenuHeightPercent = 0.5f
    private var mTopTabMenuView: LinearLayout? =null
    private var mBottomContainerView: FrameLayout? =null
    private var mContentLayoutId: Int? =null
    private var mMenuTextUnselectedColor: Int? =null
    private var mMenuUnselectedIcon: Drawable? =null
    private var mMenuTextPaddingHorizontal: Int? =null
    private var mMenuTextPaddingVertical: Int? =null
    private var mContentView: View? = null

    /**
     * tab字体大小
     */
    private var mMenuTextSize = 0

    constructor(context: Context) : this(context,null) //用代码创建实例会调用该构造
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, R.attr.DropDownMenuStyle)//在xml中调用会走该构造
    constructor(context: Context,attrs: AttributeSet?, defStyleAttr: Int) : super(context,attrs, defStyleAttr){//最终都会走到 该方法
        orientation = VERTICAL
        //定义自定义属性
        //为DropDownMenu添加自定义属性
        val array = context.obtainStyledAttributes(attrs, R.styleable.DropDownMenu, defStyleAttr, 0)
        mContentLayoutId = array.getResourceId(R.styleable.DropDownMenu_ddm_contentLayoutId, -1)

        val mDividerColor = array.getColor(R.styleable.DropDownMenu_ddm_dividerColor,
            ThemeUtils.resolveColor(getContext(), R.attr.xui_config_color_separator_dark)
        )
        val mDividerWidth = array.getDimensionPixelSize(
            R.styleable.DropDownMenu_ddm_dividerWidth,ResUtils.getDimensionPixelSize(context, R.dimen.default_ddm_divider_width)
        )
        val mDividerMargin = array.getDimensionPixelSize(
            R.styleable.DropDownMenu_ddm_dividerMargin,ResUtils.getDimensionPixelSize(context, R.dimen.default_ddm_divider_margin)
        )
        val underlineColor = array.getColor(
            R.styleable.DropDownMenu_ddm_underlineColor,ThemeUtils.resolveColor(context, R.attr.xui_config_color_separator_light)
        )
        val underlineHeight = array.getDimensionPixelSize(
            R.styleable.DropDownMenu_ddm_underlineHeight,ResUtils.getDimensionPixelSize(context, R.dimen.default_ddm_underline_height)
        )
        val menuBackgroundColor =
            array.getColor(R.styleable.DropDownMenu_ddm_menuBackgroundColor, Color.WHITE)
        val mMaskColor = array.getColor(R.styleable.DropDownMenu_ddm_maskColor,
            ResUtils.getColor(context, R.color.default_ddm_mask_color)
        )
        val mMenuTextSelectedColor =
            ContextCompat.getColor(context, R.color.xui_config_color_pure_black)
        mMenuTextUnselectedColor =
            ContextCompat.getColor(context, R.color.xui_config_color_pure_black)
        mMenuTextPaddingHorizontal = array.getDimensionPixelSize(
            R.styleable.DropDownMenu_ddm_menuTextPaddingHorizontal,
            ResUtils.getDimensionPixelSize(
                context,
                R.dimen.default_ddm_menu_text_padding_horizontal
            )
        )
        mMenuTextPaddingVertical = array.getDimensionPixelSize(
            R.styleable.DropDownMenu_ddm_menuTextPaddingVertical,ResUtils.getDimensionPixelSize(context, R.dimen.default_ddm_menu_text_padding_vertical)
        )
        mMenuTextSize = array.getDimensionPixelSize(
            R.styleable.DropDownMenu_ddm_menuTextSize,ResUtils.getDimensionPixelSize(context, R.dimen.default_ddm_menu_text_size)
        )
        mMenuUnselectedIcon =ResUtils.getVectorDrawable(getContext(), com.luis.luisgoogleproject.R.mipmap.icon_sort_off)
        val mMenuSelectedIcon =ResUtils.getVectorDrawable(getContext(), com.luis.luisgoogleproject.R.mipmap.icon_sort_on)
        val  mMenuHeightPercent =array.getFloat(R.styleable.DropDownMenu_ddm_menuHeightPercent, mMenuHeightPercent)
        array.recycle()

        //初始化tabMenuView并添加到tabMenuView
        mTopTabMenuView = LinearLayout(context)
        val params = LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        mTopTabMenuView!!.orientation = HORIZONTAL
        mTopTabMenuView!!.setBackgroundColor(menuBackgroundColor)
        mTopTabMenuView!!.layoutParams = params
        addView(mTopTabMenuView, 0)

        //为tabMenuView添加下划线
        val underLine = View(getContext())
        underLine.layoutParams = LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, underlineHeight)
        underLine.setBackgroundColor(underlineColor)
        addView(underLine, 1)

        //初始化containerView并将其添加到DropDownMenu

        //初始化containerView并将其添加到DropDownMenu
        mBottomContainerView = FrameLayout(context)
        mBottomContainerView!!.layoutParams = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT,
            FrameLayout.LayoutParams.MATCH_PARENT
        )
        addView(mBottomContainerView, 2)
    }

    /**
     * 为布局添加子view
     */
    fun setDropDownMenu(
        contentView: View,
        tabViews1: List<View>?,
        tabViews2: List<View>?,
        tabViews3: List<View>?
    ) {
        tabViews1?.let { addTabViews(it) }  //let 表示object不为Null的情况下会执行let后的函数
        tabViews2?.let { addTabViews(it) }
        tabViews3?.let { addTabViews(it) }
        mContentView = contentView
        mBottomContainerView!!.addView(contentView, 0) //第一步 将传入的第一个容器参数放到已经初始化的底部容器frameLayout中
    }

    /**
     * 将传入的view全部添加到顶部的tab 容器中，该容器为horizatal 类型的linearlayout
     */
    private fun addTabViews(tabViews: List<View>) {
        for (i in tabViews.indices) {
            mTopTabMenuView!!.addView(tabViews[i])
        }
    }

    private fun addTab(list : List<String>, index : Int){
        val tab = TextView(context)
        tab.setSingleLine()
        tab.ellipsize = TextUtils.TruncateAt.END
        tab.gravity = Gravity.CENTER
        tab.setTextSize(TypedValue.COMPLEX_UNIT_PX, mMenuTextSize.toFloat())
        tab.layoutParams = LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f)
        tab.setTextColor(mMenuTextUnselectedColor!!)
        setArrowIconEnd(tab, mMenuUnselectedIcon!!)
        tab.text = list[index]
        tab.setPadding(
            mMenuTextPaddingHorizontal!!,
            mMenuTextPaddingVertical!!,
            mMenuTextPaddingHorizontal!!,
            mMenuTextPaddingVertical!!
        )
        //添加点击事件
//        tab.setOnClickListener { switchMenu(tab) }
        mTopTabMenuView!!.addView(tab)
    }

    private fun setArrowIconEnd(view: TextView?, arrowIcon: Drawable) {
        if (view == null) {
            return
        }
        view.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, arrowIcon, null)
    }
}