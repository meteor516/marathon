package com.sf.marathon.service;

import com.sf.marathon.dao.AddressRepository;
import com.sf.marathon.domain.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public List<Address> findByName(String name) {
        return addressRepository.findByName(name);
    }

    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Transactional
    public void save(Address address) {
        addressRepository.save(address);
    }

    public List<Address> findAddressByPage(String name, int pages, int pageSize) {
        Pageable pageAble = new PageRequest(pages, pageSize);

        Page<Address> byUserName = addressRepository.findByUserName(name, pageAble);

        return byUserName.getContent();
    }
}
