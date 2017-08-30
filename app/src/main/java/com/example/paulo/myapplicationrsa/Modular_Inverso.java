package com.example.paulo.myapplicationrsa;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Modular_Inverso extends AppCompatActivity implements View.OnClickListener {


    private EditText mi_edit1;
    private EditText mi_edit2;
    private Button mi_button1;
    private TextView mi_text4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modular__inverso);


        mi_edit1 = (EditText) findViewById(R.id.MI_Edit1);
        mi_edit2 = (EditText) findViewById(R.id.MI_Edit2);
        mi_text4 = (TextView) findViewById(R.id.MI_Text4);

        mi_button1 = (Button) findViewById(R.id.MI_button1);
        mi_button1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        String mi_v1 = mi_edit1.getText().toString();
        String mi_v2 = mi_edit2.getText().toString();


        if (mi_v1.trim().isEmpty() || mi_v2.trim().isEmpty() ) {

            AlertDialog.Builder alertD_MI = new AlertDialog.Builder(this);
            alertD_MI.setMessage("Há dados em branco");
            alertD_MI.setNeutralButton("Ok", null);
            alertD_MI.show();

        } else {

            double mi_value1 = Double.parseDouble(mi_v1);
            double mi_value2 = Double.parseDouble(mi_v2);

            for (int i = 0; i < mi_value1; i++) {

                if (mi_value2*i % mi_value1 == 1) {
                    mi_text4.setText("O valor é " + i+".");
                }
            }
        }
    }
}
