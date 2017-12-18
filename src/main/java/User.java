import java.util.Base64;

/**
 * An abstract class user with some getters and setters for all types of users
 */
public abstract class User {
    private String userName;
    private String password;
    private String email;

    /**
     * The constructor of an user
     * @param userName - the string username
     * @param password - the password of the username(preferably encrypted)
     * @param email - the string email
     */
    public User(String userName, String password, String email){
        this.email = email;
        this.password = password;
        this.userName = userName;
    }

    public String getUserName(){
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword(){
        return password;
    }

    /**
     * A method that can encode strings
     * @param password - the string of the password to be encoded
     * @return - the encoded string
     */
    public static String encrypt(String password){
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    /**
     * A method to decode strings. This method is currently not used, but could be helpful for retrieving passwords.
     * @param password - the encoded string to be decoded
     * @return - the unencoded password as a string
     */
    public static String decrypt(String password){
        return new String(Base64.getDecoder().decode(password));
    }
}
