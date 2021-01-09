package com.example.ironbank2020.dao;

import com.example.ironbank2020.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface UserRepo extends JpaRepository<User, Integer> {


    @Override
    <S extends User> List<S> saveAll(Iterable<S> iterable);

    @RestResource(path = "byAge")
    List<User> findByAgeGreaterThan(@Param("age") int age);
}
