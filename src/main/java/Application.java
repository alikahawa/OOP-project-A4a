
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        QuestionList tmpql = QuestionList.ReadFromXML("C:\\Users\\ANDOR-LAPTOP\\Documents\\Uni\\OOP\\Project\\xml format.xml");
        tmpql.WriteToXML("C:\\Users\\ANDOR-LAPTOP\\Documents\\Uni\\OOP\\Project\\xml format.xml");

        while (true){
            System.out.println("Welcome to the practice low literacy program\n");
            System.out.println("Press 1 to enter the first exam");
            System.out.println("Press 2 to enter the second exam");
            System.out.println("Press 3 to exit the program");
            Scanner sc = new Scanner(System.in);
            String key = sc.next();
            switch (key){
                case "2":
                    System.out.println("Read the next text :" +
                            "\n"+"Master Event\n" +
                            "Join us at the Master Event on Thursday 23 November at VU Amsterdam.\n");
                    System.out.println("Q1 : Where will the Master Event be?");
                    System.out.println("A.TU Delft\n" +
                            "B.UVA Amsterdam\n" +
                            "C.VU Amsterdam\n" +
                            "D.UU Utrecht\n");
                    if (sc.next().toLowerCase().equals("c")){
                        System.out.println("Nice!");
                    }
                    else{
                        System.out.println("Not a good answer!" +
                                "\n the right answer is c ");
                    }

                    System.out.println("Read the next text :" + "Building 12 at TU Delft\n" +
                            "Opening Hours:\n" +
                            "Monday to Friday  from 07.30 – 18.30\n");
                    System.out.println("Q2 : Is Building 12 reachable on Thursday at 14.30 ?");
                    System.out.println("A. Yes\n" +
                            "B. No\n" +
                            "C. Not mentioned\n" +
                            "D. None of above\n");
                    if (sc.next().toLowerCase().equals("a")){
                        System.out.println("Good job!");
                    }

                    continue;
                case "1":
                    System.out.println("Look at the next text:\n" +
                            "Services\n" +
                            "  \tParking: at the rear of the building \t  \tFood and drinks: \n" +
                            "Restaurant on the 1st floor in the high-rise building.\n");
                    System.out.println("Q1 : What are the services provided by the text?");
                    System.out.println("A. Parking\n" +
                            "B. Food and drinks\n" +
                            "C. Both A and B\n" +
                            "D. None of above\n");
                    if (sc.next().toLowerCase().equals("c")){
                        System.out.println("Nice!");
                    }
                    System.out.println("Q2 : , Where can you park your car?");
                    System.out.println("A. Next to the building\n" +
                            "B. Behind the building\n" +
                            "C. Next or behind the building\n" +
                            "D. Not given\n");
                    if (sc.next().toLowerCase().equals("a")){
                        System.out.println("Good job!");
                    }
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
}
