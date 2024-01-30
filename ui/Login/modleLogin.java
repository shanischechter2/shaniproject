package com.example.myapplicationshani.ui.Login;

import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.myapplicationshani.repostry.firebaseHelper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class modleLogin {

    firebaseHelper fire;

    public modleLogin() {
        this.fire=new firebaseHelper();
    }
   public Boolean login(String e,String p)
   {
    return fire.signInWithEmailAndPassword(e,p);

   }
}
