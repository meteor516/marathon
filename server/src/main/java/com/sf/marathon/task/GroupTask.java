package com.sf.marathon.task;

import com.sf.marathon.service.GroupTaskBiz;
import com.sf.marathon.service.impl.ProMarketBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GroupTask {

    @Autowired
    private ProMarketBaseService proMarketBaseService;
    @Autowired
    private GroupTaskBiz groupTaskBiz;


}
