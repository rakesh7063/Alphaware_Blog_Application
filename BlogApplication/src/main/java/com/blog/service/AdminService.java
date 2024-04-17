package com.blog.service;

import com.blog.exception.AdminException;
import com.blog.model.User;

public interface AdminService {
    public User adminRegister (User admin) throws AdminException;
}
