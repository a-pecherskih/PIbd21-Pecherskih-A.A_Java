import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;


public class Form2 extends JDialog{
	ITransport plane = null;
	DropPanel panel = new DropPanel();
	private boolean r;

	public Form2(JFrame parent) {
		super(parent, true);
		getContentPane().setLayout(null);
		initialize();
	}

	public boolean Execute() {
		setVisible(true);
		return r;
	}

	public ITransport getPlane() {
		return panel.getPlane();
	}

	private void initialize() {
		setBounds(100, 100, 500, 500);
		setLocationRelativeTo(null);
		setTitle("Выбор машины");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		DragLabel planeLabel = new DragLabel("Plane");
		planeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		planeLabel.setBounds(10, 50, 100, 35);
		planeLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(planeLabel);

		DragLabel LightPlaneLabel = new DragLabel("LightPlane");
		LightPlaneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		LightPlaneLabel.setBounds(10, 100, 100, 35);
		LightPlaneLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(LightPlaneLabel);
		
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(150, 25, 150, 150);
		getContentPane().add(panel);

		DropLabel labelMainColor = new DropLabel("Color");
		labelMainColor.setHorizontalAlignment(SwingConstants.CENTER);
		labelMainColor.setLabelFor(panel);
		labelMainColor.setBorder(new LineBorder(new Color(0, 0, 0)));
		labelMainColor.setBounds(180, 185, 100, 40);
		getContentPane().add(labelMainColor);

		DropLabel labelDopColor = new DropLabel("DopColor");
		labelDopColor.setHorizontalAlignment(SwingConstants.CENTER);
		labelDopColor.setLabelFor(panel);
		labelDopColor.setBorder(new LineBorder(new Color(0, 0, 0)));
		labelDopColor.setBounds(180, 235, 100, 40);
		getContentPane().add(labelDopColor);

		DragPanel RED = new DragPanel();
		RED.setBackground(Color.RED);	
		RED.setBounds(320, 25, 40, 40);
		getContentPane().add(RED);
		
		DragPanel GREEN = new DragPanel();
		GREEN.setBackground(Color.GREEN);
		GREEN.setBounds(375, 25, 40, 40);
		getContentPane().add(GREEN);

		DragPanel YELLOW = new DragPanel();
		YELLOW.setBackground(Color.YELLOW);
		YELLOW.setBounds(320, 75, 40, 40);
		getContentPane().add(YELLOW);

		DragPanel MAGENTA = new DragPanel();
		MAGENTA.setBackground(Color.MAGENTA);
		MAGENTA.setBounds(375, 75, 40, 40);
		getContentPane().add(MAGENTA);		

		DragPanel BLUE = new DragPanel();
		BLUE.setBackground(Color.BLUE);
		BLUE.setBounds(320, 125, 40, 40);
		getContentPane().add(BLUE);

		DragPanel CYAN = new DragPanel();
		CYAN.setBackground(Color.CYAN);
		CYAN.setBounds(375, 125, 40, 40);
		getContentPane().add(CYAN);

		DragPanel ORANGE = new DragPanel();
		ORANGE.setBackground(Color.ORANGE);
		ORANGE.setBounds(320, 175, 40, 40);
		getContentPane().add(ORANGE);

		DragPanel BLACK = new DragPanel();
		BLACK.setBackground(Color.BLACK);
		BLACK.setBounds(375, 175, 40, 40);
		getContentPane().add(BLACK);

		JButton buttonAdd = new JButton("Добавить");
		buttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				r = true;
				dispose();
			}
		});
		buttonAdd.setBounds(10, 175, 100, 35);
		getContentPane().add(buttonAdd);
		
		JButton buttonCancel = new JButton("Отмена");
		buttonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r = false;
				dispose();
			}
		});
		buttonCancel.setBounds(10, 220, 100, 35);
		getContentPane().add(buttonCancel);

		
	}
}
