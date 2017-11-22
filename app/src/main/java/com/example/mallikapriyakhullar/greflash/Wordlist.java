package com.example.mallikapriyakhullar.greflash;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by mallikapriyakhullar on 21/11/17.
 */

public class Wordlist {

    @SerializedName("words")
    @Expose
    ArrayList<WordModel> words;

    public ArrayList<WordModel> getWords() {
        return words;
    }

    public void setWords(ArrayList<WordModel> words) {
        this.words = words;
    }
}
