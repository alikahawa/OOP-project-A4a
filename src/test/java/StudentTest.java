import Application.Student;
import Application.Teacher;
import Application.User;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StudentTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    /**
     * Test for the getter of the username
     */
    @Test
    public void test_the_constructor() {
        User Simo = new Student("simo", "lino","0123","simo@gmail.com");
        assertTrue("User constructer is not working well", new Student("simo", "lino","","").getFirstName().equals("simo"));
    }

    /**
     * Test for the getter of the email
     */
    @Test
    public void test_the_constructor1() {
        User Simo = new Student("simo", "lino","0123","simo@gmail.com");
        assertTrue("User constructer is not working well", new Student("simo", "lino","","simo@gmail.com").getEmail().equals("simo@gmail.com"));
    }
    /**
     * Test for the getter of the  password
     */
    @Test
    public void test_the_constructor2() {
        User Simo = new Student("simo", "lino","0123","simo@gmail.com");
        assertTrue("User constructer is not working well", new Student("simo", "lino","0123","simo@gmail.com").CheckPassword("0123"));
    }
    /**
     * Test the constructor
     */
    @Test
    public void test_the_constructor3(){
        Student Simo = new Student("T", "S","","");
        assertFalse("User constructer is not working well",Simo.getFirstName().equals("teacher"));
    }

    /**
     * Test the constructor
     */
    @Test
    public void test_the_constructor4(){
        Student Simo = new Student("", "","","a@gmail.com");
        assertFalse("User constructer is not working well",Simo.getEmail().equals("teacher"));
    }

    /**
     * Test the constructor
     */
    @Test
    public void test_the_constructor5(){
        Student Simo = new Student("", "","01235","");
        assertFalse("User constructer is not working well",Simo.CheckPassword("teacher"));
    }

    /**
     * Test the equal
     */
    @Test
    public void test_equals(){
        Teacher S = new Teacher("1", "2","1234","1@");
        Student s1 = new Student("1", "2","1234","1@");
        assertFalse("Equals method is not working well", s1.equals(S));
    }
    /**
     * Test the equal
     */
    @Test
    public void test_equals1(){
        Teacher S = new Teacher("2", "2","1234","1@");
        Student s1 = new Student("1", "2","1234","1@");
        assertFalse("Equals method is not working well", s1.equals(S));
    }
    /**
     * Test the equal
     */
    @Test
    public void test_equals2(){
        Student S = new Student("1", "2","1234","1@");
        Student s1 = new Student("1", "2","1234","1@");
        assertTrue("Equals method is not working well", s1.equals(S));
    }
    /**
     * Test the equal
     */
    @Test
    public void test_equals4(){
        Teacher S = new Teacher("1", "2","1234","1@");
        Student s1 = new Student("1", "2","1234","1@");
        assertFalse("Equals method is not working well", s1.equals(S));
    }
    /**
     * Test the equal
     */
    @Test
    public void test_equals5(){
        Student S = new Student("1111", "2","1234","1@");
        Student s1 = new Student("1111", "2","1234","1@");
        assertTrue("Equals method is not working well", s1.equals(S));
    }

}
