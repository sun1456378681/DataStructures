package com.paogu.template;

import java.sql.ResultSet;

/**
 * xx类
 *
 * @author eric
 * @since 2020/11/20 16:06
 */
public interface RowMapper<T> {

    /**
     * mapRow
     * @param rs
     * @param rowNum
     * @return
     * @throws Exception
     */
    T mapRow(ResultSet rs, int rowNum) throws Exception;
}
