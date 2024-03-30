package springbootmongodb.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import springbootmongodb.mongodb.domain.Post;
import springbootmongodb.mongodb.domain.User;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
