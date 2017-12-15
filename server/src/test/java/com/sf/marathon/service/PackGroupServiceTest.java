package com.sf.marathon.service;

import com.sf.marathon.dao.ProMarketBaseDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = Main.class)
public class PackGroupServiceTest {
    @Autowired
    private ProMarketBaseDao proMarketBaseDao;
    @Autowired
    private PackGroupService groupService;

    @Test
    public void savePackGroup() {
//        Customer customer = new Customer();
//        customer.setAddress("保税区");
//        customer.setGroupTime(new Date());
//
//        PackGroup packGroup = new PackGroup();
//
//        ProMarketBase one = proMarketBaseDao.findOne("1");
//
//        packGroup.setProMarketBase(one);
//        packGroup.setCreateTime(new Date());
//        packGroup.setFinish((byte)0);
//        packGroup.setGroupNum(0);
//        packGroup.setBeginTime(new DateTime().toDate());
//        packGroup.setEndTime(new DateTime().plusDays(5).toDate());
//        groupService.savePackGroup(customer,packGroup);
    }
}