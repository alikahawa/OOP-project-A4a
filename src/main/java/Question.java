import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
import java.util.List;

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

    public static List<Question> ReadFromXML(String fileName) {
        try {
            File xmlFile = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("Question");

            List<Question> QuestionList = new ArrayList<Question>();

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                Element tmpElement = (Element) nNode;
                String questionText = tmpElement.getElementsByTagName("Text").item(0).getTextContent();
                int numberOfAnswers = Integer.parseInt(tmpElement.getElementsByTagName("NumberOfAnswers").item(0).getTextContent());
                String rightAnswerString = tmpElement.getElementsByTagName("RightAnswer").item(0).getTextContent();
                int rightAnswerIndex = 0;

                ArrayList<String> answersList = new ArrayList<>();

                NodeList answersNodeList = tmpElement.getElementsByTagName("Answer");

                for (int i = 0; i < numberOfAnswers; i++)
                {
                    String tmp = answersNodeList.item(i).getTextContent();
                    if (tmp.equals(rightAnswerString))
                    {
                        rightAnswerIndex = i;
                    }
                    answersList.add(tmp);
                }

                QuestionList.add(new Question(rightAnswerIndex, answersList, questionText));


            }
            return QuestionList;

        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Question>();
        }
    }

    public void WriteToXML(String fileName)
    {
        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("MultiQuestion");
            doc.appendChild(rootElement);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
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
