package com.example.android.tourguideapp;

public class Place {
    // Name of an attraction place
    private String mPlaceName;
    // Photo of an attraction place
    private int mImageResourceID;
    private String mWebsite;
    /**
     * Create a new {@link Place} object.
     *
     * @param placeName       is the name of an attraction place.
     * @param imageResourceID is the photo of an attraction place.
     */
    public Place(String placeName, int imageResourceID) {
        mPlaceName = placeName;
        mImageResourceID = imageResourceID;
    }

    public Place(String placeName, int imageResourceID, String website) {
        mPlaceName = placeName;
        mImageResourceID = imageResourceID;
        mWebsite = website;
    }

    // Get the name of an attraction place
    public String getPlaceName() {
        return mPlaceName;
    }

    // Get the photo's ID of an attraction place
    public int getImageResourceID() {
        return mImageResourceID;
    }

    public String getWebsite() {
        return mWebsite;
    }

}
