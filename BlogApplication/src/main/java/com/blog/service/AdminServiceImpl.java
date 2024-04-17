package com.blog.service;

import com.blog.exception.AdminException;
import com.blog.exception.UserException;
import com.blog.model.User;
import com.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    UserRepository userRepo;
    @Override
    public User adminRegister(User admin) throws AdminException {
        Optional<User> exstingUser = userRepo.findByEmail(admin.getEmail());
        if(exstingUser.isPresent()) throw new AdminException("Email Id already present");
        else {
            admin.setRole("ADMIN");
            return userRepo.save(admin);
        }

    }
}
