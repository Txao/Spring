package com.java.app.DAO;

import com.java.app.models.Share;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ShareMapper implements RowMapper<Share> {
    @Override
    public Share mapRow(ResultSet resultSet, int i) throws SQLException {
        Share share = new Share();

        share.setId(resultSet.getInt("id"));
        share.setDate(resultSet.getString("date"));
        share.setCompany(resultSet.getString("company"));
        share.setPrice(resultSet.getInt("price"));

        return share;
    }
}
