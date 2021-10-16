package com.springcloud.service;

import com.common.api.entities.PaymentEntity;
import com.springcloud.dao.PayMentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private PayMentDao payMentDao;

    public int insert(PaymentEntity paymentEntity){
     return payMentDao.insert(paymentEntity);
    }

    public List<PaymentEntity> selectById(Integer id){
        return payMentDao.select(id);
    }

}
