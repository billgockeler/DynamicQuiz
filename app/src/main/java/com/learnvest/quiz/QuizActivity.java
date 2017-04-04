package com.learnvest.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.learnvest.R;
import com.learnvest.providers.QuizProvider;

public class QuizActivity extends AppCompatActivity implements QuizView, OnNextClickedListener {

    QuizWebView webview;
    QuizPresenter quizPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page);

        Button nextButton = (Button)findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });

        webview = (QuizWebView)findViewById(R.id.quizWebview);
        webview.setOnNextPageListener(this);

        quizPresenter = new QuizPresenter(new QuizProvider(), this);
        quizPresenter.loadQuiz();
    }

    public void next() {
        webview.loadUrl("javascript: next();");
    }

    @Override
    public void showQuizPage(String pageData, String[] args) {
        webview.loadData(pageData, "text/html", "utf-8");
    }

    @Override
    public void onNextClicked(String url, String[] args) {
        quizPresenter.next(url, args);
    }
}
