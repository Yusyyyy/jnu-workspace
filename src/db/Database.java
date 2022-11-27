package db;

import model.Usedata;

import java.sql.*;
import java.util.ArrayList;

public class Database {
    Connection conn = null;
    public Database() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");//注册驱动
        this.conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/homework","root","123456");
    }
    public void showConnect(){
        if (conn==null){
            System.out.println("数据库连接失败");
        }else{
            System.out.println("数据库连接成功");
        }
    }
    //关闭连接
    public void close() throws SQLException {
        conn.close();
    }
    //在表中添加数据
    public void insert(String name,String password) throws SQLException {
        PreparedStatement prep = conn.prepareStatement("insert into homework.login value (null,?,?)");
        prep.setString(1,name);
        prep.setString(2,password);
        prep.execute();

    }
    public ArrayList<Usedata> getAlluser() throws SQLException {
        ArrayList<Usedata> uselist = new ArrayList<Usedata>();
        PreparedStatement prep = conn.prepareStatement("select * from homework.login");
        prep.execute();
        ResultSet resultSet = prep.executeQuery();
        while (resultSet.next()){
            int myid = resultSet.getInt("id");
            String myname = resultSet.getString("name");
            String mypassword = resultSet.getString("password");
            uselist.add(new Usedata(myid,myname,mypassword));
        }
        return uselist;
    }
    //在表里查询数据
    public Usedata getUser(int id) throws SQLException {
        PreparedStatement prep = conn.prepareStatement("select * from homework.login where id=?");
        prep.setInt(1,id);
        prep.execute();
        ResultSet resultSet =prep.executeQuery();
        if (resultSet.next()){
            int myid = resultSet.getInt("id");
            String myname = resultSet.getString("name");
            String mypassword = resultSet.getString("password");
            return new Usedata(myid,myname,mypassword);
        }
        return null;
    }
    public Usedata login(int id,String password) throws SQLException {
        PreparedStatement prep = conn.prepareStatement("select homework.login.password from homework.login where id=?");
        prep.setInt(1,id);
        prep.execute();
        ResultSet resultSet = prep.executeQuery();
        if (resultSet.next()){
            String mypassword = resultSet.getString("password");
            if (password.equals(mypassword)){
                return getUser(id);
            }
            else
                return null;
        }
        else
            return null;
    }

}


