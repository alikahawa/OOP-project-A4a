import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.OutputKeys;


public class QuestionList {

    List<Question> qList;

    public QuestionList() {
        qList = new ArrayList<Question>();
    }

    public List<Question> getQList() {
        return qList;
    }

    public void setQList(List<Question> qList) {
        this.qList = qList;
    }

    public void add(Question q) {
        qList.add(q);
    }

    public ArrayList<Question> shuffleQuestionList(){
        ArrayList<Question> res =  new ArrayList<Question>(this.qList);
        Collections.shuffle(res);
        return res;
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

                for (int i = 0; i < numberOfAnswers; i++) {
                    String tmp = answersNodeList.item(i).getTextContent();
                    if (tmp.equals(rightAnswerString)) {
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

    public void WriteToXML(String fileName) {
        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            //Base Node
            Document doc = docBuilder.newDocument();
            Element MultiQuestionsElement = doc.createElement("MultiQuestions");
            doc.appendChild(MultiQuestionsElement);

            for (Question q : qList) {
                // Question elements
                Element QuestionElement = doc.createElement("Question");
                MultiQuestionsElement.appendChild(QuestionElement);

                //Text element
                Element TextElement = doc.createElement("Text");
                TextElement.appendChild(doc.createTextNode(q.getQuestion()));
                QuestionElement.appendChild(TextElement);

                //NumberOfAnswers element
                Element NumberOfAnswersElement = doc.createElement("NumberOfAnswers");
                NumberOfAnswersElement.appendChild(doc.createTextNode(String.valueOf(q.getAnswerList().size())));
                QuestionElement.appendChild(NumberOfAnswersElement);

                //Answers element
                Element AnswersElement = doc.createElement("Answers");
                QuestionElement.appendChild(AnswersElement);

                for (String s : q.getAnswerList()) {
                    //Answer element
                    Element AnswerElement = doc.createElement("Answer");
                    AnswerElement.appendChild(doc.createTextNode(s));
                    AnswersElement.appendChild(AnswerElement);
                }

                //RightAnswer element
                Element RightAnswerElement = doc.createElement("RightAnswer");
                RightAnswerElement.appendChild(doc.createTextNode(String.valueOf(q.getAnswerList().get(q.getRightAnswer()))));
                QuestionElement.appendChild(RightAnswerElement);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(fileName));

            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
