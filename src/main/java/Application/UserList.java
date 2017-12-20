package Application;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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

/**
 * Class Application.UserList which contains the list of all of the current users.
 */
public class UserList {
    private List<User> userList;

    /**
     * Constructor of Application.UserList. Creating a new Application.UserList automatically creates a new ArrayList to store the users in.
     */
    public UserList() {
        this.userList = new ArrayList<User>();
    }

    public List<User> getUserList() {
        return userList;
    }

    public void add(User q) {
        userList.add(q);
    }

    /**
     * A method which returns the an Application.UserList read from the xml file
     * @param fileName - the XML file to be read, containing all of the users
     * @return - an new Application.UserList
     */
    public static UserList readFromXML(String fileName) {
        try {
            // magic
            File xmlFile = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            // creates the new Application.UserList, and creates two temporary lists "Application.Student" and "Application.Teacher" containing
            // the respective elements from the XML file
            UserList userList = new UserList();
            NodeList studentList = doc.getElementsByTagName("Application.Student");
            NodeList teacherList = doc.getElementsByTagName("Application.Teacher");

            // A for loop which cycles through every Application.Student item in the XML file
            for (int temp = 0; temp < studentList.getLength(); temp++) {
                Node nNode = studentList.item(temp);

                Element tmpElement = (Element) nNode;

                String userName = tmpElement.getElementsByTagName("UserName").item(0).getTextContent();
                String password = tmpElement.getElementsByTagName("Password").item(0).getTextContent();
                String email = tmpElement.getElementsByTagName("Email").item(0).getTextContent();

                // Creates a new Application.Student with the elements in the Application.Student element
                userList.add(new Student(userName, password, email));
            }

            // Same for teachers...
            for (int temp = 0; temp < teacherList.getLength(); temp++) {
                Node nNode = teacherList.item(temp);

                Element tmpElement = (Element) nNode;

                String userName = tmpElement.getElementsByTagName("UserName").item(0).getTextContent();
                String password = tmpElement.getElementsByTagName("Password").item(0).getTextContent();
                String email = tmpElement.getElementsByTagName("Email").item(0).getTextContent();

                userList.add(new Teacher(userName, password, email));
            }

            // After all the Students and Teachers have been added, it returns the new Application.UserList
            return userList;

        } catch (Exception e) {
            e.printStackTrace();
            return new UserList();
        }
    }

    /**
     * A method to write an Application.UserList back to the XML file
     * @param fileName - the file to be written to
     */
    public void writeToXML(String fileName){
        try {

            // magic
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            //Base Node
            Document doc = docBuilder.newDocument();
            Element MultiUsers = doc.createElement("MultiUsers");
            doc.appendChild(MultiUsers);

            // Enhanced for loop through all of the users in *this* Application.UserList
            for (User user : this.getUserList()){
                // Application.Question elements
                Element User;
                // Creates an element depending on whether it is an Application.Student or an Application.Teacher
                if(user instanceof Student){
                    User = doc.createElement("Application.Student");
                }
                else {
                    User = doc.createElement("Application.Teacher");
                }
                MultiUsers.appendChild(User);

                // Adds the username, password and email to the user element
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
            // some more magic
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
