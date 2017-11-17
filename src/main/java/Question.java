import java.util.ArrayList;

public class Question {

    private char rightAnswer;
    private ArrayList<String> questionList;

    public Question(char rightAnswer, ArrayList<String> questionList) {
        this.rightAnswer = rightAnswer;
        this.questionList = questionList;
    }

    public char getRightAnswer() {
        return rightAnswer;
    }

    public char setRightAnswer(char rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public ArrayList<String> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(ArrayList<String> questionList) {
        this.questionList = questionList;
    }


}
