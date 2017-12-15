package com.sf.marathon.service.impl;

import com.sf.marathon.dao.PackGroupDao;
import com.sf.marathon.dao.ProMarketBaseRepository;
import com.sf.marathon.domain.PackGroup;
import com.sf.marathon.domain.ProMarketBase;
import com.sf.marathon.dto.PackDto;
import com.sf.marathon.service.IProMarketBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProMarketBaseService implements IProMarketBaseService {
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
        pack.setMarketName(unfinishPackageGroupById.getProMarketBase().getMarketName());
        pack.setDailyMinPackages(unfinishPackageGroupById.getProMarketBase().getDailyMinPackages());
        pack.setMinWeight(unfinishPackageGroupById.getProMarketBase().getMinWeight());
        pack.setMaxWeight(unfinishPackageGroupById.getProMarketBase().getMaxWeight());
        pack.setGroupLimit(unfinishPackageGroupById.getProMarketBase().getGroupLimit());
        pack.setGroupDuration(unfinishPackageGroupById.getProMarketBase().getGroupDuration());
        pack.setUseRequire(unfinishPackageGroupById.getProMarketBase().getUseRequire());
        pack.setBasePrice(unfinishPackageGroupById.getProMarketBase().getBasePrice());
        pack.setBaseWeight(unfinishPackageGroupById.getProMarketBase().getBaseWeight());
        pack.setBeginTime(unfinishPackageGroupById.getBeginTime());
        pack.setEndTime(unfinishPackageGroupById.getFinishTime());
        pack.setCreateTime(new Date());
        return pack;
    }

    @Override
    public PackDto findPack() {
        PackGroup unfinishPackageGroupById = packGroupDao.findOneUnfinishGroup().get(0);
        return getPackDto(unfinishPackageGroupById);
    }


}
