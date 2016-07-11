package me.roneythomas.tourguideapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class PlacesFragment extends ListFragment {
    private ArrayList<Places> mPlaces;
    private TextView mTitleTextView, mDescriptionTextView;
    private ImageView mImage;
    private Button mButton;
    private static String mChoice = "choice";


    public static PlacesFragment newInstance(int choice) {

        Bundle args = new Bundle();

        PlacesFragment fragment = new PlacesFragment();
        fragment.setArguments(args);
        args.putInt(mChoice, choice);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_places, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        mPlaces = PlacesLab.getInstance(getActivity()).get(bundle.getInt(mChoice));
        PlacesAdapter mPlacesAdapter = new PlacesAdapter(getContext(), mPlaces);
        setListAdapter(mPlacesAdapter);
    }

    public class PlacesAdapter extends ArrayAdapter<Places> {
        public PlacesAdapter(Context context, ArrayList<Places> mPlaces) {
            super(context, 0, mPlaces);
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View listItemView = convertView;
            if (listItemView == null) {
                listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_layout, parent, false);
            }
            mTitleTextView = (TextView) listItemView.findViewById(R.id.title_text_view);
            mDescriptionTextView = (TextView) listItemView.findViewById(R.id.description_text_view);
            mImage = (ImageView) listItemView.findViewById(R.id.image_view);

            mTitleTextView.setText(mPlaces.get(position).getTitle());
            mDescriptionTextView.setText(mPlaces.get(position).getDescription());
            Glide.with(getActivity()).load(mPlaces.get(position).getImage()).into(mImage);

            mButton = (Button) listItemView.findViewById(R.id.address_button);
            mButton.setText(mPlaces.get(position).getLocation().getAddress());
            mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, mPlaces.get(position).getLocation().getGmmIntentUri());
                    mapIntent.setPackage("com.google.android.apps.maps");
                    startActivity(mapIntent);
                    if (mapIntent.resolveActivity(getContext().getPackageManager()) != null) {
                        startActivity(mapIntent);
                    }
                }
            });
            return listItemView;
        }
    }
}