package week6day1;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;


public class Operatii extends JFrame implements ItemListener,ActionListener {

	JCheckBox prim, secund, tert, patru;
	JTextField primF, secundF, tertF, patruF;
	JButton aduna, scade;
	JLabel rezultat;
	JButton do_it;
	JRadioButton adunaR, scadeR;
	
	public Operatii(){
		
		prim= new JCheckBox("check_first? ");
		secund = new JCheckBox("check_second? ");
		tert = new JCheckBox("check_third? ");
		patru = new JCheckBox("check_four?");
		
		primF = new JTextField("",4);
		secundF = new JTextField("",4);
		tertF = new JTextField("",4);
		patruF = new JTextField("",4);
		
		adunaR = new JRadioButton("aduna");
		scadeR = new JRadioButton("scade");
		
		do_it = new JButton("JUST DO IT");
		
		rezultat = new JLabel("result");
		
		this.add(prim);
		this.add(secund);
		this.add(tert);
		this.add(patru);
		
		this.add(primF);
		this.add(secundF);
		this.add(tertF);
		this.add(patruF);
		
		this.add(adunaR);
		this.add(scadeR);
		
		this.add(do_it);
		
		this.add(rezultat);
		
		ButtonGroup radio = new ButtonGroup();
		radio.add(adunaR);
		radio.add(scadeR);
		
		adunaR.addItemListener(this);
		scadeR.addItemListener(this);
		
		do_it.addActionListener(this);
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.setLocationRelativeTo(null);
		this.setSize(480, 120);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}


	@Override
	public void itemStateChanged(ItemEvent l) {
		
		
		//if(l.getSource()==adunaR){
			//prim.isSelected()
		//}
		
	}
	
	public double isNumber(String parsabil){
		double nrDouble;
		try{
			nrDouble = Double.parseDouble(parsabil);
		} catch (Exception uu){
			nrDouble = Double.MAX_VALUE;
		}
		return nrDouble;
	}


	@Override
	public void actionPerformed(ActionEvent l) {

		double suma = 0;
		int contor = 0;
		if(l.getSource()==do_it){
			if(adunaR.isSelected()==true){
				JCheckBox[] vectorCheck = {prim, secund, tert, patru};
				JTextField[] vectorTxt = {primF,secundF,tertF,patruF};
				for(JTextField curentTxt : vectorTxt){
					
					if(isNumber(curentTxt.getText())!=Double.MAX_VALUE && vectorCheck[contor].isSelected() ){
						suma+=Double.parseDouble(curentTxt.getText());
					}else if(isNumber(curentTxt.getText())==Double.MAX_VALUE ){
						curentTxt.setText("");
					}
					contor++;
				
				
			}
			} else if(scadeR.isSelected()==true){
				
				JCheckBox[] vectorCheck = {prim, secund, tert, patru};
				JTextField[] vectorTxt = {primF,secundF,tertF,patruF};
				boolean isFirst = true;
				
				for(JTextField curentTxt : vectorTxt){
					
					if(isNumber(curentTxt.getText())!=Double.MAX_VALUE && vectorCheck[contor].isSelected() ){
						if(isFirst){
							suma=Double.parseDouble(curentTxt.getText());
							isFirst=false;
						} else {
							suma-=Double.parseDouble(curentTxt.getText());
						}
						
					} else if(isNumber(curentTxt.getText())==Double.MAX_VALUE ){
						curentTxt.setText("");
					}
					contor++;
				
				
			}
				
			}
			
			rezultat.setText(""+suma);
	}

		
	}
	
}
