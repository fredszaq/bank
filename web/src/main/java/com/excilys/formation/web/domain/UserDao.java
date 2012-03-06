package com.excilys.formation.web.domain;

public interface UserDao {
    User getForUsername(String username);

    void createUser(User user);
}