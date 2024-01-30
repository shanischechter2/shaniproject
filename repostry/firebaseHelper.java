package com.example.myapplicationshani.repostry;

import static java.security.AccessController.getContext;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.myapplicationshani.R;
import com.example.myapplicationshani.User;
import com.example.myapplicationshani.UsetPro;
import com.example.myapplicationshani.ui.Home.Home;
import com.example.myapplicationshani.ui.MainActivity.MainActivity;
import com.example.myapplicationshani.ui.SingIn.SingIn;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class firebaseHelper {
    FirebaseAuth auth ;
    private Boolean fLogin=true;
   private Boolean fSingin=false;
    private Boolean f=false;
    private Boolean fNowLoginMainAc=false;

    private Boolean fupdateProfole=true;
    StorageReference storageReference;
    private String Getdef;

   private String GetUserNameS="";
    DatabaseReference mDatabase;
    FirebaseUser user;

    public firebaseHelper() {
        this.auth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        this.user=FirebaseAuth.getInstance().getCurrentUser();
        storageReference= FirebaseStorage.getInstance().getReference();
    }


    public FirebaseAuth getAuth() {
        return auth;
    }

    public void updateEmail8(String n)
    {
        AuthCredential credential = EmailAuthProvider.getCredential(user.getEmail(),user.getEmail());
        user.updateEmail(n).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())
                {
                    mDatabase.child("users").child(user.getUid()).child("email").setValue(n);
                }
            }
        });
        //auth.updateCurrentUser()
    }

    public void UpdateDef(String n)
    {
        UsetPro user2 = new UsetPro(n);
           mDatabase.child("users_def").child(user.getUid()).setValue(user2);
    }
    public void UpdateName(String n)
    {
       // UsetPro user2 = new UsetPro(n);
        mDatabase.child("users").child(user.getUid()).child("username").setValue(n);
    }
    public void UpdatePhone(String n)
    {
        // UsetPro user2 = new UsetPro(n);
        mDatabase.child("users").child(user.getUid()).child("phon").setValue(n);
    }

  public void UpdatePropilpic(Uri imageViewURI)
  {
      storageReference.child("imegPro").child(user.getUid()).putFile(imageViewURI);
  }
    public void propilpic(ImageView propilPoto, Context context){
        storageReference.child("imegPro/").child(user.getUid()).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                if(uri!=null)
                {
                 //   uPRO=uri;
                    Glide.with(context).load(uri).into(propilPoto);
                    //dialog=new Dialog(getContext());
                    // dialog.setCancelable(false);

                    //dialog.setContentView(R.layout.castumpropil);
              //      propilPotoBig=dialog.findViewById(R.id.proImege2);

                  //  Glide.with(getContext()).load(uri).into(propilPotoBig);



                    // propilPoto.setImageURI(uri);


                }
            //    else
                   // Toast.makeText(getContext(), "null", Toast.LENGTH_SHORT).show();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
             //   Toast.makeText(getContext(), "ssss", Toast.LENGTH_SHORT).show();
             //   Uri uri= Uri.parse("@drawable/baseline_person_outline_24");
        //        propilPoto.setImageURI(uri);
            }
        });
    }

    public Boolean IsUserLogedin()
    {
       // user=
        if(user!=null)
        {
            fNowLoginMainAc=true;
        }
        return fNowLoginMainAc;
    }

    public void setuserName(TextView Tt)
    {
        String uid=user.getUid();

         DatabaseReference mDatabase2= FirebaseDatabase.getInstance().getReference().child("users");
         mDatabase2.child(uid).child("username").addValueEventListener(new ValueEventListener() {
           // @Override
           public void onDataChange(@NonNull DataSnapshot snapshot) {
               f=true;
                if(snapshot.exists())
                {
                     String s1=snapshot.getValue().toString();
                 //   b=true;
                     Tt.setText(s1);
                      GetUserNameS = s1;
                 //     sw=s1;
                  //    getGetUserName(GetUserNameS)


                   // f=true;
                    ;
                   // wellcom.setText("Welcome back "+s);
                }

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });
      //  String S2=s;
      //  if(b)
        if (f)
        {
         //   return GetUserName;
        }
       // return  f;
      //  else return null;

    }


    public Boolean signInWithEmailAndPassword(String email, String pass)
    {
        //Boolean f=true;
        auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
          // Boolean v=f;
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {

                    // dialogP.dismiss();
                    //  Toast.makeText(LoginActivity.this, "Yes", Toast.LENGTH_SHORT).show();
                    //  startActivity(new Intent(getApplicationContext(),Home.class));


                }
                else
                {
                    fLogin=false;

                    //  dialogP.dismiss();
                    // Toast.makeText(LoginActivity.this, "cant"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
             //return f;
           // f=v;
       });
      return fLogin;
    }
    public Boolean creatWithEmailAndPassword(String nameS,String emailS,String phonS,String passS)
    {

        auth.createUserWithEmailAndPassword(emailS,passS).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
     //       @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                   // dialogP.dismiss();
                    //Userid=auth.getCurrentUser().getUid();
                    //  DocumentReference documentReference=fstore.collection("users").document(Userid);
                 //   Toast.makeText(SingIn.this, "Yes", Toast.LENGTH_SHORT).show();
//                    HashMap<String,Object> user=new HashMap<>();
//                    user.put("userName ",nameS);
//                    user.put("useremail",emailS);
//                    user.put("userphon",phonS);
                    String Userid=auth.getCurrentUser().getUid();

                    User user2 = new User(nameS, emailS,phonS);

                    mDatabase.child("users").child(Userid).setValue(user2);
                    // documentReference.set(user);
                    //      startActivity(new Intent(getApplicationContext(),Home.class));
                    fSingin=true;
                }
                else
                {

                  //  dialogP.dismiss();
                   // Toast.makeText(SingIn.this, "cant"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
                //   return null;
            }
        });

        return  fSingin;
    }
    public void getdef(TextView t)
    {
        mDatabase.child("users_def").child(user.getUid()).child("def").addValueEventListener(new ValueEventListener() {

            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    String s = snapshot.getValue().toString();
                    Getdef=s;
                   t.setText(s);

                }
                else
                {
                    Getdef=null;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });
        //return Getdef;
    }





}
