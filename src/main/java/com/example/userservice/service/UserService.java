package com.example.userservice.service;

import com.example.userservice.Model.User;
import com.example.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    private static List<User> userList = new ArrayList<>();
    private static int count  = 0;

    static {
        userList.add(new User(++count, "Mayur", "Munde", LocalDate.now().minusYears(30), "admin"));
        userList.add(new User(++count, "Vivek", "Hatterge", LocalDate.now().minusYears(25), "admin"));
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUsers(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty())
            throw new RuntimeException();
        return user.get();

    }

    public Object createUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

/*    public List<User> findAllUsers(){
        return userList;
    }

    public User findUsers(int id) {
        return userList.stream().filter(user -> user.getId() == id).findFirst().get();
    }

    public boolean deleteUser(int id) {
        Predicate< User> p = user -> user.getId() == id;
        return userList.removeIf(p);
    }

    public User createUser(User user) {
        user.setId(++count);
        userList.add(user);
        return user;
    }*/
}
