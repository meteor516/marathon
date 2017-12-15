package com.sf.marathon.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sf.marathon.dao.PackGroupDao;
import com.sf.marathon.domain.PackGroup;
import com.sf.marathon.domain.ProMarketBase;
import com.sf.marathon.service.GroupTaskBiz;

@Component
@Transactional
public class GroupTaskBizImpl implements GroupTaskBiz {

    @Autowired
    private PackGroupDao packGroupDao;

    @Override
    public void handleProMarketBase(ProMarketBase pm) {
        PackGroup pg = packGroupDao.findUnfinishGroup(pm.getId());
        if (pg == null) {
            createPackGroup(pm);
        } else {
            checkGroupIsFinish(pm, pg);
        }
    }

    @Override
    public void createPackGroup(ProMarketBase pm) {
        PackGroup pg = new PackGroup();
        pg.setId(UUID.randomUUID().toString());
        pg.setPid(pm.getId());
        pg.setBeginTime(new Date());

        Calendar c = Calendar.getInstance();
        c.add(Calendar.MINUTE, pm.getGroupDuration());
        pg.setEndTime(c.getTime());
        pg.setGroupNum(0);
        pg.setFinish((byte) 0);
        pg.setCreateTime(new Date());
        //pg.setVersion(0);

        packGroupDao.save(pg);
        //packGroupDao.flush();
    }

    private void checkGroupIsFinish(ProMarketBase pm, PackGroup pg) {
        long endTime = (pg.getEndTime() == null) ? 0 : pg.getEndTime().getTime();
        int groupNum = (pg.getGroupNum() == null) ? 0 : pg.getGroupNum();
        int groupLimit = (pm.getGroupLimit() == null) ? 0 : pm.getGroupLimit();

        if (System.currentTimeMillis() > endTime || groupNum >= groupLimit) {
            pg.setFinish((byte) 1);
            pg.setFinishTime(new Date());
            packGroupDao.save(pg);
            // packGroupDao.flush();

            createPackGroup(pm);
        }
    }

}
