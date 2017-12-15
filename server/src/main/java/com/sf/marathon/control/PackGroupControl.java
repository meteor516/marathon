package com.sf.marathon.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import com.sf.marathon.domain.ProMarketBase;
import com.sf.marathon.dto.Offer;
import com.sf.marathon.service.impl.GroupTaskBizImpl;

@Controller
public class PackGroupControl {
	@Autowired
	private GroupTaskBizImpl groupTaskBiz;

}
