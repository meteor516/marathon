package com.sf.marathon.service;

import com.sf.marathon.Main;
import com.sf.marathon.dao.ProMarketBaseRepository;
import com.sf.marathon.domain.Customer;
import com.sf.marathon.domain.PackGroup;
import com.sf.marathon.domain.ProMarketBase;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Main.class)
public class PackGroupServiceTest {
    @Autowired
    private ProMarketBaseRepository proMarketBaseDao;
    @Autowired
    private PackGroupService groupService;

    @Test
    public void savePackGroup() {
        Customer customer = new Customer();
        customer.setAddress("保税区");
        customer.setGroupTime(new Date());

        PackGroup packGroup = new PackGroup();

        ProMarketBase one = proMarketBaseDao.getOne("1");

//        packGroup.setProMarketBase(one);
        packGroup.setCreateTime(new Date());
        packGroup.setFinish((byte) 0);
        packGroup.setGroupNum(0);
        packGroup.setBeginTime(new DateTime().toDate());
        packGroup.setEndTime(new DateTime().plusDays(5).toDate());
//        groupService.savePackGroup(customer,packGroup);//tm_pro_market_base
    }
}