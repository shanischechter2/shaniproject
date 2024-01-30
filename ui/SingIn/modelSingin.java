package com.example.myapplicationshani.ui.SingIn;

import com.example.myapplicationshani.repostry.firebaseHelper;
import com.google.firebase.auth.FirebaseAuth;

public class modelSingin {
    firebaseHelper fire;

    public modelSingin(){
        this.fire=new firebaseHelper();
    }

    public Boolean create(String nameS,String emailS,String phonS,String passS)
    {
        return fire.creatWithEmailAndPassword(nameS,emailS,phonS,passS);

    }
}
