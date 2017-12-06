
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class QuestionTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    /**
     * Test for the getter of the Question
     */
    @Test
    public void test_the_constructor() {
        ArrayList<String> al = new ArrayList<>();
        assertThat("Question constructor is not working well", new Question(1, al, "What is what?").getQuestion(),
                equalTo("What is what?"));
    }

    /**
     * Test for the getter of the RightAnswer
     */
    @Test
    public void test_the_constructor1() {
        ArrayList<String> al = new ArrayList<>();
        assertTrue("Address constructor is not working",
                new Question(2, al, "What is what?").getRightAnswer() == 2);
    }

    /**
     * A test for AnswerList getter
     */
    @Test
    public void test_the_constructor2() {
        ArrayList<String> la = new ArrayList<>();
        ArrayList<String> al = new ArrayList<>();
        String a = "answer b";
        String a1 = "answer a";
        String a2 = "answer c";
        al.add(a); al.add(a1); al.add(a2);
        la.add(a);
        assertFalse("", new Question(1, al, "some question?").getAnswerList().equals(la));
    }

    /**
     *
     */
    @Test
    public void test_print(){
        ArrayList<String> al = new ArrayList<>();
        String a = "answer b";
        String a1 = "answer a";
        String a2 = "answer c";
        Question q = new Question(2,al,"What is the right answer?");

    }

    /**
     *All 5 next tests are to test the method of isitRightAnswer
     *
     */
    @Test
    public void test_isItRightAnswer(){
        ArrayList<String> al = new ArrayList<>();
        String a = "answer b";
        String b = "answer a";
        String c = "answer c";
        String d = "answer d";
        al.add(a); al.add(b); al.add(c); al.add(d);
        Question q = new Question(2,al,"What is the right answer?");
        assertTrue("Isrightanswer is not working!",q.isItRightAnswer('b'));
    }

    @Test
    public void test_isItRightAnswer1(){
        ArrayList<String> al = new ArrayList<>();
        String a = "answer b";
        String b = "answer a";
        String c = "answer c";
        String d = "answer d";
        al.add(a); al.add(b); al.add(c); al.add(d);
        Question q = new Question(2,al,"What is the right answer?");
        assertFalse("Isrightanswer is not working!",q.isItRightAnswer('d'));
    }

    @Test
    public void test_isItRightAnswer2(){
        ArrayList<String> al = new ArrayList<>();
        String a = "answer b";
        String b = "answer a";
        String c = "answer c";
        String d = "answer d";
        al.add(a); al.add(b); al.add(c); al.add(d);
        Question q = new Question(2,al,"What is the right answer?");
        assertFalse("Isrightanswer is not working!",q.isItRightAnswer('e'));
    }

    @Test
    public void test_isItRightAnswer3(){
        ArrayList<String> al = new ArrayList<>();
        String a = "answer b";
        String b = "answer a";
        String c = "answer c";
        String d = "answer d";
        al.add(a); al.add(b); al.add(c); al.add(d);
        Question q = new Question('d' ,al,"What is the right answer?");
        assertTrue("Isrightanswer is not working!",q.isItRightAnswer('d'));
    }

    @Test
    public void test_isItRightAnswer4(){
        ArrayList<String> al = new ArrayList<>();
        String a = "answer b";
        String b = "answer a";
        String c = "answer c";
        String d = "answer d";
        al.add(a); al.add(b); al.add(c); al.add(d);
        Question q = new Question(1,al,"What is the right answer?");
        assertFalse("Isrightanswer is not working!",q.isItRightAnswer('z'));
    }
}
