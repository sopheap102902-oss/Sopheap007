package com.sopheap007.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private TextView tvTitle;
    private EditText etPhone;
    private Button btnLogin, btnKh, btnEn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitle = findViewById(R.id.tvTitle);
        etPhone = findViewById(R.id.etPhone);
        btnLogin = findViewById(R.id.btnLogin);
        btnKh = findViewById(R.id.btnKh);
        btnEn = findViewById(R.id.btnEn);

        // ប៊ូតុងប្ដូរជាភាសាខ្មែរ
        btnKh.setOnClickListener(v -> {
            tvTitle.setText("សូមបញ្ចូលលេខទូរសព្ទ");
            etPhone.setHint("លេខទូរសព្ទ Telegram");
            btnLogin.setText("ផ្ញើលេខកូដ OTP");
        });

        // ប៊ូតុងប្ដូរជាភាសាអង់គ្លេស
        btnEn.setOnClickListener(v -> {
            tvTitle.setText("Enter Phone Number");
            etPhone.setHint("Telegram Phone Number");
            btnLogin.setText("Send OTP Code");
        });

        btnLogin.setOnClickListener(v -> {
            String phone = etPhone.getText().toString();
            if (!phone.isEmpty()) {
                Toast.makeText(this, "កំពុងផ្ញើ OTP ទៅកាន់: " + phone, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "សូមបញ្ចូលលេខទូរសព្ទ!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

