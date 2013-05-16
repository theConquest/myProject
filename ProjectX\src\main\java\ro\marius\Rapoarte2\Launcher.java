myProject
=========
package Rapoarte2;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Launcher {
  static private String ora;
	static private String pos1;
	static private String pos2;
	static private String result;
	static JTextField oraTF;
	static JTextField POS1TF;
	static JTextField POS2TF;
    public static void setOra(String ora1){ora = ora1;}
	public static String getOra(){return ora;}
	public static void setPos1(String p1){pos1 = p1;}
	public static String getPos1(){return pos1;}
	public static void setPos2(String p2){pos2 = p2;}
	public static String getPos2(){return pos2;}
	//public static void setResult(String res){res = result;}
	//public static String getResult(){return result;}
	
	public static void main(String[]args){
		//Instantiaza butoane, Instantiaza listeneri, adauga listeneri la butoane
		//Instantiaza text field
		//Instantiaza text label
		//Instantiaza JFrame, adauga tot ce e mai sus la el si gata;
		JLabel oraLabel = new JLabel("introduceti intervalul orar, ex: 07-08:", JLabel.CENTER);
        oraLabel.setSize(300, 30);
        oraLabel.setLocation(5, 5);
        
        JLabel POSLabel = new JLabel("Introduceti raportul pentru POS1 si POS2, ex 875 sau 150.87:",JLabel.CENTER);
        POSLabel.setSize(350, 30);
        POSLabel.setLocation(35, 70);
       
        oraTF = new JTextField(JTextField.CENTER);
        oraTF.setSize(50, 30);
        oraTF.setLocation(40, 30);
        
        POS1TF = new JTextField(JTextField.CENTER);
        POS1TF.setSize(80, 30);
        POS1TF.setLocation(40, 100);
        
        POS2TF = new JTextField(JTextField.CENTER);
        POS2TF.setSize(80, 30);
        POS2TF.setLocation(150, 100);
        
        JButton buttonC = new JButton("Calculeaza");
        buttonC.setSize(170, 40);
        buttonC.setLocation(40, 150);
        
        JButton buttonEx = new JButton("Exporta");
        buttonEx.setSize(170, 40);
        buttonEx.setLocation(220, 150);
        
        JPanel myPanel = new JPanel();
		myPanel.setOpaque(true);
        myPanel.setBackground(Color.WHITE);
        myPanel.setLayout(null);
        
        JFrame myFrame = new JFrame("Calcul rapoarte");
		myFrame.setSize(600, 500);
		myFrame.setVisible(true);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		 myPanel.add(oraLabel);
	     myPanel.add(oraTF);
	     myPanel.add(POSLabel);
	     myPanel.add(POS1TF);
	     myPanel.add(POS2TF);
	     myPanel.add(buttonC);
	     myPanel.add(buttonEx);
	     myFrame.setContentPane(myPanel);
	     
	     buttonC.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent e)
	            { 
        		  getVar(); 
	            }
	        });
	     buttonEx.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent e)
	            { 
        		 ExportFile exp = new ExportFile();
        		 exp.export(result);
        		 System.out.println("exporta");
	            }
	        });
	     
	}
	public static void getVar(){
		setOra(oraTF.getText());
		setPos1(POS1TF.getText());
		setPos2(POS2TF.getText());
		
		ButtonC bc = new ButtonC();
		bc.createLine(getOra(), getPos1(), getPos2());
		
		result = bc.getLine();     // String-ul final pt export
		
		System.out.println(result);
	}

}
