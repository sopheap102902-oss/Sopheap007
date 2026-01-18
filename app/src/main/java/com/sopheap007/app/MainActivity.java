package com.sopheap007.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.Gravity;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // បង្កើតអក្សរបង្ហាញលើអេក្រង់
        TextView textView = new TextView(this);
        textView.setText("ជំរាបសួរ! នេះគឺជា App របស់ Sopheap");
        textView.setTextSize(24);
        textView.setGravity(Gravity.CENTER);

        setContentView(textView);
    }
}

