package com.example.myapplicationshani.ui.HomeFrag;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
//import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplicationshani.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class homeFragment extends Fragment {
    TextView wellcom;
    ImageView imageView;
    String Userid;
    modelHomeFrag MhomeFrag;
    private DatabaseReference mDatabase;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home,container,false);
        wellcom=view.findViewById(R.id.wellcomeText2);
        imageView=view.findViewById(R.id.like2);
        MhomeFrag = new modelHomeFrag();

        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        Userid= user.getUid();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("users");
        MhomeFrag.setUserNAme(wellcom);
       // String s=MhomeFrag.setUserNAme2();
       // wellcom.setText("www"+s);
////        if(userName!=null)
//        {
//            wellcom.setText("Welcome back "+userName);
//        }
//        mDatabase.child(Userid).child("username").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if(snapshot.exists())
//                {
//                    String s=snapshot.getValue().toString();
//
//                    wellcom.setText("Welcome back "+s);
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
        // Inflate the layout for this fragment
        return view;
    }
}