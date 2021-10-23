package com.springalibaba.service.impl;

import com.springalibaba.dao.StorageDao;
import com.springalibaba.service.StroageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StroageImpl implements StroageService {
    @Autowired
    private StorageDao storageDao;
    @Override
    public void decrease(Long productId, Integer count) {
        storageDao.decrease(productId,count);
    }
}
