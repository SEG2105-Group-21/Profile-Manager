package com.example.profilemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class ProfileActivity extends AppCompatActivity {

    // The 9 icon buttons.
    ImageView avatar00;
    ImageView avatar01;
    ImageView avatar02;
    ImageView avatar03;
    ImageView avatar04;
    ImageView avatar05;
    ImageView avatar06;
    ImageView avatar07;
    ImageView avatar08;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        avatar00 = (ImageView) findViewById(R.id.flagid00);
        avatar00.setTag(R.drawable.img_00);
        avatar01 = (ImageView) findViewById(R.id.flagid01);
        avatar01.setTag(R.drawable.img_01);
        avatar02 = (ImageView) findViewById(R.id.flagid02);
        avatar02.setTag(R.drawable.img_02);
        avatar03 = (ImageView) findViewById(R.id.flagid03);
        avatar03.setTag(R.drawable.img_03);
        avatar04 = (ImageView) findViewById(R.id.flagid04);
        avatar04.setTag(R.drawable.img_04);
        avatar05 = (ImageView) findViewById(R.id.flagid05);
        avatar05.setTag(R.drawable.img_05);
        avatar06 = (ImageView) findViewById(R.id.flagid06);
        avatar06.setTag(R.drawable.img_06);
        avatar07 = (ImageView) findViewById(R.id.flagid07);
        avatar07.setTag(R.drawable.img_07);
        avatar08 = (ImageView) findViewById(R.id.flagid08);
        avatar08.setTag(R.drawable.img_08);

        avatar00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTeamIcon(view);
            }
        });
        avatar01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTeamIcon(view);
            }
        });
        avatar02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTeamIcon(view);
            }
        });
        avatar03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTeamIcon(view);
            }
        });
        avatar04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTeamIcon(view);
            }
        });
        avatar05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTeamIcon(view);
            }
        });
        avatar06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTeamIcon(view);
            }
        });
        avatar07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTeamIcon(view);
            }
        });
        avatar08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTeamIcon(view);
            }
        });
    }

    // method that forwards the ID that the user clicks to later use as the avatar for the profile
    public void setTeamIcon(View view) {

        //creating a return intent to pass to the main activity
        Intent returnIntent = new Intent();

        // figuring out which image was clicked
        View selectedImage = view;

        // adding details to the return intent
        returnIntent.putExtra("imageID", (int) selectedImage.getTag());
        setResult(RESULT_OK, returnIntent);

        // finishing the activity and returning to the main screen
        finish();
    }
}
