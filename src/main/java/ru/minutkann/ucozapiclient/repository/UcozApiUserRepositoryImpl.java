package ru.minutkann.ucozapiclient.repository;

import com.github.scribejava.core.model.Verb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.minutkann.ucozapiclient.model.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Repository
public class UcozApiUserRepositoryImpl implements UserRepository {

    private final UcozApiClient client;

    @Autowired
    public UcozApiUserRepositoryImpl(UcozApiClient client) {
        this.client = client;
    }

    public User get(int id) throws InterruptedException, ExecutionException, IOException {
        Map<String,String> params = new HashMap<>();
        params.put("user_id", String.valueOf(id));
        System.out.println(client.getResponse(Verb.GET, "users", params).getBody());
        return null;
    }

    @Override
    public List<User> getAll() throws InterruptedException, ExecutionException, IOException {
        System.out.println(client.getResponse(Verb.GET, "users").getBody());
        return null;
    }
}
