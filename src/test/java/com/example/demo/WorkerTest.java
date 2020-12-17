package com.example.demo;

import com.example.service.WorkerRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkerTest {
    @Autowired
    private WorkerRepository WorkerRepository;
    @Test
    public void Test() throws Exception{
        // 创建10条记录
        WorkerRepository.save(new Worker("AAA", 10));
        WorkerRepository.save(new Worker("BBB", 20));
        WorkerRepository.save(new Worker("CCC", 30));
        WorkerRepository.save(new Worker("DDD", 40));
        WorkerRepository.save(new Worker("EEE", 50));
        WorkerRepository.save(new Worker("FFF", 60));
        WorkerRepository.save(new Worker("GGG", 70));
        WorkerRepository.save(new Worker("HHH", 80));
        WorkerRepository.save(new Worker("III", 90));
        WorkerRepository.save(new Worker("JJJ", 100));

        // 测试findAll, 查询所有记录
        Assert.assertEquals(10, WorkerRepository.findAll().size());

        // 测试findByName, 查询姓名为FFF的Worker
        Assert.assertEquals(60, WorkerRepository.findByName("FFF").getAge().longValue());

        // 测试findWorker, 查询姓名为FFF的Worker
        Assert.assertEquals(60, WorkerRepository.findWorker("FFF").getAge().longValue());

        // 测试findByNameAndAge, 查询姓名为FFF并且年龄为60的Worker
        Assert.assertEquals("FFF", WorkerRepository.findByNameAndAge("FFF", 60).getName());

        // 测试删除姓名为AAA的Worker
        WorkerRepository.delete(WorkerRepository.findByName("AAA"));

        // 测试findAll, 查询所有记录, 验证上面的删除是否成功
        Assert.assertEquals(9, WorkerRepository.findAll().size());

    }

}
