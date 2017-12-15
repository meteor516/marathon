package com.sf.marathon.control;
import com.sf.marathon.dto.CustomerDto;
import com.sf.marathon.service.IPackGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PackGroupControl {
    @Autowired
    private IPackGroupService packGroupService;

    @RequestMapping(value = "/savePackGroup", method = RequestMethod.GET)
    public String savePackGroup() {
//        @RequestBody CustomerDto customerDto
        CustomerDto customer = new CustomerDto();
        customer.setPackId("1");
        customer.setProId("1");
        customer.setAddress("山东");
        customer.setUserName("colin");

        packGroupService.savePackGroup(customer);
        return "success";
    }
}
