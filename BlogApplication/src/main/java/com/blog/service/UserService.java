package com.blog.service;

import com.blog.exception.UserException;
import com.blog.model.User;

public interface UserService {
public User getRegister (User user) throws UserException;
}
