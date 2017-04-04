package com.learnvest.quiz;

import com.learnvest.providers.QuizProvider;


public class QuizPresenter {

    private final QuizProvider provider;
    private final QuizView view;

    public QuizPresenter(QuizProvider provider, QuizView view){
        this.provider = provider;
        this.view = view;
    }


    public void loadQuiz(){
        String quizData = provider.getQuizData("start.html");
        view.showQuizPage(quizData, null);
    }

    public void next(String url, String[] args){
        String quizData = provider.getQuizData(url);
        view.showQuizPage(quizData, args);
    }
}
