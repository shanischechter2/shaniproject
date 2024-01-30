package com.example.myapplicationshani.ui.PersonalFrag;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplicationshani.repostry.firebaseHelper;

public class modelPersonalFrag {
    firebaseHelper fire;

    public modelPersonalFrag() {
        this.fire=new firebaseHelper();
    }
    public void setusername(TextView t)
    {
        fire.setuserName(t);
    }
    public void setuserDef(TextView t)
    {
       fire.getdef(t);
    }
    public void setuserProfile(ImageView u, Context context)
    {
        fire.propilpic(u,context);
    }


}
