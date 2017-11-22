package com.example.mallikapriyakhullar.greflash;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by mallikapriyakhullar on 21/11/17.
 */


public class WordModel {
    @SerializedName("word")
    @Expose
    String word;

    @SerializedName("meaning")
    @Expose
    String meaning;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

}

