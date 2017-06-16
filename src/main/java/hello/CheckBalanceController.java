package hello;

import com.mongodb.util.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by sushantkumar on 13/6/17.
 */
@RestController
public class CheckBalanceController {


    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/checkbalance", method = RequestMethod.GET, produces = "application/json")
    public String CheckBalance(@RequestParam(value = "username", defaultValue = "null") String username,
                               HttpSession session) {
        System.out.println("Check Balance Request!");

        if(session.isNew()){
            return "User not logged in error!!";
        }
        else{
            //get user balance from user repository
            for(User user: userRepository.findAll()){
                if(user.getUsername().equals(username)){
                    System.out.println("Current User Balance: " + user.getBalance());
                    return "Balance: " + user.getBalance();
                }
            }

        }
        return "Check Balanced Called!";
    }
}
