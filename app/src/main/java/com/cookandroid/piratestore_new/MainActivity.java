package com.cookandroid.piratestore_new;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.OAuthProvider;
import com.google.firebase.auth.TwitterAuthCredential;


public class MainActivity extends AppCompatActivity {
    EditText editText_id;
    EditText editText_pw;
    Button btn_login;
    Button btn_loginTwitter;
    Button btn_join;
    TextView textView_findAccount;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //파이어베이스 초기화
        FirebaseApp.initializeApp(this);
        firebaseAuth = FirebaseAuth.getInstance();

        setContentView(R.layout.activity_main);

        editText_id = findViewById(R.id.plainText_ID);
        editText_pw = findViewById(R.id.plainText_PW);
        btn_login = findViewById(R.id.btn_login);
        btn_loginTwitter = findViewById(R.id.btn_login_twitter);
        btn_join = findViewById(R.id.btn_join);
        textView_findAccount = findViewById(R.id.textView_findAccount);


        //트위터 로그인 구현
        btn_loginTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signInWithTwitter();
            }
        });

        btn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), JoinActivity.class));
            }
        });
    }

    private void signInWithTwitter(){
        try {
            OAuthProvider.Builder provider = OAuthProvider.newBuilder("twitter.com");
            firebaseAuth
                    .startActivityForSignInWithProvider(MainActivity.this, provider.build())
                    .addOnSuccessListener(
                            new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    // User is signed in.
                                    //메인 페이지로 넘기기
                                }
                            })
                    .addOnFailureListener(
                            new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.e("SignInFailure", "Error signing in with Twitter", e);
                                    // Handle failure.
                                }
                            });
        } catch (Exception e) {
            Log.e("SignInException", "Exception during Twitter sign-in", e);
        }
    }


}