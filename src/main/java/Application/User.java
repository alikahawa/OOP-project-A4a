package Application;

import java.util.Base64;
import java.security.SecureRandom;
import java.security.*;
import java.nio.charset.StandardCharsets;

/**
 * An abstract class user with some getters and setters for all types of users
 */
public abstract class User {
    private String firstName;
    private String lastName;
    private String passwordSalt;
    private String passwordHash;
    private String email;

    /**
     * The constructor of an user
     *
     * @param firstName - the string firstName
     * @param lastName - the string lastName
     * @param password - the password of the username(preferably encrypted)
     * @param email    - the string email
     */
    public User(String firstName, String lastName, String password, String email) {
        this.email = email;
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[24];
        random.nextBytes(bytes);
        this.passwordSalt = new String(bytes);
        this.passwordHash = HashPassword(password, this.passwordSalt);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    /**
     * A method that can encode strings
     *
     * @param password - the string of the password to be encoded
     * @return - the encoded string
     */
    public static String encrypt(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    /**
     * A method to decode strings. This method is currently not used, but could be helpful for retrieving passwords.
     *
     * @param password - the encoded string to be decoded
     * @return - the unencoded password as a string
     */
    public static String decrypt(String password) {
        return new String(Base64.getDecoder().decode(password));
    }

    /**
     * A method that hashes a password using a secure hashing function
     *
     * @param password the password to hash
     * @param salt the salt used to secure the hash
     * @return the hashed password
     */
    public String HashPassword(String password, String salt)
    {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest((salt + password).getBytes(StandardCharsets.UTF_8));
            return new String(hash);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return "";
    }

    public boolean CheckPassword(String password)
    {
        return HashPassword(password, passwordSalt).equals(this.passwordHash);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof User) {
            if (((User)o).getFirstName().equals(this.getFirstName()) &&
                ((User)o).getFirstName().equals(this.getFirstName()) &&
                ((User)o).getEmail().equals(this.getEmail()))
            {
                return true;
            }
        }
        return false;
    }
}
