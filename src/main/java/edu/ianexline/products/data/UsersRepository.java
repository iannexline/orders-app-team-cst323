package edu.ianexline.products.data;

import org.springframework.data.repository.CrudRepository;

import edu.ianexline.products.models.UserEntity;

public interface UsersRepository extends CrudRepository<UserEntity, Integer> {

    UserEntity findByUsername(String username);
}