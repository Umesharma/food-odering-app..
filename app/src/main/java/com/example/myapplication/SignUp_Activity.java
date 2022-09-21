package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp_Activity extends AppCompatActivity {

    EditText username ,password,repassword;
    Button register,loginpage;
    DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().setTitle("REGISTER");

         username=(EditText)findViewById(R.id.username) ;
         password=(EditText)findViewById(R.id.password);
         repassword=(EditText)findViewById(R.id.repassword) ;


        register=findViewById(R.id.btnregister);
        loginpage=findViewById(R.id.login);
        myDB=new DBHelper(this);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass= repassword.getText().toString();

                if(user.equals("")||pass.equals("")||repass.equals("")){
                    Toast.makeText(SignUp_Activity.this, "FIll all the filed", Toast.LENGTH_SHORT).show();
                }else
                {
                    if (pass.equals(repass))
                    {

                    Boolean userchekResult= myDB.checkusername(user);
                        if(!userchekResult)
                        {
                         Boolean regResult= myDB.insertData(user,pass);
                         if(regResult==true)
                         {
                             Toast.makeText(SignUp_Activity.this, "registration successful", Toast.LENGTH_SHORT).show();
//                             Intent intent=new Intent(SignUp_Activity.this,SignIn_Activity.class);
//                             startActivity(intent);
                         }
                       else {
                             Toast.makeText(SignUp_Activity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                         }
                       }

                        else {
                            Toast.makeText(SignUp_Activity.this, "user Already Exits .\n Please sign in", Toast.LENGTH_SHORT).show();

                            }
                    }
                    else
                    {
                        Toast.makeText(SignUp_Activity.this, "password not match", Toast.LENGTH_SHORT).show();
                    }
                }
//
//                Intent intent=new Intent(SignUp_Activity.this,SignIn_Activity.class);
//                startActivity(intent);
            }
        });
        loginpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(SignUp_Activity.this,SignIn_Activity.class);
                startActivity(intent);
            }
        });
    }
}