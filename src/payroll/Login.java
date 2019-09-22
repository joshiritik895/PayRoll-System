package payroll;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;

    Login(){
    super("Login Page");
        setLayout(new BorderLayout());
        t1 = new JTextField(10);
        t2 = new JPasswordField(10);
        JLabel l = new JLabel(new ImageIcon(ClassLoader.getSystemResource("icon/defaultpic.png")));
        b1 = new JButton("submit",new ImageIcon(ClassLoader.getSystemResource("icon/login.png")));
        b2 = new JButton("cancel",new ImageIcon(ClassLoader.getSystemResource("icon/cancel.png")));
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        JPanel p1,p2,p3,p4;
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        ImageIcon ml = new ImageIcon("login.png");
        JLabel jl = new JLabel(ml);
        p1.add(jl);
        
        add(l,BorderLayout.WEST);
        p2.add(new JLabel("User Name"));
        p2.add(t1);
        p2.add(new JLabel("Password"));
        p2.add(t2);
        add(p2,BorderLayout.CENTER);
        
        p4.add(b1);
        p4.add(b2);
        add(p4,BorderLayout.SOUTH);
       
        setSize(350,200);
        setLocation(600,400);
        setVisible(true);
     }
    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        if(msg.equals("submit")){
        try{
            conn c = new conn();
            String u = t1.getText();
            char v[] = t2.getPassword();
            String p = new String(v);
            String q = "select * from login where username='"+u+"' and password='"+p+"'";
            ResultSet rs = c.s.executeQuery(q);
             if(rs.next()){
                String user = rs.getString("username");
                String pass = rs.getString("password");
                 if(u.equals(user)&&p.equals(pass)){
                    System.err.println("ttttt");
                new Project().setVisible(true);
                setVisible(false);    
                }
             }
                 else if(!(rs.next())){
             JOptionPane.showMessageDialog(null,"invalid login");
                setVisible(false);
             }
            
             
        }catch(Exception e){
            e.printStackTrace();
        }
        } 
        else if (msg.equals("cancel")){
            this.dispose();
        }
    }       
        public static void main(String args[]){
            new Login();
        }
    }


