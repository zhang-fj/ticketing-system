package com.cyx.ems.sys.service.impl;

import com.cyx.ems.common.mybaits.mapper.BaseMapper;
import com.cyx.ems.common.mybaits.service.impl.BaseServiceImpl;
import com.cyx.ems.sys.entity.SysDict;
import com.cyx.ems.sys.mapper.SysDictMapper;
import com.cyx.ems.sys.service.SysDictService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SysDictServiceImpl extends BaseServiceImpl<SysDict> implements SysDictService {

    @Autowired
    private SysDictMapper sysDictMapper;

    @Override
    public BaseMapper<SysDict> getMapper() {
        return sysDictMapper;
    }
}
