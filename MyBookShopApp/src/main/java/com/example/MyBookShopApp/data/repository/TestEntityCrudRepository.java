package com.example.MyBookShopApp.data.repository;

import com.example.MyBookShopApp.data.dto.TestEntity;
import org.springframework.data.repository.CrudRepository;

public interface TestEntityCrudRepository extends CrudRepository<TestEntity,Long> {
}
