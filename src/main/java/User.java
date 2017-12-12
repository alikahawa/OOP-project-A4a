import java.util.Base64;

public abstract class User {
    private String userName;
    private String password;
    private String email;

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

    public static String encrypt(String password){
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    public static String decrypt(String password){
        return new String(Base64.getDecoder().decode(password));
    }
}
