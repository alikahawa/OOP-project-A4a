import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Question {

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

    public boolean askQuestion(Scanner sc){
        System.out.println(this.question);
        ArrayList<String> shuffledAnswerList = new ArrayList<String>(this.answerList);
        Collections.shuffle(shuffledAnswerList);

        for(String answer: shuffledAnswerList){
            System.out.println(String.valueOf((char)(shuffledAnswerList.indexOf(answer) + 65)) + ": " + answer);
        }

        int answer = sc.next().toUpperCase().charAt(0) - 65;
        if(answer > this.answerList.size() || answer < 0) {
            System.out.println("wrong\n");
            return false;
        }
        boolean res = shuffledAnswerList.get(answer).equals(this.answerList.get(rightAnswer));
        if(res){
            System.out.println("right\n");
        }
        else{
            System.out.println("wrong\n");
        }
        return res;
    }
}
