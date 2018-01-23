package com.sample.canteen;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;

public interface MenuRepository extends MongoRepository<Menu, String> {

    Menu findByDate(Date date);
}
