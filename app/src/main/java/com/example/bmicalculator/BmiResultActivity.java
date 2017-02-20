package com.example.bmicalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class BmiResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_result);

        TextView bmiValueTextView = (TextView) findViewById(R.id.bmi_value_text_view);
        TextView bmiDescriptionTextView = (TextView) findViewById(R.id.bmi_description_text_view);
        ImageView bmiImageView = (ImageView) findViewById(R.id.bmi_image_view);

        Intent intent = getIntent();
        double bmiValue = intent.getDoubleExtra("bmi_value", 0);
        String bmiMessage = intent.getStringExtra("bmi_message");
        int bmiImage = intent.getIntExtra("bmi_image", 0);

        bmiValueTextView.setText(String.format(Locale.US, "%.2f", bmiValue));
        bmiDescriptionTextView.setText(bmiMessage);

        bmiImageView.setImageResource(bmiImage);
    }
}
