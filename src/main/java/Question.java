import java.util.ArrayList;

public class Question {

    private String rightAnswer;
    private ArrayList<String> questionList;

    public Question(String rightAnswer, ArrayList<String> questionList) {
        this.rightAnswer = rightAnswer;
        this.questionList = questionList;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public ArrayList<String> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(ArrayList<String> questionList) {
        this.questionList = questionList;
    }


}
