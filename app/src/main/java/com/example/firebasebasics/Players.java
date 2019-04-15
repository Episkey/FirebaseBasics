package com.example.firebasebasics;

public class Players {

    private String pseudo;
    private String score;

    public Players() {
    }

    public Players(String pseudo, String score) {
        this.pseudo = pseudo;
        this.score = score;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
