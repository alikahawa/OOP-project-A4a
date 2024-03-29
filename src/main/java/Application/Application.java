package Application;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        QuestionList tmpql = QuestionList.ReadFromXML("OOP.xml");
        tmpql.WriteToXML("OOP.xml");

        UserList userList = UserList.readFromXML("src/Users.xml");
        userList.writeToXML("src/Users.xml");

        while (true){
            String key;
            Scanner sc = new Scanner(System.in);
            System.out.println("Welcome to the practice low literacy program.");
            // This is meant as a demo. Feel free to pull this branch and see how the options work.
            login_register_loop:
            while(true){
                System.out.println("Would you like to login or register?\nPress 1 to login\nPress 2 to register");
                key = sc.next();
                if(key.equals("1")){
                    break;
                }
                else if(key.equals("2")){
                    System.out.println("Are you a teacher(1) or a student(2)?");
                    String type = sc.next();
                    System.out.println("Please enter a first name: ");
                    String firstName = sc.next();
                    System.out.println("Please enter a last name: ");
                    String lastName = sc.next();
                    System.out.println("Enter a password: ");
                    String password = sc.next();
                    System.out.println("Enter your email:");
                    key = sc.next();
                    if(type.equals("1")){
                        userList.add(new Teacher(firstName, lastName, password, key));
                        System.out.println("User added!");
                    }
                    else if(type.equals("2")){
                        userList.add(new Student(firstName, lastName, password, key));
                        System.out.println("User added!");
                    }
                    break;
                }
            }
            System.out.println("Username: user\nPassword: password\n");
            while(true) {
                System.out.println("Please enter your email address: ");
                key = sc.next();
                int loggedIn = 0;
                int usernameFound = 0;
                for(User user : userList.getUserList()){
                    if(key.equals(user.getEmail())) {
                        usernameFound = 1;
                        System.out.println("Please enter your password: ");
                        key = sc.next();
                        if (user.CheckPassword(key)) {
                            loggedIn = 1;
                            break;
                        } else {
                            System.out.println("The password you provided was incorrect.");
                        }
                    }
                }
                if(usernameFound == 0){
                    System.out.println("The username you provided was not found.");
                }
                if(loggedIn == 1){
                    break;
                }
            }
            System.out.println("Press 1 to for randomized questions");
            System.out.println("Press 2 to for a certain amount of randomized questions");
            System.out.println("Press 0 to exit the program");
            key = sc.next();
            switch (key){
                case "0":
                    userList.writeToXML("src/Users.xml");
                    System.exit(0);
                    break;
                case "1":
                    tmpql.displayQuestionList(sc);
                    break;
                case "2":
                    System.out.println("Enter a number of questions: ");
                    int nQuestions = Integer.parseInt(sc.next());
                    tmpql.displayQuestionList(sc, nQuestions);
                    break;
                case "3":
                    for(Question question : tmpql.getQList()){
                        if(question instanceof UIQuestions){
                            System.out.println(question.getQuestion());
                        }
                    }
                 default:
                     System.out.println("Try another choice");
                     continue;
            }
        }
    }
}
