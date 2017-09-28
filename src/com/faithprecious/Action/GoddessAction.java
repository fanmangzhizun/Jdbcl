package com.faithprecious.Action;

import com.faithprecious.dao.GoddessDAO;
import com.faithprecious.model.Goddess;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by faithpercious on 2017/9/28.
 */
public class GoddessAction {
    public static void main(String[] args) throws SQLException {
        GoddessDAO gd = new GoddessDAO();
        Goddess g = new Goddess();
        g.setAge(20);
        g.setBirthday(new Date());
        g.setUser_name("凤灵雪");
        g.setMobile("15952365989");
        g.setCreate_user("ADMIN");
        g.setSex(0);
        g.setId(3);
        g.setEmail("FLXzxi@cold.com");
        g.setUpdate_user("ADMIN");
        gd.addGoddess(g);
    }
}
