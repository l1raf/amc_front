package com.example.amchack;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Q_2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Q_2Fragment extends Fragment {

    private RadioGroup mRadioGroup;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public Q_2Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Q_2Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Q_2Fragment newInstance(String param1, String param2) {
        Q_2Fragment fragment = new Q_2Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_q_2, container, false);

        mRadioGroup = v.findViewById(R.id.answers_radio_group_2);
        RadioButton r = mRadioGroup.findViewById(R.id.radioButton2_2);
        r.setChecked(true);
        int radioButtonID = mRadioGroup.getCheckedRadioButtonId();
        View radioButton = mRadioGroup.findViewById(radioButtonID);
        DetectBirdActivity.birdForDetect.setColor(r.getText().toString());

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                RadioButton r = mRadioGroup.findViewById(mRadioGroup.getCheckedRadioButtonId());
                DetectBirdActivity.birdForDetect.setSize(r.getText().toString());
            }
        });
        return v;
    }
}