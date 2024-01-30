package com.example.myapplicationshani.ui.AddPost;

import androidx.activity.result.ActivityResult;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplicationshani.R;
import com.example.myapplicationshani.ui.Home.Home;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;

import org.w3c.dom.Text;

public class add extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST = 1;
    Uri imageUri;
 String imgUrl;
 StorageTask uplodeTask;

 EditText discrip;

 ImageView close,added;
 TextView post;
 StorageReference storageReference;
    FirebaseAuth auth;
    String Userid;
 private  final  int GALERY=1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        discrip=findViewById(R.id.post_descripsion);
        auth=FirebaseAuth.getInstance();
        Userid=auth.getCurrentUser().getUid();
        close=findViewById(R.id.close);
        added=findViewById(R.id.postImg);
        post=findViewById(R.id.postP);
        storageReference= FirebaseStorage.getInstance().getReference();
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(add.this, Home.class));
                finish();
            }
        });

//        Intent inGallry=new Intent(Intent.ACTION_PICK);
//     inGallry.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//     startActivityForResult(inGallry,GALERY);
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                added.getDrawable();



            }
        });
        added.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, PICK_IMAGE_REQUEST);
             //    Toast.makeText(add.this, "SSS", Toast.LENGTH_SHORT).show();
            }
        });


    }
    public void UploadP(View view)
    {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri selectedImageUri = data.getData();

            // Now you can do something with the selected image URI
            // For example, display the image in an ImageView
            ImageView imageView = findViewById(R.id.postImg);
            imageView.setImageURI(selectedImageUri);
            storageReference.child("posts").child(Userid).putFile(selectedImageUri);
        }
    }
}