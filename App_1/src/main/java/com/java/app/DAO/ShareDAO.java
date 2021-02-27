package com.java.app.DAO;

import com.java.app.models.Share;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShareDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ShareDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Share> showAll() {
        return jdbcTemplate.query("SELECT * FROM Shares", new ShareMapper());
    }

    public Share getShare(String company) {
        return jdbcTemplate.query("SELECT * FROM Shares WHERE company=?", new Object[]{company}, new ShareMapper())
                .stream().findAny().orElse(null);
    }

    public void add(Share share) {
        jdbcTemplate.update("INSERT INTO Shares values(?, ?, ?)",
                share.getDate(), share.getCompany(), share.getPrice());
    }

    public void delete(String company) {
        jdbcTemplate.update("DELETE FROM Shares WHERE company=?", company);
    }

    public void update(String company, Share share) {
        jdbcTemplate.update("UPDATE Shares SET date=?, company=?, price=? WHERE  company=?",
                share.getDate(), share.getCompany(), share.getPrice(), company);
    }
}
