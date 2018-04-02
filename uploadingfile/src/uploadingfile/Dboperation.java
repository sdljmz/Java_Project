/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uploadingfile;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import static java.lang.Character.UnicodeBlock.forName;
import java.sql.Blob;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.util.jar.Pack200.Packer.PASS;
import static javafx.css.StyleOrigin.USER;
import static uploadingfile.Dboperation.DB_URL;

/**
 * @author LJMZ
 * 此类用于和数据库交互，主要功能有检查更新用户，上传文件，下载文件
 */
public class Dboperation {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/UpLoadingFile";
    static final String User = "root";
     byte[] file_neirong ;
    Connection conn = null;
    Statement stmt = null;
    public Dboperation(){
    
    }
    
    public byte [] getneirong(){
        return this.file_neirong;
    }
   
    public int db_Open(String sqll,String sqlll){       //验证用户是否能够登录
         try{
             Class.forName("com.mysql.jdbc.Driver");
             this.conn = (Connection) DriverManager.getConnection(DB_URL,User,"");
             stmt = (Statement) conn.createStatement();
             String sql="select * from Users where user = '" + sqll + "'and password = '" + sqlll + "';";
             ResultSet rs = stmt.executeQuery(sql);
             if(rs.next()){
                 rs.close();
                conn.close();
                 return 1;
             }else {
                 rs.close();
                 conn.close();
                 return 2;
             }
        }catch(SQLException se){
             se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
              try{
                if(conn!=null) 
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
         }
         return 3;
    }
   
     public int db_DownLoad(String file_name,String file_author){       //下载文件
         try{
             Class.forName("com.mysql.jdbc.Driver");
             this.conn = (Connection) DriverManager.getConnection(DB_URL,User,"");
             stmt = (Statement) conn.createStatement();
             String sql="select * from file where name = '" + file_name + "'and  author= '" + file_author + "';";
             ResultSet rs = stmt.executeQuery(sql);
             if(rs.next()){
                this.file_neirong = rs.getBytes("neirong");
                 //System.out.println(this.file_neirong);
                rs.close();
                conn.close();
                 return 1;
             }else {
                 rs.close();
                 conn.close();
                 return 2;
             }
        }catch(SQLException se){
             se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
              try{
                if(conn!=null) 
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
         }
         return 3;
    }
    public int db_Up(String file_name,byte [] file_neirong,String file_author){         //上传文件
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = (Connection) DriverManager.getConnection(DB_URL,User,"");
            stmt = (Statement) conn.createStatement();
            String sql = "insert into file(name,neirong,author) value (?,?,?)";
            PreparedStatement ptmt = conn.prepareStatement(sql);
            ptmt.setString(1, file_name);
            ptmt.setBytes(2,file_neirong);
            ptmt.setString(3,file_author);
            ptmt.executeUpdate();
            ptmt.close();
            conn.close();
            return 1;
        }catch(SQLException se){
             se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
              try{
                if(conn!=null) 
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
         }
         return 3;
    }
    public int db_Regist(String user_name,String user_password){        //新增用户
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = (Connection) DriverManager.getConnection(DB_URL,User,"");
            stmt = (Statement) conn.createStatement();
            String sql = "insert into users(user,password) value (?,?)";
            PreparedStatement ptmt = conn.prepareStatement(sql);
            ptmt.setString(1, user_name);
            ptmt.setString(2, user_password);

            ptmt.executeUpdate();
            ptmt.close();
            conn.close();
            return 1;
        }catch(SQLException se){
             se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
              try{
                if(conn!=null) 
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
         }
         return 3;
    }
    
    public int db_Proving(String user_name){        //验证想要增加的用户是否已经存在
         try{
             Class.forName("com.mysql.jdbc.Driver");
             this.conn = (Connection) DriverManager.getConnection(DB_URL,User,"");
             stmt = (Statement) conn.createStatement();
             String sql="select * from users where user = '" + user_name + "';";
             ResultSet rs = stmt.executeQuery(sql);
             if(rs.next()){
                rs.close();
                conn.close();
                 return 1;
             }else {
                 rs.close();
                 conn.close();
                 return 2;
             }
        }catch(SQLException se){
             se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
              try{
                if(conn!=null) 
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
         }
         return 3;
    }
    
    public int db_chachong(String file_name,String file_author){       //查重文件
         try{
             Class.forName("com.mysql.jdbc.Driver");
             this.conn = (Connection) DriverManager.getConnection(DB_URL,User,"");
             stmt = (Statement) conn.createStatement();
             String sql="select * from file where name = '" + file_name + "'and  author= '" + file_author + "';";
             ResultSet rs = stmt.executeQuery(sql);
             if(rs.next()){
                 //System.out.println(this.file_neirong);
                rs.close();
                conn.close();
                 return 1;
             }else {
                 rs.close();
                 conn.close();
                 return 2;
             }
        }catch(SQLException se){
             se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
              try{
                if(conn!=null) 
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
         }
         return 3;
    }
}

