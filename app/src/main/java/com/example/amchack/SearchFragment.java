package com.example.amchack;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class SearchFragment extends Fragment implements LoaderManager.LoaderCallbacks<String> {

    private ScrollView mScrollView;
    private Button mButton;
    private RadioGroup mRadioGroup;
    private static String birdName;
    private String[] mNames;
    private SharedPreferencesHelper mSharedPreferencesHelper;

    public static String getBirdName() {
        return birdName;
    }

    public SearchFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        mRadioGroup = view.findViewById(R.id.list_rg);
        mButton = view.findViewById(R.id.add_button);
        mButton.setEnabled(false);

        mSharedPreferencesHelper = new SharedPreferencesHelper(getActivity());

        getNames();
        for (int i = 0; i < mNames.length; i++) {
            RadioButton button = new RadioButton(getContext());
            button.setPadding(10, 0, 10, 10);
            button.setText(mNames[i]);
            button.setId(i);
            mRadioGroup.addView(button);
        }

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                mSharedPreferencesHelper.saveChoice(mNames[checkedId]);
                mButton.setEnabled(true);
                mButton.setText("Добавить птицу!");
            }
        });

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mSharedPreferencesHelper.getChoice();
                Intent intent = new Intent(getActivity(), BirdsActivity2.class);
                startActivity(intent);
            }
        });

        return view;
    }

    private void getNames() {
        Gson gson = new Gson();
        String json = readFileFromRawDirectory(R.raw.birds_names);
        String[] object = gson.fromJson(json, String[].class);
        mNames = object;
    }

    private String readFileFromRawDirectory(int resourceId) {
        InputStream iStream = getContext().getResources().openRawResource(resourceId);
        ByteArrayOutputStream byteStream = null;
        try {
            byte[] buffer = new byte[iStream.available()];
            iStream.read(buffer);
            byteStream = new ByteArrayOutputStream();
            byteStream.write(buffer);
            byteStream.close();
            iStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return byteStream.toString();
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {

    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }
}