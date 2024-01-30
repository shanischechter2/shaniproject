package com.example.myapplicationshani.ui.MainActivity;

import com.example.myapplicationshani.repostry.firebaseHelper;

public class modelMainActivity {
    firebaseHelper fire;

    public modelMainActivity() {
        this.fire=new firebaseHelper();
    }

    public Boolean isLoged()
    {
       return fire.IsUserLogedin();
    }
}
