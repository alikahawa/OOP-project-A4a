import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;

public class Question {
    /**
     * Rightanswer is int and in the method is rightanswer it is casted to char?!
     * Explain why you made such a choice
     */
    private int rightAnswer;
    private ArrayList<String> answerList;
    private String question;

    public Question(int rightAnswer, ArrayList<String> answerList, String question) {
        this.rightAnswer = rightAnswer;
        this.answerList = answerList;
        this.question = question;
    }

    public ArrayList<String> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(ArrayList<String> answerList) {
        this.answerList = answerList;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(int rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    /**
     * Explain?!!
     * @return
     */
    public ArrayList<String> getQuestionList() {
        return answerList;
    }

    public void setQuestionList(ArrayList<String> questionList) {
        this.answerList = questionList;
    }

    /**
     * Explination!?!
     */
    public void print() {
        System.out.println(question);

        for (int i = 0; i < answerList.size(); i++) {
            System.out.println(answerList.get(i));
        }
    }

    /**
     * Look at the attributes!
     * @param input
     * @return
     */
    public boolean isItRightAnswer(char input) {
        char tmp = (char)(this.rightAnswer + 'A');
        return true;
    }
}

