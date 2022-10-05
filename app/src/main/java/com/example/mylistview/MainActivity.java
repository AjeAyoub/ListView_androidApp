package com.example.mylistview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
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

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String [] mTitle = {"Singapore","Ottawa","Rabat","Washington","Londres","Bangkok","Berlin"};
    String [] mDescription = {"capital of Singapore","capital of Canada","capital of Morocco","capital of US","capital of UK","capital of Thailand","capital of Germany"};
    int [] images = {R.drawable.singapore,R.drawable.ottawa,R.drawable.rabat,R.drawable.washington,R.drawable.london,R.drawable.bangkok,R.drawable.berlin};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView1);



        MyAdapter adapter = new MyAdapter(this, mTitle , mDescription ,images );
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){

                    Toast.makeText(MainActivity.this,"capital of Singapore" , Toast.LENGTH_SHORT).show();

                }
                if (position == 1){

                    Toast.makeText(MainActivity.this,"capital of Canada" , Toast.LENGTH_SHORT).show();
                }
                if (position == 2){
                    Toast.makeText(MainActivity.this,"capital of Morocco" , Toast.LENGTH_SHORT).show();
                }
                if (position == 3){
                    Toast.makeText(MainActivity.this,"capital of US" , Toast.LENGTH_SHORT).show();
                }
                if (position == 4){
                    Toast.makeText(MainActivity.this,"capital of Uk" , Toast.LENGTH_SHORT).show();
                }
                if (position == 5){
                    Toast.makeText(MainActivity.this,"capital of Thailand" , Toast.LENGTH_SHORT).show();
                }
                if (position == 6){
                    Toast.makeText(MainActivity.this,"capital of Germany" , Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String [] rTitle;
        String [] rDescription;
        int [] rImgs;


        public MyAdapter(Context c, String[] title, String[] description, int[] imgs) {
            super(c, R.layout.row, R.id.textView1 ,title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row,parent,false);

            ImageView myImages = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            myImages.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);


            return row ;
        }
    }
}