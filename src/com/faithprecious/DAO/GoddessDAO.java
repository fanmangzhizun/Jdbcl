package com.faithprecious.DAO;

import com.faithprecious.db.DBUtils;
import com.faithprecious.model.Goddess;
import org.omg.CORBA.Object;

import java.sql.*;
import java.sql.Date;
import java.util.*;

/**
 * Created by faithpercious on 2017/9/28.
 * 模型层中的底层方法
 */
public class GoddessDAO {

//增加操作
    public void addGoddess(Goddess g) throws SQLException {
            Connection connection=DBUtils.getConnection();
            String sql= "insert into girls.message ("+
                    "user_name,sex,age,birthday,email,mobile,"
        +"create_user,create_date,update_user,update_date,isdel)values("
        +"?,?,?,?,?,?,?,current_date,?,current_date,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,g.getUser_name());
            preparedStatement.setInt(2,g.getSex());
            preparedStatement.setInt(3,g.getAge());
            preparedStatement.setDate(4,new Date(g.getBirthday().getTime()));
            preparedStatement.setString(5,g.getEmail());
            preparedStatement.setString(6,g.getMobile());
            preparedStatement.setString(7,g.getCreate_user());
            preparedStatement.setString(8,g.getUpdate_user());
            preparedStatement.setInt(9,g.getIsdel());
            preparedStatement.execute();
            //踩了参数的坑，被初始化的值不再设置位置,直接设置参数即可
    }
    //删除操作
        public  void deleteGoddess(int id) throws SQLException {
            Connection connection=DBUtils.getConnection();
            String sql=""+"delete from girls.message where id=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
    }
        //修改操作
        public  void updateGoddess(Goddess g) throws SQLException {
         Connection connection = DBUtils.getConnection();
            String sql = "UPDATE girls.message set user_name=?,sex=?,age=?,birthday=?,email=?,mobile=?," +
                    " update_user=?,update_date=CURRENT_DATE ,isdel=? where id=?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, g.getUser_name());
            preparedStatement.setInt(2, g.getSex());
            preparedStatement.setInt(3, g.getAge());
            preparedStatement.setDate(4, new Date(g.getBirthday().getTime()));
            preparedStatement.setString(5, g.getEmail());
            preparedStatement.setString(6, g.getMobile());
            preparedStatement.setString(7, g.getUpdate_user());
            preparedStatement.setInt(8, g.getIsdel());
            preparedStatement.setInt(9,g.getId());
            preparedStatement.execute();
        }
    //查询操作

    public Goddess getGoddess(int id) throws SQLException {
        Goddess g=null;
        Connection connection=DBUtils.getConnection();
        String sql="SELECT * FROM Girls.message WHERE id=?";
        PreparedStatement preparedStatement =connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){
            g=new Goddess();
            g.setAge(resultSet.getInt("age"));
            g.setEmail(resultSet.getString("email"));
            g.setId(id);
            g.setSex(resultSet.getInt("sex"));
            g.setCreate_user(resultSet.getString("create_user"));
            g.setMobile(resultSet.getString("mobile"));
            g.setUser_name(resultSet.getString("user_name"));
            g.setBirthday(resultSet.getDate("birthday"));
            g.setCreate_date(resultSet.getDate("create_date"));
            g.setUpdate_date(resultSet.getDate("update_date"));
            g.setIsdel(resultSet.getInt("isdel"));
        }
        return  g;
    }


        //获取对象信息
        public List<Goddess> query() throws SQLException {
            Connection connection=DBUtils.getConnection();
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT user_name,age FROM message");
            List<Goddess> g=new ArrayList<>();
            Goddess gs=null;
                while (resultSet.next()) {
                    gs=new Goddess();
                    gs.setUser_name(resultSet.getNString("user_name"));
                    gs.setAge(resultSet.getInt("age"));
                    g.add(gs);
                }
            return g;
     }

     public  List<Goddess> query(String name) throws SQLException {
        List<Goddess> result=new ArrayList<>();//创建一个放置结果的队列
        Connection connection=DBUtils.getConnection();
        StringBuffer sb=new StringBuffer();
        sb.append("select * from girls.message");
         sb.append(" where user_name =?");
        PreparedStatement pst=connection.prepareStatement(sb.toString());
        pst.setString(1,name);
         Goddess g=null;
         ResultSet resultSet =pst.executeQuery();
         while (resultSet.next()){
             g=new Goddess();
             g.setAge(resultSet.getInt("age"));
             g.setEmail(resultSet.getString("email"));
             g.setId(resultSet.getInt("id"));
             g.setSex(resultSet.getInt("sex"));
             g.setCreate_user(resultSet.getString("create_user"));
             g.setMobile(resultSet.getString("mobile"));
             g.setUser_name(resultSet.getString("user_name"));
             g.setBirthday(resultSet.getDate("birthday"));
             g.setCreate_date(resultSet.getDate("create_date"));
             g.setUpdate_date(resultSet.getDate("update_date"));
             g.setIsdel(resultSet.getInt("isdel"));
             result.add(g);
         }
         return result;
    }
    public  List<Goddess> query(List<Map<String, java.lang.Object>> params) throws SQLException {
        List<Goddess> result=new ArrayList<>();
        Connection con=DBUtils.getConnection();
        StringBuffer sb=new StringBuffer();
        sb.append("select * from girls.message where 1=1 ");
        for (int i=0;i<params.size();i++){
            if (params.size()>0&&params!=null){
                Map<String, java.lang.Object> map=params.get(i);
                sb.append("and"+" "+map.get("name")+""+map.get("rele")+""+map.get("value")+"");
            }
        }
        PreparedStatement pst=con.prepareStatement(sb.toString());
        System.out.println(sb.toString());
        ResultSet rs=pst.executeQuery();
        Goddess g=null;
        while (rs.next()){
            g=new Goddess();
            g.setAge(rs.getInt("age"));
            g.setEmail(rs.getString("email"));
            g.setId(rs.getInt("id"));
            g.setSex(rs.getInt("sex"));
            g.setCreate_user(rs.getString("create_user"));
            g.setMobile(rs.getString("mobile"));
            g.setUser_name(rs.getString("user_name"));
            g.setBirthday(rs.getDate("birthday"));
            g.setCreate_date(rs.getDate("create_date"));
            g.setUpdate_date(rs.getDate("update_date"));
            g.setIsdel(rs.getInt("isdel"));
            result.add(g);
        }
        return result;
    }
}
