package com.example.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Signin extends AppCompatActivity {

    EditText Idname,spassword;
    TextView newacc;
    Button obj2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        Idname=findViewById(R.id.idname);
        spassword=findViewById(R.id.password);
        newacc=findViewById(R.id.newaccount);
        obj2=findViewById(R.id.button);

        newacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Signin.this,Regester.class);
                startActivity(intent);
            }
        });
        obj2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Fname =Idname.getText().toString();
                String Spassword =spassword.getText().toString();
                if (Fname.isEmpty()){
                    Toast.makeText(Signin.this, "Enter name", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (Spassword.isEmpty()) {
                        Toast.makeText(Signin.this, "Enter password", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        SharedPreferences preferences =getSharedPreferences("demo",MODE_PRIVATE);
                        String loginname =preferences.getString("name",null);
                        String loginpassword1 =preferences.getString("password",null);


                        if (Fname.equals(loginname))
                        {
                            if (Spassword.equals(loginpassword1))
                            {
                                Intent intent = new Intent(Signin.this, Category.class);
                                startActivity(intent);
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(), "Password not matach", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "Username not matach", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }
}