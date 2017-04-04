package com.learnvest.providers;

import java.util.HashMap;

public class QuizProvider {

    private HashMap<String, String> data;

    private final String startContent =
        "<p>What is your name?</p><input type='text' id='firstname'>" +
        "<p>What is your age?</p><input type='text' id='age'>" +
        "<p>What is your job title?</p><input type='text' id='title'>" +
        "<p>What is your geographic location?</p><input type='text' id='location'><br><br>" +

        "<script type='text/javascript'> " +
            "function next(){ " +
                "var name = document.getElementById('firstname').value; " +
                "var age = document.getElementById('age').value; " +
                "var title = document.getElementById('title').value; " +
                "var location = document.getElementById('location').value; " +
                "var params = [name, age, title, location]; " +
                "var url = 'salary.html'; " +
                "QuizWebView.next(url, params); " +
            "} " +
        "</script>";

    private final String salaryContent =
        "<p>What is your monthly salary?</p><input type='text' id='salary'><br>" +
        "<script type='text/javascript'>" +
            "function next(){" +
               "var salary = document.getElementById('salary').value;" +
               "var args = [salary];" +
               "var url = 'worry.html';" +
               "QuizWebView.next(url, args);" +
            "}" +
        "</script>";

    private final String worryContent =
        "<p>What do you worry the most about?</p>" +
        "<input type='checkbox' value='retirement'>Saving for Retirement<br>" +
        "<input type='checkbox' value='debt'>Paying off Debt<br>" +
        "<input type='checkbox' value='home'>Buying a Home<br>" +
        "<input type='checkbox' value='married'>Getting Married<br>" +
        "<input type='checkbox' value='investing'>Investing<br>" +

        "<script type='text/javascript'> " +
            "function next(){ " +
                "var params = []; " +
                "var url = 'debt.html'; " +
                "QuizWebView.next(url, params); " +
            "} " +
        "</script>";

    private final String debtContent =
        "<p>What is your debt range?</p>" +
        "<input type='radio' name='debt' value='retirement' checked>$0 - $500<br>" +
        "<input type='radio' name='debt' value='debt'>$500 - $2,500<br>" +
        "<input type='radio' name='debt' value='home'>$2,500 - $10,000<br>" +
        "<input type='radio' name='debt' value='married'>Greater than $10,000<br>" +

        "<script type='text/javascript'> " +
            "function next(){ " +
                "var params = []; " +
                "var url = 'finished.html'; " +
                "QuizWebView.next(url, params); " +
            "} " +
            "</script>";

    private final String finishedContent = "<p>All Finished.Congratulations!</p>";

    public QuizProvider(){
        data = new HashMap<String, String>();
        data.put("start.html", startContent);
        data.put("salary.html", salaryContent);
        data.put("worry.html", worryContent);
        data.put("debt.html", debtContent);
        data.put("finished.html", finishedContent);
    }

    public String getQuizData(String pageName){
        return data.get(pageName);
    }


}
