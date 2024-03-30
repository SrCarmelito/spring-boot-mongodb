package springbootmongodb.mongodb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootmongodb.mongodb.domain.User;
import springbootmongodb.mongodb.dto.UserDTO;
import springbootmongodb.mongodb.repository.UserRepository;
import springbootmongodb.mongodb.service.exception.ObjectNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User obj) {
        return repository.insert(obj);
    }

    public User fromDTO(UserDTO objDTO) {
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }

    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }

    public User update(User obj) {
        Optional<User> obj1 = repository.findById(obj.getId());
        User newObj = obj1.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
        updateData(newObj, obj);

        return repository.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

}
