package com.sf.marathon.control;

import com.sf.marathon.domain.Address;
import com.sf.marathon.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AddressController {
    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "/showAddress", method = RequestMethod.GET)
    public @ResponseBody
    List<Address> showAddress() {
        return addressService.findAll();
    }

    @RequestMapping("/findAddress")
    public @ResponseBody
    Address findAddress(@RequestParam(name = "name") String name) {
        List<Address> list = addressService.findByName(name);
        return (list.isEmpty()) ? null : list.get(0);
    }

    @RequestMapping("/saveAddress")
    public @ResponseBody
    void saveAddress(@RequestParam(name = "name") String name, @RequestParam(name = "age") int age) {
        Address address = new Address();
        address.setName(name);
        address.setAge(age);
        address.setId(3);
        addressService.save(address);
    }

    @RequestMapping(value = "/findAddressByPage", method = RequestMethod.GET)
    public @ResponseBody
    Address findAddressByPage(@RequestParam(name = "name") String name,
                              @RequestParam(name = "page") int page, @RequestParam(name = "pageSize") int pageSize) {
        List<Address> list = addressService.findAddressByPage(name, page, pageSize);
        return (list.isEmpty()) ? null : list.get(0);
    }

}
