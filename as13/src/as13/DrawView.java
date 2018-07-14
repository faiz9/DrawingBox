package as13;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class DrawView extends JPanel implements MyPropertyChangeListener, MouseListener, MouseMotionListener {

				
	private Model model;
	private int xSaved;
	private int ySaved;
	public DrawView() {
		setForeground(Color.YELLOW);
	} 
	 public void setModel(Model model) {
		   this.model = model;
	       model.addMyPropertyChangeListener(this);
	       this.addMouseListener(this);
	       this.addMouseMotionListener(this);

	    }
	 
	 public void paintComponent(Graphics g) {

	       super.paintComponent(g);

	       g.drawRect(Math.min(xSaved, model.getRecLength()+ xSaved),

	                   Math.min(ySaved, model.getRecWidth()+ ySaved),

	                   Math.abs( model.getRecLength()),

	                   Math.abs(model.getRecWidth()));

	 

	    }

	@Override
	public void myPropertyChange(MyPropertyChangeEvent ev) {
		this.repaint();
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent eV) {
		xSaved=eV.getX();
		ySaved=eV.getY();
		
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
	    model.setRecLength(e.getX() - xSaved);

	    model.setRecWidth(e.getY() - ySaved);    
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
