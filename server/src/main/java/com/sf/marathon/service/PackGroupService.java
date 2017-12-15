package com.sf.marathon.service;

import com.sf.marathon.Dto.CustomerDto;
import com.sf.marathon.dao.CustomerDao;
import com.sf.marathon.dao.PackGroupDao;
import com.sf.marathon.dao.ProMarketBaseDao;
import com.sf.marathon.domain.Customer;
import com.sf.marathon.domain.PackGroup;
import com.sf.marathon.domain.ProMarketBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.UUID;

@Transactional
@Service
public class PackGroupService implements IPackGroupService {
    @Autowired
    private PackGroupDao packGroupDao;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private ProMarketBaseDao proMarketBaseDao;


//    @Override
//    public void savePackGroup(Customer customer, PackGroup packGroup) {
//        ProMarketBase one = proMarketBaseDao.getOne("1");
//
//        customerDao.save(customer);
//        packGroupDao.save(packGroup);
//    }

    @Override
    public void savePackGroup(CustomerDto customerDto) {
        PackGroup packGroup = packGroupDao.findUnfinishPackageGroupById(customerDto.getPackId());
        ProMarketBase proMarketBase = packGroup.getProMarketBase();
        int groupLimit = proMarketBase.getGroupLimit();
        Integer groupNum = packGroup.getGroupNum();
        if (groupNum < groupLimit) {//over limit
            int currentGroup = packGroup.getGroupNum() + 1;
            if (currentGroup == groupLimit) {
                packGroup.setFinish((byte) 1);//完成
            }
            packGroup.setGroupNum(currentGroup);
            packGroupDao.save(packGroup);
            Customer customer = genCustomer(customerDto);
            customerDao.save(customer);
        } else {
            packGroup = new PackGroup();
            packGroup.setGroupNum(1);
            packGroup.setCreateTime(new Date());
            ProMarketBase one = proMarketBaseDao.getOne(customerDto.getProId());
            Customer customer = genCustomer(customerDto);
            customerDao.save(customer);
        }

    }

    private Customer genCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setGroupTime(customerDto.getGroupTime());
        customer.setAddress(customerDto.getAddress());
        customer.setRegion(customerDto.getRegion());
        customer.setUserName(customerDto.getUserName());
        customer.setId(UUID.randomUUID().toString());
        return customer;
    }
}
