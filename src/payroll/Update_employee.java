package payroll;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Update_employee extends JFrame implements ActionListener,ItemListener{
        
    JLabel l1,l2,l3,l4,l5,l6,l7,emp;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JButton b1,b2;
    Choice c1,c2;
    
    Update_employee(){
          
        super("Update Employee");
        setLayout(new GridLayout(9,2,10,10));
         getContentPane().setBackground(Color.WHITE);
          c2 = new Choice();
          try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
      
            while(rs.next()){
                c2.add(rs.getString("id"));    
            }
        }catch(Exception e){ }
          emp = new JLabel("Select Empno");
          add(emp);
          add(c2);
          l1 = new JLabel("Name");
          t1 = new JTextField(15);
          add(l1);
          add(t1);
          
        c1 = new Choice();
        c1.add("Male");
        c1.add("Female");
        
        l2 = new JLabel("Gender");
        add(l2);
        add(c1);
        
        l3 = new JLabel("Address");
        t3 = new JTextField(15);
        add(l3);
        add(t3);
        
        
        l4 = new JLabel("State");
        t4 = new JTextField(15);
        add(l4);
        add(t4);
       
        l5 = new JLabel("City");
        t5 = new JTextField(15);
        add(l5);
        add(t5);
          
       l6 = new JLabel("Email");
        t6 = new JTextField(15);
        add(l6);
        add(t6);
        
        l7 = new JLabel("Phone");
        t7= new JTextField(15);
        add(l7);
        add(t7);
        
        b1 =new JButton("Update");
        b2 = new JButton("Delete");
        
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b1);
        add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        c2.addItemListener(this);
        
        setVisible(true);
        setSize(400,450);
        setLocation(600,200);
        
       }
      public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==b1){
            String n = t1.getText();
            String g = c1.getSelectedItem();
            String a = t3.getText();
            String s = t4.getText();
            String c = t5.getText();
            String e = t6.getText();
            String p = t7.getText();
            String qry = "update employee set name='"+n+"',gender='"+g+"',address='"+a+"',state='"+s+"',city='"+c+"',email='"+e+"',phone='"+p+"'   where id="+c2.getSelectedItem();
       

           try{
                conn c1 = new conn();
                c1.s.executeUpdate(qry);
                JOptionPane.showMessageDialog(null,"Employee Updated");
                setVisible(false);
            }catch(Exception ee){
                ee.printStackTrace();
            }
        }
        
        if(ae.getSource()==b2){
            try{
                conn c1 = new conn();
                c1.s.executeUpdate("delete from employee where id="+c2.getSelectedItem());
                JOptionPane.showMessageDialog(null,"Employee Deleted");
                this.setVisible(false);
            }catch(Exception ee){
                ee.printStackTrace();
            }
        }        
      }
        
        public void itemStateChanged(ItemEvent ie){
        try{
            conn c1 = new conn();
            ResultSet rs = c1.s.executeQuery("select * from employee where id="+c2.getSelectedItem());
            
            if(rs.next()){
                t1.setText(rs.getString("name"));
                t3.setText(rs.getString("address"));
                t4.setText(rs.getString("state"));
                t5.setText(rs.getString("city"));
                t6.setText(rs.getString("email"));
                t7.setText(rs.getString("phone"));
            }
        }catch(Exception ee){
           ee.printStackTrace();
        }
    
    }
    
    public static void main(String[] args){
        new Update_employee();
    }
      
        }          
