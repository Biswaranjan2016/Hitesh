package com.learncodeonline.courses.interviewpreparation.recyclerCardlayout;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.learncodeonline.courses.interviewpreparation.R;
import com.learncodeonline.courses.interviewpreparation.jsonProcessing.Question;
import com.learncodeonline.courses.interviewpreparation.jsonProcessing.TemporaryData;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>{

    private List<Question> questions;

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView question;
        private TextView answer;

        public MyViewHolder(View view){
            super(view);
            question = view.findViewById(R.id.question_textview);
            answer = view.findViewById(R.id.answer_textview);
        }
    }

    public Adapter(List<Question> questions){
        this.questions = questions;
        if (questions == null){
            Log.e("Adapter","Null Ref");
        }
    }

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardlayout,parent,false);
        return new MyViewHolder(itemView);
    }

    public void onBindViewHolder(MyViewHolder myViewHolder,int position){
        Question question = questions.get(position);
        myViewHolder.question.setText(question.getQuestion());
        myViewHolder.answer.setText(question.getAnswer());
    }

    public int getItemCount(){
        return questions.size();
    }
}
