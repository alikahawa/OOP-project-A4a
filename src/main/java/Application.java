
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class    Application {

    static QuestionList globalQuestionList = QuestionList.ReadFromXML("C:\\Users\\ANDOR-LAPTOP\\Documents\\Uni\\OOP\\Project\\xml format.xml");

    public static void main(String[] args) {


        while (true){
            System.out.println("Welcome to the practice low literacy program\n");
            System.out.println("Press 1 to do nothing");
            System.out.println("Press 2 to add a question);
            System.out.println("Press 3 to exit the program");
            Scanner sc = new Scanner(System.in);
            String key = sc.next();
            switch (key){
                case "2":
                    addQuestion();
                    continue;
                case "1":
                    continue;
                case "3":
                    System.exit(0);
                    break;
                 default:
                     System.out.println("Try another choice");
                     continue;
            }
        }
    }

    public static void addQuestion()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("What is your question?");
        String questionText = sc.next();
        System.out.println("How many answers does your program have?");
        int amountOfAnswers = sc.nextInt();

        ArrayList<String> answerList = new ArrayList<>();
        for (int i = 0; i < amountOfAnswers; i++)
        {
            char tmp = (char)('A' + i);
            System.out.print("Answer ");
            System.out.print(tmp);
            System.out.println(" is:");

            answerList.add(sc.next());
        }

        System.out.println("The right answer is?");

          char rightAnswer = sc.next().toUpperCase().charAt(0);

        Question q1 = new Question(rightAnswer,answerList,questionText);
        globalQuestionList.add(q1);
    }
}
