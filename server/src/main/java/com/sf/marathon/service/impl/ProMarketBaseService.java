package com.sf.marathon.service.impl;

import com.sf.marathon.dao.PackGroupDao;
import com.sf.marathon.dao.ProMarketBaseRepository;
import com.sf.marathon.domain.PackGroup;
import com.sf.marathon.domain.ProMarketBase;
import com.sf.marathon.dto.PackDto;
import com.sf.marathon.service.IProMarketBaseService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProMarketBaseService implements IProMarketBaseService {
    private static final String DATE_FORMATE = "MM月dd日";
    @Autowired
    private ProMarketBaseRepository proMarketBaseRepository;

    @Autowired
    private PackGroupDao packGroupDao;

    public List<ProMarketBase> findAll() {
        return proMarketBaseRepository.findAll();
    }

    public ProMarketBase getOne(String id) {
        return proMarketBaseRepository.getOne(id);
    }

    public Page<ProMarketBase> findAll(int page, int pageSize) {
        Pageable pageable = new PageRequest(page, pageSize);
        return proMarketBaseRepository.findAll(pageable);
    }

    public PackDto findPack(String pid) {
        PackGroup unfinishPackageGroupById = packGroupDao.findUnfinishGroup(pid).get(0);

        return getPackDto(unfinishPackageGroupById);
    }

    private PackDto getPackDto(PackGroup unfinishPackageGroupById) {
        PackDto pack = new PackDto();
        ProMarketBase proMarketBase = unfinishPackageGroupById.getProMarketBase();
        pack.setPackId(proMarketBase.getId());
        pack.setProId(unfinishPackageGroupById.getId());
        pack.setMarketName(proMarketBase.getMarketName());
        pack.setDailyMinPackages(proMarketBase.getDailyMinPackages());
        pack.setMinWeight(proMarketBase.getMinWeight());
        pack.setMaxWeight(proMarketBase.getMaxWeight());
        pack.setGroupLimit(proMarketBase.getGroupLimit());
        pack.setGroupDuration(proMarketBase.getGroupDuration());
        pack.setUseRequire(proMarketBase.getUseRequire());
        pack.setBasePrice(proMarketBase.getBasePrice());
        pack.setBaseWeight(proMarketBase.getBaseWeight());

        pack.setBeginTime(new DateTime(unfinishPackageGroupById.getBeginTime()).toString(DATE_FORMATE));
        pack.setEndTime(new DateTime(unfinishPackageGroupById.getEndTime()).toString(DATE_FORMATE));
        return pack;
    }

    @Override
    public PackDto findPack() {
        PackGroup unfinishPackageGroupById = packGroupDao.findOneUnfinishGroup().get(0);
        return getPackDto(unfinishPackageGroupById);
    }


}
