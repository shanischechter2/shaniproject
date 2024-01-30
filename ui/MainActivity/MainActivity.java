package com.example.myapplicationshani.ui.MainActivity;

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
import android.widget.Toast;

import com.example.myapplicationshani.R;
import com.example.myapplicationshani.ui.Home.Home;
import com.example.myapplicationshani.ui.Login.LoginActivity;
import com.example.myapplicationshani.ui.SingIn.SingIn;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    Button log,sing;
    FirebaseUser user;
    modelMainActivity modelMain;

    @Override
    protected void onStart() {
        super.onStart();
        user=FirebaseAuth.getInstance().getCurrentUser();
        modelMain=new modelMainActivity();
//        if(modelMain.isLoged())
//        {
//            startActivity(new Intent(MainActivity.this, Home.class));
//            finish();
//        }
        if(user!=null)
        {
            startActivity(new Intent(MainActivity.this, Home.class));
            finish();
        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        log=findViewById(R.id.startlog);
        sing=findViewById(R.id.Startsing);
        Intent intentS=new Intent(MainActivity.this, SingIn.class);
        Intent intentH=new Intent(MainActivity.this, LoginActivity.class);

        sing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(intentS);
            }
        });
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(intentH);

            }
        });

    }
}