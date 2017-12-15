package com.sf.marathon.control;

import com.sf.marathon.dto.CustomerDto;
import com.sf.marathon.dto.Result;
import com.sf.marathon.service.IPackGroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.Boolean.TRUE;

@RestController
public class PackGroupControl {
    private static final Logger logger = LoggerFactory.getLogger(PackGroupControl.class);

    @Autowired
    private IPackGroupService packGroupService;

    @RequestMapping(value = "/savePackGroup")
    public Result<Void> savePackGroup(@RequestBody CustomerDto customerDto) {
        Result<Void> result = new Result<>();
        try {
            packGroupService.savePackGroup(customerDto);
            result.setIsSuccess(TRUE);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setIsSuccess(false);
            result.setErrorMsg(e.getMessage());
        }
        return result;
    }
}
