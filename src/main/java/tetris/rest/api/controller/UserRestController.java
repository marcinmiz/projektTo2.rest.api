package tetris.rest.api.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tetris.rest.api.data.FriendRelationRepository;
import tetris.rest.api.data.UserRepository;
import tetris.rest.api.model.entity.FriendRelation;
import tetris.rest.api.model.entity.User;
import tetris.rest.api.model.entity.angular.AngularUser;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("api/users")
public class UserRestController {

    @Autowired
    private UserRepository userRepository;
    private FriendRelationRepository friendRelationRepository;

    @GetMapping
    public List<AngularUser> getAllUsers() {
        List<AngularUser> list = new ArrayList<>();
        userRepository.findAll().forEach(user -> list.add(new AngularUser(user)));
        return list;
    }

    @GetMapping("/getfriends/{id}")
    public List<AngularUser> getAllFriends(@PathVariable("id") Integer id) {
        List<AngularUser> list = new ArrayList<>();
//        userRepository.findAll().forEach(user -> list.add(new AngularUser(user)));
        List<FriendRelation> list2 = new ArrayList<>();
        friendRelationRepository.findAll().forEach(list2::add);
        list2.stream().filter(p -> p.getReceiverUser().getId().equals(id) || p.getSenderUser().getId().equals(id));
        for (FriendRelation friendRelation: list2){
            if (!friendRelation.getReceiverUser().getId().equals(id)){
                list.add(new AngularUser(userRepository.findById(friendRelation.getReceiverUser().getId()).get()));
            }
            if (!friendRelation.getReceiverUser().getId().equals(id)){
                list.add(new AngularUser(userRepository.findById(friendRelation.getSenderUser().getId()).get()));
            }
        }
        return list;
    }

    @GetMapping("/{id}")
    public AngularUser getUser(@PathVariable("id") Integer id){
            return new AngularUser(userRepository.findById(id).get());
    }

    @PutMapping
    public AngularUser updateUser(@RequestBody AngularUser updatedUser) {
        User originalUser = userRepository.findById(updatedUser.getId()).get();
        originalUser.setUsername(updatedUser.getUsername());
        originalUser.setRankingsPoints(updatedUser.getRankingsPoints());
        return new AngularUser(userRepository.save(originalUser));
    }
    @PostMapping
    public AngularUser newUser(@RequestBody User user){
            return new AngularUser(userRepository.save(user));
    }

}
