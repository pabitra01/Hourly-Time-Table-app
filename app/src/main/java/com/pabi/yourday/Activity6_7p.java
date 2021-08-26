package com.pabi.yourday;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.HashMap;
import java.util.Map;

public class Activity6_7p extends AppCompatActivity {
    private AdView mAdView;
    private EditText title_edit,details_edit;
    private Button save_button;
    private TextView title_view,details_view;
    private static final String TITLE = "title";
    private static final String DETAILS = "details";
    FirebaseFirestore db=FirebaseFirestore.getInstance();
    FirebaseUser users= FirebaseAuth.getInstance().getCurrentUser();
    String id=users.getUid();
    DocumentReference documentReference=db.collection("DATA").document(id).collection("6_7pm").document("doc");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity67p);
        getSupportActionBar().setTitle("6 PM - 7 PM");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        title_edit=findViewById(R.id.editTextTitle67p);
        details_edit=findViewById(R.id.editTextDetails67p);
        save_button=findViewById(R.id.save_button_67p);
        title_view=findViewById(R.id.title67p);
        details_view=findViewById(R.id.details67p);
    }
    @Override
    protected void onStart() {
        super.onStart();
        documentReference.addSnapshotListener(this,new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent( DocumentSnapshot documentSnapshot, FirebaseFirestoreException e) {
                if(e!=null){
                    Toast.makeText(Activity6_7p.this,"error",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(documentSnapshot.exists()){
                    String titleGetFromDb=documentSnapshot.getString(TITLE);
                    String detailsGetFromDb=documentSnapshot.getString(DETAILS);
                    title_view.setText(titleGetFromDb);
                    details_view.setText(detailsGetFromDb);
                    title_edit.setText(titleGetFromDb);
                    details_edit.setText(detailsGetFromDb);

                }else {
                    title_view.setText("Title");
                    details_view.setText("Details");
                }
            }
        });
    }

    public void save_data(View v){
        String title=title_edit.getText().toString();
        String details=details_edit.getText().toString();
        Map<String,Object> dataOfEdittext=new HashMap<>();
        dataOfEdittext.put(TITLE,title);
        dataOfEdittext.put(DETAILS,details);
        documentReference.set(dataOfEdittext).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(Activity6_7p.this,"Successfully saved",Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Activity6_7p.this,"Try again",Toast.LENGTH_SHORT).show();
            }
        });
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    String titleGetFromDb=documentSnapshot.getString(TITLE);
                    String detailsGetFromDb=documentSnapshot.getString(DETAILS);
                    title_view.setText(titleGetFromDb);
                    details_view.setText(detailsGetFromDb);


                }else {
                    title_view.setText("Title");
                    details_view.setText("Details");

                }

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
        title_edit.setVisibility(View.GONE);
        details_edit.setVisibility(View.GONE);
        save_button.setVisibility(View.GONE);
        title_view.setVisibility(View.VISIBLE);
        details_view.setVisibility(View.VISIBLE);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.edit_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.edit_menu_icon_button:

                if(title_edit.getVisibility()==View.VISIBLE&&details_edit.getVisibility()==View.VISIBLE&&save_button.getVisibility()==View.VISIBLE){
                    title_edit.setVisibility(View.GONE);
                    details_edit.setVisibility(View.GONE);
                    save_button.setVisibility(View.GONE);
                    title_view.setVisibility(View.VISIBLE);
                    details_view.setVisibility(View.VISIBLE);

                }else {
                    title_edit.setVisibility(View.VISIBLE);
                    details_edit.setVisibility(View.VISIBLE);
                    save_button.setVisibility(View.VISIBLE);
                    title_view.setVisibility(View.GONE);
                    details_view.setVisibility(View.GONE);
                }

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
}