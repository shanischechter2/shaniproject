package com.example.myapplicationshani.ui.PersonalFrag;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.myapplicationshani.R;
import com.example.myapplicationshani.ui.Update.UpdatePropil;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;


public class personalFragment extends Fragment {

TextView ProfilName,defProfil;
ImageView propilPoto,propilPotoBig;
LinearLayout linearLayout;

Button up;
String Userid;
Uri uPRO;
    StorageReference storageReference;
RecyclerView recyclerView;
    private DatabaseReference mDatabase;


    Dialog dialog;
    modelPersonalFrag personalFrag;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_personal,container,false);
        ProfilName=view.findViewById(R.id.UserName_profil);
        defProfil=view.findViewById(R.id.defProfil);
        linearLayout=view.findViewById(R.id.linearPro);
        propilPoto=view.findViewById(R.id.image_propile);
        up=view.findViewById(R.id.updeatPro);
        recyclerView=view.findViewById(R.id.posts_view);
       // storageReference= FirebaseStorage.getInstance().getReference();
   //     FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
    //     Userid= user.getUid();
         personalFrag=new modelPersonalFrag();

 //       mDatabase = FirebaseDatabase.getInstance().getReference();
        personalFrag.setusername(ProfilName);
        personalFrag.setuserDef(defProfil);
        // storageReference.child("posts").child(Userid).ad
//        mDatabase.child("users").child(Userid).child("username").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if(snapshot.exists())
//                {
//                    String s=snapshot.getValue().toString();
//
//                    ProfilName.setText(s);
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });



//        mDatabase.child("users_def").child(Userid).child("def").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if(snapshot.exists())
//                {
//                    String s=snapshot.getValue().toString();
//
//                   defProfil.setText(s);
//                }
//            }

//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

        final long ONE_MEGABYTE = 1024 * 1024;
        personalFrag.setuserProfile(propilPoto,getContext());
//        storageReference.child("imegPro/").child(Userid).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//            @Override
//            public void onSuccess(Uri uri) {
//                if(uri!=null)
//                {
//                    uPRO=uri;
//                    Glide.with(getContext()).load(uri).into(propilPoto);
//                    dialog=new Dialog(getContext());
//                    // dialog.setCancelable(false);
//
//                    dialog.setContentView(R.layout.castumpropil);
//                    propilPotoBig=dialog.findViewById(R.id.proImege2);
//
//                    Glide.with(getContext()).load(uri).into(propilPotoBig);
//
//
//
//                   // propilPoto.setImageURI(uri);
//
//
//                }
//                else
//                    Toast.makeText(getContext(), "null", Toast.LENGTH_SHORT).show();
//
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception exception) {
//                // Handle any errors
//                Toast.makeText(getContext(), "ssss", Toast.LENGTH_SHORT).show();
//                Uri uri= Uri.parse("@drawable/baseline_person_outline_24");
//                propilPoto.setImageURI(uri);
//            }
//        });
//        propilPoto.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View view) {
////                dialog=new Dialog(getContext());
////               // dialog.setCancelable(false);
////                dialog.setContentView(R.layout.castumpropil);
////
////
////                propilPotoBig=dialog.findViewById(R.id.proImege2);
//              //  Toast.makeText(getContext(), "ssss", Toast.LENGTH_SHORT).show();
//
//                //propilPotoBig.setImageResource(R.drawable.add_shopping_cart_24);
//
//               // String S=String.valueOf(propilPotoBig.getBackground());
//              //  Toast.makeText(getContext(), S, Toast.LENGTH_SHORT).show();
//                //Glide.with(getContext()).load(uPRO).into(propilPotoBig);
//                dialog.show();
////
//                return false;
//            }
//        });
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UpdatePropil.class);
                startActivity(intent);

            }
        });


        return  view;
       // return inflater.inflate(R.layout.fragment_personal, container, false);

    }
}