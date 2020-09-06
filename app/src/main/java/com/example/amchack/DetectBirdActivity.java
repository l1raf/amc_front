package com.example.amchack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class DetectBirdActivity extends AppCompatActivity {

    private TextView mQuestionTV, mQuestion2TV;
    public static FragmentManager fragmentManager;
    private Spinner spinner;
    private Button mKnownButton;
    private RadioGroup mRadioGroup;
    FrameLayout mForDark;
    private RadioButton r1, r2, r3, r4, r5, r6, r7, r8, r9;
    private static OkHttpClient client;
    private final static String url = "https://hseapitraining20200905085422.azurewebsites.net/api/Birds/GetAllBirds";

    private String[] colors_user = {"Черная/черные участки","Белая/белые участки"," Красные/оранжевые участки", "Желтая/зеленая/голубая", "Серая",
            "Бурая/рыжая/коричневая (воробьиные)", "Бурая/рыжая/коричневая (неворобьиные)", "С продольными пестринами", "С поперечными пестринами"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detect_bird);
        mQuestionTV = findViewById(R.id.question_tv);
        mQuestion2TV = findViewById(R.id.question_tv_2);
        mKnownButton = findViewById(R.id.know_button);
        mForDark = findViewById(R.id.for_dark);

        mQuestionTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        fragmentManager = getSupportFragmentManager();
                        FragmentTransaction transaction = fragmentManager.beginTransaction();
                        Q_1Fragment fragment = new Q_1Fragment();
                        transaction.add(R.id.question_container, fragment).commit();
                        transaction.addToBackStack(null);
                        mForDark.setBackgroundResource(R.drawable.black_trans_back);
                        mKnownButton.setEnabled(false);
                    }
                });

        mQuestion2TV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                Q_2Fragment fragment = new Q_2Fragment();
                transaction.add(R.id.question_container, fragment).commit();
                transaction.addToBackStack(null);
                mForDark.setBackgroundResource(R.drawable.black_trans_back);
                mKnownButton.setEnabled(false);
            }
        });


        client = new OkHttpClient();
        AskQuestions();

        new Thread(new Runnable() {
            @Override
            public void run() {
                MakeGet();
            }
        }).start();

    }

    private void MakeGet() {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response response = client.newCall(request).execute();
           // mQuestionTV.setText(response.body().string().substring(0,10));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        findViewById(R.id.for_dark).setBackgroundColor(Color.TRANSPARENT);
    }

    private void AskQuestions() {


    }
}