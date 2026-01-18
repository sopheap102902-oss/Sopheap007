package com.sopheap007.app;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.widget.*;
import org.json.*;
import java.io.*;

public class MainActivity extends Activity {
    private TableLayout tableChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tableChat = findViewById(R.id.tableChat);

        // នៅពេលចុចប៊ូតុង Login ឱ្យវាទៅអាន File JSON
        findViewById(R.id.btnLogin).setOnClickListener(v -> readTelegramJSON());
    }

    private void readTelegramJSON() {
        // ផ្លូវទៅកាន់ File (ឧបមាថាវាមានក្នុង Folder Downloads)
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "result.json");
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) sb.append(line);
            br.close();

            JSONObject jsonObject = new JSONObject(sb.toString());
            JSONArray chats = jsonObject.getJSONObject("chats").getJSONArray("list");

            tableChat.removeAllViews(); // លុបទិន្នន័យចាស់ចេញ

            for (int i = 0; i < chats.length(); i++) {
                JSONObject chat = chats.getJSONObject(i);
                String name = chat.optString("name", "Unknown");
                String date = chat.optString("type", "Chat"); // បង្ហាញប្រភេទ Chat សិន
                addChatRow(name, date);
            }
        } catch (Exception e) {
            Toast.makeText(this, "រកមិនឃើញ File result.json ក្នុង Downloads ទេ!", Toast.LENGTH_LONG).show();
        }
    }

    private void addChatRow(String name, String info) {
        TableRow row = new TableRow(this);
        row.setPadding(5, 15, 5, 15);
        
        TextView tvName = new TextView(this);
        tvName.setText(name);
        tvName.setTextColor(Color.parseColor("#FF8C00"));
        tvName.setLayoutParams(new TableRow.LayoutParams(0, -2, 1f));

        TextView tvInfo = new TextView(this);
        tvInfo.setText(info);
        tvInfo.setTextColor(Color.parseColor("#FF8C00"));
        tvInfo.setLayoutParams(new TableRow.LayoutParams(0, -2, 1f));

        row.addView(tvName);
        row.addView(tvInfo);
        tableChat.addView(row);
    }
}

