package project.spring.userchargermanagementsystem.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import project.spring.userchargermanagementsystem.model.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

}
