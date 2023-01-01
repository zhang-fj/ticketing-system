package com.cyx.ems.sys.rest;

import com.cyx.ems.common.mybaits.model.SaveModel;
import com.cyx.ems.common.mybaits.model.TabPage;
import com.cyx.ems.sys.entity.SysDict;
import com.cyx.ems.sys.service.SysDictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Api(tags="1、字典管理")
@RestController
@RequiredArgsConstructor
@RequestMapping("/sys/SysDict")
public class SysDictController {

	private final SysDictService service;

    @ApiOperation(value = "1、查询")
    @ApiImplicitParams({})
	@PostMapping(value="page")
	public ResponseEntity<TabPage<SysDict>> page(@RequestBody Map<String, Object> param){
		return new ResponseEntity(service.selectForPage(param), HttpStatus.OK);
	}

    @ApiImplicitParams({})
    @PostMapping(value="test")
    public ResponseEntity<TabPage<SysDict>> test(@RequestBody Map<String, Object> param){
        return new ResponseEntity(null, HttpStatus.OK);
    }

    @ApiOperation(value = "2、保存")
    @PostMapping(value="save")
    public ResponseEntity<SysDict> save(@RequestBody SysDict entity){
        return new ResponseEntity(service.saveOrUpdate(entity), HttpStatus.OK);
    }

    @ApiOperation(value = "3、批量保存")
    @PostMapping(value="batchSave")
    public ResponseEntity<SaveModel<SysDict>> batchSave(@RequestBody SaveModel<SysDict> entity){
        return new ResponseEntity(service.batchSaveOrUpdate(entity), HttpStatus.OK);
    }

    @ApiOperation(value = "4、删除")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "ids", value = "id数组", required = true),
    })
	@DeleteMapping(value="del")
	public ResponseEntity<Object> del(@RequestBody List<String> ids){
		service.deleteByIds(ids);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

    @ApiOperation(value = "5、加载")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "数据主键", required = true),
    })
    @GetMapping(value="load")
    public ResponseEntity<SysDict> load(String id){
    	return new ResponseEntity(service.selectByPK(id), HttpStatus.OK);
    }

}
