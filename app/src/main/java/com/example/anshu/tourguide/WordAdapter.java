package com.example.anshu.tourguide;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Location>  {

    private int mColorResourceId;
    public WordAdapter(Context context, ArrayList<Location> locations, int colorResourceId) {
        super(context, 0, locations);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Location currentLocation = getItem(position);
        TextView miwokTextView =  listItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(currentLocation.getMiwokTranslationId());

        TextView defaultTextView =  listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentLocation.getDefaultTranslationId());

        ImageView imageView = listItemView.findViewById(R.id.image);
        if (currentLocation.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentLocation.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}