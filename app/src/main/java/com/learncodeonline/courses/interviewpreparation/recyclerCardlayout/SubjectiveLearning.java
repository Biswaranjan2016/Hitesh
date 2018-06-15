package com.learncodeonline.courses.interviewpreparation.recyclerCardlayout;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.learncodeonline.courses.interviewpreparation.R;

public class SubjectiveLearning extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjective_learning);
        WebView webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setBackgroundColor(Color.TRANSPARENT);
        String html = "<html><body><a href=\"https://courses.learncodeonline.in\">" +
                "<img src=\"https://dl.dropbox.com/s/8k4qj5urd2zbyit/Did%20you%20%281%29.png?dl=0\" height=60 width=350></a></html>";
        webView.loadData(html,"text/html","UTF-8");
//        webView.loadUrl("https://dl.dropbox.com/s/d6rjyre59ipdyxw/Resource.html?dl=0");

    }
}
