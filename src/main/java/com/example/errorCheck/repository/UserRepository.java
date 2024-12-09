package com.example.errorCheck.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.errorCheck.model.AppUser;

@Repository
public interface UserRepository extends CrudRepository<AppUser, Long> {

}
