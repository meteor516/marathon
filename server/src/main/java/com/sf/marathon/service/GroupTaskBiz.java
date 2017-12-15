package com.sf.marathon.service;

import com.sf.marathon.domain.ProMarketBase;

public interface GroupTaskBiz {

    void handleProMarketBase(ProMarketBase pm);

    void createPackGroup(ProMarketBase pm);

}
