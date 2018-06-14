package ru.minutkann.ucozapiclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.minutkann.ucozapiclient.model.User;
import ru.minutkann.ucozapiclient.repository.UserRepository;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    public User get(int id) {
        try {
            return repository.get(id);
        } catch (InterruptedException | ExecutionException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<User> getAll(){
        try {
            return repository.getAll();
        } catch (InterruptedException | ExecutionException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
