package com.example.amchack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class BirdsActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ArrayList<Bird> birds;
    private BirdsAdapter mBirdsAdapter;
    private ArrayList<Bird> mBirds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birds);

        mBirdsAdapter = new BirdsAdapter();
        mRecyclerView = findViewById(R.id.found_birds);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mRecyclerView.setAdapter(mBirdsAdapter);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            mBirds = bundle.getParcelableArrayList("Birds");
        }
    }
}