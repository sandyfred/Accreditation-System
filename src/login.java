import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class login implements ActionListener {
	
	JFrame f;
	JLabel label1;JLabel label2;
	JTextField text1;
	JPasswordField text2;
	JButton SUBMIT;
	JPanel panel;
	int userid;
	JLabel l1;
	
	public void UserLogin() {
		
	f = new JFrame("Accreditation Compliance System");
	
	label1 = new JLabel();
	label1.setText("Username:");
	text1 = new JTextField(15);
	label1.setBounds(100,50,100,30);
	text1.setBounds(250,50,100,30);
	 
	label2 = new JLabel();
	label2.setText("Password:");
	text2 = new JPasswordField(15);
	label2.setBounds(100,100,100,30);
	text2.setBounds(250,100,100,30);
	  
	SUBMIT=new JButton("SUBMIT");
	SUBMIT.addActionListener(this);
	SUBMIT.setBounds(150,150,100,30);
	
	l1 = new JLabel("Invalid Username or Password.Try again");
	l1.setBounds(100,200,500,30);
	l1.setVisible(false);   
	
	
	f.add(label1);
	f.add(text1);
	f.add(label2);
	f.add(text2);
	f.add(SUBMIT);
	f.add(l1);
	f.setLayout(null);
	f.setSize(500,500);
	f.setVisible(true);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		String username = text1.getText();
		@SuppressWarnings("deprecation")
		String password = text2.getText();
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/accreditation",
                    "root", "root");
			 PreparedStatement st = con.prepareStatement("Select userid, username, password from userinfo where username=? and password=?");
			 
			 st.setString(1, username);
             st.setString(2, password);
             ResultSet rs = st.executeQuery();
            
             if (rs.next()) {
                 if(username.equals("principal")) {
                	 
                	 new PrincipalScreen1();
                	 f.dispose();
                 }
                 else {
                	 
                	 userid = rs.getInt(1);
                	 new deptscreen(userid);
                	 f.dispose();
                 }
             } 
             else {
            	 
            	 l1.setVisible(true);
            	 text1.setText(null);
            	 text2.setText(null);
             }
             con.close();
             
         } 
		catch (SQLException sqlException) {
			
             sqlException.printStackTrace();
		}
	}
	
	public static void main(String args[]) {
		
		login m1=new login();
		m1.UserLogin();
	}
}
