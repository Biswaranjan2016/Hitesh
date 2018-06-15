package com.learncodeonline.courses.interviewpreparation.recyclerCardlayout;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.learncodeonline.courses.interviewpreparation.R;
import com.learncodeonline.courses.interviewpreparation.jsonProcessing.QS;
import com.learncodeonline.courses.interviewpreparation.jsonProcessing.Question;

import java.util.List;
import java.util.Random;


public class WelcomeFrag extends Fragment {

    TextView textView;
    TextView question;
    public WelcomeFrag() {

    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        //The url of the Json File
        final String URL = "https://learncodeonline.in/api/android/datastructure.json";

        View view = inflater.inflate(R.layout.fragment_welcome, container, false);
        textView = view.findViewById(R.id.frag1_Answer);
        question = view.findViewById(R.id.frag1_Question);

        // Inflate the layout for this fragment
        WebView webView = view.findViewById(R.id.webView_welcome);

        //Creating the webview for the banner
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setBackgroundColor(Color.TRANSPARENT);
        String html = "<html><body><a href=\"https://courses.learncodeonline.in\">" +
                "<img src=\"https://dl.dropbox.com/s/mbxkanc4mp5my2v/Welcome.png?dl=0\" height=60 width=350></a></html>";
        webView.loadData(html,"text/html","UTF-8");


        //Deserializing the Json.
        StringRequest request = new StringRequest(URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("PrepareJson",response);
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                QS qs = gson.fromJson(response,QS.class);
                List<Question> questions=qs.getQuestions();
                Random random = new Random();
                int num = random.nextInt(5);

                textView.setText(questions.get(num).getAnswer());
                question.setText(questions.get(num).getQuestion());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        //Preparing the queue and submitting the request.
        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
        queue.add(request);
        return view;
    }

}
