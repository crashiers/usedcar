package com.cn.jhsoft.usedcar.common.inter;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;

/**
 * @author szh
 * @date 2016-3-9
 * @param <T>
 */
public interface TableCells<T> {

    /**
     * @note 该接口在ExcelUtil中被实现，主要功能： 根据 T(po类)指定字段 设置tableRow的数据,
     *       并可以做一定的业务处理，（更好的实现方式，在ExcelUtil中做成抽象方法）
     * @param tableRow
     * @param t
     */
    void selectedTableCells(HSSFRow tableRow, T t, HSSFCellStyle cellStyle);
}
