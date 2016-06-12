package week6day1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class SimulatorDesen extends JFrame{
	int x=0;
	int y=0;
	int x2=0;
	int y2=0;
	Graphics2D gr;
	public SimulatorDesen(){
		
		
		this.setLayout(new BorderLayout());
		JPanel buttonHolder = new JPanel();
		buttonHolder.setBackground(Color.YELLOW);
		JPanel canvas = new JPanel();
		
		this.add(buttonHolder,BorderLayout.NORTH);
		this.add(canvas, BorderLayout.CENTER);
		
		this.setSize(1280,1024);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		canvas.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				x=e.getX();
				y=e.getY();
			}
		});
		
		canvas.addMouseMotionListener(new MouseAdapter(){
			public void mouseDragged(MouseEvent e) {
				super.mouseDragged(e);
				gr=(Graphics2D) canvas.getGraphics();
				
				
				x2=e.getX();
				y2=e.getY();
			
				gr.drawLine(x, y, x2, y2);
				x=e.getX();
				y=e.getY();
				
			}
		});
		
		
	}

}
