package com.example.imageslider;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.imageslider.Adapter.ViewPagerAdapter;
import com.example.imageslider.Listener.IFirebaseLoader;
import com.example.imageslider.Modal.News;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    DatabaseReference databaseReference;

    IFirebaseLoader firebaseLoader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference = FirebaseDatabase.getInstance().getReference("News");

//        firebaseLoader = this;

        loadNews();

        viewPager = findViewById(R.id.view_pager);


    }

    private void loadNews() {
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            List<News> News_image_list = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()) {
                    News_image_list.add(dataSnapshot1.getValue(News.class));
                }
                onFirebaseLoadSuccess(News_image_list);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void onFirebaseLoadSuccess(List<News> News_image_list) {

        viewPagerAdapter = new ViewPagerAdapter(this, News_image_list);
        viewPager.setAdapter(viewPagerAdapter);

    }
}
