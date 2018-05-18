import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;


public class Form1 {

	private JFrame frame;

	private Airfield airfield;
	private AirfieldPanel panel;
	JList list = new JList();;
	Color color;
 	Color dopColor;
 	Color dopColor2;
 	private JTextField textField;
 	Form2 form2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form1 window = new Form1();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);
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
		airfield = new Airfield(5);
		
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for(int i = 1; i < 6; i++){
			list = new JList<>(listModel);
			listModel.addElement("Уровень " + i);
		}	
		initialize();	
		list.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		list.setSelectedIndex(airfield.getCurrentLevel());
		color = Color.WHITE;
        dopColor = Color.YELLOW;
        dopColor2 = Color.RED;
        Draw();
	}
	
	private void Draw(){
		if(list.getSelectedIndex() > -1){
			panel.updateAirfieldPanel(airfield);
		}
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Airfield");
		frame.setBounds(100, 100, 950, 608);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new AirfieldPanel(airfield);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 756, 435);
		frame.getContentPane().add(panel);
		
		PlanePanel panel_1 = new PlanePanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(749, 446, 137, 112);
		frame.getContentPane().add(panel_1);
		
		JButton buttonSetPlane = new JButton("Set plane");
		buttonSetPlane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				form2 = new Form2(frame);
				if(form2.Execute()){
					ITransport plane = form2.getPlane();
					if(plane == null){
						return;
					}
				int place = airfield.PutPlaneInAirfield(plane);
				if (place > -1) {
					panel.updateAirfieldPanel(airfield);
					JOptionPane.showMessageDialog(null, "Ваше место: " + (place + 1), "",
					JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Нет мест", "", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			}});
		buttonSetPlane.setBounds(766, 257, 120, 23);
		frame.getContentPane().add(buttonSetPlane);
		
		
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
		buttonTakePlane.setBounds(777, 412, 89, 23);
		frame.getContentPane().add(buttonTakePlane);
		
		textField = new JTextField();
		textField.setBounds(780, 378, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\u041C\u0435\u0441\u0442\u043E:");
		label.setBounds(803, 353, 46, 14);
		frame.getContentPane().add(label);
		
		list.setBounds(774, 11, 150, 160);
		frame.getContentPane().add(list);
		
		JButton buttonDown = new JButton("<<");
		buttonDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				airfield.LevelDown();
				list.setSelectedIndex(airfield.getCurrentLevel());
				Draw();
			}
		});
		buttonDown.setBounds(760, 203, 49, 31);
		frame.getContentPane().add(buttonDown);
		
		JButton buttonUp = new JButton(">>");
		buttonUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				airfield.LevelUp();
				list.setSelectedIndex(airfield.getCurrentLevel());
				Draw();
			}
		});
		buttonUp.setBounds(829, 203, 49, 31);
		frame.getContentPane().add(buttonUp);	
		
	}
}
