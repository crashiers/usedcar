package com.cn.jhsoft.usedcar.common.utils;

import com.cn.jhsoft.usedcar.common.xss.SQLFilter;
import org.apache.commons.lang.StringUtils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 查询参数
 *
 * @author jhsoft
 * @email hn1987@126.com
 * @date 2017-03-14 23:15
 */
public class Query extends LinkedHashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	//当前页码
    private int page = 1;
    //每页条数
    private int limit = 10;
    // 显示 开始的 页码
    private int startPage;
    // 显示 到的 页码
    private int endPage;
    // 总页码
    private int totalPage;
    //循环页码显示的数量，如 1,2,3,4 ... 用.号来代替的
    public static final int SHOWPAGESUM = 10;
    // 总记录数
    private int total;

    public Query(Map<String, Object> params){
        this.putAll(params);

        //分页参数
        this.page = 1;
        if (params.get("page") != null) {
            this.page = Integer.parseInt(params.get("page").toString());
        }
        this.limit = 10;
        if (params.get("limit") != null) {
            this.limit = Integer.parseInt(params.get("limit").toString());
        }
        this.put("offset", (page - 1) * limit);
        this.put("page", page);
        this.put("limit", limit);

        //防止SQL注入（因为sidx、order是通过拼接SQL实现排序的，会有SQL注入风险）
        String sidx = (String)params.get("sidx");
        String order = (String)params.get("order");
        if(StringUtils.isNotBlank(sidx)){
            this.put("sidx", SQLFilter.sqlInject(sidx));
        }
        if(StringUtils.isNotBlank(order)){
            this.put("order", SQLFilter.sqlInject(order));
        }

    }


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getTotalPage() {
        // 分页用，主要是为了适应模板中的 #numbers.sequence(1, totalPages)
        return totalPage == 0 ? 1 : totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getStartPage() {
        return page > SHOWPAGESUM/2 ? page - SHOWPAGESUM/2 : 1;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return getTotalPage() - page > SHOWPAGESUM/2 ? page + SHOWPAGESUM/2 : getTotalPage();
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
        this.put("total", total);
        setTotalPage((int)Math.ceil((float)total/limit));
    }
}
