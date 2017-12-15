package com.sf.marathon.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sf.marathon.domain.ProMarketBase;
import com.sf.marathon.service.GroupTaskBiz;
import com.sf.marathon.service.ProMarketBaseService;

@Component
public class GroupTask {

    @Autowired
    private ProMarketBaseService proMarketBaseService;
    @Autowired
    private GroupTaskBiz groupTaskBiz;

    @Scheduled(fixedRate = 6000)
    public void executeGroupTask() {
        List<ProMarketBase> list = proMarketBaseService.findAll();
        list.forEach(pm -> groupTaskBiz.handleProMarketBase(pm));
    }
}
