import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class Form1 {

	private JFrame frame;
	
	private Airfield airfield;
	private AirfieldPanel panel;
    
	Color color;
 	Color dopColor;
 	Color dopColor2;
 	private JTextField textField;
	
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
		airfield = new Airfield();
		initialize();	
		color = Color.WHITE;
        dopColor = Color.YELLOW;
        dopColor2 = Color.RED;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Airfield");
		frame.setBounds(100, 100, 838, 608);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new AirfieldPanel(airfield);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 756, 408);
		frame.getContentPane().add(panel);
		
		PlanePanel panel_1 = new PlanePanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(619, 423, 137, 112);
		frame.getContentPane().add(panel_1);
		
		JButton buttonSetPlane = new JButton("Set plane");
		buttonSetPlane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ColorDialog colorDialog = new ColorDialog(frame, true, color);
				colorDialog.setLocationRelativeTo(null); 
				colorDialog.setVisible(true);
				color = colorDialog.getColor();
				
				ColorDialog colorDialog2 = new ColorDialog(frame, true, color);
				colorDialog2.setLocationRelativeTo(null); 
				colorDialog2.setVisible(true);
				dopColor = colorDialog2.getColor();
				ITransport inter = new Plane(7, 750, 1.50, 4100, color, dopColor);;
				int place = airfield.PutPlaneInAirfield(inter);
				if (place > -1) {
					panel.updateAirfieldPanel(airfield);
					JOptionPane.showMessageDialog(null, "Ваше место: " + (place + 1), "",
					JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Нет мест", "", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		buttonSetPlane.setBounds(57, 456, 120, 23);
		frame.getContentPane().add(buttonSetPlane);
		
		JButton buttonSetLightPlane = new JButton("Set light plane");
		buttonSetLightPlane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ColorDialog colorDialog = new ColorDialog(frame, true, color);
				colorDialog.setLocationRelativeTo(null); 
				colorDialog.setVisible(true);
				color = colorDialog.getColor();
				
				ColorDialog colorDialog2 = new ColorDialog(frame, true, color);
				colorDialog2.setLocationRelativeTo(null); 
				colorDialog2.setVisible(true);
				dopColor = colorDialog2.getColor();
				
				ColorDialog colorDialog3 = new ColorDialog(frame, true, color);
				colorDialog3.setLocationRelativeTo(null); 
				colorDialog3.setVisible(true);
				dopColor2 = colorDialog3.getColor();
				
				ITransport inter = new LightPlane(7, 750, 1.50, 4100, color, true, true, dopColor, dopColor2);
				int place = airfield.PutPlaneInAirfield(inter);
				if (place > -1) {
					panel.updateAirfieldPanel(airfield);
					JOptionPane.showMessageDialog(null, "Ваше место: " + (place + 1), "",
					JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Нет мест", "", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		buttonSetLightPlane.setBounds(57, 500, 120, 23);
		frame.getContentPane().add(buttonSetLightPlane);
		
		JButton buttonTakePlane = new JButton("Забрать");
		buttonTakePlane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText() != "")
	            {
	                ITransport inter = airfield.GetPlaneFromAirfield(Integer.parseInt(textField.getText()) - 1);
	                if (inter != null) {
	                	inter.setPosition(10, 0);
	                	panel.updateAirfieldPanel(airfield);
	                	panel_1.updatePlane(inter);
	                } else {
	                	JOptionPane.showMessageDialog(null, "Самолета на этом месте нет", "", JOptionPane.INFORMATION_MESSAGE);
	                }
	            }
			}
		});
		buttonTakePlane.setBounds(491, 488, 89, 23);
		frame.getContentPane().add(buttonTakePlane);
		
		textField = new JTextField();
		textField.setBounds(491, 457, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\u041C\u0435\u0441\u0442\u043E:");
		label.setBounds(495, 432, 46, 14);
		frame.getContentPane().add(label);
		
		
	}
}
