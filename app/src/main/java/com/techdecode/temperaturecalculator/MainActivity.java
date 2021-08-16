package com.techdecode.temperaturecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_value;
    RadioButton btn_celsius;
    RadioButton btn_fahrenheit;
    Button btn_calculate;
    TextView tv_display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_value = findViewById(R.id.et_value);
        btn_celsius = findViewById(R.id.btn_celsius);
        btn_fahrenheit = findViewById(R.id.btn_fahrenheit);
        btn_calculate = findViewById(R.id.btn_calculate);
        tv_display = findViewById(R.id.tv_display);
    }

    @Override protected void onResume() {
        super.onResume();
        btn_calculate.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            calculateAnswer();
        }
        });
    }

    private void calculateAnswer(){
        Calculation calculations = new Calculation();
        String temp_value = et_value.getText().toString();
        if(TextUtils.isEmpty(temp_value)){
            Toast.makeText(this, "Please add a value", Toast.LENGTH_LONG).show();
        }else {
            Float temp = Float.parseFloat(temp_value);
            if(btn_celsius.isChecked()){
                temp = calculations.convertCelciusToFahrenheit(temp);
            }else if(btn_fahrenheit.isChecked()){
                temp = calculations.convertFahrenheitToCelcius(temp);
            }else{
                Toast.makeText(this, "Select Radio", Toast.LENGTH_LONG).show();
                temp = 0.0f;
            }
            tv_display.setText(new Float(temp).toString());

        }

    }
}