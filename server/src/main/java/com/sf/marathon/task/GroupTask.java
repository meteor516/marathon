package com.sf.marathon.task;

import com.sf.marathon.dao.PackGroupDao;
import com.sf.marathon.domain.ProMarketBase;
import com.sf.marathon.service.ProMarketBaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GroupTask {

    @Autowired
    private ProMarketBaseService proMarketBaseService;
    @Autowired
    private PackGroupDao packGroupDao;

//    @Scheduled(fixedRate = 6000)
//    public void executeGroupTask() {
//        List<ProMarketBase> list = proMarketBaseService.findAll();
//        list.forEach(pm -> handleProMarketBase(pm));
//    }

    private void handleProMarketBase(ProMarketBase pm) {

    }
}
