package me.roneythomas.tourguideapp;


/**
 * Created by roneythomas on 2016-07-01.
 */
public class Places {
    private int mTitle;
    private int mDescription;
    private int mImage;
    private Location mLocation;

    Places(int mTitle, int mDescription, int mImage, Location mLocation) {
        this.mTitle = mTitle;
        this.mDescription = mDescription;
        this.mImage = mImage;
        this.mLocation = mLocation;
    }

    public int getImage() {
        return mImage;
    }

    public void setImage(int mImage) {
        this.mImage = mImage;
    }

    public int getTitle() {
        return mTitle;
    }

    public void setTitle(int mTitle) {
        this.mTitle = mTitle;
    }

    public int getDescription() {
        return mDescription;
    }

    public void setDescription(int mDescription) {
        this.mDescription = mDescription;
    }

    public Location getLocation() {
        return mLocation;
    }

    public void setLocation(Location location) {
        mLocation = location;
    }
}
