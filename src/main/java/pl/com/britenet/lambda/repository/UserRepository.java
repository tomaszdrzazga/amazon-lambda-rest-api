package pl.com.britenet.lambda.repository;

import org.springframework.data.repository.CrudRepository;
import pl.com.britenet.lambda.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}