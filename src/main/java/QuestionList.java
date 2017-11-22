import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class QuestionList {

    List<Question> qList;

    public QuestionList()
    {
        qList = new ArrayList<Question>();
    }

    public List<Question> getQList()
    {
        return qList;
    }

    public void setQList(List<Question> qList)
    {
        this.qList = qList;
    }

    public void add(Question q)
    {
        qList.add(q);
    }

    public static QuestionList ReadFromXML(String fileName) {
        try {
            File xmlFile = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("Question");

            QuestionList questionList = new QuestionList();

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

                questionList.add(new Question(rightAnswerIndex, answersList, questionText));

            }
            return questionList;

        } catch (Exception e) {
            e.printStackTrace();
            return new QuestionList();
        }
    }

    public void WriteToXML(String fileName)
    {

    }

}
