package com.learncodeonline.courses.interviewpreparation.jsonProcessing;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.learncodeonline.courses.interviewpreparation.R;

import java.util.Iterator;
import java.util.List;

public class PrepareJson extends Activity {


    public   static List<Question> questions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prepare_json);

//        return questions;

    }
//    public List<Question> prepareData(){
//
//    }
    public static void setData(List<Question> questions){
        PrepareJson.questions = questions;
        Log.e("PrepareJson",Integer.toString(questions.size()));
    }
}
