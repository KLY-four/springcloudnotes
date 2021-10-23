package com.springalibaba.service;

public interface StroageService {

    // 扣减库存
    void decrease(Long productId, Integer count);

}
