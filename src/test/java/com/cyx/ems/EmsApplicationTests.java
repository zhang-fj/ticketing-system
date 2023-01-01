package com.cyx.ems;

import com.cyx.ems.common.mybaits.model.TabPage;
import com.cyx.ems.sys.entity.SysDict;
import com.cyx.ems.sys.mapper.SysDictMapper;
import com.cyx.ems.sys.service.SysDictService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class EmsApplicationTests {

    @Autowired
    private SysDictService service;

    @Test
    void contextLoads() {
    }

    @Test
    void insert(){
        SysDict entity = new SysDict();
        for(int i=0;i<10;i++){
            entity.setId(null);
            entity.setDictCode("TEST"+i);
            entity.setDictName("TEST"+i);
            entity.setDictType("S");
            entity.setDictDesc("TSET"+i);
            entity.setWhoForInsert("TEST_USER");
            service.saveOrUpdate(entity);
        }
    }

    @Test
    void select(){
        Map<String,Object> params=new HashMap<String,Object>();
        service.findAll(params);
    }

    @Test
    void page(){
        Map<String,Object> params=new HashMap<String,Object>();
        params.put("page",3);
        params.put("size",20);
        TabPage<SysDict> page = service.selectForPage(params);
    }



}
