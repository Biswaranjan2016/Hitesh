package com.learncodeonline.courses.interviewpreparation.recyclerCardlayout;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.learncodeonline.courses.interviewpreparation.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Others extends Fragment {


    public Others() {
        // Required empty public constructor
    }

//https://www.dropbox.com/s/mbxkanc4mp5my2v/Welcome.png?dl=0
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_others, container, false);
        WebView webView = view.findViewById(R.id.webView_rest);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setBackgroundColor(Color.TRANSPARENT);
        String html = "<html><body><a href=\"https://courses.learncodeonline.in\">" +
                "<img src=\"https://dl.dropbox.com/s/vmr64e4n6odhd88/1.png?dl=0\" height=60 width=350></a></html>";
        webView.loadData(html,"text/html","UTF-8");
        return view;
    }

}
