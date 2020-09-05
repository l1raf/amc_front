package com.example.amchack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

    private TextView mQuestionTV;
    private Spinner spinner;
    private RadioGroup mRadioGroup;
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

    private void AskQuestions() {
        mQuestionTV.setText("Какого цвета птица?");

    }


}