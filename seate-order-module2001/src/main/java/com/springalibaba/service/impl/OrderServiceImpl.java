package com.springalibaba.service.impl;

import com.springalibaba.dao.OrderDao;
import com.springalibaba.domain.Order;
import com.springalibaba.service.AccountService;
import com.springalibaba.service.OrderService;
import com.springalibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private StorageService storageService;

    @Autowired
    private AccountService accountService;

    @Override
    @GlobalTransactional(rollbackFor = Exception.class) //该注解可以检测到其他服务产生的异常
    //@Transactional(rollbackFor = Exception.class)  //该注解只能感知本服务所抛出的异常，对其它服务不可知。
    /**
     * 如果是远程调用超时，@Transactional照样回滚，因为超时异常并不由远程服务抛出
     * 但如果远程服务自己有异常，那么该注解就不能感知了。
     * */
    public int create(Order order) {
        System.out.println("订单插入开始--------------");
        Integer integer = orderDao.create(order);
        if(integer==1){
            System.out.println("订单插入成功");
        }
        System.out.println("库存减少开始");
       storageService.de(order.getProductId(),order.getCount());
        System.out.println("库存减少完毕");

        System.out.println("账户余额扣减开始");
        /**
         * 这里如果远程服务抛出了异常，该服务在获取返回后一样会当作异常处理，所以会将异常直接响应
         * 虽然该异常并不由本服务抛出
         * */
        accountService.Moneyde(order.getUserId(),order.getMoney());
        System.out.println("账户余额扣减介绍");

        System.out.println("更新订单状态开始");
        orderDao.update(order.getUserId(),order.getStatus());
        System.out.println("更新订单状态结束");
      return 1;

    }

    @Override
    public int update(Long userId,Integer status) {
        return orderDao.update(userId,status);
    }
}
