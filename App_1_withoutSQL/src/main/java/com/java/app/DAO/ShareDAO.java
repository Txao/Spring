package com.java.app.DAO;

import com.java.app.models.Share;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ShareDAO {
    private int id;
    private Map<Integer, Share> shares;

    {
        shares = new HashMap<>();

        add(new Share("01.01.2019", "Gazprom", 2000));
        add(new Share("01.01.2019", "AvtoVAZ", 2500));
        add(new Share("05.01.2019", "Tinkoff", 10000));
    }

    public Map<Integer, Share> showAll() {
        return shares;
    }

    public Share getShare(int id) {
        return shares.get(id);
    }

    public void add(Share share) {
        shares.put(++id, share);
    }

    public void delete(int id) {
        shares.remove(id);
    }

    public void update(int id, Share share) {
        shares.put(id, share);
    }
}