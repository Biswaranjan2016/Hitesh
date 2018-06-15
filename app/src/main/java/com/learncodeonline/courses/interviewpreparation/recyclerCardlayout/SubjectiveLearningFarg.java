package com.learncodeonline.courses.interviewpreparation.recyclerCardlayout;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.learncodeonline.courses.interviewpreparation.R;
import com.learncodeonline.courses.interviewpreparation.jsonProcessing.PrepareJson;
import com.learncodeonline.courses.interviewpreparation.jsonProcessing.QS;
import com.learncodeonline.courses.interviewpreparation.jsonProcessing.Question;
import com.learncodeonline.courses.interviewpreparation.jsonProcessing.TemporaryData;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class SubjectiveLearningFarg extends Fragment {


    private Adapter mAdapter;
    private RecyclerView recyclerView;
    List<Question> questions = new ArrayList<Question>();
    private final String TAG = "SubhectiveLearningFrag";
    public static final String URL = "https://learncodeonline.in/api/android/datastructure.json";

    public SubjectiveLearningFarg() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);



    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_subjective_learning_farg,container,false);

        recyclerView = view.findViewById(R.id.recyclerView);
        if (PrepareJson.questions == null){
            Log.e(TAG,"Null Ref");
        }else {
            mAdapter = new Adapter(PrepareJson.questions);
        }


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        WebView webView = view.findViewById(R.id.webView_DS);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setBackgroundColor(Color.TRANSPARENT);
        String html = "<html><body><a href=\"https://courses.learncodeonline.in\">" +
                "<img src=\"https://dl.dropbox.com/s/8k4qj5urd2zbyit/Did%20you%20%281%29.png?dl=0\" height=60 width=350></a></html>";
        webView.loadData(html,"text/html","UTF-8");

        StringRequest request = new StringRequest(URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("PrepareJson",response);
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                QS qs = gson.fromJson(response,QS.class);
                List<Question> questions=qs.getQuestions();
                recyclerView.setAdapter(new Adapter(questions));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
        queue.add(request);

        return view;

    }

    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

    }

    private void prepareData(){
        PrepareJson prepareJson = new PrepareJson();
//        List<Question> questions = prepareJson.prepareData();
        Log.e(TAG,Integer.toString(questions.size()));
        mAdapter.notifyDataSetChanged();
    }

}
