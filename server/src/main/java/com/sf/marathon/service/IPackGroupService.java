package com.sf.marathon.service;

import com.sf.marathon.domain.Customer;
import com.sf.marathon.domain.PackGroup;

public interface IPackGroupService {
    public void savePackGroup(Customer customer, PackGroup packGroup);
}
