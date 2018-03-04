package com.dominio.jc.androidsemana2;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Confirmacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);
        populateSummary(getIntent());
    }


    private void populateSummary(Intent intent){
        ((TextView)findViewById(R.id.txtFullValue)).setText(intent.getStringExtra(MainActivity.FRM_FULL_NAME));
        ((TextView)findViewById(R.id.txtPhoneValue)).setText(intent.getStringExtra(MainActivity.FRM_PHONE_NUMBER));
        ((TextView)findViewById(R.id.txtBirthValue)).setText(intent.getStringExtra(MainActivity.FRM_BIRTH_DATE));
        ((TextView)findViewById(R.id.txtEmailValue)).setText(intent.getStringExtra(MainActivity.FRM_EMAIL));
        ((TextView)findViewById(R.id.txtDescriptionValue)).setText(intent.getStringExtra(MainActivity.FRM_DESCRIPTION));
    }

    public void showData(View view){
        Intent mainIntent  = new Intent(this,MainActivity.class);
        mainIntent.putExtras(getIntent());
        startActivity(mainIntent);
    }
}
