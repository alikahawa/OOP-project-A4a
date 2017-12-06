import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class QuestionTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void test_the_constructor() {
        ArrayList<String> al = new ArrayList<>();
        assertThat("Question constructer is not working well", new MultiQuestion(1, al, "What is what?").getQuestion(),
                equalTo("What is what?"));
    }

    @Test
    public void test_the_constructor1() {
        ArrayList<String> al = new ArrayList<>();
        assertTrue("Address constructor is not working",
                new MultiQuestion (2, al, "What is what?").getRightAnswer() == 2);
    }

}
