package Application;

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
import java.util.Scanner;
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

    public QuestionList(ArrayList<Question> qlist) {
        this.qList = qlist;
    }

    public List<Question> getQList() {
        return qList;
    }

    public ArrayList<MultiQuestion> getMultiQList(){
        ArrayList<MultiQuestion> res =  new ArrayList<MultiQuestion>();

        for (int i =0; i< qList.size(); i++)
        {
            res.add(getMultiQuestion(i));
        }

        return res;
    }

    public ArrayList<UIQuestions> getDropDownList(){
        ArrayList<UIQuestions> res =  new ArrayList<UIQuestions>();

        for (int i =0; i< qList.size(); i++)
        {
            if(this.qList.get(i) instanceof DropDown){
                res.add((DropDown)this.qList.get(i));
            }
        }

        return res;
    }

    public Question getQ(int i) {
        return qList.get(i);
    }

    // verkrijgt een multiquestion uit de lijst, gespecificeert, als dat geen multiquestion is de volgende
    public MultiQuestion getMultiQuestion(int nummer) {
        for ( int i = 0; i< qList.size(); i++)
        {
            if (getQ(nummer + i) instanceof MultiQuestion)
            {
                return (MultiQuestion)getQ(nummer + i);
            }
        }
        // De multiquestions zijn op
        throw new IndexOutOfBoundsException();
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

    public void displayQuestionList(Scanner sc, int nQuestions){
        ArrayList<Question> shuffledTmpql = this.shuffleQuestionList();
        int nRight = 0;
        for(int i = 0; i<nQuestions; i++){
            if(((MultiQuestion)shuffledTmpql.get(i)).askQuestion(sc)){
                nRight++;
            }
        }
        int grade = Math.round(nRight / nQuestions * 10);
        System.out.println("Your grade is a: " + grade);
        if(grade >= 6){
            System.out.println("Well Done!");
        }
    }

    public void displayQuestionList(Scanner sc){
        displayQuestionList(sc, this.qList.size());
    }

    public static QuestionList ReadFromXML(String fileName) {
        try {
            File xmlFile = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            Element MultiQuestionsElement = (Element)doc.getElementsByTagName("MultiQuestions").item(0);
            Element PictureQuestionsElement = (Element)doc.getElementsByTagName("PictureQuestions").item(0);
            Element DropDownElement = (Element)doc.getElementsByTagName("DropDownQuestions").item(0);
            Element CheckBoxElement = (Element)doc.getElementsByTagName("CheckBoxQuestions").item(0);

            NodeList nList = MultiQuestionsElement.getElementsByTagName("Question");

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

                questionList.add(new MultiQuestion(rightAnswerIndex, answersList, questionText));

            }


            nList = PictureQuestionsElement.getElementsByTagName("Question");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                Element tmpElement = (Element) nNode;
                String questionText = tmpElement.getElementsByTagName("Text").item(0).getTextContent();
                String picture = tmpElement.getElementsByTagName("Picture").item(0).getTextContent();
                int X1 = Integer.parseInt(tmpElement.getElementsByTagName("X1").item(0).getTextContent());
                int X2 = Integer.parseInt(tmpElement.getElementsByTagName("X2").item(0).getTextContent());
                int Y1 = Integer.parseInt(tmpElement.getElementsByTagName("Y1").item(0).getTextContent());
                int Y2 = Integer.parseInt(tmpElement.getElementsByTagName("Y2").item(0).getTextContent());

                questionList.add(new PictureQuestion(questionText, picture, X1, X2, Y1, Y2));
            }

            nList = DropDownElement.getElementsByTagName("Question");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                Element tmpElement = (Element) nNode;
                String questionText = tmpElement.getElementsByTagName("Text").item(0).getTextContent();
                String rightAnswerString = tmpElement.getElementsByTagName("RightAnswer").item(0).getTextContent();
                int rightAnswerIndex = 0;

                ArrayList<String> answersList = new ArrayList<>();

                NodeList answersNodeList = tmpElement.getElementsByTagName("Answer");

                for (int i = 0; i < 3; i++) {
                    String tmp = answersNodeList.item(i).getTextContent();
                    if (tmp.equals(rightAnswerString)) {
                        rightAnswerIndex = i;
                    }
                    answersList.add(tmp);
                }

                questionList.add(new DropDown(rightAnswerIndex, answersList, questionText));

        }

        nList = CheckBoxElement.getElementsByTagName("Question");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                Element tmpElement = (Element) nNode;
                String questionText = tmpElement.getElementsByTagName("Text").item(0).getTextContent();

                ArrayList<String> answersList = new ArrayList<>();


                NodeList answersNodeList = tmpElement.getElementsByTagName("Answer");
                for (int i = 0; i < 3; i++) {
                    String tmp = answersNodeList.item(i).getTextContent();
                    answersList.add(tmp);
                }

                ArrayList<String> rightAnswerList = new ArrayList<>();


                NodeList rightAnswersNodeList = tmpElement.getElementsByTagName("RightAnswer");
                for (int i = 0; i < rightAnswersNodeList.getLength(); i++) {
                    String tmp = rightAnswersNodeList.item(i).getTextContent();
                    rightAnswerList.add(tmp);
                }

                questionList.add(new CheckBox(rightAnswerList, answersList, questionText));

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
            Element QuestionsElement = doc.createElement("Questions");
            doc.appendChild(QuestionsElement);
            Element MultiQuestionsElement = doc.createElement("MultiQuestions");
            QuestionsElement.appendChild(MultiQuestionsElement);
            Element PictureQuestionsElement = doc.createElement("PictureQuestions");
            QuestionsElement.appendChild(PictureQuestionsElement);
            Element DropDownElement = doc.createElement("DropDownQuestions");
            QuestionsElement.appendChild(DropDownElement);
            Element CheckBoxElement = doc.createElement("CheckBoxQuestions");
            QuestionsElement.appendChild(CheckBoxElement);

            for (Question q2 : qList) {
                if (q2 instanceof MultiQuestion) {
                    MultiQuestion q = (MultiQuestion)q2;

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
                else if (q2 instanceof PictureQuestion)
                {
                    PictureQuestion q = (PictureQuestion)q2;

                    // Question elements
                    Element QuestionElement = doc.createElement("Question");
                    PictureQuestionsElement.appendChild(QuestionElement);

                    //Text element
                    Element TextElement = doc.createElement("Text");
                    TextElement.appendChild(doc.createTextNode(q.getQuestion()));
                    QuestionElement.appendChild(TextElement);

                    //Picture element
                    Element PictureElement = doc.createElement("Picture");
                    PictureElement.appendChild(doc.createTextNode(q.getPicture()));
                    QuestionElement.appendChild(PictureElement);

                    // Bounds elements
                    Element BoundsElement = doc.createElement("Bounds");
                    QuestionElement.appendChild(BoundsElement);

                    //X1 element
                    Element X1Element = doc.createElement("X1");
                    X1Element.appendChild(doc.createTextNode(String.valueOf(q.getX1())));
                    BoundsElement.appendChild(X1Element);

                    //X2 element
                    Element X2Element = doc.createElement("X2");
                    X2Element.appendChild(doc.createTextNode(String.valueOf(q.getX2())));
                    BoundsElement.appendChild(X2Element);

                    //Y1 element
                    Element Y1Element = doc.createElement("Y1");
                    Y1Element.appendChild(doc.createTextNode(String.valueOf(q.getY1())));
                    BoundsElement.appendChild(Y1Element);

                    //Y2 element
                    Element Y2Element = doc.createElement("Y2");
                    Y2Element.appendChild(doc.createTextNode(String.valueOf(q.getY2())));
                    BoundsElement.appendChild(Y2Element);
                }

                else if (q2 instanceof DropDown) {
                    DropDown q = (DropDown)q2;

                    // Question elements
                    Element QuestionElement = doc.createElement("Question");
                    DropDownElement.appendChild(QuestionElement);

                    //Text element
                    Element TextElement = doc.createElement("Text");
                    TextElement.appendChild(doc.createTextNode(q.getQuestion()));
                    QuestionElement.appendChild(TextElement);

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

                else if (q2 instanceof CheckBox) {
                    CheckBox q = (CheckBox)q2;

                    // Question elements
                    Element QuestionElement = doc.createElement("Question");
                    CheckBoxElement.appendChild(QuestionElement);

                    //Text element
                    Element TextElement = doc.createElement("Text");
                    TextElement.appendChild(doc.createTextNode(q.getQuestion()));
                    QuestionElement.appendChild(TextElement);

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
                    Element RightAnswerElement = doc.createElement("RightAnswers");
                    QuestionElement.appendChild(RightAnswerElement);

                    for (String s : q.getRightAnswerList()) {
                        //Answer element
                        Element AnswerElement = doc.createElement("RightAnswer");
                        AnswerElement.appendChild(doc.createTextNode(s));
                        RightAnswerElement.appendChild(AnswerElement);
                    }
                }
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

    @Override
    public boolean equals(Object other)
    {
        if (other instanceof QuestionList)
        {
            QuestionList otherQL = (QuestionList)other;
            if (otherQL.qList.size() == this.qList.size())
            {
                for (Question q : otherQL.qList)
                {
                    if (!this.qList.contains(q))
                    {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

}
