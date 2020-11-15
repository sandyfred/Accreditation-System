import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class PrincipalScreen2 implements ActionListener{
	
	JFrame f;
	JLabel l;
	JCheckBox cb1,cb2,cb3,cb4;
	int deptid;
	String deptcode;
	JButton b, back;
	String name;
	String item[] = new String[4];
	boolean itemstatus[] = new boolean[4];
	
	
	public void display(String deptname)
	{
		name = deptname;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/accreditation",
                    "root", "root");
			PreparedStatement st = con.prepareStatement("SELECT deptid,deptcode FROM deptinfo WHERE deptname=?");
			st.setString(1, deptname);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				deptid = rs.getInt(1);
				deptcode = rs.getString(2);
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
		}
			 catch (SQLException sqlException) {
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
		
		cb1.setEnabled(false);
		cb2.setEnabled(false);
		cb3.setEnabled(false);
		cb4.setEnabled(false);
		
		b = new JButton("Validate");
		b.setBounds(100,150,100,20);
		b.addActionListener(this);
		
		back = new JButton("Go Back");
		back.setBounds(100,200,100,20);
		back.addActionListener(this);
		
		JProgressBar jb = new JProgressBar(0,4);
		jb.setBounds(100,100,160,30);
		jb.setStringPainted(true);
		int c = 0;
		for(int i=0;i<itemstatus.length;i++)
		{
			if(itemstatus[i]==true)
				c++;
		}
		jb.setValue(c);
		f = new JFrame(deptname);
		f.add(cb1);
		f.add(cb2);
		f.add(cb3);
		f.add(cb4);
		f.add(jb);
		f.add(b);
		f.add(back);
		f.setLayout(null);
		f.setSize(400,400);
		f.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==b) {
		FileWriter fw;
		try {
			fw = new FileWriter("D:\\Mini Project OOOPS FileGenerator\\test.txt");
			fw.write("Department:"+ name);
			fw.write(System.lineSeparator());
			fw.write("Department Code:"+ deptcode);
			fw.write(System.lineSeparator());
			fw.write("Documents and status:");
			fw.write(System.lineSeparator());
			for(int i = 0;i<item.length;i++)
			{
				fw.write(item[i] + ": " + itemstatus[i]);
				fw.write(System.lineSeparator());
			}
			fw.close();
			
			} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		}
		else if(e.getSource()==back) {
			new PrincipalScreen1();
			f.dispose();
			}
		
	}
	
}
