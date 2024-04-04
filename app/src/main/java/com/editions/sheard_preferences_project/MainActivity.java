package com.editions.sheard_preferences_project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnSave, btnGetData;
    EditText edName, edEmail, edPassword, edStudent_id,edNational_id,edPasport_id;

    //===============================
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnSave= findViewById(R.id.btnSave);
        btnGetData= findViewById(R.id.btnGetData);
        edName= findViewById(R.id.edName);
        edEmail= findViewById(R.id.edEmail);
        edPassword= findViewById(R.id.edPassword);
        edStudent_id= findViewById(R.id.edStudent_id);
        edNational_id= findViewById(R.id.edNational_id);
        edPasport_id= findViewById(R.id.edPasport_id);
        //================================================

        sharedPreferences= getSharedPreferences(""+getString(R.string.app_name), MODE_PRIVATE);
        editor= sharedPreferences.edit();

        //================================================
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveData();
            }
        });

        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code here
               GetData();
            }
        });


    }//onClick End Here////////

    private void SaveData(){

        //===============================================
        String Name= edName.getText().toString();
        String Email= edEmail.getText().toString();
        String Password= edPassword.getText().toString();
        String Student= edStudent_id.getText().toString();
        String National= edNational_id.getText().toString();
        String Pasport= edPasport_id.getText().toString();
        //==================================================

        editor.putString("data", "Name: "+Name+"\nEmail: "+Email+"\nPassword: "+Password+"\nStudent ID: "+Student+"\nNational ID: "+National+"\nPasport ID: "+Pasport);
        editor.apply();

    } //putString end here===========================


    private void GetData(){
        startActivity(new Intent(MainActivity.this, MainActivity2.class));
    }//intent end here ///////////


}