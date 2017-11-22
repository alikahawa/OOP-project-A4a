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

    public void setRightAnswer(char rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public ArrayList<String> getQuestionList() {
        return answerList;
    }

    public void setQuestionList(ArrayList<String> questionList) {
        this.answerList = questionList;
    }

    public static void ReadFromXML(String fileName) {
        try {
            File xmlFile = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("Question");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                System.out.println("\nCurrent Element :" + nNode.getNodeName());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void print() {
        System.out.println(question);

        for (int i = 0; i < answerList.size(); i++) {
            System.out.println(answerList.get(i));
        }
    }

    public boolean isItRightAnswer(String input) {
        String tmp = "" + this.rightAnswer;
        return (tmp.equals(input));
    }
}
