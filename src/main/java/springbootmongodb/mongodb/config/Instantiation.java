package springbootmongodb.mongodb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import springbootmongodb.mongodb.domain.Post;
import springbootmongodb.mongodb.domain.User;
import springbootmongodb.mongodb.dto.AuthorDTO;
import springbootmongodb.mongodb.repository.PostRepository;
import springbootmongodb.mongodb.repository.UserRepository;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        repository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        repository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null,
                sdf.parse("21/03/2018"),
                "Partiu viagem",
                "Vou viajar para São Paulo. Abraços!",
                new AuthorDTO(maria));
        Post post2 = new Post(null,
                sdf.parse("23/03/2018"),
                "Bom dia",
                "Acordei Feliz hoje!",
                new AuthorDTO(maria));

        postRepository.saveAll(Arrays.asList(post1, post2));
    }

}
