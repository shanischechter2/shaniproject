package com.example.myapplicationshani.ui.Update;

import android.content.Context;
import android.widget.ImageView;

import com.example.myapplicationshani.repostry.firebaseHelper;

public class modelUpdate {
    firebaseHelper fire;

    public modelUpdate(){
        this.fire=new firebaseHelper();
    }

    public void SetPro(ImageView m, Context context)
    {
        fire.propilpic(m,context);
    }
    public void Setdef(String s)
    {
        fire.UpdateDef(s);
    }
    public void Setname(String s)
    {
        fire.UpdateName(s);
    }
    public void SetPhone(String s)
    {
        fire.UpdatePhone(s);
    }
    public  void SetEmail(String s)
    {
        fire.updateEmail8(s);
    }



//    public Boolean getDef(EditText s, String id)
//    {
//        String s2="";
//        if(s2!=null)
//        {
//            s.setText(s2);
//            return true;
//        }
//        else
//        {
//            return false;
//        }
//    }
}
