package com.example.prit.instagramviewer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Prit on 2/3/2015.
 */
public class InstagramPhotosAdapter extends ArrayAdapter<InstagramPhoto> {

    public InstagramPhotosAdapter(Context context, List<InstagramPhoto> objects) {
        super(context, android.R.layout.simple_list_item_1, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        InstagramPhoto photo = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.items_photo,parent,false);

        }
        TextView tvCaption = (TextView)convertView.findViewById(R.id.tvCaption);
        TextView tvLikes = (TextView)convertView.findViewById(R.id.tvLikes);
        TextView tvUser = (TextView)convertView.findViewById(R.id.tvUser);
        ImageView imProfile = (ImageView)convertView.findViewById(R.id.imProfile);
        ImageView ivPhoto = (ImageView)convertView.findViewById(R.id.ivPhoto);
        tvCaption.setText(photo.caption);
        tvLikes.setText("* Likes " + photo.likesCount);
        tvUser.setText(photo.username);
        imProfile.setImageResource(0);
        Picasso.with(getContext()).load(photo.profilepic).into(imProfile);
        ivPhoto.setImageResource(0);
        Picasso.with(getContext()).load(photo.imageurl).into(ivPhoto);
        return convertView;
    }
}
