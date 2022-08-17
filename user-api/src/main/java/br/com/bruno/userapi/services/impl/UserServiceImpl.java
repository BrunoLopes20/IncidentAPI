package br.com.bruno.userapi.services.impl;

import br.com.bruno.userapi.domain.User;
import br.com.bruno.userapi.repositories.UserRepository;
import br.com.bruno.userapi.services.UserService;
import br.com.bruno.userapi.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {


    private final UserRepository repository;

    @Override
    public User findById(Long id) {
        return repository.findById(id).orElseThrow(()-> new ObjectNotFoundException("Object not fund"));
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }
}
