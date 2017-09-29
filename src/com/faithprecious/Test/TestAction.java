package com.faithprecious.Test;

import com.faithprecious.Action.GoddessAction;
import com.faithprecious.DAO.GoddessDAO;
import com.faithprecious.model.Goddess;

import java.sql.SQLException;
import java.util.*;

/**
 * Created by faithpercious on 2017/9/29.
 * 测试类，检测
 */
public class TestAction {
    public static void main(String[] args) throws SQLException {
        GoddessAction goddessAction=new GoddessAction();
        GoddessDAO goddessDAO=new GoddessDAO();
        Goddess g=new Goddess();
//        dg.setUser_name("风灵");
//        dg.setAge(20);
//        dg.setBirthday(new Date());
//        dg.setMobile("15952365989");
//        dg.setEmail("fengling@cold.com");
//       goddessAction.add(dg);
//     goddessAction.del(6);
//        dg.setMobile("189123456");
//        dg.setId(5);
//        goddessAction.edit(dg);

//        g.setAge(20);
//        g.setUser_name("不知火舞");
//        g.setMobile("15952365988");
//        g.setCreate_user("ADMIN");
//        g.setSex(0);
//        g.setId(4);
//        g.setEmail("FLXzxi@cold.com");
//        g.setUpdate_user("ADMIN");
//        goddessAction.edit(g);

//       Goddess hk=goddessAction.get(3) ;
//        System.out.println(hk.toString());


                List<Map<String,Object>> params=new ArrayList<>();
        Map<String,Object> map=new HashMap<>();
        map.put("name","id");
        map.put("rele","=");
        map.put("value","2");
        params.add(map);
                List<Goddess> hk=goddessAction.query(params);
        for (Goddess d:hk
             ) {
            System.out.println(d);
        }
    }

}
