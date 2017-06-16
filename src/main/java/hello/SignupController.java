package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sushantkumar on 13/6/17.
 */
@RestController
public class SignupController {

    @Autowired
    public UserRepository repository;

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(@RequestParam(value = "username", defaultValue = "null") String username,
                       @RequestParam(value = "password") String password,
                       @RequestParam(value = "confirm_password") String confirmPassword
    ){
        if(username!=null){
            for(User user : repository.findAll()){
                if(user.getUsername().equals(username)){
                    System.out.println("Username Already Exists Error");
                    return "Username Already Exists Error";
                }
            }
        }
        if(!password.equals(confirmPassword)){
            System.out.println("Password Mismatch Error!!");
            //return appropriate response error message
            return "Password Mismatch Error!!";
        }
        else if(password.length()<8){
            System.out.println("Weak Password Error");
            return "Password is short. Minimum 8 characters required";
        }
        else {
            System.out.println("Inserting Record with \nUsername: " + username + "\tPassword: " + password);
            repository.save(new User(username, password));
            return "Record Inserted Successfully!";
        }
    }
}
