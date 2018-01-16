package Application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckBox extends UIQuestions {

    private List<String> answerList = new ArrayList<String>();
    private List<String> rightAnswerList = new ArrayList<String>();
    private String questionText;

    public CheckBox(List<String> rightAnswerList, List<String> answerList, String question) {
        super(question);
        this.rightAnswerList = rightAnswerList;
        this.answerList = answerList;
    }

    public void print() {

    }

    public List<String> getAnswerList(){
        return answerList;
    }

    public List<String> getRightAnswerList(){
        return rightAnswerList;
    }

    public boolean checkAnswer(List<String> givenAnswerList){
        Collections.sort(this.rightAnswerList);
        Collections.sort(givenAnswerList);
        return this.rightAnswerList.equals(givenAnswerList);
    }

}
