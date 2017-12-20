import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TeacherTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    /**
     * Test for the getter of the username
     */
    @Test
    public void test_the_constructor() {
        User Simo = new Teacher("simo","0123","simo@gmail.com");
        assertTrue("User constructer is not working well", new Teacher("simo","","").getUserName().equals("simo"));
    }

    /**
     * Test for the getter of the email
     */
    @Test
    public void test_the_constructor1() {
        User Simo = new Teacher("simo","0123","simo@gmail.com");
        assertTrue("User constructer is not working well", new Teacher("simo","","simo@gmail.com").getEmail().equals("simo@gmail.com"));
    }
    /**
     * Test for the getter of the  password
     */
    @Test
    public void test_the_constructor2() {
        User Simo = new Teacher("simo","0123","simo@gmail.com");
        assertTrue("User constructer is not working well", new Teacher("simo","0123","simo@gmail.com").getPassword().equals("0123"));
    }
    /**
     * Test the constructor
     */
    @Test
    public void test_the_constructor3(){
        Teacher Simo = new Teacher("T","","");
        assertFalse("User constructer is not working well",Simo.getUserName().equals("teacher"));
    }

    /**
     * Test the constructor
     */
    @Test
    public void test_the_constructor4(){
        Teacher Simo = new Teacher("","","a@gmail.com");
        assertFalse("User constructer is not working well",Simo.getEmail().equals("teacher"));
    }

    /**
     * Test the constructor
     */
    @Test
    public void test_the_constructor5(){
        Teacher Simo = new Teacher("","01235","");
        assertFalse("User constructer is not working well",Simo.getPassword().equals("teacher"));
    }

    /**
     * Test the equal
     */
    @Test
    public void test_equals(){
        Teacher S = new Teacher("1","1234","1@");
        Student s1 = new Student("1","1234","1@");
        assertFalse("Equals method is not working well", s1.equals(S));
    }
    /**
     * Test the equal
     */
    @Test
    public void test_equals1(){
        Teacher S = new Teacher("2","1234","1@");
        Student s1 = new Student("1","1234","1@");
        assertFalse("Equals method is not working well", s1.equals(S));
    }
    /**
     * Test the equal
     */
    @Test
    public void test_equals2(){
        Teacher S = new Teacher("1","1234","1@");
        Teacher s1 = new Teacher("1","1234","1@");
        assertTrue("Equals method is not working well", s1.equals(S));
    }
    /**
     * Test the equal
     */
    @Test
    public void test_equals3(){
        Teacher S = new Teacher("1","1234","1@");
        Teacher s1 = new Teacher("2","1234","1@");
        assertFalse("Equals method is not working well", s1.equals(S));
    }
    /**
     * Test the equal
     */
    @Test
    public void test_equals6(){
        Teacher S = new Teacher("1","1234","@");
        Teacher s1 = new Teacher("1","1234","1@");
        assertFalse("Equals method is not working well", s1.equals(S));
    }
    /**
     * Test the equal
     */
    @Test
    public void test_equals4(){
        Teacher S = new Teacher("1","1234","1@");
        Student s1 = new Student("1","1234","1@");
        assertFalse("Equals method is not working well", s1.equals(S));
    }
    /**
     * Test the equal
     */
    @Test
    public void test_equals5(){
        Teacher S = new Teacher("1111","1234","1@");
        Teacher s1 = new Teacher("1111","1234","1@");
        assertTrue("Equals method is not working well", s1.equals(S));
    }

}
