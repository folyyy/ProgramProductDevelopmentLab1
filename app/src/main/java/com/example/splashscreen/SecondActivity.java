package com.example.splashscreen;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    // Getting an array of 1 million numbers and filling it with values from 1 to 1 million.
    int[] NAMES = new int[1000000];
    public void enternum() {
        for (int i = 0; i < 1000000; i++) {
            NAMES[i] = i + 1;
        }
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        enternum();
        // Creating a ListView and then setting up an adapter to it.
        ListView listView = findViewById(R.id.listView);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
    }

    // Class CustomAdapter used to store images and numbers, that are going to be in a customlayout.xml
    class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return NAMES.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            // Putting customlayout in view, then getting each string in the list a number and an image.
            view = getLayoutInflater().inflate(R.layout.customlayout,null);
            ImageView imageView = view.findViewById(R.id.imageView);
            TextView textView_name = view.findViewById(R.id.textView_name);
            imageView.setImageResource(R.drawable.pet);
            // Even numbers getting grey background, odd numbers getting white background.
            if (NAMES[i] % 2 == 0) {
                textView_name.setBackgroundResource(R.color.colorGrey);
            } else textView_name.setBackgroundResource(R.color.colorWhite);
            // Class Num converts numbers into words.
            textView_name.setText(Num.toString(NAMES[i]));
            return view;
        }
    }
}
