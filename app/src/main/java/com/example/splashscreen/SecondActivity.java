package com.example.splashscreen;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        // Creating a ListView and then setting up an adapter to it.
        ListView listView = findViewById(R.id.listView);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
    }

    // If "back" key pressed, finish the app.
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    // Class CustomAdapter used to store images and numbers, that are going to be in a customlayout.xml
    class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return 1000000;
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
            if (i % 2 == 0) {
//                textView_name.setBackgroundResource(R.color.colorWhite);
                view.setBackgroundResource(R.color.colorWhite);
            } else {
//                textView_name.setBackgroundResource(R.color.colorGrey);
                view.setBackgroundResource(R.color.colorGrey);
            }

            // Class Num converts numbers into words.
            textView_name.setText(Num.toString(i+1));
            return view;
        }
    }
}
