package as13;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TextView extends JPanel implements MyPropertyChangeListener {
	private JTextField jtfRecLength;
	private JTextField jtfRecWidth;

	private Model model;
	
	public TextView() {
		
		JLabel lblLength = new JLabel("Length:");
		add(lblLength);
		
		jtfRecLength = new JTextField();
		jtfRecLength.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
			 	String sLength = jtfRecLength.getText().trim();
			 	int len = Integer.parseInt(sLength);
				model.setRecLength(len);
				
			}
		});
		add(jtfRecLength);
		jtfRecLength.setColumns(10);
		
		JLabel lblWidth = new JLabel("Width");
		add(lblWidth);
		
		jtfRecWidth = new JTextField();
		jtfRecWidth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sWidth = jtfRecWidth.getText().trim();
				System.out.println("addActionListener before" + sWidth);
			 	int width = Integer.parseInt(sWidth);
			 	model.setRecWidth(width);
			 	System.out.println("addActionListener after");
			}
		});
		add(jtfRecWidth);
		jtfRecWidth.setColumns(10);

	}
	public void setModel(Model model) {
	       this.model = model;
	       model.addMyPropertyChangeListener(this);
	       
	    }

	@Override
	public void myPropertyChange(MyPropertyChangeEvent ev) {
		 System.out.println("myPropertyChange");
		if (ev.propertyName.equalsIgnoreCase("length")){
	           jtfRecLength.setText(""+ev.getOldValue());
	       } else if (ev.propertyName.equalsIgnoreCase("width")){
	           jtfRecWidth.setText(""+ev.getNewValue());
	       }
	}
	 
	    

}
