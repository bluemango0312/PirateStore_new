package com.cookandroid.piratestore_new;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import java.util.HashMap;
import java.util.Map;

public class JoinActivity extends AppCompatActivity {
    EditText ID;
    EditText PW;
    EditText NAME;
    EditText NUMBER;
    Button createProfileBtn;
    Button twitterBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        //상태바, 하단바 레이아웃 관련
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        View mainLayout = findViewById(R.id.fullScreen);
        //ExtensionUtils.setPaddingForStatusBar(mainLayout, this);

        ID = findViewById(R.id.IDplainText);
        PW = findViewById(R.id.PWplainText);
        NAME = findViewById(R.id.nameplainText);
        NUMBER = findViewById(R.id.NumberplainText);
        createProfileBtn = findViewById(R.id.profileJoinBtn);
        twitterBtn = findViewById(R.id.twitterBtn);

        //mAuth = FirebaseAuth.getInstance();


        createProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = ID.getText().toString();
                String pw = PW.getText().toString();
                String name = NAME.getText().toString();
                String number = NUMBER.getText().toString();

                if (!id.isEmpty() && !pw.isEmpty() && !name.isEmpty() && !number.isEmpty()) {
                }
            }
        });

        twitterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}


