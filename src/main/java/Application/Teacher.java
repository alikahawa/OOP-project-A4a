package Application;

/**
 * Class Teacher which extends class User. Teacher specific methods need to be added here(currently none).
 */
public class Teacher extends User {
    public Teacher(String firstName, String lastName, String password, String email){
        super(firstName, lastName, password, email);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Teacher) {
            if (((Teacher)o).getFirstName().equals(this.getFirstName()) &&
                    ((Teacher)o).getFirstName().equals(this.getFirstName()) &&
                    ((Teacher)o).getEmail().equals(this.getEmail()))
            {
                return true;
            }
        }
        return false;
    }
}
