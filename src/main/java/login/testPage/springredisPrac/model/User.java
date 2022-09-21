package login.testPage.springredisPrac.model;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class User {

    private static final Logger logger = LoggerFactory.getLogger(User.class);

    //User objects, can set new details in controller/form
    private String username;
    private String firstName = "John";
    private String lastName ="Johnson";
    private String message = "john Johsnon";
    private ArrayList<String> testList;

    
    public ArrayList<String> getTestList() {
        return testList;
    }
    public void setTestList(ArrayList<String> testList) {
        this.testList = testList;
    }


    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    
}
