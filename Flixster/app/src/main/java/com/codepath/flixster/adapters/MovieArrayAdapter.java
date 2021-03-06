package com.codepath.flixster.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.flixster.R;
import com.codepath.flixster.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by darwinmendyke on 1/3/17.
 */
public class MovieArrayAdapter extends ArrayAdapter<Movie> {

    public MovieArrayAdapter(Context context,  List<Movie> movies) {
        super(context, android.R.layout.simple_list_item_1, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // get the data item for position
        Movie movie = getItem(position);

        // check if existing view is being reused
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);
        }

        // find the image view
        ImageView ivImage = (ImageView) convertView.findViewById(R.id.movieImage);
        // clear out image from converView
        ivImage.setImageResource(0);

        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView overview = (TextView) convertView.findViewById(R.id.overview);

        // populate data
        title.setText(movie.getOriginalTitle());
        overview.setText(movie.getOverview());
 
        Picasso.with(getContext()).load(movie.getPosterPath()).into(ivImage);
        // return the view
        return convertView;
    }
}
