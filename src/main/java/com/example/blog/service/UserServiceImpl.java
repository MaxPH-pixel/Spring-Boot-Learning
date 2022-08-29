package com.example.blog.service;

import com.example.blog.model.User;
import com.example.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        if(user.getMessage() != null &&
                user.getMessage().length() > 0 &&
                user.getName() != null &&
                user.getName().length() > 0) {
            throw new IllegalStateException("Name or massage not valid");
        }
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteMassage(Integer id) {
        boolean exists = userRepository
                .existsById(id);
        if(!exists){
            throw new IllegalArgumentException("User with id " + id + "does not exists");
        }
        userRepository.deleteById(id);
    }

    @Transactional
    public void updateMassage(Integer id, String massage) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Massage with id " + id + "does not exists"));

        if(massage != null &&
                    massage.length() > 0 ){
            user.setMessage(massage);
        }
    }
}
