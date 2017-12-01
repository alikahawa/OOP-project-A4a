import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class QuestionListTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void test_the_constructor() {
        ArrayList<String> al = new ArrayList<>();
        Question q = new Question(1,al,"Some question?");
        QuestionList ql = new QuestionList();

        assertThat("Question constructor is not working well", new Question(1, al, "What is what?").getQuestion(),
                equalTo("What is what?"));
    }

    @Test
    public void test_the_addQuestions() {
        ArrayList<String> al = new ArrayList<>();
        Question q = new Question(1,al,"Some question?");
        QuestionList ql = new QuestionList();
        ql.add(q);
        QuestionList q2 = new QuestionList();
        q2.add(q);
       assertTrue("Add is Not working well!",q2.equals(ql));
    }

    @Test
    public void test_the_addQuestions1() {
        ArrayList<String> al = new ArrayList<>();
        Question q = new Question(1,al,"Some question?");
        Question qu = new Question(2,al,"Another Question?");
        QuestionList ql = new QuestionList();
        ql.add(q);
        QuestionList q2 = new QuestionList();
        q2.add(q);
        q2.add(qu);
        assertFalse("Add is not working well!",q2.equals(ql));
    }

    @Test
    public void test_the_addQuestions2() {
        ArrayList<String> al = new ArrayList<>();
        Question q = new Question(1,al,"Some question?");
        Question qu = new Question(2,al,"Another Question?");
        QuestionList ql = new QuestionList();
        ql.add(q);
        ql.add(qu);
        QuestionList q2 = new QuestionList();
        q2.add(q);
        q2.add(qu);
        assertTrue("Add is not working well!",q2.equals(ql));
    }

    @Test
    public void test_the_addQuestions3() {
        ArrayList<String> al = new ArrayList<>();
        Question q = new Question(1,al,"Some question?");
        Question qu = new Question(2,al,"Another Question?");
        QuestionList ql = new QuestionList();
        ql.add(q);
        ql.add(qu);
        ql.add(qu);
        QuestionList q2 = new QuestionList();
        q2.add(q);
        q2.add(qu);
        assertFalse("Add is not working well!",q2.equals(ql));
    }

}
