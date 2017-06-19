package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by sushantkumar on 14/6/17.
 */
@RestController
public class LogoutController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logout(@RequestParam(value = "username",defaultValue = "null")String username, HttpSession session,
                         HttpServletRequest request){

        if(session.isNew()){
            session.invalidate();
            return "User Not Logged In!!";
        }
        else{
            for(User user: userRepository.findAll()){
                if(user.getUsername().equals(username)){
                    if(user.isLoggedIn()) {
                        user.setLoggedIn(false);
                        userRepository.save(user);
                    }
                    else{
                        return "User Not Logged In";
                    }
                }
            }
            session.invalidate();
            return "User Logged out Successfully";
        }
    }
}
