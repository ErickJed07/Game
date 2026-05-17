package com.example.learningprocess;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> textList  = new ArrayList<>();
    ArrayList<Integer> shapeList = new ArrayList<>();
    public GridAdapter(Context context, ArrayList<String> a_text, ArrayList<Integer> a_image) {
        this.context = context;
        this.textList = a_text;
        this.shapeList = a_image;
    }

    @Override
    public int getCount() {
        return textList.size();
    }

    @Override
    public Object getItem(int position) {
        return shapeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        @SuppressLint("ViewHolder") View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.grid_shapes,parent,false);

        ImageView imageView = view.findViewById(R.id.shapeView);
        TextView textView = view.findViewById(R.id.textView);

        textView.setText(textList.get(position));
        imageView.setImageResource(shapeList.get(position));

        return view;
    }
}
