package com.ztrey.myapplication;
//Quote Class. It hold the information and attributes of a given quotation
public class Quote {
    String quoteText;
    Boolean isFavorite;

    //Constructor
    public Quote(String text){
        quoteText = text;
        isFavorite = false;
    }

    //ztrey - fill this out once i've completed what excatly a "favorite" entails
    //Marks a given question as a favorite
    public void   markAsFavorite(){
        this.isFavorite = true;
    }

}
