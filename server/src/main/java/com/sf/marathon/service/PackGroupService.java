package com.sf.marathon.service;

import com.sf.marathon.dao.CustomerDao;
import com.sf.marathon.dao.PackGroupDao;
import com.sf.marathon.domain.Customer;
import com.sf.marathon.domain.PackGroup;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

@Transactional
public class PackGroupService implements IPackGroupService {
    @Autowired
    private PackGroupDao packGroupDao;

    @Autowired
    private CustomerDao customerDao;

    @Override
    public void savePackGroup(Customer customer, PackGroup packGroup) {
        customerDao.save(customer);
        packGroupDao.save(packGroup);
    }
}
