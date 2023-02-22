package com.example.customadapterdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> names = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listid);
        names = new ArrayList<>();
        names.add("Rudolph");
        names.add("Comet");
        names.add("Blitzen");
        names.add("Donner");
        names.add("Cupid");
        names.add("Dasher");
        names.add("Dancer");
        names.add("Prancer");
        names.add("Vixen");
        CustomAdapter adapter = new CustomAdapter(this, R.layout.adapter_layout, names);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, i + " ", Toast.LENGTH_LONG).show();
            }
        });
    }

    public class CustomAdapter extends ArrayAdapter<String>{
        List list;
        Context context;
        int xmlResource;

        public CustomAdapter(Context context, int resource, List<String> objects){
            super(context, resource, objects);
            xmlResource = resource;
            list = objects;
            this.context = context;
        }
        public View getView(int position, View convertView, ViewGroup parent){
            //return super.getView(position, convertView, parent);
            //we are getting specific so we mute this
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View adapterLayout = layoutInflater.inflate(xmlResource, null);
            //root has to do with heirarchy of Views, keep null for out purposes

            TextView name = adapterLayout.findViewById(R.id.textView);
            ImageView image = adapterLayout.findViewById(R.id.imageView);
            Button remove = adapterLayout.findViewById(R.id.button);
            remove.setText("remove");

            remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    list.remove(position);
                    notifyDataSetChanged();
                }
            });
            name.setText(list.get(position) + " " + position);
            image.setImageResource(R.drawable.reindeer);
            return adapterLayout;
        }

    }


}