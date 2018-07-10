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

public class RestaurantFragment extends Fragment {


    public RestaurantFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        // Create a list of locations
        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(R.string.laplage_restaurant, R.string.laplage,
                R.drawable.ic_littledos, "geo:15.640433, 73.719171"));
        locations.add(new Location(R.string.sakana_restaurant, R.string.sakana,
                R.drawable.ic_longdoggers, "geo:15.598815, 73.74655"));

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