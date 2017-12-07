import java.util.ArrayList;

public class MultiQuestion extends Question {

    private int rightAnswer;
    private ArrayList<String> answerList;

    public MultiQuestion(int rightAnswer, ArrayList<String> answerList, String question) {
        super(question);
        this.rightAnswer = rightAnswer;
        this.answerList = answerList;
    }

    public ArrayList<String> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(ArrayList<String> answerList) {
        this.answerList = answerList;
    }

    public int getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(int rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public ArrayList<String> getQuestionList() {
        return answerList;
    }

    public void setQuestionList(ArrayList<String> questionList) {
        this.answerList = questionList;
    }

    public void print() {
        System.out.println(question);

        for (int i = 0; i < answerList.size(); i++) {
            System.out.println(answerList.get(i));
        }
    }

    public boolean isItRightAnswer(char input) {
        char tmp = (char)(this.rightAnswer + 'A');
        return tmp == Character.toUpperCase(input);
    }

}
