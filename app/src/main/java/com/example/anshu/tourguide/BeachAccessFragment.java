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

public class BeachAccessFragment extends Fragment {


    public BeachAccessFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);
        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(R.string.beach_access_mobor, R.string.mobor_beach,
                R.drawable.hightowerbeach, "geo:15.157315, 73.946269"));
        locations.add(new Location(R.string.beach_access_sinquerim, R.string.sinquerim_beach,
                R.drawable.ic_pelican, "geo:15.499155,73.767464"));

        WordAdapter adapter = new WordAdapter(getActivity(), locations, R.color.category_beach_access);
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