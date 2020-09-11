package com.example.amchack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class FilteredBirdsActivity extends AppCompatActivity {
    ApiInterface apiInterface;
    private RecyclerView mRecyclerView;
    private ArrayList<Bird> birdList;
    private FilteredBirdsAdapter mFilteredBirdsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birds);


        mRecyclerView = findViewById(R.id.filtered_recycler_view);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mFilteredBirdsAdapter = new FilteredBirdsAdapter(FilteredBirdsActivity.this, new ArrayList<Bird>() );
        mRecyclerView.setAdapter(mFilteredBirdsAdapter);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        getFilteredBirds();

        /*
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            mBirds = bundle.getParcelableArrayList("Birds");
        }

         */
    }

    private void getFilteredBirds() {
        Call<List<Bird>> call = apiInterface.getFilteredBirds("Серая", "С воробья");
        call.enqueue(new Callback<List<Bird>>() {
            @Override
            public void onResponse(Call<List<Bird>> call, retrofit2.Response<List<Bird>> response) {
                birdList = new ArrayList<>(response.body());
                mFilteredBirdsAdapter = new FilteredBirdsAdapter(FilteredBirdsActivity.this, birdList);
                mRecyclerView.setAdapter(mFilteredBirdsAdapter);
            }

            @Override
            public void onFailure(Call<List<Bird>> call, Throwable t) {

            }
        });
    }
}