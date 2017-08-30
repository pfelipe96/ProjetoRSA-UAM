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

public class Converter_Mensagem extends AppCompatActivity implements View.OnClickListener {

    private EditText cm_edit1;
    private Button cm_button1;
    private ListView cm_list1;
    private ArrayAdapter<Integer> arrayAdapter_cm;
    Calculos_Criptografia cm_criptografia = new Calculos_Criptografia();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter__mensagem);

        cm_edit1 = (EditText) findViewById(R.id.CM_EditText1);
        cm_button1 = (Button) findViewById(R.id.CM_button1);
        cm_button1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        String cm_v1 = cm_edit1.getText().toString();

        if (cm_v1.trim().isEmpty()) {

            AlertDialog.Builder alertaD_C = new AlertDialog.Builder(this);
            alertaD_C.setMessage("Há dados em branco");
            alertaD_C.setNeutralButton("Ok", null);
            alertaD_C.show();
        } else {

            cm_list1 = (ListView) findViewById(R.id.CM_ListView1);

            cm_criptografia.calcularCriptografia(5293, 41, cm_v1);

            arrayAdapter_cm = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, cm_criptografia.arrayList_Criptografia);
            cm_list1.setAdapter(arrayAdapter_cm);

            cm_list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Integer selected_cm = cm_criptografia.arrayList_Criptografia.get(position);
                    Toast.makeText(getApplicationContext(), "O número da  criptografia é " + selected_cm, Toast.LENGTH_LONG).show();
                }


            });

        }
    }
}
