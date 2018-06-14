package ru.minutkann.ucozapiclient.repository;

import ru.minutkann.ucozapiclient.model.User;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

public interface UserRepository {
    User get(int id) throws InterruptedException, ExecutionException, IOException;

    List<User> getAll() throws InterruptedException, ExecutionException, IOException;
}
