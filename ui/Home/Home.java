package com.example.myapplicationshani.ui.Home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;


import com.example.myapplicationshani.R;

import com.example.myapplicationshani.ui.AddPost.add;
import com.example.myapplicationshani.ui.Cart.cartFragment;
import com.example.myapplicationshani.ui.HomeFrag.homeFragment;
import com.example.myapplicationshani.ui.MenuFrag.menuFragment;
import com.example.myapplicationshani.ui.PersonalFrag.personalFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Home extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    TextView userNamePropile;
    private DatabaseReference mDatabase;


    homeFragment HomeFragment=new homeFragment();
    cartFragment CartFragment=new cartFragment();
    menuFragment MenuFragment=new menuFragment();
    personalFragment PersonalFragment=new personalFragment();

    String Userid;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bottomNavigationView=findViewById(R.id.bottomMahvrimView);

        userNamePropile= (TextView) findViewById(R.id.UserName_profil);
     //   mDatabase = FirebaseDatabase.getInstance().getReference().child("users");
    //    FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        getSupportFragmentManager().beginTransaction().replace(R.id.f_container,HomeFragment).commit();
        bottomNavigationView.setSelectedItemId(R.id.home);
  //     Userid= user.getUid();
   //    String s=user.;

//
//        mDatabase.child(Userid).child("username").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                 if(snapshot.exists())
//                 {
//                     String s=snapshot.getValue().toString();
//
//                    // userNamePropile.setText(s);
//                 }
//            }

//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//        mDatabase.child("users").child(Userid).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DataSnapshot> task) {
//                if (!task.isSuccessful()) {
//                    Log.e("firebase", "Error getting data", task.getException());
//                }
//                else {
//                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
//                    String u=String.valueOf(task.getResult().getValue()).toString();
//                 //   userNamePropile.setText(u);
//                }
//
//              //
//            }
//        });





        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {




            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment=null;
                switch(item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.f_container,HomeFragment).commit();
                        return true;
                    case R.id.menu:
                        getSupportFragmentManager().beginTransaction().replace(R.id.f_container,MenuFragment).commit();
                        return true;
                    case R.id.cart:
                        getSupportFragmentManager().beginTransaction().replace(R.id.f_container,CartFragment).commit();
                        return true;
                    case R.id.personal:
                        getSupportFragmentManager().beginTransaction().replace(R.id.f_container,PersonalFragment).commit();
                        return true;
                }
             //   getSupportFragmentManager().beginTransaction().replace(R.id.f_container,PersonalFragment).commit();
                return false;
            }
        });


        findViewById(R.id.plos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, add.class));
            }
        });


    }



}