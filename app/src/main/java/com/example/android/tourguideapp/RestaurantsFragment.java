package com.example.android.tourguideapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RestaurantsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RestaurantsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RestaurantsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RestaurantsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RestaurantsFragment newInstance(String param1, String param2) {
        RestaurantsFragment fragment = new RestaurantsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Create an array of places
        ArrayList<Place> places = new ArrayList<Place>();

        // Add to an array new objects with the data


        places.add(new Place(getString(R.string.restaurant1),R.drawable.food,getString(R.string.restaurant1website)));
        places.add(new Place(getString(R.string.restaurant2),R.drawable.hotel,getString(R.string.restaurant2website)));
        places.add(new Place(getString(R.string.restaurant3),R.drawable.mall,getString(R.string.restaurant3website)));
        places.add(new Place(getString(R.string.restaurant4),R.drawable.food,getString(R.string.restaurant4website)));
        places.add(new Place(getString(R.string.restaurant5),R.drawable.hotel,getString(R.string.restaurant5website)));


        // Inflate current View object in places_list.xml
        View rootView = inflater.inflate(R.layout.places_list, container, false);

        // Create PlaceAdapter object in current activity for data from places array
        PlaceAdapter placeAdapter = new PlaceAdapter(getActivity(), places);

        // Create ListView object in places_list.xml and set the PlaceAdapter object to it
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(placeAdapter);
        //Intent to bring up a detail screen of the item that is clicked.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Place currentPlace = (Place) parent.getItemAtPosition(position);
                String place_name = currentPlace.getPlaceName();
                String website = currentPlace.getWebsite();
                int image = currentPlace.getImageResourceID();
                Intent intent = new Intent(getActivity(), PlaceDetailActivity.class);
                intent.putExtra("PlaceName", place_name);
                intent.putExtra("Website", website);
                intent.putExtra("Image", image);
                startActivity(intent);
            }
        });
        // Return current View object with the data
        return rootView;
    }
}