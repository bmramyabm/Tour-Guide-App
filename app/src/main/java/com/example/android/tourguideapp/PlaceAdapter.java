package com.example.android.tourguideapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class PlaceAdapter extends ArrayAdapter<Place> {

    public PlaceAdapter(@NonNull Context context, @NonNull ArrayList<Place> objects) {
        super(context, 0, objects);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override

    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        Place currentPlace = (Place) getItem(position);

        TextView place_text_view = (TextView) convertView.findViewById(R.id.place_text_view);
        // Get the default translation from the currentWord object and set this text on
        // the default TextView.
        place_text_view.setText(currentPlace.getPlaceName());

        ImageView itemImageView = (ImageView) convertView.findViewById(R.id.item_image);
        itemImageView.setImageResource(currentPlace.getImageResourceID());

        return convertView;
    }

}
