package com.example.amchack;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Q_1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Q_1Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RadioGroup mRadioGroup;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Q_1Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Q_1Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Q_1Fragment newInstance(String param1, String param2) {
        Q_1Fragment fragment = new Q_1Fragment();
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
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       final View v = inflater.inflate(R.layout.fragment_q_1, container, false);
       getActivity().findViewById(R.id.for_dark).setBackgroundResource(R.drawable.black_trans_back);

       // окрас

        mRadioGroup = v.findViewById(R.id.answers_radio_group);
        RadioButton r = mRadioGroup.findViewById(R.id.radioButton1);
        r.setChecked(true);
        int radioButtonID = mRadioGroup.getCheckedRadioButtonId();
        View radioButton = mRadioGroup.findViewById(radioButtonID);
        DetectBirdActivity.birdForDetect.setColor(r.getText().toString());

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                RadioButton r = mRadioGroup.findViewById(mRadioGroup.getCheckedRadioButtonId());

                DetectBirdActivity.birdForDetect.setColor(r.getText().toString());
            }
        });
       return v;
    }
}