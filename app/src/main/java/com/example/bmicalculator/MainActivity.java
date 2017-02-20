package com.example.bmicalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.bmicalculator.model.HumanBody;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private EditText mHeightEditText, mWeightEditText;
    private HumanBody mHumanBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHeightEditText = (EditText) findViewById(R.id.height_edit_text);
        mWeightEditText = (EditText) findViewById(R.id.weight_edit_text);

        Button calculateButton = (Button) findViewById(R.id.calculate_button);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateInput()) {
                    double height = Double.valueOf(mHeightEditText.getText().toString());
                    double weight = Double.valueOf(mWeightEditText.getText().toString());

                    mHumanBody = new HumanBody(height, weight);
                    double bmiValue = mHumanBody.getBmiValue();
                    String bmiDescription = mHumanBody.getBmiDescription();
                    int bmiImage = mHumanBody.getBmiImage();

                    String msg = String.format(
                            Locale.US,
                            "BMI Value: %.2f, BMI Description: %s",
                            bmiValue,
                            bmiDescription
                    );
                    Log.i(TAG, msg);

                    Intent intent = new Intent(MainActivity.this, BmiResultActivity.class);
                    intent.putExtra("bmi_value", bmiValue);
                    intent.putExtra("bmi_message", bmiDescription);
                    intent.putExtra("bmi_image", bmiImage);
                    startActivity(intent);
                } else {
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("ผิดพลาด")
                            .setMessage("ป้อนข้อมูลไม่ครบ")
                            .setPositiveButton("OK", null)
                            .show();
                }
            }
        });
    }

    private boolean validateInput() {
        if (mHeightEditText.getText().toString().trim().isEmpty()) {
            mHeightEditText.setError("ป้อนส่วนสูงในหน่วยเซนติเมตร");
            return false;
        } else if (mWeightEditText.getText().toString().trim().isEmpty()) {
            mWeightEditText.setError("ป้อนน้ำหนักในหน่วยกิโลกรัม");
            return false;
        }
        return true;
    }
}
