package com.edu.poli.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class Recall implements Question<String> {

    private String key;

    public Recall(String key) {
        this.key = key;
    }

    @Override
    public String answeredBy(Actor actor) {
        return actor.recall(key).toString();
    }

    public static Recall string(String key){
        return new Recall(key);
    }
}
