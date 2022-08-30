package com.example.blog.service;

import com.example.blog.model.dto.UserCreateDto;
import com.example.blog.model.entity.User;
import com.example.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(UserCreateDto userCreateDto) {
        User user = User.builder()
                .name(userCreateDto.getName())
                .message(userCreateDto.getMessage())
                .build();
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
        if (!exists) {
            throw new EntityNotFoundException("User with id " + id + "does not exists");
        }
        userRepository.deleteById(id);
    }

    @Transactional
    public void updateMassage(Integer id, String massage) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Massage with id " + id + "does not exists"));
        user.setMessage(massage);
    }
}
