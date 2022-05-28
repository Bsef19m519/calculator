package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    float num1=0f,num2=1f;
    String op;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_layout);
        textView=findViewById(R.id.textView);
    }

    public void numberClick(View view) {
        Button b = (Button) view;
        textView.setText(textView.getText().toString() + b.getText());
    }

    public void clearScreen(View view) {
        textView.setText("");
        num1=0f;
        num2=1f;
        op="";
    }
    public void operatorClick(View view){
        try {
            num1 = Float.parseFloat(textView.getText().toString());
        }
        catch (Exception e)
        {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
        //Toast.makeText(this, textView.getText().toString(), Toast.LENGTH_SHORT).show();
        op=((Button) view).getText().toString();
        textView.setText("");
    }
    public void equalClick(View view){
        if(op.equals("")) return;
        try {
            num2 = Float.parseFloat(textView.getText().toString());
        }
        catch (Exception e)
        {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
        float res=10f;
        if(op.equals("+")) res=num1+num2;
        else if(op.equals("-")) res=num1-num2;
        else if(op.equals("*")) res=num1*num1;
        else if(op.equals("/")) res=(float)num1/num2;
        textView.setText(String.valueOf(res));
        num1=0f;
        num2=1f;
    }
}