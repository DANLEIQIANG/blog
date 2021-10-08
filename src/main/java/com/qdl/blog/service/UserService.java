package com.qdl.blog.service;

import com.qdl.blog.po.User;

public interface UserService {

    User checkUser(String username, String password);

}


