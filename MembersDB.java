/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.bl;

import java.util.List;
import za.ac.tut.entity.Member;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author olwet
 */
public class MembersDB implements DAO<Member> {
    //connection
    
   private Connection connection ;

    public MembersDB(String url,String username ,String password ) throws SQLException {
        this.connection=DriverManager.getConnection(url,username,password) ;
        
    }
   public void close(){
       if(connection !=null)
       {
           try{
                 connection.close();
           }
           catch(SQLException e)
           {
               e.printStackTrace();
           }
       }
   }

    @Override
    public Member get(String id) {
       
            String sql="Select Name,Surname,Id,Gender,Trainer,Contract from "+
                    "MembersTbl where Id=?";
             try {
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                String name=rs.getString("Name");
                String surname=rs.getString("Surname");
                String gender=rs.getString("Gender");
                String idNo=rs.getString("Id");
                Boolean trainer=rs.getBoolean("Trainer");
                String contract=rs.getString("Contract");
                Member member=new Member(name,surname,gender,idNo,contract,trainer);
                rs.close();
                return member;
            }
            else
            {
                rs.close();
                return null;
            }
            
        } catch (SQLException ex) {
           
            System.err.println(ex);
            return null;
        }
    
    }

    @Override
    public List<Member> getAll() {
       String sql="Select * from MembersTbl";
       try {
           PreparedStatement ps=connection.prepareStatement(sql);
           ResultSet rs=ps.executeQuery();
           List<Member> members=new ArrayList<>();
           while(rs.next())
           {
           
               String name=rs.getString("Name");
                String surname=rs.getString("Surname");
                String gender=rs.getString("Gender");
                String idNo=rs.getString("Id");
                Boolean trainer=rs.getBoolean("Trainer");
                String contract=rs.getString("Contract");
                Member member=new Member(name,surname,gender,idNo,contract,trainer);
                members.add(member);
           }
           rs.close();
           return members;
       } catch (SQLException ex) {
           System.err.println(ex);
           return null;
       }
    }

    @Override
    public boolean remove(String idnum) {
        String sql="Delete From MembersTbl where Id = ?";
                    
               try {
            PreparedStatement ps=connection.prepareStatement(sql);
          
              ps.setString(1, idnum);
           
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
         
           System.err.println(ex);
           return false;
        
        }
    }

    @Override
    public boolean update(Member t) {
       
     String sql="UPDATE MembersTbl SET "
             + "Name=?,"
             + "Surname=?,"
             + "Gender=?,"
             + "Trainer=?"
             + "Where Id=?";
                    
               try {
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setString(1, t.getName());
            ps.setString(2, t.getSurname());
          
            ps.setString(3, t.getGender());
            ps.setBoolean(4, t.getTrainer());
              ps.setString(5, t.getIdno());
           
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
         
           System.err.println(ex);
           return false;
        
        }
    }

    @Override
    public boolean add(Member t) {
     
            String sql="INSERT INTO MembersTbl(Name,Surname,Id,Gender,Trainer,Contract)"
                    + "Values (?,?,?,?,?,?)";
               try {
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setString(1, t.getName());
            ps.setString(2, t.getSurname());
            ps.setString(3, t.getIdno());
            ps.setString(4, t.getGender());
            

            ps.setBoolean(5, t.getTrainer());
            ps.setString(6, t.getContractsType());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
         
           System.err.println(ex);
           return false;
        
        }
    
    }
    
}
