package com.sf.marathon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sf.marathon.dao.AddressRepository;
import com.sf.marathon.domain.Address;

@Controller
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @RequestMapping("/showAddress")
    public @ResponseBody List<Address> showAddress() {
        return addressRepository.findAll();
    }

    @RequestMapping("/findAddress")
    public @ResponseBody Address findAddress(@RequestParam(name = "name") String name) {
        List<Address> list = addressRepository.findByName(name);
        return (list.isEmpty()) ? null : list.get(0);
    }

    @RequestMapping("/saveAddress")
    public @ResponseBody void saveAddress(@RequestParam(name = "name") String name, @RequestParam(name = "age") int age) {
        Address address = new Address();
        address.setName(name);
        address.setAge(age);
        address.setId(3);
        addressRepository.save(address);
    }
}
