package com.example.myapplicationshani.ui.SingIn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplicationshani.R;
import com.example.myapplicationshani.User;
import com.example.myapplicationshani.ui.Home.Home;
import com.example.myapplicationshani.ui.Login.LoginActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.core.Tag;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SingIn extends AppCompatActivity {
EditText name,email,phon,pass;
Button singIn;
TextView moveT;

DatabaseReference reference;
FirebaseAuth auth;
FirebaseFirestore fstore;

    private DatabaseReference mDatabase;
    String Userid;
public static  final String TAG="TAG";

modelSingin modelS;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_in);
        name=findViewById(R.id.nameS);
        email=findViewById(R.id.emailS);
        phon=findViewById(R.id.phonS);
        pass=findViewById(R.id.passS);
        singIn=findViewById(R.id.singS);
       moveT=findViewById(R.id.moveTLogin);
        auth=FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        modelS=new modelSingin();


        moveT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SingIn.this, LoginActivity.class));
            }
        });
        singIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                    dialogP=new ProgressDialog(SingIn.this);
//                    dialogP.setMessage("whit plese");
//                    dialogP.show();
                    String nameString=name.getText().toString().trim();
                    String passString=pass.getText().toString().trim();
                    String emailString=email.getText().toString();
                    String phonString=phon.getText().toString();

//                    if(auth.getCurrentUser()!=null)
//                    {
//                        startActivity(new Intent(getApplicationContext(),Home.class));
//                        finish();
//                    }
                   if(TextUtils.isEmpty(nameString))
                   {
                       name.setError("set a username");
                   }

                       else if(TextUtils.isEmpty(passString))
                       {
                           pass.setError("set a password");


                       }
                       else if(passString.length()<6)
                       {
                       pass.setError("set a password bigger then 6 chars");
                       } else if(TextUtils.isEmpty(emailString))
                   {
                       email.setError("set a email");
                   }
                        else if(TextUtils.isEmpty(phonString)){
                            phon.setError("set a phon number");

                   }
                   else {
                       ProgressDialog dialogP = new ProgressDialog(SingIn.this);
                       dialogP.setMessage("whit plese");
                       dialogP.show();
                       Boolean b=modelS.create(nameString,emailString,phonString,passString);
                       if (b)
                       {
                           dialogP.dismiss();
                           Toast.makeText(SingIn.this, "Yes", Toast.LENGTH_SHORT).show();
                           startActivity(new Intent(getApplicationContext(), Home.class));

                       }
                       else
                       {
                           dialogP.dismiss();
                           Toast.makeText(SingIn.this, "cant", Toast.LENGTH_SHORT).show();
                       }
                     //  singUp(nameString,emailString,phonString,passString);
                   }

            }
        });
    }
    public void singUp(String nameS,String emailS,String phonS,String passS)
    {
        auth.createUserWithEmailAndPassword(emailS,passS).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {

                    //Userid=auth.getCurrentUser().getUid();
                  //  DocumentReference documentReference=fstore.collection("users").document(Userid);
                    Toast.makeText(SingIn.this, "Yes", Toast.LENGTH_SHORT).show();
//                    HashMap<String,Object> user=new HashMap<>();
//                    user.put("userName ",nameS);
//                    user.put("useremail",emailS);
//                    user.put("userphon",phonS);
                    Userid=auth.getCurrentUser().getUid();

                    User user2 = new User(nameS, emailS,phonS);

                    mDatabase.child("users").child(Userid).setValue(user2);
                   // documentReference.set(user);


                }
                else
                {
                   // dialogP.dismiss();
                    Toast.makeText(SingIn.this, "cant"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
             //   return null;
            }
        });

    }
}