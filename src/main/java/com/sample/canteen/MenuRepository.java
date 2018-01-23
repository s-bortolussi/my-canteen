package com.sample.canteen;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;

public interface MenuRepository extends MongoRepository<Menu, String> {

    Menu findByDate(LocalDate date);
}
