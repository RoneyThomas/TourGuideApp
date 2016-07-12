package me.roneythomas.tourguideapp;

import android.content.Context;
import android.net.Uri;

public class Location {
    private Uri mGmmIntentUri;
    private String mAddress;

    Location(Context context, int mGmmIntentUri, int mAddress) {
        this.mGmmIntentUri = Uri.parse("geo:" + context.getString(mGmmIntentUri) + "?q=" + Uri.encode(context.getString(mAddress)));
        this.mAddress = context.getString(mAddress);
    }

    public Uri getGmmIntentUri() {
        return mGmmIntentUri;
    }

    public String getAddress() {
        return mAddress;
    }
}
