package com.example.paulo.myapplicationrsa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.main_button1_criptografia).setOnClickListener(this);
        findViewById(R.id.main_button2_mi).setOnClickListener(this);
        findViewById(R.id.main_button3_descriptografia).setOnClickListener(this);
        findViewById(R.id.main_button4_converte_mensagem).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.main_button1_criptografia:
                startActivity(new Intent(MainActivity.this, Criptografia.class));
                break;

            case R.id.main_button2_mi:
                startActivity(new Intent(MainActivity.this, Modular_Inverso.class ));
                break;

            case R.id.main_button3_descriptografia:
                startActivity(new Intent(MainActivity.this, Descriptografia.class));
                break;

            case R.id.main_button4_converte_mensagem:
                startActivity(new Intent(MainActivity.this, Converter_Mensagem.class));
                break;
        }
    }
}
