package com.example.bmicalculator.model;

import com.example.bmicalculator.R;

/**
 * Created by Promlert on 10/19/2016.
 */

public class HumanBody {

    private double mHeightInCm;
    private double mWeightInKg;

    private double mBmiValue;
    private String mBmiDescription;
    private int mBmiImage;

    public HumanBody(double heightInCm, double weightInKg) {
        mHeightInCm = heightInCm;
        mWeightInKg = weightInKg;
        calculateBmi();
    }

    private void calculateBmi() {
        double heightInMeter = mHeightInCm / 100;
        mBmiValue = mWeightInKg / (heightInMeter * heightInMeter);

        if (mBmiValue < 18.5) {
            // underweight
            mBmiDescription = "น้ำหนักน้อยกว่าปกติ (ผอม)";
            mBmiImage = R.drawable.bmi_underweight;
        } else if (mBmiValue < 25) {
            // normal/healthy weight
            mBmiDescription = "น้ำหนักปกติ";
            mBmiImage = R.drawable.bmi_normal_weight;
        } else if (mBmiValue < 30) {
            // overweight
            mBmiDescription = "น้ำหนักมากกว่าปกติ (ท้วม)";
            mBmiImage = R.drawable.bmi_overweight;
        } else if (mBmiValue >= 30) {
            // obesity
            mBmiDescription = "น้ำหนักมากกว่าปกติมาก (อ้วน)";
            mBmiImage = R.drawable.bmi_obesity;
        }
    }

    public double getBmiValue() {
        return mBmiValue;
    }

    public String getBmiDescription() {
        return mBmiDescription;
    }

    public int getBmiImage() {
        return mBmiImage;
    }

/*
    public double getBmiValue() {
        double heightInMeter = mHeightInCm / 100;
        double bmi = mWeightInKg / (heightInMeter * heightInMeter);
        return bmi;
    }

    public String getBmiMessage() {
        double bmiValue = getBmiValue();
        if (bmiValue < 18.5) {
            // underweight
            return "น้ำหนักน้อยกว่าปกติ (ผอม)";
        } else if (bmiValue < 25) {
            // normal weight
            return "น้ำหนักปกติ";
        } else if (bmiValue < 30) {
            // overweight
            return "น้ำหนักมากกว่าปกติ (ท้วม)";
        } else if (bmiValue >= 30) {
            // obesity
            return "น้ำหนักมากกว่าปกติมาก (อ้วน)";
        }
        return "";
    }
*/
}
