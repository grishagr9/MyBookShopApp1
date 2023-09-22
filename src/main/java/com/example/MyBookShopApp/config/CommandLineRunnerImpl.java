package com.example.MyBookShopApp.config;

import com.example.MyBookShopApp.data.BookRepository;
import com.example.MyBookShopApp.data.TestEntity;
import com.example.MyBookShopApp.data.TestEntityCrudRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.logging.Logger;
import jakarta.persistence.EntityManagerFactory;

@Configuration
public class CommandLineRunnerImpl implements CommandLineRunner {

    /*@Autowired
    TestEntityCrudRepository testEntityCrudRepository;

    @Autowired
    BookRepository bookRepository;*/
    @Override
    public void run(String... args) throws Exception {
        /*for (int i = 0; i < 5; i++) {
            createTestEntity(new TestEntity());
        }

        TestEntity readTestEntity = readTestEntityById(3L);
        if(readTestEntity!=null){
            Logger.getLogger(CommandLineRunnerImpl.class.getSimpleName()).info("read "+readTestEntity.toString());
        }else{
            throw new NullPointerException();
        }

        TestEntity updateTestEntity = updateTestEntityById(2L);
        if(updateTestEntity!=null){
            Logger.getLogger(CommandLineRunnerImpl.class.getSimpleName()).info("update "+readTestEntity.toString());
        }else{
            throw new NullPointerException();
        }*/

        //deleteTestEntityById(1L);
        //Logger.getLogger(CommandLineRunnerImpl.class.getSimpleName()).info(bookRepository.findBooksByAuthor_FirstName("Kali").toString());
        //Logger.getLogger(CommandLineRunnerImpl.class.getSimpleName()).info(bookRepository.customFindAllBooks().toString());
    }
/*
    private void deleteTestEntityById(Long id) {
        TestEntity testEntity = testEntityCrudRepository.findById(id).get();
        testEntityCrudRepository.delete(testEntity);
    }

    private TestEntity updateTestEntityById(Long id) {
        TestEntity testEntity = testEntityCrudRepository.findById(id).get();
        testEntity.setData("NEW DATA BLYA");
        testEntityCrudRepository.save(testEntity);
        return testEntity;
    }

    private TestEntity readTestEntityById(Long id) {
        return testEntityCrudRepository.findById(id).get();
    }

    private void createTestEntity(TestEntity entity) {
        entity.setData(entity.getClass().getSimpleName() + "хуй" +entity.hashCode());
        testEntityCrudRepository.save(entity);
    }*/
}
