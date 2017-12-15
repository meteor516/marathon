package com.sf.marathon.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sf.marathon.dao.PackGroupDao;
import com.sf.marathon.dao.ProMarketBaseDao;
import com.sf.marathon.domain.ProMarketBase;

@Component
public class GroupTask {

    @Autowired
    private ProMarketBaseDao proMarketBaseDao;
    @Autowired
    private PackGroupDao packGroupDao;

    @Scheduled(fixedRate = 6000)
    public void executeGroupTask() {
        List<ProMarketBase> list = proMarketBaseDao.findAll();
        list.forEach(pm -> handleProMarketBase(pm));
    }

    private void handleProMarketBase(ProMarketBase pm) {

    }
}
