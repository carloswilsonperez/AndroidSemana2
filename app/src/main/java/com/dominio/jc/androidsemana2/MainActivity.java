package com.dominio.jc.androidsemana2;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import com.dominio.jc.androidsemana2.bean.Contact;
import com.dominio.jc.androidsemana2.util.ContactAppUtil;

import javax.xml.datatype.Duration;

public class MainActivity extends AppCompatActivity {

    public static final String FRM_FULL_NAME = "FRM_FULL_NAME";
    public static final String FRM_BIRTH_DATE= "FRM_BIRTH_DATE";
    public static final String FRM_PHONE_NUMBER= "FRM_PHONE_NUMBER";
    public static final String FRM_EMAIL= "FRM_EMAIL";
    public static final String FRM_DESCRIPTION= "FRM_DESCRIPTION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        restoreFromExtras(getIntent());
    }

    public void showConfirmation(View view){

        Intent confirmationIntent = new Intent(this,Confirmacion.class);
        populateExtras(confirmationIntent,getContactData(view));
        startActivity(confirmationIntent);
    }

    private Contact getContactData(View view){
        Contact contact = new Contact();
        contact.setFullName(((TextInputEditText)findViewById(R.id.txtFullName)).getText().toString());
        contact.setPhoneNumber(((TextInputEditText)findViewById(R.id.txtPhoneNumber)).getText().toString());
        contact.setEmail(((TextInputEditText)findViewById(R.id.txtEmail)).getText().toString());
        contact.setDescription(((TextInputEditText)findViewById(R.id.txtDescription)).getText().toString());

        DatePicker dpBirthDate = (DatePicker)findViewById(R.id.dpBirthDate);
        contact.setBirthDate(ContactAppUtil.getDateAsString(dpBirthDate));

        return contact;
    }

    private void populateExtras(Intent intent, Contact contact){
        intent.putExtra(FRM_FULL_NAME,contact.getFullName());
        intent.putExtra(FRM_BIRTH_DATE,contact.getBirthDate());
        intent.putExtra(FRM_PHONE_NUMBER,contact.getPhoneNumber());
        intent.putExtra(FRM_EMAIL,contact.getEmail());
        intent.putExtra(FRM_DESCRIPTION,contact.getDescription());
    }

    private void restoreFromExtras(Intent intent){
        ((TextInputEditText)findViewById(R.id.txtFullName)).setText(intent.getStringExtra(FRM_FULL_NAME));
        ((TextInputEditText)findViewById(R.id.txtDescription)).setText(intent.getStringExtra(FRM_DESCRIPTION));
        ((TextInputEditText)findViewById(R.id.txtEmail)).setText(intent.getStringExtra(FRM_EMAIL));
        ((TextInputEditText)findViewById(R.id.txtPhoneNumber)).setText(intent.getStringExtra(FRM_PHONE_NUMBER));
        String date = intent.getStringExtra(FRM_BIRTH_DATE);
        if(date!=null){
            ContactAppUtil.updateDatePicker((DatePicker)findViewById(R.id.dpBirthDate),intent.getStringExtra(FRM_BIRTH_DATE));
        }
        //ContactAppUtil.updateDatePicker((DatePicker)findViewById(R.id.dpBirthDate),intent.getStringExtra(FRM_BIRTH_DATE));



    }


}
