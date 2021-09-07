package com.example.android.tourguideapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PlaceDetailActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_detail);

        Intent currentPlace = getIntent();

        //Set the corresponding TextView and ImageViews in the detail layout
        //depending on what is clicked;
        TextView placeTextView = findViewById(R.id.title_large);
        String titleForPlaying = currentPlace.getStringExtra("PlaceName");
        placeTextView.setText(titleForPlaying);


        ImageView detailImage = (ImageView) findViewById(R.id.large_image);
        int image = currentPlace.getIntExtra("Image", 0);
        detailImage.setImageResource(image);

        //Intent for opening a browser app and navigating to the website;
        //Intent corresponds  to the 'link' ImageView in activity_place_detail
        String website = currentPlace.getStringExtra("Website");
        ImageView goToWebsite = (ImageView) findViewById(R.id.go_to_website);
        goToWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentWebsite = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
                startActivity(intentWebsite);
            }
        });
    }


}


