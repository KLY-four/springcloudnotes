package com.springcloud.service.impl;

import com.springcloud.dao.AccountDao;
import com.springcloud.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@Service
public class AccountImpl implements AccountService {
    @Resource
    private AccountDao accountDao;

    /**
     * 扣减账户余额
     */
    @Override
    public void decrease(Long userId, BigDecimal money) {

        //try { TimeUnit.SECONDS.sleep(20); } catch (InterruptedException e) { e.printStackTrace(); }
        int a =2/0;
        accountDao.decrease(userId,money);
    }

}
