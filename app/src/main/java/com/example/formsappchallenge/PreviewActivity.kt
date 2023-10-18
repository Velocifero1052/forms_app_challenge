package com.example.formsappchallenge

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_preview.button_send_email_message
import kotlinx.android.synthetic.main.activity_preview.button_send_sms_message
import kotlinx.android.synthetic.main.activity_preview.text_view_message

class PreviewActivity: AppCompatActivity() {

    private lateinit var message: Message
    private lateinit var messagePreviewText: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)
        displayMessage()
        setupButton()
        setupEmailButton()
    }

    private fun displayMessage() {
        message = intent.getSerializableExtra("message") as Message
        messagePreviewText = """
            Full name: ${message.firstName} ${message.lastName}
            Email: ${message.email}
            Subscription: ${message.getSubscription()}
            PhoneNumber: ${message.phoneNumber}
            AccountType: ${message.accountType}
        """.trimIndent()
        //set this text here
        text_view_message.text = messagePreviewText
    }

    private fun setupButton() {
        button_send_sms_message.setOnClickListener{
            val sendIntent: Intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("smsto: ${message.phoneNumber}")
                putExtra("sms_body", messagePreviewText)
            }
            startActivity(sendIntent)
        }
    }

    private fun setupEmailButton() {

        button_send_email_message.setOnClickListener(View.OnClickListener { v: View? ->
            val launchEmailAppIntent = Intent(Intent.ACTION_SENDTO)
            launchEmailAppIntent.data = Uri.parse("mailto:${message.email}")
            startActivity(launchEmailAppIntent)
        })

    }

}