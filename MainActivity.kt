package com.fxzin67.demo

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Switch
import android.widget.ScrollView

class MainActivity : Activity() {
    private val cyan = Color.rgb(0, 229, 255)
    private val bg = Color.rgb(8, 11, 18)
    private val panel = Color.rgb(17, 24, 39)
    private fun dp(v: Int) = (v * resources.displayMetrics.density).toInt()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = bg
        window.navigationBarColor = bg

        val page = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER_HORIZONTAL
            setPadding(dp(20), dp(28), dp(20), dp(20))
            setBackgroundColor(bg)
        }
        val scroll = ScrollView(this).apply { addView(page) }

        val title = TextView(this).apply {
            text = "HACKED BY FXZIN67"
            setTextColor(cyan); textSize = 25f
            typeface = Typeface.DEFAULT_BOLD
            gravity = Gravity.CENTER
        }
        page.addView(title, LinearLayout.LayoutParams(-1, -2))
        val subtitle = TextView(this).apply {
            text = "FREE FIRE • DEMO CONTROL PANEL  |  V2.0"
            setTextColor(Color.LTGRAY); textSize = 12f
            gravity = Gravity.CENTER
            setPadding(0, dp(8), 0, dp(24))
        }
        page.addView(subtitle)

        val card = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(16), dp(12), dp(16), dp(12))
            setBackgroundColor(panel)
        }
        page.addView(card, LinearLayout.LayoutParams(-1, -2))

        addToggle(card, "🎯  AIMBOT", true)
        addToggle(card, "👁️  ESP", true)
        addToggle(card, "⚡  AIM FOV", true)
        addToggle(card, "🎮  GAME MODE", true)

        val status = TextView(this).apply {
            text = "STATUS: DEMO ONLY\nNo connection to Free Fire"
            setTextColor(cyan); textSize = 14f
            gravity = Gravity.CENTER
            typeface = Typeface.DEFAULT_BOLD
            setPadding(0, dp(26), 0, dp(8))
        }
        page.addView(status, LinearLayout.LayoutParams(-1, -2))
        val note = TextView(this).apply {
            text = "Este aplicativo é apenas uma demonstração visual. Os controles não alteram o jogo."
            setTextColor(Color.GRAY); textSize = 12f
            gravity = Gravity.CENTER
        }
        page.addView(note)
        setContentView(scroll)
    }

    private fun addToggle(parent: LinearLayout, label: String, initial: Boolean) {
        val row = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            setPadding(0, dp(10), 0, dp(10))
        }
        val text = TextView(this).apply {
            this.text = label; setTextColor(Color.WHITE)
            textSize = 16f; typeface = Typeface.DEFAULT_BOLD
        }
        row.addView(text, LinearLayout.LayoutParams(0, -2, 1f))
        val toggle = Switch(this).apply {
            isChecked = initial
            buttonTintList = android.content.res.ColorStateList.valueOf(cyan)
            setOnCheckedChangeListener { _, checked ->
                text.alpha = if (checked) 1f else 0.55f
            }
        }
        row.addView(toggle)
        parent.addView(row, LinearLayout.LayoutParams(-1, -2))
        val divider = android.view.View(this).apply { setBackgroundColor(Color.rgb(45, 55, 72)) }
        parent.addView(divider, LinearLayout.LayoutParams(-1, dp(1)))
    }
}
