import javax.swing.*;
import java.awt.event.*;


public class PrincipalScreen1 implements ActionListener {
	
	JFrame f;
	JLabel l;
	JButton b;
	@SuppressWarnings("rawtypes")
	JComboBox c;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	PrincipalScreen1()
	{
		f = new JFrame("Welcome,Principal");
		
		l = new JLabel();
		l.setHorizontalAlignment(JLabel.CENTER);  
		l.setSize(400,100);
		l.setText("Select Department");
		
		b=new JButton("Confirm");
		b.setBounds(200,100,100,20);
		b.addActionListener(this);
		
		String dept[] = {"Civil","Mechanical","Electrical"};
		c = new JComboBox(dept);
		c.setBounds(50, 100,90,20);
		
		f.add(c); f.add(l); f.add(b);    
		f.setLayout(null);    
		f.setSize(350,350);    
		f.setVisible(true); 
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String deptname = (String) c.getItemAt(c.getSelectedIndex());
		PrincipalScreen2 pr2 = new PrincipalScreen2();
		pr2.display(deptname);
		f.dispose();
		
	}
	
}
