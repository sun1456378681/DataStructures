package com.paogu.template.jdbc.dao;

import com.paogu.template.RowMapper;
import com.paogu.template.entity.Member;
import com.paogu.template.jdbc.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

/**
 * 数据库操作类
 *
 * @author eric
 * @since 2020/11/20 16:27
 */
public class MemberDao extends JdbcTemplate {

    public MemberDao(DataSource dataSource) {
        super(dataSource);
    }

    public List<?> selectAll() {
        String sql = "select * from t_member";
        RowMapper rowMapper = (ResultSet rs, int rowNum) -> {
            Member member = new Member();
            member.setUserName(rs.getString("username"));
            member.setPassword(rs.getString("password"));
            member.setAge(rs.getInt("age"));
            member.setAddr(rs.getString("addr"));
            return member;
        };
        return super.executeQuery(sql, rowMapper, null);
    }
}
