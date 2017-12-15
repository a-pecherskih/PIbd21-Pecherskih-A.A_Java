import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Form1 {

	private JFrame frame;
	private JTextField textBoxMaxSpeed;
    private JTextField textBoxMaxAltitude;
    private JTextField textBoxMaxCountPassenget;
    private JTextField textBoxWeight;
    JButton buttonSelectColor;
    JButton buttonSelectDopColor;
    JButton buttonSelectDopColor2;
    JCheckBox checkBoxWings;
    JCheckBox checkBoxScrew;
	
	Color color;
    Color dopColor;
    Color dopColor2;
    int maxSpeed;
    double maxAltitude;
    int maxCountPass;
    int weight;
    private ITransport inter;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form1 window = new Form1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Form1() {
		initialize();	
		color = Color.WHITE;
        dopColor = Color.YELLOW;
        dopColor2 = Color.RED;
        maxSpeed = 750; 
        maxAltitude = 1.50;
        maxCountPass = 7;
        weight = 4100;
        buttonSelectColor.setBackground(color);
        buttonSelectDopColor.setBackground(dopColor);
        buttonSelectDopColor2.setBackground(dopColor2);
        
	}
	
	 private boolean checkFields()
     {
		 try{
			 maxSpeed = Integer.parseInt(textBoxMaxSpeed.getText());
			 maxAltitude = Double.parseDouble(textBoxMaxAltitude.getText());
			 maxCountPass = Integer.parseInt(textBoxMaxCountPassenget.getText());
			 weight = Integer.parseInt(textBoxWeight.getText());
			 
		 }catch(NumberFormatException ex){
			 return false;
		 }
         return true;
     }
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 838, 608);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		PlanePanel panel = new PlanePanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 699, 402);
		frame.getContentPane().add(panel);
		
		textBoxMaxSpeed = new JTextField();
		textBoxMaxSpeed.setText("500");
		textBoxMaxSpeed.setBounds(134, 456, 86, 20);
		frame.getContentPane().add(textBoxMaxSpeed);
		textBoxMaxSpeed.setColumns(10);
		
		textBoxMaxAltitude = new JTextField();
		textBoxMaxAltitude.setText("1");
		textBoxMaxAltitude.setColumns(10);
		textBoxMaxAltitude.setBounds(134, 487, 86, 20);
		frame.getContentPane().add(textBoxMaxAltitude);
		
		JLabel lblMaxSpeed = new JLabel("Max speed");
		lblMaxSpeed.setBounds(30, 459, 65, 14);
		frame.getContentPane().add(lblMaxSpeed);
		
		JLabel lblMaxAltitude = new JLabel("Max Altitude");
		lblMaxAltitude.setBounds(30, 490, 94, 14);
		frame.getContentPane().add(lblMaxAltitude);
		
		JLabel lblMaxCoutPassenger = new JLabel("Max cout passenger");
		lblMaxCoutPassenger.setBounds(250, 459, 104, 14);
		frame.getContentPane().add(lblMaxCoutPassenger);
		
		textBoxMaxCountPassenget = new JTextField();
		textBoxMaxCountPassenget.setText("5");
		textBoxMaxCountPassenget.setColumns(10);
		textBoxMaxCountPassenget.setBounds(354, 456, 86, 20);
		frame.getContentPane().add(textBoxMaxCountPassenget);
		
		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setBounds(250, 490, 65, 14);
		frame.getContentPane().add(lblWeight);
		
		textBoxWeight = new JTextField();
		textBoxWeight.setText("2500");
		textBoxWeight.setColumns(10);
		textBoxWeight.setBounds(354, 487, 86, 20);
		frame.getContentPane().add(textBoxWeight);
		
		JButton buttonSetPlane = new JButton("SetPlane");
		buttonSetPlane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (checkFields()) {
					inter = new Plane(maxCountPass, maxSpeed, maxAltitude, weight, color, dopColor);
					panel.updatePlane(inter);
				}
			}
		});
		buttonSetPlane.setBounds(131, 524, 89, 23);
		frame.getContentPane().add(buttonSetPlane);
		
		JButton buttonSetLightPlane = new JButton("SetLightPlane");
		buttonSetLightPlane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkFields()) {
					inter = new LightPlane(maxCountPass, maxSpeed, maxAltitude, weight, color, checkBoxWings.isSelected(), checkBoxScrew.isSelected(), dopColor, dopColor2);
					panel.updatePlane(inter);
				}
			}
		});
		buttonSetLightPlane.setBounds(270, 524, 120, 23);
		frame.getContentPane().add(buttonSetLightPlane);
		
		JButton buttonMove = new JButton("Move");
		buttonMove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (inter != null) {
					inter.movePlane();
					panel.updatePlane(inter);
				}
			}
		});
		buttonMove.setBounds(678, 524, 89, 23);
		frame.getContentPane().add(buttonMove);
		
		JLabel lblMainColor = new JLabel("Main color");
		lblMainColor.setBounds(493, 456, 65, 14);
		frame.getContentPane().add(lblMainColor);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(493, 487, 65, 14);
		frame.getContentPane().add(lblColor);
		
		checkBoxWings = new JCheckBox("Wings");
		checkBoxWings.setBounds(652, 455, 65, 23);
		frame.getContentPane().add(checkBoxWings);
		
		checkBoxScrew = new JCheckBox("Screw");
		checkBoxScrew.setBounds(652, 486, 65, 23);
		frame.getContentPane().add(checkBoxScrew);
		
		buttonSelectColor = new JButton("");
		buttonSelectColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//переданные аргументы
				ColorDialog colorDialog = new ColorDialog(frame, true, color);
				colorDialog.setVisible(true);
				color = colorDialog.getColor();
				buttonSelectColor.setBackground(color);

			}
		});
		buttonSelectColor.setBounds(569, 448, 65, 36);
		frame.getContentPane().add(buttonSelectColor);
		
		buttonSelectDopColor = new JButton("");
		buttonSelectDopColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ColorDialog colorD = new ColorDialog(frame, true, dopColor);
				colorD.setVisible(true);
				dopColor = colorD.getColor();
				buttonSelectDopColor.setBackground(dopColor);
			}
		});
		buttonSelectDopColor.setBounds(569, 486, 65, 36);
		frame.getContentPane().add(buttonSelectDopColor);
		
		buttonSelectDopColor2 = new JButton("");
		buttonSelectDopColor2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ColorDialog colorD = new ColorDialog(frame, true, dopColor2);
				colorD.setVisible(true);
				dopColor2 = colorD.getColor();
				buttonSelectDopColor.setBackground(dopColor2);
			}
		});
		buttonSelectDopColor2.setBounds(736, 455, 65, 36);
		frame.getContentPane().add(buttonSelectDopColor2);
		
		
	}
}
