import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class tempGUI extends JFrame implements ActionListener{
    private Container pane;
    private JButton bf, bc;
    private JLabel lf, lc;
    private JTextField tf, tc;

    private void toF(){
	try{
	    tf.setText("" + tempConvert.CtoF(Double.parseDouble(tc.getText())));
	}catch(NumberFormatException e){
	    tf.setText("0");
	}
    }

    private void toC(){
	try{
	    tc.setText("" + tempConvert.FtoC(Double.parseDouble(tf.getText())));
	}catch(NumberFormatException e){
	    tc.setText("0");
	}
    }
    
    public void actionPerformed(ActionEvent e){
	String event = e.getActionCommand();
	if(event.equals("toF")){
	    toF();
	}
	if(event.equals("toC")){
	    toC();
	}
    }

    
    public tempGUI(){
	this.setTitle("Temperature Converter");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new GridLayout(3, 2));
	
	bf = new JButton("Convert to F");
	bf.addActionListener(this);
	bf.setActionCommand("toF");
	bc = new JButton("Convert to C");
	bc.addActionListener(this);
	bc.setActionCommand("toC");

	tf = new JTextField(10);
	tc = new JTextField(10);

	lf = new JLabel("Fahrenheit");
	lc = new JLabel("Celcius");

	pane.add(lf);
	pane.add(lc);
	pane.add(tf);
	pane.add(tc);
	pane.add(bc);
	pane.add(bf);
    }

   public static void main(String[] args) {
     tempGUI g = new tempGUI();
     g.setVisible(true);
  } 

}
