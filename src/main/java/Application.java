
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        QuestionList tmpql = QuestionList.ReadFromXML("OOP.xml");
        tmpql.WriteToXML("OOP.xml");

        while (true){
            System.out.println("Welcome to the practice low literacy program\n");
            System.out.println("Press 1 to for randomized questions");
            System.out.println("Press 0 to exit the program");
            Scanner sc = new Scanner(System.in);
            String key = sc.next();
            switch (key){
                case "0":
                    System.exit(0);
                    break;
                case "1":
                    ArrayList<Question> shuffledTmpql = tmpql.shuffleQuestionList();
                    for(Question question : shuffledTmpql){
                        question.askQuestion(sc);
                    }
                 default:
                     System.out.println("Try another choice");
                     continue;
            }
        }
    }
}
