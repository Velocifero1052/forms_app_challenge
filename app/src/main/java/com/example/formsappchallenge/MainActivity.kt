package com.example.formsappchallenge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.account_type_spinner
import kotlinx.android.synthetic.main.activity_main.button_preview
import kotlinx.android.synthetic.main.activity_main.edit_text_email
import kotlinx.android.synthetic.main.activity_main.edit_text_first_name
import kotlinx.android.synthetic.main.activity_main.edit_text_last_name
import kotlinx.android.synthetic.main.activity_main.phone_number_edit_text
import kotlinx.android.synthetic.main.activity_main.subscribe_to_newsletter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val previewButton = button_preview

        previewButton.setOnClickListener{
            onPreviewClicked()
        }

        val spinnerValues: Array<String> = arrayOf("Individual", "Organization")

        val spinnerAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item, spinnerValues
        );
        account_type_spinner.adapter = spinnerAdapter

    }

    private fun onPreviewClicked() {
        val message = Message(
            edit_text_last_name.text.toString(),
            edit_text_first_name.text.toString(),
            edit_text_email.text.toString(),
            subscribe_to_newsletter.isChecked,
            phone_number_edit_text.text.toString(),
            account_type_spinner.selectedItem.toString()
        )

        val previewActivityIntent = Intent(this, PreviewActivity::class.java)
        previewActivityIntent.putExtra("message", message)

        startActivity(previewActivityIntent)
    }

}