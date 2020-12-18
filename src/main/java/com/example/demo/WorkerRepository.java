package com.example.demo;

import com.example.demo.Worker;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@CacheConfig(cacheNames = "workers")
public interface WorkerRepository extends JpaRepository<Worker,Long> {

    @Cacheable
    Worker findByName(String name);
    Worker findByNameAndAge(String name,Integer age);

    @Query("from Worker u where u.name=:name")
    Worker findWorker(@Param("name")String name);
}
