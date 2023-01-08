package com.example.myfood;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class ProviderAddService extends AppCompatActivity {
    private String CategoryName, Description, Price, Pnam, saveCurrentDate, saveCurrentTime;
    private Button AddNewServiceButton;
    private ImageView InputServiceImage;
    private EditText InputServiceName,InputServiceDescription, InputServicePrice;

    private static final int GalleryPick=1;
    private Uri ImageUri;
    private String productRandomKey, downloadImageUri;
    private StorageReference ServiceImageRef;
    private DatabaseReference ServiceRef;
    private ProgressDialog loadingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_add_service);


        CategoryName=getIntent().getExtras().get("services").toString();
        ServiceImageRef = FirebaseStorage.getInstance().getReference().child("Service Image");
        ServiceRef = FirebaseDatabase.getInstance().getReference().child("Services");


        AddNewServiceButton=(Button)findViewById(R.id.add_new_service);

        InputServiceImage=(ImageView) findViewById(R.id.select_service_image);

        InputServiceName=(EditText) findViewById(R.id.service_name);
        InputServiceDescription=(EditText) findViewById(R.id.service_description);
        InputServicePrice=(EditText) findViewById(R.id.service_price);
        loadingBar = new ProgressDialog(this);



        InputServiceImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenGallery();
            }
        });

        AddNewServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValidateServiceData();
            }
        });

    }

    private void OpenGallery() {
        Intent galleryIntent =new Intent();
        galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent,GalleryPick);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==GalleryPick && resultCode==RESULT_OK && data!=null)
        {
            ImageUri =data.getData();
            InputServiceImage.setImageURI(ImageUri);

        }

    }

    private void ValidateServiceData()
    {
        Description=InputServiceDescription.getText().toString();
        Price=InputServicePrice.getText().toString();
        Pnam=InputServiceName.getText().toString();

        if(ImageUri == null)
        {
            Toast.makeText(this, "Service image is mandatory...", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(Description))
        {
            Toast.makeText(this, "Please write service Description", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(Price))
        {
            Toast.makeText(this, "Please write service price", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(Pnam))
        {
            Toast.makeText(this, "Please write service name", Toast.LENGTH_SHORT).show();
        }
        else
        {
            StoreServiceInformation();
        }






    }

    private void StoreServiceInformation() {

        loadingBar.setTitle("Add New Service");
        loadingBar.setMessage("Please wait, while we are adding the new service...");
        loadingBar.setCanceledOnTouchOutside(false);
        loadingBar.show();


        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd, yyyy");
        saveCurrentDate=currentDate.format(calendar.getTime());


        SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
        saveCurrentTime=currentTime.format(calendar.getTime());

        productRandomKey = saveCurrentDate + saveCurrentTime;


        StorageReference filePath= ServiceImageRef.child(ImageUri.getLastPathSegment()+ productRandomKey + ".jpg");

        final UploadTask uploadTask =filePath.putFile(ImageUri);

        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                String message = e.toString();
                Toast.makeText(ProviderAddService.this, "Error: " + message, Toast.LENGTH_SHORT).show();

                loadingBar.dismiss();



            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(ProviderAddService.this, "Service Image Uploaded Successfully...", Toast.LENGTH_SHORT).show();

                Task<Uri> uriTask = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                    @Override
                    public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                        if (task.isSuccessful())
                        {
                            throw task.getException();

                        }
                        downloadImageUri = filePath.getDownloadUrl().toString();
                        return filePath.getDownloadUrl();

                    }
                }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                    @Override
                    public void onComplete(@NonNull Task<Uri> task) {
                        if (task.isSuccessful())
                        {
                            downloadImageUri = task.getResult().toString();
                            Toast.makeText(ProviderAddService.this, "got the Service image Url Successfully...", Toast.LENGTH_SHORT).show();


                            SaveProductInfoToDatabase();
                        }
                    }
                });
            }
        });

    }

    private void SaveProductInfoToDatabase() {

        HashMap<String, Object> serviceMap = new HashMap<>();

        serviceMap.put("pid",productRandomKey);
        serviceMap.put("date",saveCurrentDate);
        serviceMap.put("time",saveCurrentTime);
        serviceMap.put("description",Description);
        serviceMap.put("image",downloadImageUri);
        serviceMap.put("category",CategoryName);
        serviceMap.put("price",Price);
        serviceMap.put("pname",Pnam);

        ServiceRef.child(productRandomKey).updateChildren(serviceMap)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if(task.isSuccessful())
                        {
                            Intent intent=new Intent(ProviderAddService.this,ProviderDash.class);
                            startActivity(intent);


                            loadingBar.dismiss();
                            Toast.makeText(ProviderAddService.this, "Service is added Successfully...", Toast.LENGTH_SHORT).show();
                        }else
                        {
                            loadingBar.dismiss();
                            String message =task.getException().toString();
                            Toast.makeText(ProviderAddService.this, "Error: " + message, Toast.LENGTH_SHORT).show();
                        }

                    }
                });



    }
}