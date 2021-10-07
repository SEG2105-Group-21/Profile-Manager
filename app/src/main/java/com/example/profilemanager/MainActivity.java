package com.example.profilemanager;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

/**
 * Profile Manager app for Android devices
 * <p>
 * This app allows a user to manage sports teams. The app is contains Google Maps integration.
 */
public class MainActivity extends AppCompatActivity {

    // create all buttons
    private Button btnGoogleMaps;
    private ImageView avatarImageClickable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize all buttons
        avatarImageClickable = (ImageView) findViewById(R.id.avatarImage);
        avatarImageClickable.bringToFront();
        btnGoogleMaps = findViewById(R.id.google_maps);

        // ==================== add on click listener to buttons ====================

        avatarImageClickable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // starts new activity "ProfileActivity.java" (go to ProfileActivity screen)
                onSetAvatarButton(view);
            }
        });

        btnGoogleMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onOpenInGoogleMaps(view);
            }
        });

    }


    //-------------------------METHODS-----------------------------

    public void onOpenProfileActivity() {
        Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
        startActivity(intent);
    }

    //method to open google maps in our app
    //method used for our OnCLick for the "open in google maps" button

    // NOTE: The text in the field "enterWonderAddress" will automatically be pasted onto google maps search
    public void onOpenInGoogleMaps(View view) {

        //need to add teamAddressTextView later
        EditText teamAddress = (EditText) findViewById(R.id.enterWonderAddress);

        //create a Uri from a string. Use the result to create an indent
        Uri gameIntentUri = Uri.parse("http://maps.google.co.in/maps?q=" + teamAddress.getText());

        //create an intent from gameIntentUri. Set the action to ACTION_VIEW
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gameIntentUri);

        // MAke the intent explicit by setting the google Maps Package
        mapIntent.setPackage("com.google.android.apps.maps");

        //attempt to start the activity that can handle the intent
        startActivity(mapIntent);
    }

    // Method to set a new image for your main profile
    ActivityResultLauncher<Intent> profileActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        //there are no request codes
                        Intent data = result.getData();
                        int resID = data.getIntExtra("imageID", R.drawable.img_00);

                        avatarImageClickable.setImageResource(resID);
                    }
                }
            });

    //method that opens another activity where the user can choose a new avatar for the team profile
    public void onSetAvatarButton(View view) {
        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
        profileActivityResultLauncher.launch(intent);
    }
}



