import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class deptscreen implements ActionListener{

	JFrame f;
	JCheckBox cb1,cb2,cb3,cb4;
	JLabel l;
	JButton u,r;
	int deptid;
	String deptcode;
	String deptname;
	String item[] = new String[4];
	boolean itemstatus[] = new boolean[4];
	int userid;
	
	deptscreen(int userid1){
		userid = userid1;
	try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/accreditation",
                    "root", "root");
			PreparedStatement st = con.prepareStatement("SELECT deptid,deptcode,deptname FROM deptinfo WHERE userid=?");
			st.setInt(1, userid);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				deptid = rs.getInt(1);
				deptcode = rs.getString(2);
				deptname = rs.getString(3);
			}
			PreparedStatement st1 = con.prepareStatement("SELECT item,itemstatus FROM checklist WHERE deptid=?");
			st1.setInt(1,deptid);
			ResultSet rs1 = st1.executeQuery();
			int i=0;
			while(rs1.next())
			{
				item[i] = rs1.getString(1);
				itemstatus[i] = rs1.getBoolean(2);
				i++;
				}
			con.close();
			
	}
	catch(SQLException sqlException){
		sqlException.printStackTrace();
	}
	
	cb1 = new JCheckBox(item[0],itemstatus[0]);
	cb1.setBounds(100,20,150,20);
	cb2 = new JCheckBox(item[1],itemstatus[1]);
	cb2.setBounds(100,40,150,20);
	cb3 = new JCheckBox(item[2],itemstatus[2]);
	cb3.setBounds(100,60,150,20);
	cb4 = new JCheckBox(item[3],itemstatus[3]);
	cb4.setBounds(100,80,150,20);
	
	
	u = new JButton("Update");
	u.setBounds(100,150,100,20);
	u.addActionListener(this);
		
	
	r = new JButton("Refresh");
	r.setBounds(100,200,100,20);
	r.addActionListener(this);
		
	f = new JFrame(deptname + "department");
	f.add(cb1);
	f.add(cb2);
	f.add(cb3);
	f.add(cb4);
	f.add(u);
	f.add(r);
	f.setSize(400,400);
	f.setLayout(null);
	f.setVisible(true);

	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==u)
		{
			try {

				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/accreditation",
	                    "root", "root");
				if(cb1.isSelected()) {
					PreparedStatement st1 = con.prepareStatement("UPDATE checklist SET itemstatus = 1 WHERE item = ? AND deptid = ?");
					st1.setString(1, cb1.getText());
					st1.setInt(2,deptid);
					st1.executeUpdate();
				}
				else {
					PreparedStatement st1 = con.prepareStatement("UPDATE checklist SET itemstatus = 0 WHERE item = ? AND deptid = ?");
					st1.setString(1, cb1.getText());
					st1.setInt(2,deptid);
					st1.executeUpdate();
				}
				
				if(cb2.isSelected()) {
					PreparedStatement st2 = con.prepareStatement("UPDATE checklist SET itemstatus = 1 WHERE item = ? AND deptid = ?");
					st2.setString(1, cb2.getText());
					st2.setInt(2,deptid);
					st2.executeUpdate();
				}
				else {
					PreparedStatement st2 = con.prepareStatement("UPDATE checklist SET itemstatus = 0 WHERE item = ? AND deptid = ?");
					st2.setString(1, cb2.getText());
					st2.setInt(2,deptid);
					st2.executeUpdate();
				}
				
				if(cb3.isSelected()) {
					PreparedStatement st3 = con.prepareStatement("UPDATE checklist SET itemstatus = 1 WHERE item = ? AND deptid = ?");
					st3.setString(1, cb3.getText());
					st3.setInt(2,deptid);
					st3.executeUpdate();
				}
				else {
					PreparedStatement st3 = con.prepareStatement("UPDATE checklist SET itemstatus = 0 WHERE item = ? AND deptid = ?");
					st3.setString(1, cb3.getText());
					st3.setInt(2,deptid);
					st3.executeUpdate();
				}
				
				if(cb4.isSelected()) {
					PreparedStatement st4 = con.prepareStatement("UPDATE checklist SET itemstatus = 1 WHERE item = ? AND deptid = ?");
					st4.setString(1, cb4.getText());
					st4.setInt(2,deptid);
					st4.executeUpdate();
				}
				else {
					PreparedStatement st4 = con.prepareStatement("UPDATE checklist SET itemstatus = 0 WHERE item = ? AND deptid = ?");
					st4.setString(1, cb4.getText());
					st4.setInt(2,deptid);
					st4.executeUpdate();
				}
				con.close();
					
			}
			catch(SQLException sqlException){
				sqlException.printStackTrace();
			}
			
		}
		else if(e.getSource()==r) {
			try {

				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/accreditation",
	                    "root", "root");
				PreparedStatement st1 = con.prepareStatement("SELECT item,itemstatus FROM checklist WHERE deptid=?");
				st1.setInt(1,deptid);
				ResultSet rs1 = st1.executeQuery();
				int i=0;
				while(rs1.next())
				{
					item[i] = rs1.getString(1);
					itemstatus[i] = rs1.getBoolean(2);
					i++;
					}
				con.close();
				
				
		    }
			catch(SQLException sqlException){
			sqlException.printStackTrace();
			}
			cb1.setSelected(itemstatus[0]);
			cb2.setSelected(itemstatus[1]);
			cb3.setSelected(itemstatus[2]);
			cb4.setSelected(itemstatus[3]);
		}
	}
	
}

	
