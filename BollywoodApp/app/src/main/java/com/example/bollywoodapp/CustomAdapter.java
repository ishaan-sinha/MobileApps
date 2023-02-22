package com.example.bollywoodapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Actor> {
    List<Actor> MaleList;
    List<Actor> FemaleList;
    Context context;
    int xmlResource;

    public CustomAdapter(Context context, int resource, List<Actor> maleList){
        super(context, resource, maleList);
        xmlResource = resource;
        this.MaleList = maleList;
        FemaleList = MainActivity.femaleNames;
        this.context = context;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        //return super.getView(position, convertView, parent);
        //we are getting specific so we mute this

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View adapterLayout = layoutInflater.inflate(xmlResource, null);
        //root has to do with heirarchy of Views, keep null for our purposes

        TextView name = adapterLayout.findViewById(R.id.textView);
        ImageView image = adapterLayout.findViewById(R.id.imageView);
        Button b1 = adapterLayout.findViewById(R.id.button);
        TextView movie = adapterLayout.findViewById(R.id.textView3);

        name.setText(MaleList.get(position).getName());
        movie.setText("Latest Movie: " + MaleList.get(position).getLatestMovie());
        image.setImageResource(MaleList.get(position).getImage());
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MainActivity.switched.contains(position)){
                    MainActivity.switched.remove(Integer.valueOf(position));
                }
                else{
                    MainActivity.switched.add(position);
                }
                Actor temp = FemaleList.get(position);
                FemaleList.set(position, MaleList.get(position));
                MaleList.set(position, temp);
                name.setText(MaleList.get(position).getName());
                image.setImageResource(MaleList.get(position).getImage());
                movie.setText("Latest Movie: " + MaleList.get(position).getLatestMovie());
            }
        });

        return adapterLayout;
    }
}
