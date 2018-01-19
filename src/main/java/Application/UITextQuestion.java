package Application;

import java.util.ArrayList;
import java.util.List;

public class UITextQuestion extends UIQuestions {

    private List<String> answerList = new ArrayList<String>();
    private int rightAnswer;
    private String questionText;

    public UITextQuestion(int rightAnswer, List<String> answerList, String question) {
        super(question);
        this.rightAnswer = rightAnswer;
        this.answerList = answerList;
    }

    public void print() {

    }

    public List<String> getAnswerList(){
        return answerList;
    }

    public int getRightAnswer(){
        return rightAnswer;
    }

}
