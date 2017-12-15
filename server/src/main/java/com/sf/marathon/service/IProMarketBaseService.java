package com.sf.marathon.service;

import com.sf.marathon.dto.PackDto;

public interface IProMarketBaseService {
    public PackDto findPack(String pid);

    public PackDto findPack();
}
