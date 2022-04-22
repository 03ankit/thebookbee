package com.example.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Regester extends AppCompatActivity {

    EditText Name,Password,Cpassword;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regester);

        Name =findViewById(R.id.idname);
        Password=findViewById(R.id.password);
        Cpassword=findViewById(R.id.cpassword);
        btn=findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fname = Name.getText().toString().trim();
                String lpassword =Password.getText().toString();
                String cpassword =Cpassword.getText().toString();

                if(fname.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Enter name ", Toast.LENGTH_LONG).show();
                }
                else{
                    if (lpassword.isEmpty())
                    {
                        Toast.makeText(getApplicationContext(), "enter password", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        if (cpassword.isEmpty())
                        {
                            Toast.makeText(getApplicationContext(), "Enter confrim password", Toast.LENGTH_SHORT).show();
                        }
                        if(!lpassword.equals(cpassword))
                        {
                            Toast.makeText(getApplicationContext(), " Password not matach", Toast.LENGTH_LONG).show();
                        }
                        else {
                            SharedPreferences preferences = getSharedPreferences("demo", MODE_PRIVATE);
                            SharedPreferences.Editor edit = preferences.edit();
                            edit.putString("name", fname);
                            edit.putString("password", lpassword);
                            edit.putString("cpassword", cpassword);
                            edit.apply();

                            Intent intent =new Intent(Regester.this,Signin.class);
                            startActivity(intent);
                        }
                    }
                }

            }
        });
    }
}