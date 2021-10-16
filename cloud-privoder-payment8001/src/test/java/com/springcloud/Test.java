package com.springcloud;
import com.common.api.entities.PaymentEntity;
import com.springcloud.service.PaymentService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @Autowired
    private PaymentService paymentService;

    @org.junit.Test
    public void de(){
        PaymentEntity nihao = new PaymentEntity(null);
        System.out.println(nihao.getId());
        paymentService.insert(nihao);
        System.out.println(nihao.getId());
    }
}
