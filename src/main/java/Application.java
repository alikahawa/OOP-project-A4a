import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        QuestionList tmpql = QuestionList.ReadFromXML("OOP.xml");
        tmpql.WriteToXML("OOP.xml");

        while (true){
            System.out.println("Welcome to the practice low literacy program\n");
            System.out.println("Press 1 to for randomized questions");
            System.out.println("Press 2 to for a certain amount of randomized questions");
            System.out.println("Press 0 to exit the program");
            Scanner sc = new Scanner(System.in);
            String key = sc.next();
            switch (key){
                case "0":
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
                 default:
                     System.out.println("Try another choice");
                     continue;
            }
        }
    }
}
