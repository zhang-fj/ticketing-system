package com.cyx.ems.common.mybaits.page;

import com.cyx.ems.common.mybaits.model.TabPage;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PageUtils {


    public static <X> TabPage<X> selectForPage(Map<String, Object> params, SelectCallBack<X> callBack) throws Exception {
        TabPage<X> tabPage = new TabPage<X>();
        Integer page = (Integer) params.get("page");
        Integer size = (Integer) params.get("size");
        List<X> list = new ArrayList<X>();
        if (size != null) {
            PageHelper.startPage(page, size);
            PageInfo<X> da = new PageInfo<X>(callBack.query(params));
            list = da.getList();
            tabPage.setData(list);
            tabPage.setTotal(da.getTotal());
        } else {
            list = callBack.query(params);
            tabPage.setData(list);
            tabPage.setTotal(list.size());
        }
        return tabPage;
    }

    public interface SelectCallBack<X> {
        public List<X> query(Map<String, Object> params) throws Exception;
    }

}
