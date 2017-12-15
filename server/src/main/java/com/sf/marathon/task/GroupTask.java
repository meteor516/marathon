package com.sf.marathon.task;

import com.sf.marathon.domain.ProMarketBase;
import com.sf.marathon.service.GroupTaskBiz;
import com.sf.marathon.service.impl.ProMarketBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class GroupTask {

    @Autowired
    private ProMarketBaseService proMarketBaseService;
    @Autowired
    private GroupTaskBiz groupTaskBiz;

    @Scheduled(fixedRate = 6000)
    public void executeGroupTask() {
        int page = 0;
        int pageSize = 1000;

        int resultSize = 0;
        do {
            Page<ProMarketBase> result = proMarketBaseService.findAll(page++, pageSize);
            resultSize = result.getContent().size();
            if (resultSize > 0) {
                result.getContent().forEach(pm -> groupTaskBiz.handleProMarketBase(pm));
            }
        } while (resultSize >= pageSize);
    }
}
