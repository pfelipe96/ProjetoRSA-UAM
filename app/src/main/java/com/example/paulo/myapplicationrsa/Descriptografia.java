package com.example.paulo.myapplicationrsa;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Descriptografia extends AppCompatActivity implements View.OnClickListener {

    private EditText d_edit1;
    private EditText d_edit2;
    private EditText d_edit3;
    private Button d_button1;
    private ListView list_D;
    private ArrayAdapter<String> arrayAdapter_D;

    Calculos_Descriptografia d_Calculos = new Calculos_Descriptografia();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descriptografia);

        d_edit1 = (EditText) findViewById(R.id.D_Edit1);
        d_edit2 = (EditText) findViewById(R.id.D_Edit2);
        d_edit3 = (EditText) findViewById(R.id.D_Edit3);
        list_D = (ListView) findViewById(R.id.D_input);

        d_button1 = (Button) findViewById(R.id.D_button1);
        d_button1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        String d_v1 = d_edit1.getText().toString();
        String d_v2 = d_edit2.getText().toString();
        String d_v3 = d_edit3.getText().toString();

        if (d_v1.trim().isEmpty() || d_v2.trim().isEmpty() || d_v3.trim().isEmpty()) {

            AlertDialog.Builder alertaD_C = new AlertDialog.Builder(this);
            alertaD_C.setMessage("Há dados em branco");
            alertaD_C.setNeutralButton("Ok", null);
            alertaD_C.show();

        } else {

            int d_value2 = Integer.parseInt(d_v2);

            list_D = (ListView) findViewById(R.id.D_input);

            d_Calculos.calcularDescriptografia(d_v1, d_value2, d_v3);

            arrayAdapter_D = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, d_Calculos.arrayList_Descriptografia);
            list_D.setAdapter(arrayAdapter_D);

            list_D.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String selected_D = d_Calculos.arrayList_Descriptografia.get(position);
                    Toast.makeText(getApplicationContext(), "O número da descriptografia é " + selected_D, Toast.LENGTH_LONG).show();
                }
            });


        }
    }
}

