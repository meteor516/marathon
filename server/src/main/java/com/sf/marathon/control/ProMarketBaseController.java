package com.sf.marathon.control;

import com.sf.marathon.dto.PackDto;
import com.sf.marathon.dto.Result;
import com.sf.marathon.service.IProMarketBaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.Boolean.TRUE;

@RestController
public class ProMarketBaseController {
    private static final Logger logger = LoggerFactory.getLogger(ProMarketBaseController.class);
    @Autowired
    private IProMarketBaseService proMarketBaseService;

    @RequestMapping(value = "/detail")
    public Result<PackDto> detail() {
        Result<PackDto> result = new Result<>();
        try {
            PackDto pack = proMarketBaseService.findPack();
            result.setResponse(pack);
            result.setIsSuccess(TRUE);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setIsSuccess(false);
            result.setErrorMsg(e.getMessage());
        }
        return result;
    }

}
