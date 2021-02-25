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

    public Share getShare(int id) {
        return jdbcTemplate.query("SELECT * FROM Shares WHERE id=?", new Object[]{id}, new ShareMapper())
                .stream().findAny().orElse(null);
    }

    public void add(Share share) {
        jdbcTemplate.update("INSERT INTO Shares (date, company, price) values(?, ?, ?)",
                share.getDate(), share.getCompany(), share.getPrice());
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Shares WHERE id=?", id);
    }

    public void update(int id, Share share) {
        jdbcTemplate.update("UPDATE Shares SET date=?, company=?, price=? WHERE  id=?",
                share.getDate(), share.getCompany(), share.getPrice(), id);
    }
}
