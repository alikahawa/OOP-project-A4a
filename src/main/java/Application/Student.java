package Application;

/**
 * Class Student which extends class User. Possible progress overview method would need to be added here
 */
public class Student extends User {
    public Student(String firstName, String lastName, String password, String email){
        super(firstName, lastName, password, email);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Student) {
            if (((Student)o).getFirstName().equals(this.getFirstName()) &&
                    ((Student)o).getFirstName().equals(this.getFirstName()) &&
                    ((Student)o).getEmail().equals(this.getEmail()))
            {
                return true;
            }
        }
        return false;
    }
}
