package payroll;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class List_Employee extends JFrame implements ActionListener{
     JTable j1;
    JButton b1;
    String h[]={"Emp id","Name","Gender","Address","State","City","Email id","Phone"};
    String d[][]=new String[20][8];  
    int i=0,j=0;
     List_Employee(){

     super("View Employees");
         setSize(1000,400);
         setLocation(450,200);
         try{
             String q = "select * from employee";
             conn c = new conn();
             ResultSet re = c.s.executeQuery(q);
             while(re.next()){
                 d[i][j++]=re.getString("id");
                 d[i][j++]=re.getString("name");
                 d[i][j++]=re.getString("gender");
                 d[i][j++]=re.getString("address");
                 d[i][j++]=re.getString("state");
                 d[i][j++]=re.getString("city");
                 d[i][j++]=re.getString("email");
                 d[i][j++]=re.getString("phone");
                 i++;
                 j=0;
               }
             j1 = new JTable(d, h);
         }catch(Exception e){
             e.printStackTrace();
         }
         
         b1= new JButton("Print");
         add(b1,"South");
         
         JScrollPane s = new JScrollPane(j1);
         add(s);
         
         b1.addActionListener(this);
     
     }
     public void actionPerformed(ActionEvent ae){
         try{
             j1.print();
         }catch(Exception e){
             e.printStackTrace();
         }
     }
         public static void main(String args[]){
           new List_Employee().setVisible(true);
      }
         
     }
   
