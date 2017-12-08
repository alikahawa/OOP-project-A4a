import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public abstract class Question {

    protected String question;

    public Question(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public abstract void print();


}

