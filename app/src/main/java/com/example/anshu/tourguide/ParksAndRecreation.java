package com.example.anshu.tourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ParksAndRecreation extends Fragment {

    public ParksAndRecreation() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        // Create a list of locations
        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(R.string.bardez_goa, R.string.splashdown_waterpark,
                R.drawable.ic_boatramp, "geo:15.579003,73.758791"));
        locations.add(new Location(R.string.nuvemgoa, R.string.froggy,
                R.drawable.ic_tennis_courts, "geo:15.321632, 73.951931"));

        WordAdapter adapter = new WordAdapter(getActivity(), locations, R.color.category_parks);

        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Location location = locations.get(position);
                showMap(Uri.parse(location.getAudioResourceId()));
            }
        });
        return rootView;
    }

    public void showMap(Uri geoLocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}