package com.faithprecious.Action;

import com.faithprecious.DAO.GoddessDAO;
import com.faithprecious.model.Goddess;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by faithpercious on 2017/9/28.
 * 控制层的实现
 */
public class GoddessAction {
    public GoddessAction() {}
        public void add (Goddess goddess) throws SQLException {
            GoddessDAO gd = new GoddessDAO();
            goddess.setSex(Integer.valueOf(0));
            goddess.setIsdel(Integer.valueOf(0));
            goddess.setCreate_user("ADMIN");
            goddess.setUpdate_user("ADMIN");
            gd.addGoddess(goddess);
        }
    public void edit(Goddess goddess) throws SQLException {
        GoddessDAO gd = new GoddessDAO();
        gd.updateGoddess(goddess);
    }

    public Goddess get(int id) throws SQLException {
        GoddessDAO gd=new GoddessDAO();
        return  gd.getGoddess(id);
    }
    public void del(int id) throws SQLException {
        GoddessDAO gd = new GoddessDAO();
        gd.deleteGoddess(id);
    }

    public List<Goddess> query() throws SQLException {
        GoddessDAO gd = new GoddessDAO();
        return gd.query();
    }

    public List<Goddess> query(List<Map<String, Object>> params) throws SQLException {
        GoddessDAO gd = new GoddessDAO();
        return gd.query(params);
    }

}
//        gd.deleteGoddess(4);
//        Goddess  h=gd.getGoddess(3);
//        System.out.println(h.toString());
//       gt=gd.query("Marry");


//        List<Goddess> result=gd.query(params);
//               for (Goddess G:result){
//            System.out.println(G);
//        }




