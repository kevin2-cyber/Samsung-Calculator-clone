package com.codelab.samsungcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.codelab.samsungcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // viewBinding
    private lateinit var binding: ActivityMainBinding
    var lastNumeric: Boolean = false
    var lastDot: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btnMod.setOnClickListener {
            onDigit(it)
        }

        binding.btnCLR.setOnClickListener {
            onClear(it)
        }

        binding.btnEqual.setOnClickListener {
            onEqual(it)
        }

        binding.btnBraces.setOnClickListener {
            onDigit(it)
        }

        binding.btnDivide.setOnClickListener {
            onOperator(it)
        }

        binding.btnMultiply.setOnClickListener {
            onOperator(it)
        }

        binding.btnAdd.setOnClickListener {
            onOperator(it)
        }

        binding.btnSubtract.setOnClickListener {
            onOperator(it)
        }
    }

    fun onDigit(view: View) {
        binding.tvInput.append((view as Button).text)
        lastNumeric = true
        lastDot = false
    }

    private fun onClear(view: View) {
        binding.tvInput.text = ""
    }

    fun onDecimalPoint(view: View) {
        if (lastNumeric && !lastDot){
            binding.tvInput.append(".")
            lastNumeric = false
            lastDot = true
        }
    }

    fun onOperator(view: View) {
        binding.tvInput.text.let {
            if (lastNumeric && !isOperatorAdded(it.toString())) {
                binding.tvInput.append((view as Button).text)
                lastNumeric = false
                lastDot = false
            }
        }
    }

    private fun onEqual(view: View) {
        if (lastNumeric) {
            var tvValue = binding.tvInput.text.toString()
            var prefix = ""
            try {
                if (tvValue.startsWith("-")) {
                    prefix = "-"
                    tvValue = tvValue.substring(1)
                }

                if (tvValue.contains("-")) {
                    val splitValue = tvValue.split("-")

                    var one =  splitValue[0] // 9
                    val two = splitValue[1] // 1

                    if (prefix.isNotEmpty()) {
                        one = prefix + one
                    }

                    val result = one.toDouble() - two.toDouble()
                    binding.tvInput.text = removeZeroAfterDot(result.toString())
                } else if (tvValue.contains("+")) {
                    val splitValue = tvValue.split("+")

                    var one =  splitValue[0] // 9
                    val two = splitValue[1] // 1

                    if (prefix.isNotEmpty()) {
                        one = prefix + one
                    }

                    val result = one.toDouble() + two.toDouble()
                    binding.tvInput.text = removeZeroAfterDot(result.toString())
                } else if (tvValue.contains("/")) {
                    val splitValue = tvValue.split("/")

                    var one =  splitValue[0] // 9
                    val two = splitValue[1] // 1

                    if (prefix.isNotEmpty()) {
                        one = prefix + one
                    }

                    val result = one.toDouble() / two.toDouble()
                    binding.tvInput.text = result.toString()
                } else if (tvValue.contains("*")) {
                    val splitValue = tvValue.split("*")

                    var one =  splitValue[0] // 9
                    val two = splitValue[1] // 1

                    if (prefix.isNotEmpty()) {
                        one = prefix + one
                    }

                    val result = one.toDouble() * two.toDouble()
                    binding.tvInput.text = removeZeroAfterDot(result.toString())
                } else if (tvValue.contains("%")) {
                    val splitValue = tvValue.split("%")

                    var one = splitValue[0]
                    val two = splitValue[1]

                    if (prefix.isNotEmpty()) {
                        one = prefix + one
                    }

                    val result = one.toDouble() % two.toDouble()
                    binding.tvInput.text = removeZeroAfterDot(result.toString())
                }

            } catch (e: ArithmeticException) {
                e.printStackTrace()
            }
        }
    }

    private fun removeZeroAfterDot(result: String) : String {
        var value = result
        if (result.contains(".0"))
            value = result.substring(0, result.length - 2)
        return value
    }

    private fun isOperatorAdded(value: String): Boolean {
        return if (value.startsWith("-")) {
            false
        } else {
            value.contains("/")
                    || value.contains("*")
                    || value.contains("+")
                    || value.contains("-")
        }
    }
}