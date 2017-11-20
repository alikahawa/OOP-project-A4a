import java.lang.reflect.Array;
import java.util.ArrayList;

public class Question {

    private char rightAnswer;
    private ArrayList<String> answerList;
    private String question;

    public Question(char rightAnswer, ArrayList<String> answerList, String question) {
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

    public char getRightAnswer() {
        return rightAnswer;
    }

    public char setRightAnswer(char rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public ArrayList<String> getQuestionList() {
        return answerList;
    }

    public void setQuestionList(ArrayList<String> questionList) {
        this.answerList = questionList;
    }

    public String print()
    {
        for(int i = 0; i < answerList.size(); i++)
        {

        }
    }
}
