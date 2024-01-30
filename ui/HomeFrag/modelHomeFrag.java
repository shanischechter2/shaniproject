package com.example.myapplicationshani.ui.HomeFrag;

import android.widget.TextView;

import com.example.myapplicationshani.repostry.firebaseHelper;

public class modelHomeFrag {

    firebaseHelper fire;

    public modelHomeFrag() {
        this.fire=new firebaseHelper();
    }
    public void setUserNAme(TextView T)
    {
        fire.setuserName(T);

    }

}
