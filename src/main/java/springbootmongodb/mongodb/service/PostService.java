package springbootmongodb.mongodb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootmongodb.mongodb.domain.Post;
import springbootmongodb.mongodb.domain.User;
import springbootmongodb.mongodb.dto.UserDTO;
import springbootmongodb.mongodb.repository.PostRepository;
import springbootmongodb.mongodb.repository.UserRepository;
import springbootmongodb.mongodb.service.exception.ObjectNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }


}
