package Application;

import java.util.List;

public abstract class UIQuestions extends Question {


    public UIQuestions(String question) {
        super(question);
    }

    abstract public List<String> getAnswerList();
}
