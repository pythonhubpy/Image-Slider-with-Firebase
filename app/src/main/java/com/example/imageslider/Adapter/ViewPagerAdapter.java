package com.example.imageslider.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.imageslider.Modal.News;
import com.example.imageslider.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {

    Context context;
    List<News> News_image_list;
    LayoutInflater layoutInflater;

    public ViewPagerAdapter(Context context, List<News> News_image_list) {
        this.context = context;
        this.News_image_list = News_image_list;
        layoutInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return News_image_list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ((ViewPager)container).removeView((View)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = layoutInflater.inflate(R.layout.imageslider, container, false);

        ImageView imageView = view.findViewById(R.id.image_slider);
//        Picasso.get().load(News_image_list.get(position).getUrl()).into(imageView);
        Glide.with(context).load(News_image_list.get(position).getUrl()).into(imageView);

        container.addView(view);
        return view;
    }
}
