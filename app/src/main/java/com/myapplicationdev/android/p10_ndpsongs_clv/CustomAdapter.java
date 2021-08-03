package com.myapplicationdev.android.p10_ndpsongs_clv;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context context;
    int layout_id;
    ArrayList<Song> SongList;

    public CustomAdapter(Context context, int resource, ArrayList<Song> SongList) {
        super(context, resource, SongList);

        this.context = context;
        this.layout_id = resource;
        this.SongList = SongList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvTitle = rowView.findViewById(R.id.tvTitle);
        TextView tvSinger = rowView.findViewById(R.id.tvSinger);
        TextView tvYear = rowView.findViewById(R.id.tvYear);
        RatingBar rbStars = rowView.findViewById(R.id.rbStars);
        ImageView ivNew = rowView.findViewById(R.id.ivNew);

        Song currItem = SongList.get(position);

        tvTitle.setText(currItem.getTitle());
        tvSinger.setText(currItem.getSingers());
        tvYear.setText(String.valueOf(currItem.getYearReleased()));
        rbStars.setRating((currItem.getStars()));

        tvTitle.setTextColor(Color.BLUE);
        tvTitle.setTextSize(20f);
        tvSinger.setTextColor(Color.rgb(117,255,255));
        tvYear.setTextColor(Color.GRAY);


        if (currItem.getYearReleased() >= 1999) {
            ivNew.setVisibility(View.VISIBLE);
        }
        else {
            ivNew.setVisibility(View.INVISIBLE);
        }

        return rowView;
    }


}
