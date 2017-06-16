package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Created by sushantkumar on 13/6/17.
 */
@RestController
public class LoginController {


    @Autowired
    public UserRepository repository;

    @RequestMapping (value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "username", defaultValue = "null") String username,
                        @RequestParam(value = "password",defaultValue = "none") String password,
                        HttpServletRequest request,
                        HttpServletRequest response,
                        HttpSession session)
    {

        if((request.getAttribute("IsValidRequest")!= null) && request.getAttribute("IsValidRequest").equals("false")){
            return "Invalid Request";
        }

        if(session.isNew()){
            session.setMaxInactiveInterval(100);
            for (User user : repository.findAll()) {
                if (user.getUsername().equals(username.trim())) {
                    if (user.getPassword().equals(password.trim())) {
                        System.out.println("Valid Credentials");
                        if (!user.isLoggedIn()) {
                            user.setLoggedIn(true);
                            repository.save(user);
                            session.setAttribute("token","randomtoken"+username);
                            return "User Logged In Successfully!";
                        } else {
                            return "User Already Logged In";
                        }
                    } else
                        return "Password Incorrect Error!!";
                }
            }
            return "User Name Not Found";
        }

        /*if (session.isNew()) {
            session.setMaxInactiveInterval(100);
        }
        System.out.println("Requested Params\n\tUsername: " + username + "\tPassword: " + password);
        for (User user : repository.findAll()) {
            if (user.getUsername().equals(username.trim())) {
                if (user.getPassword().equals(password.trim())) {
                    System.out.println(session.getId());
                    if (!user.isLoggedIn()) {
                        user.setLoggedIn(true);
                        session.setAttribute("LOGGEDIN_USER","true");
                        return "User Logged In Successfully!";
                    } else {
                        return "User Already Logged In";
                    }
                } else
                    return "Password Incorrect Error!!";
            }
        }
        return "User Name Not Found";
        */



        return "User Already Logged In";
    }
}
