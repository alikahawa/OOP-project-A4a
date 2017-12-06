import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Question {
    /**
     * RightANswer is a position in the arrayList which is the right answer. For example if the right answer
     * is A the this.rightAnswer is 0.
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
     * Same as getAnswerList() to make it confusing.
     */
    public ArrayList<String> getQuestionList() {
        return answerList;
    }

    public void setQuestionList(ArrayList<String> questionList) {
        this.answerList = questionList;
    }

    /**
     * Prints out a question + the answerlist.
     */
    public void print() {
        System.out.println(question);

        for (int i = 0; i < answerList.size(); i++) {
            System.out.println(answerList.get(i));
        }
    }

    /**
     * Checks if an answer is right
     * @param input
     * @return boolean
     */
    public boolean isItRightAnswer(char input) {
        int tmp = (this.rightAnswer + 'a');
        char tmp2 = Character.toLowerCase(input);
        return (tmp == (int)tmp2);
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

