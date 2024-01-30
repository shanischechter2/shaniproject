package com.example.myapplicationshani.ui.Login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplicationshani.R;
import com.example.myapplicationshani.ui.Home.Home;
import com.example.myapplicationshani.ui.SingIn.SingIn;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    EditText pass,email;
    Button log;
    TextView sing;
    FirebaseAuth auth;
    ProgressDialog dialogP;
    modleLogin modleL;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        pass=findViewById(R.id.passL);
        email=findViewById(R.id.emelL);
        log=findViewById(R.id.log);
        sing=findViewById(R.id.sing);
      //  auth=FirebaseAuth.getInstance();
        modleL=new modleLogin();
        sing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SingIn.class));
            }
        });
        log.setOnClickListener(new View.OnClickListener() {
          //  @Override
            public void onClick(View v) {
                dialogP=new ProgressDialog(LoginActivity.this);
                dialogP.setMessage("whit plese");
                dialogP.show();
                String Spass=pass.getText().toString().trim();
                String Semail=email.getText().toString().trim();
                if (TextUtils.isEmpty(Semail)||TextUtils.isEmpty(Spass))
                {
                    Toast.makeText(LoginActivity.this, "fill all", Toast.LENGTH_SHORT).show();
                }else
                {
                   Boolean b= modleL.login(Semail,Spass);
                    if (b)
                    {
                         dialogP.dismiss();
                          Toast.makeText(LoginActivity.this, "Yes", Toast.LENGTH_SHORT).show();
                          startActivity(new Intent(getApplicationContext(), Home.class));
                    }
                    else
                    {
                          dialogP.dismiss();
                         Toast.makeText(LoginActivity.this, "cant", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
    }
}