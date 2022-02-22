package com.example.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DataBaseHelper dataBaseHelper;
    EditText edit1,edit2,edit3;
    Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataBaseHelper=new DataBaseHelper(this);
        edit1=findViewById(R.id.edt1);
        edit2=findViewById(R.id.edt2);
        edit3=findViewById(R.id.edt3);
        btn1=findViewById(R.id.btn1);
       btn2=findViewById(R.id.btn2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edit1.getText().toString();
                String password = edit2.getText().toString();
                String confirm = edit3.getText().toString();
                if (username.equals("") || password.equals("") || confirm.equals("")) {
                    Toast.makeText(MainActivity.this, "Fill the Fields", Toast.LENGTH_SHORT).show();
                }else {
                    if(password.equals(confirm)){
                       Boolean checkname= dataBaseHelper.checkname(username) ;
                       if ( checkname==true){
                           Boolean insert= dataBaseHelper.Insert(username, password) ;
                           if (insert==true){
                               Toast.makeText(MainActivity.this, "Register SuccessFully", Toast.LENGTH_SHORT).show();
                         edit1.setText("");
                         edit2.setText("");
                         edit3.setText("");

                           }

                       }
                       else {
                           Toast.makeText(MainActivity.this, "UserName Already Taken", Toast.LENGTH_SHORT).show();
                       }
                    }
                    else {
                        Toast.makeText(MainActivity.this, "PassWord Does,nt Match", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });
      btn2.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent=new Intent(MainActivity.this,login.class);
              startActivity(intent);
          }
      });

    }
}