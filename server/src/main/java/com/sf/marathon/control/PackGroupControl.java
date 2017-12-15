package com.sf.marathon.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sf.marathon.dto.CustomerDto;
import com.sf.marathon.dto.Result;
import com.sf.marathon.service.IPackGroupService;

@Controller
public class PackGroupControl {

	private static final Logger logger = LoggerFactory.getLogger(ProMarketBaseController.class);
	@Autowired
	private IPackGroupService packGroupService;

	@RequestMapping(value = "/savePackGroup", method = RequestMethod.POST)
	public Result<String> savePackGroup(CustomerDto dto) {
		// CustomerDto customer = new CustomerDto();
		// customer.setPackId("1");
		// customer.setProId("1");
		// customer.setAddress("山东");
		// customer.setUserName("colin");
		Result<String> result = new Result<>();
		try {
			packGroupService.savePackGroup(dto);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setIsSuccess(false);
			result.setErrorMsg(e.getMessage());
		}
		return result;
	}
}
