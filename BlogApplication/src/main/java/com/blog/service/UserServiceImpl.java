package com.blog.service;

import com.blog.exception.UserException;
import com.blog.model.User;
import com.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepo;
    @Override
    public User getRegister(User user) throws UserException {
      Optional<User> exstingUser = userRepo.findByEmail(user.getEmail());
      if(exstingUser.isPresent()) throw new UserException("Email Id already present");
      else {
          user.setRole("USER");
          return userRepo.save(user);
      }
    }
}
