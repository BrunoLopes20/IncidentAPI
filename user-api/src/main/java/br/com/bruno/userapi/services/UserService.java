package br.com.bruno.userapi.services;


import br.com.bruno.userapi.domain.User;

import java.util.List;

public interface UserService {

    User findById(Long id);
    List<User> findAll();

}
