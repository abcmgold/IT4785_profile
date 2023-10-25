package com.example.createprofile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var firstName: TextView
    private lateinit var lastName: TextView
    private lateinit var radioGroupGender: RadioGroup
    private lateinit var radioButtonMale: RadioButton
    private lateinit var radioButtonFemale: RadioButton
    private var isOnChoose: Boolean = false
    private lateinit var birthday: EditText
    private lateinit var address: EditText
    private lateinit var email: EditText
    private lateinit var checkBox: CheckBox
    private var isOnChooseCheckBox: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.buttonSelectRegister)
        firstName = findViewById(R.id.firstName)
        lastName = findViewById(R.id.lastName)
        radioGroupGender = findViewById(R.id.radioGroupGender)
        radioButtonMale = findViewById(R.id.radioButtonMale)
        radioButtonFemale = findViewById(R.id.radioButtonFemale)
        birthday = findViewById(R.id.birthdayEditText)
        address = findViewById(R.id.addressEditText)
        email = findViewById(R.id.emailEditText)
        checkBox = findViewById(R.id.checkBox)

        rollButton.setOnClickListener {
            handleRegister()
        }

        radioGroupGender.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId == R.id.radioButtonMale || checkedId == R.id.radioButtonFemale) {
                isOnChoose = true
            }
        }

        checkBox.setOnClickListener { isOnChooseCheckBox = !isOnChooseCheckBox }

    }

    private fun handleRegister() {
        if (firstName.text.isEmpty() || lastName.text.isEmpty() || !isOnChoose || birthday.text.toString().isEmpty() || address.text.toString().isEmpty() || email.text.toString().isEmpty() || !isOnChooseCheckBox) {
            val toast = Toast.makeText(this, "Hãy điền đủ thông tin!", Toast.LENGTH_SHORT).show()
        } else {
            val toast = Toast.makeText(this, "Tạo thành công", Toast.LENGTH_SHORT).show()
        }
    }
}