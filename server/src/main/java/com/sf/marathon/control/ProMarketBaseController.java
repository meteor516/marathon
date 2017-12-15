package com.sf.marathon.control;

import com.sf.marathon.dto.PackDto;
import com.sf.marathon.dto.Result;
import com.sf.marathon.service.IProMarketBaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ProMarketBaseController {
    private static final Logger logger = LoggerFactory.getLogger(ProMarketBaseController.class);
    @Autowired
    public IProMarketBaseService proMarketBaseService;

    @RequestMapping(value = "/list/{page}/{pageSize}", method = RequestMethod.GET)
    public Page<PackDto> list(@PathVariable("page") int page, @PathVariable("pageSize") int pageSize) {
        return null;
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public Result<PackDto> detail(@PathVariable("id") String id) {
        Result<PackDto> result = new Result<>();
        try {
            PackDto pack = proMarketBaseService.findPack(id);
            result.setResponse(pack);
            result.setSuccess(Boolean.TRUE);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setSuccess(false);
            result.setErrorMsg(e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/offer", method = RequestMethod.POST)
    public void offer(Long id) {
        // TODO
    }


}
