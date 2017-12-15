package com.sf.marathon.control;

import com.sf.marathon.dto.PackDto;
import com.sf.marathon.dto.Result;
import com.sf.marathon.service.IProMarketBaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ProMarketBaseController {
    private static final Logger logger = LoggerFactory.getLogger(ProMarketBaseController.class);
    @Autowired
    public IProMarketBaseService proMarketBaseService;

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public Result<PackDto> detail() {
        Result<PackDto> result = new Result<>();
        try {
            PackDto pack = proMarketBaseService.findPack();
            result.setIsSuccess(Boolean.TRUE);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setIsSuccess(false);
            result.setErrorMsg(e.getMessage());
        }
        return result;
    }

}
