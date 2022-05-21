package com.example.fitbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class bmi extends AppCompatActivity {
    Button button;

    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_bmi);
        button = findViewById(R.id.calculate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    TextView txtResult = (TextView) findViewById(R.id.textViewResult);
                    Intent intent = new Intent(getApplicationContext(), bmi_second.class);
                    intent.putExtra("imcResult", txtResult.getText());
                    startActivity(intent);
                }
        });

    }
    public void calcBMI(View view) {
        // Do something in response to button click
        TextView txtResult = (TextView) findViewById(R.id.textViewResult);
        EditText txtWeight = (EditText) findViewById(R.id.editTextWeight);
        EditText txtHeight = (EditText) findViewById(R.id.editTextHeight);

        try{

            double weight = Double.parseDouble(txtWeight.getText().toString());
            double height = Double.parseDouble(txtHeight.getText().toString());
            double result = weight / Math.pow(height, 2);
            txtResult.setText(String.format("%.1f", result));
            flag = true;

        } catch (NumberFormatException e){
            Log.d("Fail", "Error: " + e);
        }

    }



}