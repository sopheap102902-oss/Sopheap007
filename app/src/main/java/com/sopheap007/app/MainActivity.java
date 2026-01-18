package com.sopheap007.app;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private TableLayout tableChat;
    private TextView tvTitle;
    private EditText etPhone;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tableChat = findViewById(R.id.tableChat);
        tvTitle = findViewById(R.id.tvTitle);
        etPhone = findViewById(R.id.etPhone);
        btnLogin = findViewById(R.id.btnLogin);
        
        findViewById(R.id.btnKh).setOnClickListener(v -> updateLanguage("km"));
        findViewById(R.id.btnEn).setOnClickListener(v -> updateLanguage("en"));

        // បន្ថែមទិន្នន័យគំរូក្នុង Table (ពណ៌ខៀវ អក្សរទឹកក្រូច)
        addChatRow("Sopheap", "2026-01-18 22:52");
        addChatRow("Telegram User", "2026-01-18 23:05");
        addChatRow("Bot Support", "2026-01-18 23:10");
    }

    private void addChatRow(String name, String dateTime) {
        TableRow row = new TableRow(this);
        row.setPadding(5, 15, 5, 15);
        row.setOnClickListener(v -> Toast.makeText(this, "សាររបស់: " + name, Toast.LENGTH_SHORT).show());

        TextView tvName = new TextView(this);
        tvName.setText(name);
        tvName.setTextColor(Color.parseColor("#FF8C00"));
        tvName.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f));

        TextView tvDate = new TextView(this);
        tvDate.setText(dateTime);
        tvDate.setTextColor(Color.parseColor("#FF8C00"));
        tvDate.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f));

        row.addView(tvName);
        row.addView(tvDate);
        tableChat.addView(row);
    }

    private void updateLanguage(String lang) {
        if (lang.equals("km")) {
            tvTitle.setText("សូមបញ្ចូលលេខទូរសព្ទ");
            btnLogin.setText("ផ្ញើលេខកូដ OTP");
            etPhone.setHint("973177337");
        } else {
            tvTitle.setText("Please Enter Phone Number");
            btnLogin.setText("Send OTP Code");
            etPhone.setHint("Phone Number");
        }
    }
}

