package tetris.rest.api.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tetris.rest.api.data.UserRepository;
import tetris.rest.api.model.entity.User;

import javax.servlet.http.HttpServletResponse;
@RestController
@RequestMapping("api/users")
public class UserRestController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping
    public List<User> getUsers(HttpServletResponse response){
        return (List<User>) userRepository.findAll();
    }
}
