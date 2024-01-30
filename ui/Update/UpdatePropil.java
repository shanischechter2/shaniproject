package com.example.myapplicationshani.ui.Update;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import com.example.myapplicationshani.R;
import com.example.myapplicationshani.UsetPro;
import com.example.myapplicationshani.ui.Home.Home;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class UpdatePropil extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST = 1;
    Button updet,back;
    ImageView img;
    FirebaseFirestore fstore;
    EditText def,name,phone,email;
    private DatabaseReference mDatabase;

    FirebaseAuth auth;
    String Userid;
    StorageReference storageReference;
    modelUpdate modelUpdate1;
    Uri selectedImageUri2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_propil);
        updet=findViewById(R.id.updet);
        back=findViewById(R.id.back);
        def=findViewById(R.id.defProfilUpdate);
        name=findViewById(R.id.nameProfilUpdate);
        phone=findViewById(R.id.phoneProfilUpdate);
        email=findViewById(R.id.emailProfilUpdate);

        fstore=FirebaseFirestore.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        storageReference= FirebaseStorage.getInstance().getReference();
        modelUpdate1=new modelUpdate();
        auth=FirebaseAuth.getInstance();
        Userid=auth.getCurrentUser().getUid();
        img=findViewById(R.id.image_propileUpdet);
//        modelUpdate1.getDef(def,Userid);
////        mDatabase.child("users_def").child(Userid).child("def").addValueEventListener(new ValueEventListener() {
////            @Override
////            public void onDataChange(@NonNull DataSnapshot snapshot) {
////                if(snapshot.exists())
////                {
////                    String s=snapshot.getValue().toString();
////
////                    def.setText(s);
////                }
////            }
////
////            @Override
////            public void onCancelled(@NonNull DatabaseError error) {
////
////            }
////        });
        modelUpdate1.SetPro(img,UpdatePropil.this);
//        storageReference.child("imegPro/").child(Userid).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//            @Override
//            public void onSuccess(Uri uri) {
//                if(uri!=null)
//                {
//                    Glide.with(UpdatePropil.this).load(uri).into(img);
//                    ArrayList<View> uris=new ArrayList<>();
//                    View view1=img;
//                    uris.add(view1);
//
//
//                    // propilPoto.setImageURI(uri);
//
//
//                }
//                else
//                    Toast.makeText(UpdatePropil.this, "null", Toast.LENGTH_SHORT).show();
//
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception exception) {
//                // Handle any errors
//                Toast.makeText(UpdatePropil.this, "ssss", Toast.LENGTH_SHORT).show();
//                Uri uri= Uri.parse("@drawable/baseline_person_add_alt_1_24");
//               img.setImageURI(uri);
//            }
//        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UpdatePropil.this, Home.class));
            }
        });
//
       updet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                String namenew=name.getText().toString();
//                String ponenew=phone.getText().toString();
                if (!(TextUtils.isEmpty(def.getText())))
                {
                    String defnew=def.getText().toString();
                    modelUpdate1.Setdef(defnew);
                //    Toast.makeText(UpdatePropil.this, "dd", Toast.LENGTH_SHORT).show();
                }
                if (!(TextUtils.isEmpty(name.getText())))
                {
                    String defnew=name.getText().toString();
                    modelUpdate1.Setname(defnew);
                    //    Toast.makeText(UpdatePropil.this, "dd", Toast.LENGTH_SHORT).show();
                }
                if (!(TextUtils.isEmpty(phone.getText())))
                {
                    String defnew=phone.getText().toString();
                    modelUpdate1.SetPhone(defnew);
                   // "shanigal98@gmail.com"
                    //    Toast.makeText(UpdatePropil.this, "dd", Toast.LENGTH_SHORT).show();
                }
                if (!(TextUtils.isEmpty(email.getText())))
                {
                    String defnew=email.getText().toString();
                    modelUpdate1.SetEmail(defnew);

                    //    Toast.makeText(UpdatePropil.this, "dd", Toast.LENGTH_SHORT).show();
                }

                   startActivity(new Intent(UpdatePropil.this,Home.class));


            }
        });
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, PICK_IMAGE_REQUEST);


            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri selectedImageUri = data.getData();
            selectedImageUri2=selectedImageUri;
            // Now you can do something with the selected image URI
            // For example, display the image in an ImageView
            ImageView imageView = findViewById(R.id.postImg);
            img.setImageURI(selectedImageUri);

           // storageReference.child("imegPro").child(Userid).putFile(selectedImageUri);
         //   img.setImageURI((selectedImageUri));

        }
    }
}