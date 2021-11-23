package com.project.shop.projectshop.repository.user;

import java.util.Optional;

import com.project.shop.projectshop.model.user.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

  Optional<UserEntity> findOneByName(String name);

  Optional<UserEntity> findOneByEmail(String email);

}
