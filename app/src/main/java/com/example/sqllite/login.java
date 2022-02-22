package com.example.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
  Button button;
  EditText edt1, edt2;
  DataBaseHelper dataBaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edt1=findViewById(R.id.edt4);
        edt2=findViewById(R.id.edt5);
        button=findViewById(R.id.btn2);
        dataBaseHelper=new DataBaseHelper(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String username=edt1.getText().toString();
                String password=edt2.getText().toString();
                Boolean checklogin=dataBaseHelper.checklogin(username,password);
                if (checklogin==true){
                    Intent intent=new Intent(login.this,Dashboard.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(login.this,"Invalid Username Password", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}