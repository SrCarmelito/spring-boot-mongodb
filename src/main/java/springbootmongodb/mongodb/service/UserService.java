package springbootmongodb.mongodb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootmongodb.mongodb.domain.User;
import springbootmongodb.mongodb.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    public List<User> findAll() {
        return repository.findAll();
    }

}
