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
import android.widget.Toast;

public class Criptografia extends AppCompatActivity implements View.OnClickListener {

    private EditText c_edit1;
    private EditText c_edit2;
    private EditText c_edit3;
    private Button c_button1;
    private ListView list_C;
    private ArrayAdapter<Integer> arrayAdapter_C;
    Calculos_Criptografia c_Criptografia = new Calculos_Criptografia();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criptografia);


        c_edit1 = (EditText) findViewById(R.id.C_Edit1);
        c_edit2 = (EditText) findViewById(R.id.C_Edit2);
        c_edit3 = (EditText) findViewById(R.id.C_Edit3);

        c_button1 = (Button) findViewById(R.id.C_button1);
        c_button1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {


        String c_v1 = c_edit1.getText().toString();

        String c_v2 = c_edit2.getText().toString();

        String c_v3 = c_edit3.getText().toString();

        if (c_v1.trim().isEmpty() || c_v2.trim().isEmpty() || c_v3.trim().isEmpty()) {

            AlertDialog.Builder alertaD_C = new AlertDialog.Builder(this);
            alertaD_C.setMessage("Há dados em branco");
            alertaD_C.setNeutralButton("Ok", null);
            alertaD_C.show();

        } else {


            int c_valor1 = Integer.parseInt(c_v1);
            int c_valor2 =Integer.parseInt(c_v2);

            list_C = (ListView) findViewById(R.id.C_output);

            c_Criptografia.calcularCriptografia(c_valor1, c_valor2, c_v3);

            arrayAdapter_C = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, c_Criptografia.arrayList_Criptografia);
            list_C.setAdapter(arrayAdapter_C);

            list_C.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Integer selected_C = c_Criptografia.arrayList_Criptografia.get(position);
                    Toast.makeText(getApplicationContext(), "O número da  criptografia é " + selected_C, Toast.LENGTH_LONG).show();
                }


            });

        }
    }
}
