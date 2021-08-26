package com.pabi.yourday;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    TextView t6a,t7a,t8a,t9a,t10a,t11a,t12a,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t1a,t2a,t3a,t4a,t5a;
    private static final String TAG = "Main Activity";
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });



        mAuth = FirebaseAuth.getInstance();
        mAuth.signInAnonymously()
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {


                            FirebaseUser user = mAuth.getCurrentUser();

                        } else {


                            Toast.makeText(MainActivity.this, "Some error occurred reopen the app",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });




        t6a=findViewById(R.id.textView);
        t6a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 =new Intent(MainActivity.this,Activity6_7.class);
                startActivity(intent1);
            }
        });
        t7a=findViewById(R.id.textView2);
        t7a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 =new Intent(MainActivity.this,Activity7_8.class);

                startActivity(intent2);
            }
        });
        t8a=findViewById(R.id.textView3);
        t8a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 =new Intent(MainActivity.this,Activity8_9.class);

                startActivity(intent3);
            }
        });
        t9a=findViewById(R.id.textView4);
        t9a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 =new Intent(MainActivity.this,Activity9_10.class);

                startActivity(intent4);
            }
        });
        t10a=findViewById(R.id.textView5);
        t10a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 =new Intent(MainActivity.this,Activity10_11.class);

                startActivity(intent5);
            }
        });
        t11a=findViewById(R.id.textView6);
        t11a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent6 =new Intent(MainActivity.this,Activity11_12.class);

                startActivity(intent6);
            }
        });
        t12a=findViewById(R.id.textView7);
        t12a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent7 =new Intent(MainActivity.this,Activity12_1p.class);

                startActivity(intent7);
            }
        });
        t1=findViewById(R.id.textView8);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent8 =new Intent(MainActivity.this,Activity1_2p.class);

                startActivity(intent8);
            }
        });
        t2=findViewById(R.id.textView9);
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,Activity2_3p.class);

                startActivity(intent);
            }
        });
        t3=findViewById(R.id.textView10);
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent8 =new Intent(MainActivity.this,Activity3_4p.class);

                startActivity(intent8);
            }
        });
        t4=findViewById(R.id.textView11);
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,Activity4_5p.class);

                startActivity(intent);
            }
        });
        t5=findViewById(R.id.textView12);
        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,Activity5_6p.class);

                startActivity(intent);
            }
        });
        t6=findViewById(R.id.textView13);
        t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,Activity6_7p.class);

                startActivity(intent);
            }
        });
        t7=findViewById(R.id.textView14);
        t7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,Activity7_8p.class);

                startActivity(intent);
            }
        });
        t8=findViewById(R.id.textView15);
        t8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,Activity8_9p.class);

                startActivity(intent);
            }
        });
        t9=findViewById(R.id.textView16);
        t9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,Activity9_10p.class);

                startActivity(intent);
            }
        });
        t10=findViewById(R.id.textView17);
        t10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,Activity10_11p.class);

                startActivity(intent);
            }
        });
        t11=findViewById(R.id.textView18);
        t11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,Activity11_12p.class);

                startActivity(intent);
            }
        });
        t12=findViewById(R.id.textView19);
        t12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,Activity12_1.class);

                startActivity(intent);
            }
        });
        t1a=findViewById(R.id.textView20);
        t1a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,Activity1_2.class);

                startActivity(intent);
            }
        });
        t2a=findViewById(R.id.textView21);
        t2a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,Activity2_3.class);

                startActivity(intent);
            }
        });
        t3a=findViewById(R.id.textView22);
        t3a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,Activity3_4.class);

                startActivity(intent);
            }
        });
        t4a=findViewById(R.id.textView23);
        t4a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,Activity4_5.class);

                startActivity(intent);
            }
        });
        t5a=findViewById(R.id.textView24);
        t5a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,Activity5_6.class);

                startActivity(intent);
            }
        });
    }
    @Override
    public void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();

    }

}