package com.example.customadapterpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
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
        names.add("Pikachu");
        names.add("Squirtle");
        names.add("Charmander");
        names.add("Bulbasaur");
        names.add("Charizard");
        names.add("Eevee");
        CustomAdapter adapter = new CustomAdapter(this, R.layout.adapter_layout, names);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, i + " ", Toast.LENGTH_LONG).show();
            }
        });
    }
    public class CustomAdapter extends ArrayAdapter<String> {
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

            name.setText(list.get(position).toString());
            Log.d("info", list.get(position).toString());
            switch(list.get(position).toString()) {
                case "Bulbasaur":
                    image.setImageResource(R.drawable.bulbasaur);
                    remove.setText("Plant");
                    remove.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            listView.setBackgroundColor(Color.GREEN);
                        }
                    });
                    break;
                case "Pikachu":
                    image.setImageResource(R.drawable.pikachu);
                    remove.setText("Lightning");
                    remove.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            listView.setBackgroundColor(Color.YELLOW);
                        }
                    });
                    break;
                case "Squirtle":
                    image.setImageResource(R.drawable.squirtle);
                    remove.setText("Water");
                    remove.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            listView.setBackgroundColor(Color.BLUE);
                        }
                    });
                    break;
                case "Charmander":
                    image.setImageResource(R.drawable.charmander);
                    remove.setText("Fire");
                    remove.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            listView.setBackgroundColor(Color.RED);
                        }
                    });
                    break;
                case "Charizard":
                    image.setImageResource(R.drawable.charizard);
                    remove.setText("Fire");
                    remove.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            listView.setBackgroundColor(Color.RED);
                        }
                    });
                    break;
                case "Eevee":
                    image.setImageResource(R.drawable.eevee);
                    remove.setText("Neutral");
                    remove.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            listView.setBackgroundColor(Color.GRAY);
                        }
                    });
                    break;
                default:
                    // code block
            }

            return adapterLayout;
        }
    }
    public class Pokemon{
        String type;
        String color;
        public Pokemon(String type, String color){
            this.type = type;
            this.color = color;
        }

        public String getColor(){
            return color;
        }
        public String getType(){
            return type;
        }
    }
}