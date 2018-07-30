package com.example.android.sample.calculator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the "計算する" button
        val button = findViewById<Button>(R.id.calculate)
        // Set a event when the button clicked
        button.setOnClickListener {
            // Validation
            var isValid = true
            // - Price
            val priceEditText = findViewById<EditText>(R.id.price)
            val priceText = priceEditText.text.toString()
            if (priceText.isEmpty()) {
                priceEditText.error = getString(R.string.price_error)
                isValid = false
            }
            // - Discount
            val discountEditText = findViewById<EditText>(R.id.discount)
            val discountText = discountEditText.text.toString()
            if (discountText.isEmpty()) {
                discountEditText.error = getString(R.string.discount_error)
                isValid = false
            }

            if (isValid) {
                // Convert String to Int
                val price = priceText.toInt()
                val discount = discountText.toInt()

                // Transit to the result page
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("price", price)
                intent.putExtra("discount", discount)
                startActivity(intent)

            }
        }
    }
}
