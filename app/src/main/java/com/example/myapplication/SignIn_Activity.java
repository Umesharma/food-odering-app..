package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignIn_Activity extends AppCompatActivity {
Button home;

    EditText username,password;
    DBHelper myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        username=(EditText) findViewById(R.id.usernameLogin);
        password= (EditText)findViewById(R.id.passwordLogin) ;

        home=findViewById(R.id.btnregister);

        myDB=new DBHelper(this);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("") || pass.equals("")){
                    Toast.makeText(SignIn_Activity.this, "Please enter the Field ", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean result= myDB.checkusernamePassword(user,pass);
                    if (result==true)
                    {
                        Intent intent=new Intent(SignIn_Activity.this,Home_Activity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(SignIn_Activity.this, "Invalid user name password", Toast.LENGTH_SHORT).show();
                    }
                    Intent intent=new Intent(SignIn_Activity.this,Home_Activity.class);
                    startActivity(intent);
                }


                Intent intent=new Intent(SignIn_Activity.this,Home_Activity.class);
                startActivity(intent);

            }
        });
  }
}