package com.example.MyBookShopApp.config;

import com.example.MyBookShopApp.data.repository.AuthorRepository;
import com.example.MyBookShopApp.data.repository.BookRepository;
import com.example.MyBookShopApp.data.dto.TestEntity;
import com.example.MyBookShopApp.data.repository.TestEntityCrudRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

//@Configuration
public class CommandLineRunnerImpl implements CommandLineRunner {


    TestEntityCrudRepository testEntityCrudRepository;
    BookRepository bookRepository;
    AuthorRepository authorRepository;

    public CommandLineRunnerImpl(TestEntityCrudRepository testEntityCrudRepository, BookRepository bookRepository, AuthorRepository authorRepository) {
        this.testEntityCrudRepository = testEntityCrudRepository;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 5; i++) {
            createTestEntity(new TestEntity());
        }

        TestEntity readTestEntity = readTestEntityById(3L);
        if (readTestEntity != null) {
            Logger.getLogger(CommandLineRunnerImpl.class.getSimpleName()).info("read" + readTestEntity.toString());
        } else {
            throw new NullPointerException();
        }

        TestEntity updatedTestEntity = updateTestEntityById(5L);
        if (updatedTestEntity != null) {
            Logger.getLogger(CommandLineRunnerImpl.class.getSimpleName()).info("update " + updatedTestEntity.toString());
        } else {
            throw new NullPointerException();
        }

        deleteTestEntityById(4L);

        Logger.getLogger(CommandLineRunnerImpl.class.getSimpleName()).info(bookRepository.findBooksByAuthor_FirstName("Denyse").toString());


    }

    private void deleteTestEntityById(Long id) {
        TestEntity testEntity = testEntityCrudRepository.findById(id).get();
        testEntityCrudRepository.delete(testEntity);
    }

    private TestEntity updateTestEntityById(Long id) {
        TestEntity testEntity = testEntityCrudRepository.findById(id).get();
        testEntity.setData("NEW DATA");
        testEntityCrudRepository.save(testEntity);
        return testEntity;
    }

    private TestEntity readTestEntityById(Long id) {
        return testEntityCrudRepository.findById(id).get();
    }

    private void createTestEntity(TestEntity entity) {
        entity.setData(entity.getClass().getSimpleName()+entity.hashCode());
        testEntityCrudRepository.save(entity);
    }
}
