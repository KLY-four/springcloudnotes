package com.springcloud.dao;

import com.common.api.entities.PaymentEntity;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface PayMentDao {

    Integer insert(PaymentEntity paymentEntity);

    List<PaymentEntity> select(Integer id);
}
