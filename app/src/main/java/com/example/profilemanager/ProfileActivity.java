package com.example.profilemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class ProfileActivity extends AppCompatActivity {

    // acts as a button. avatar00 corresponds to flagid00 in activity_profile.xml
    ImageView avatar00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // this block of code below is currently redundant as the avatar images in TableLayout
        //  doesn't even show up on screen. Edit or delete at your convenience. - Kien
        avatar00 = (ImageView) findViewById(R.id.flagid00);

        avatar00.setOnClickListener(new View.OnClickListener() {
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
        ImageView selectedImage = (ImageView) view;

        // adding details to the return intent
        returnIntent.putExtra("imageID", selectedImage.getId());
        setResult(RESULT_OK, returnIntent);

        //finninshing the activity and returning to the main screen
        finish();
    }
}
