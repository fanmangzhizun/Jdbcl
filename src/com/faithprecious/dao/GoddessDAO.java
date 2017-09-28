package com.faithprecious.dao;

import com.faithprecious.db.DBUtils;
import com.faithprecious.model.Goddess;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by faithpercious on 2017/9/28.
 */
public class GoddessDAO {

//增加操作
    public void addGoddess(Goddess g) throws SQLException {
            Connection connection=DBUtils.getConnection();
            String sql= "insert into girls.message ("+
                    "id,user_name,sex,age,birthday,email,mobile,"
        +"create_user,create_date,update_user,update_date,isdel)values("
        +"?,?,?,?,?,?,?,?,current_date,?,current_date,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,g.getId());
            preparedStatement.setString(2,g.getUser_name());
            preparedStatement.setInt(3,g.getSex());
            preparedStatement.setInt(4,g.getAge());
            preparedStatement.setDate(5,new Date(g.getBirthday().getTime()));
            preparedStatement.setString(6,g.getEmail());
            preparedStatement.setString(7,g.getMobile());
            preparedStatement.setString(8,g.getCreate_user());
            preparedStatement.setString(9,g.getUpdate_user());
            preparedStatement.setInt(10,g.getIsdel());
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
            String sql = "UPDATE   girls.message (" +
                    "set id=?,user_name=?,sex=?,age=?,birthday=?,email=?,mobile=?,"
                    + "create_user=?,create_date=CURRENT_DATE ,update_user=?,update_date=CURRENT_DATE ,isdel=?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, g.getId());
            preparedStatement.setString(2, g.getUser_name());
            preparedStatement.setInt(3, g.getSex());
            preparedStatement.setInt(4, g.getAge());
            preparedStatement.setDate(5, new Date(g.getBirthday().getTime()));
            preparedStatement.setString(6, g.getEmail());
            preparedStatement.setString(7, g.getMobile());
            preparedStatement.setString(8, g.getCreate_user());
            preparedStatement.setString(9, g.getUpdate_user());
            preparedStatement.setInt(10, g.getIsdel());
            preparedStatement.execute();
        }

        //查询操作
        public List<Goddess> query() throws SQLException {
            Connection connection=DBUtils.getConnection();
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT user_name,age,birthday FROM message");
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
     public Goddess getGoddess(){
         return null;
     }
}
