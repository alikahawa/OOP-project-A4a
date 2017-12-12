import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.jws.soap.SOAPBinding;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UserList {
    private List<User> userList;

    public UserList() {
        this.userList = new ArrayList<User>();
    }

    public List<User> getUserList() {
        return userList;
    }

    public void add(User q) {
        userList.add(q);
    }

    public static UserList readFromXML(String fileName) {
        try {
            File xmlFile = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            UserList userList = new UserList();
            NodeList studentList = doc.getElementsByTagName("Student");
            NodeList teacherList = doc.getElementsByTagName("Teacher");

            for (int temp = 0; temp < studentList.getLength(); temp++) {
                Node nNode = studentList.item(temp);

                Element tmpElement = (Element) nNode;

                String userName = tmpElement.getElementsByTagName("UserName").item(0).getTextContent();
                String password = tmpElement.getElementsByTagName("Password").item(0).getTextContent();
                String email = tmpElement.getElementsByTagName("Email").item(0).getTextContent();

                userList.add(new Student(userName, password, email));
            }

            for (int temp = 0; temp < teacherList.getLength(); temp++) {
                Node nNode = teacherList.item(temp);

                Element tmpElement = (Element) nNode;

                String userName = tmpElement.getElementsByTagName("UserName").item(0).getTextContent();
                String password = tmpElement.getElementsByTagName("Password").item(0).getTextContent();
                String email = tmpElement.getElementsByTagName("Email").item(0).getTextContent();

                userList.add(new Teacher(userName, password, email));
            }

            return userList;

        } catch (Exception e) {
            e.printStackTrace();
            return new UserList();
        }
    }

    public void writeToXML(String fileName){
        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            //Base Node
            Document doc = docBuilder.newDocument();
            Element MultiUsers = doc.createElement("MultiUsers");
            doc.appendChild(MultiUsers);

            for (User user : this.getUserList()){
                // Question elements
                Element User;
                if(user instanceof Student){
                    User = doc.createElement("Student");
                }
                else {
                    User = doc.createElement("Teacher");
                }
                MultiUsers.appendChild(User);

                //Text element
                Element UserName = doc.createElement("UserName");
                UserName.appendChild(doc.createTextNode(user.getUserName()));
                User.appendChild(UserName);

                Element Password = doc.createElement("Password");
                Password.appendChild(doc.createTextNode(user.getPassword()));
                User.appendChild(Password);

                Element Email = doc.createElement("Email");
                Email.appendChild(doc.createTextNode(user.getEmail()));
                User.appendChild(Email);

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
