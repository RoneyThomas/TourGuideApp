package me.roneythomas.tourguideapp;

import android.content.Context;

import java.util.ArrayList;


public class PlacesLab {
    private static PlacesLab sPlaceLab;

    public static final int TOURIST_ATTRACTIONS = 0;
    public static final int PARKS = 1;
    public static final int HOTELS = 2;
    public static final int EVENTS = 3;

    private ArrayList<Places> mTouristAttractions;
    private ArrayList<Places> mParks;
    private ArrayList<Places> mHotels;
    private ArrayList<Places> mEvents;

    public static PlacesLab getInstance(Context context) {
        if (sPlaceLab == null) {
            sPlaceLab = new PlacesLab(context);
        }
        return sPlaceLab;
    }

    private PlacesLab(Context context) {
        Location cnTowerLocation = new Location(context, R.string.tourist_attraction_1_uri, R.string.tourist_attraction_1_address);
        Location romLocation = new Location(context, R.string.tourist_attraction_2_uri, R.string.tourist_attraction_2_address);
        Location ripleysAquariumLocation = new Location(context, R.string.tourist_attraction_3_uri, R.string.tourist_attraction_3_address);

        Places cnTower = new Places(R.string.tourist_attraction_1_title, R.string.tourist_attraction_1_description, R.drawable.cn_tower, cnTowerLocation);
        Places rom = new Places(R.string.tourist_attraction_2_title, R.string.tourist_attraction_2_description, R.drawable.rom, romLocation);
        Places ripleysAquarium = new Places(R.string.tourist_attraction_3_title, R.string.tourist_attraction_3_description, R.drawable.ripleys_aquarium, ripleysAquariumLocation);

        mTouristAttractions = new ArrayList<>();
        mTouristAttractions.add(cnTower);
        mTouristAttractions.add(rom);
        mTouristAttractions.add(ripleysAquarium);

        Location highParkLocation = new Location(context, R.string.parks_1_uri, R.string.parks_1_address);
        Location centreIslandLocation = new Location(context, R.string.parks_2_uri, R.string.parks_2_address);
        Location bluffersParkLocation = new Location(context, R.string.parks_3_uri, R.string.parks_3_address);

        Places highPark = new Places(R.string.parks_1_title, R.string.parks_1_description, R.drawable.high_park, highParkLocation);
        Places centreIsland = new Places(R.string.parks_2_title, R.string.parks_2_description, R.drawable.centre_island, centreIslandLocation);
        Places bluffersPark = new Places(R.string.parks_3_title, R.string.parks_3_description, R.drawable.bluffers_park, bluffersParkLocation);

        mParks = new ArrayList<>();
        mParks.add(highPark);
        mParks.add(centreIsland);
        mParks.add(bluffersPark);

        Location drakeHotelLocation = new Location(context, R.string.hotel_1_uri, R.string.hotel_1_address);
        Location fourSeasonsHotellLocation = new Location(context, R.string.hotel_2_uri, R.string.hotel_2_address);
        Location shangriLaHoteLocation = new Location(context, R.string.hotel_3_uri, R.string.hotel_3_address);

        Places drakeHotel = new Places(R.string.hotel_1_title, R.string.hotel_1_description, R.drawable.drake_hotel, drakeHotelLocation);
        Places fourSeasonsHotel = new Places(R.string.hotel_2_title, R.string.hotel_2_description, R.drawable.four_seasons_hotel, fourSeasonsHotellLocation);
        Places shangriLaHotel = new Places(R.string.hotel_3_title, R.string.hotel_3_description, R.drawable.shangri_la_hotel, shangriLaHoteLocation);

        mHotels = new ArrayList<>();
        mHotels.add(drakeHotel);
        mHotels.add(fourSeasonsHotel);
        mHotels.add(shangriLaHotel);

        Location cneLocation = new Location(context, R.string.events_1_uri, R.string.events_1_address);
        Location tiffLocation = new Location(context, R.string.events_2_uri, R.string.events_2_address);
        Location fanExpoLocation = new Location(context, R.string.events_3_uri, R.string.events_3_address);

        Places cne = new Places(R.string.events_1_title, R.string.events_1_description, R.drawable.cne, cneLocation);
        Places tiff = new Places(R.string.events_2_title, R.string.events_2_description, R.drawable.tiff, tiffLocation);
        Places fanExpo = new Places(R.string.events_3_title, R.string.events_3_description, R.drawable.fan_expo, fanExpoLocation);

        mEvents = new ArrayList<>();
        mEvents.add(cne);
        mEvents.add(tiff);
        mEvents.add(fanExpo);
    }

    public ArrayList<Places> get(int choice) {
        switch (choice) {
            case TOURIST_ATTRACTIONS:
                return mTouristAttractions;
            case PARKS:
                return mParks;
            case HOTELS:
                return mHotels;
            case EVENTS:
                return mEvents;
            default:
                return null;
        }
    }
}
