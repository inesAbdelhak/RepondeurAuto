package com.example.repondeurauto;

public class AutoReponse {
    private String title;
    private String text;

    public AutoReponse(String title, String text) {
        //  propriétés de la réponse automatique
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}