package week6day1;


import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FormeDesene extends JFrame implements ActionListener,ItemListener {
	
	JButton bLine,bOval, bRectangle;
	JPanel pSus,cJos;
	
	Graphics object;
	Choice colorList;
	String vectorCulori[] = {"roz","gri","verde"};
	JCheckBox isFill;
	Color culoareAleasa;
	
	public FormeDesene(){
		
		colorList = new Choice();
		for (int i = 0; i < vectorCulori.length; i++) {
			colorList.add(vectorCulori[i]);
		}
		bLine = new JButton("Deseneaza Linie");
		bOval = new JButton("Deseneaza Oval");
		bRectangle = new JButton("Deseneaza Dreptunghi");
		isFill = new JCheckBox("FILL THAT");
		
		pSus = new JPanel(new GridLayout(1,3));
		pSus.add(bLine);
		pSus.add(bOval);
		pSus.add(bRectangle);
		pSus.add(colorList);
		pSus.add(isFill);
		
		cJos = new JPanel();
		
		this.setLayout(new BorderLayout());
		this.add(pSus,BorderLayout.NORTH);
		this.add(cJos,BorderLayout.CENTER);
		this.setSize(480,320);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		bLine.addActionListener(this);
		bOval.addActionListener(this);
		bRectangle.addActionListener(this);
		
		colorList.addItemListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent ar) {
		
		object = cJos.getGraphics();
		if(ar.getSource()==bLine){
			
			
			
			for(int i=0;i<50;i++){
				Random cX = new Random();
				Random cy = new Random();
				int x = cX.nextInt(cJos.getWidth());
				int y = cy.nextInt(cJos.getHeight());
				int x2 = cX.nextInt(cJos.getWidth());
				int y2 = cy.nextInt(cJos.getHeight());
				object.drawLine(x, y, x2, y2);
				object.setColor(culoareAleasa);
				
			}
			
			
			
		}
		if(ar.getSource()==bOval){
			for(int i=0;i<5;i++){
				Random cX = new Random();
				Random cy = new Random();
				int x = cX.nextInt(cJos.getWidth());
				int y = cy.nextInt(cJos.getHeight());
				int x2 = cX.nextInt(cJos.getWidth());
				int y2 = cy.nextInt(cJos.getHeight());
			object.drawOval(x, y, x2, y2);
			object.setColor(culoareAleasa);
			if(isFill.isSelected()){
				object.fillOval(x, y, x2, y2);
				
			}
			}
			
		}
		if(ar.getSource()==bRectangle){
			for(int i=0;i<5;i++){
				Random cX = new Random();
				Random cy = new Random();
				int x = cX.nextInt(cJos.getWidth());
				int y = cy.nextInt(cJos.getHeight());
				int x2 = cX.nextInt(cJos.getWidth());
				int y2 = cy.nextInt(cJos.getHeight());
			object.drawRect(x, y, x2, y2);
			object.setColor(culoareAleasa);
			if(isFill.isSelected()){
				object.fillRect(x, y, x2, y2);
				object.setColor(culoareAleasa);
				
			}
			}
			
		}
		
	}

	@Override
	public void itemStateChanged(ItemEvent evo) {
		
		if(evo.getSource()==colorList){
			if(colorList.getSelectedItem()=="roz"){
				culoareAleasa=Color.pink;
			}
			if(colorList.getSelectedItem()=="gri"){
				culoareAleasa=Color.gray;
			}
			if(colorList.getSelectedItem()=="verde"){
				culoareAleasa=Color.green;
			}
		}
		
	}
	

}
