import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JLabel;

import java.awt.Checkbox;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Form1 {

	private JFrame frame;
	JButton buttonClearPotatos;
	JButton buttonSlicePotatos;
	JButton buttonAddOil;
	JButton buttonAddPotatos;
	JButton buttonGetPotatos;
	JButton buttonPutPotatos;
	JButton buttonAddSalt;
	
	 private Potato[] potatos;
     private Salt salt;
     private WaterTap waterTap;
     private Knife knife;
     private Pan pan;
     private Stove stove;
     private Dish dish;
     private Oil oil;

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
		waterTap = new WaterTap();
        knife = new Knife();
        pan = new Pan();
        stove = new Stove();
        dish = new Dish();
        oil = new Oil();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Кухня");
		frame.setBounds(100, 100, 728, 522);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
				
		 Font font = new Font("Verdana", Font.BOLD, 11);
		 Border solidBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
		 ButtonGroup group = new ButtonGroup();
		
		JLabel label = new JLabel("\u041A\u0430\u0440\u0442\u043E\u0448\u043A\u0430");
		label.setBounds(35, 40, 74, 20);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u0421\u043E\u043B\u044C");
		label_1.setBounds(35, 71, 74, 20);
		frame.getContentPane().add(label_1);
		
		JCheckBox checkBoxHaveOil = new JCheckBox("\u041C\u0430\u0441\u043B\u043E");
		checkBoxHaveOil.setBounds(35, 98, 97, 23);
		frame.getContentPane().add(checkBoxHaveOil);
		
		JSpinner numericUpDownPotatos = new JSpinner();
		numericUpDownPotatos.setBounds(104, 40, 52, 20);
		frame.getContentPane().add(numericUpDownPotatos);
		
		JSpinner numericUpDownSalt = new JSpinner();
		numericUpDownSalt.setBounds(104, 71, 52, 20);
		frame.getContentPane().add(numericUpDownSalt);
		
		JRadioButton radioButtonOpen = new JRadioButton("\u041E\u0442\u043A\u0440\u044B\u0442\u044C");
		group.add(radioButtonOpen);
		radioButtonOpen.setBounds(207, 39, 79, 23);
		frame.getContentPane().add(radioButtonOpen);
		
		JRadioButton radioButtonClose = new JRadioButton("\u0417\u0430\u043A\u0440\u044B\u0442\u044C");
		group.add(radioButtonClose);
		radioButtonClose.setSelected(true);
		radioButtonClose.setBounds(207, 70, 79, 23);
		frame.getContentPane().add(radioButtonClose);
		
		JButton buttonWash = new JButton("\u041F\u043E\u043C\u044B\u0442\u044C \u043A\u0430\u0440\u0442\u043E\u0448\u043A\u0443");
		buttonWash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(radioButtonOpen.isSelected()){
					 waterTap.setState(true);
				}else{
					JOptionPane.showMessageDialog(frame, "Кран закрыт, как мыть?", "Ошибка логики",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				 if ((int)numericUpDownPotatos.getValue() > 0)
		            {
		                potatos = new Potato[(int)numericUpDownPotatos.getValue()];
		                pan.Init((int)numericUpDownPotatos.getValue());
		                for (int i = 0; i < potatos.length; ++i)
		                {
		                    potatos[i] = new Potato();
		                }
		                for (int i = 0; i < potatos.length; ++i)
		                {
		                    waterTap.Wash(potatos[i]);
		                }
		                numericUpDownPotatos.setEnabled(false);
		                radioButtonClose.setSelected(true);
		                buttonClearPotatos.setEnabled(true);
		                buttonSlicePotatos.setEnabled(true);
		                JOptionPane.showMessageDialog(null, "Картошку помыли, нужно теперь почистить", "Кухня",
								JOptionPane.INFORMATION_MESSAGE);		                
		            }
		            else
		            {
		            	JOptionPane.showMessageDialog(frame, "Картошки то нет, что мыть?", "Ошибка логики",
								JOptionPane.ERROR_MESSAGE);		               
		            }
			}
		});
		buttonWash.setBounds(290, 40, 157, 61);
		frame.getContentPane().add(buttonWash);
		
		buttonClearPotatos = new JButton("\u041F\u043E\u0447\u0438\u0441\u0442\u0438\u0442\u044C \u043A\u0430\u0440\u0442\u043E\u0448\u043A\u0443");
		buttonClearPotatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((int)numericUpDownPotatos.getValue() == 0)
	            {
	                if (potatos == null)
	                {
	                	JOptionPane.showMessageDialog(frame, "Картошки то нет, что чистить?", "Ошибка логики",
								JOptionPane.ERROR_MESSAGE);
	                	return;
	                }
	            }
	            else
	            if (potatos == null)
	            {
	            	JOptionPane.showMessageDialog(frame, "Картошки нужно помыть", "Ошибка логики",
							JOptionPane.ERROR_MESSAGE);
	            	return;
	            }

	            for (int i = 0; i < potatos.length; ++i)
	            {
	                knife.Clean(potatos[i]);
	            }
	            JOptionPane.showMessageDialog(null, "Картошку почистили", "Кухня",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		buttonClearPotatos.setBounds(507, 40, 157, 39);
		frame.getContentPane().add(buttonClearPotatos);
		
		buttonSlicePotatos = new JButton("\u041D\u0430\u0440\u0435\u0437\u0430\u0442\u044C \u043A\u0430\u0440\u0442\u043E\u0448\u043A\u0443");
		buttonSlicePotatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if ((int)numericUpDownPotatos.getValue() == 0)
		            {
		                if (potatos == null)
		                {
		                	JOptionPane.showMessageDialog(frame, "Картошки нет, что чистить?", "Ошибка логики",
									JOptionPane.ERROR_MESSAGE);
		                	return;
		                }
		            }
		            else
		               if (potatos == null)
		            {
		            	   JOptionPane.showMessageDialog(frame, "Картошки нужно помыть", "Ошибка логики",
									JOptionPane.ERROR_MESSAGE);
			            	return;
		            }

		            for (int i = 0; i < potatos.length; ++i)
		            {
		                if (potatos[i].getHave_skin())
		                {
		                    {
		                    	JOptionPane.showMessageDialog(frame, "Картошки нужно почистить", "Ошибка логики",
										JOptionPane.ERROR_MESSAGE);
				            	return;
		                    }
		                }

		            }

		            for (int i = 0; i < potatos.length; ++i)
		            {
		                {
		                    knife.Slice(potatos[i]);
		                }
		            }
		            JOptionPane.showMessageDialog(null, "Картошка готова к приготовлению!", "Кухня",
							JOptionPane.INFORMATION_MESSAGE);
			}
		});
		buttonSlicePotatos.setBounds(507, 86, 157, 39);
		frame.getContentPane().add(buttonSlicePotatos);

		JCheckBox checkBox1 = new JCheckBox("\u0412\u043A\u043B");
		checkBox1.setBounds(106, 197, 52, 23);
		frame.getContentPane().add(checkBox1);
		
		JButton buttonAddPan = new JButton("\u041F\u043E\u0441\u0442\u0430\u0432\u0438\u0442\u044C \u043A\u0430\u0441\u0442\u0440\u044E\u043B\u044E");
		buttonAddPan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 stove.setPan(pan);
		         buttonAddOil.setEnabled(true);
		         JOptionPane.showMessageDialog(null, "Кастрюлька на плите", "Кухня",
							JOptionPane.INFORMATION_MESSAGE);
			}
		});
		buttonAddPan.setBounds(40, 227, 173, 39);
		frame.getContentPane().add(buttonAddPan);
		
		JButton buttonCook = new JButton("\u0414\u043E\u0432\u0435\u0441\u0442\u0438 \u043C\u0430\u0441\u043B\u043E \u0434\u043E \u043A\u0438\u043F\u0435\u043D\u0438\u044F");
		buttonCook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkBox1.isSelected())
	            {
	                stove.setState(true);
	            }
				if (!stove.getState())
	            {
					JOptionPane.showMessageDialog(frame, "Плита выключена", "Ошибка логики",
							JOptionPane.ERROR_MESSAGE);
	            	return;
	            }
	            if (oil.getState())
	            {
	                stove.Cook();
	                JOptionPane.showMessageDialog(null, "Масло накалилось, можно добавлять картошку", "Кухня",
							JOptionPane.INFORMATION_MESSAGE);
	                buttonAddPotatos.setEnabled(true);
	                return;
	            }

	            else
	            {
	            	JOptionPane.showMessageDialog(frame, "Что-то пошло не так, картошка не сварилась", "Ошибка логики",
							JOptionPane.ERROR_MESSAGE);
	                return;
	            }
			}
		});
		buttonCook.setEnabled(false);
		buttonCook.setBounds(29, 277, 209, 39);
		frame.getContentPane().add(buttonCook);
		
		JButton buttonCookPotatos = new JButton("\u0413\u043E\u0442\u043E\u0432\u0438\u0442\u044C");
		buttonCookPotatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!pan.getReadyToGo())
	            {
					JOptionPane.showMessageDialog(frame, "У нас не все готово к варке!", "Ошибка логики",
							JOptionPane.ERROR_MESSAGE);
	                return;
	            }
	            stove.Cook();
	            if (stove.getPan().IsReady())
	            {
	                checkBox1.setSelected(false);
	                buttonGetPotatos.setEnabled(true);
	                JOptionPane.showMessageDialog(null, "Пожарилась", "Кухня",
							JOptionPane.INFORMATION_MESSAGE);
	            }
	            else
	            {
	            	JOptionPane.showMessageDialog(frame, "Что-то пошло не так, картошка не пожарилась", "Ошибка логики",
							JOptionPane.ERROR_MESSAGE);
	                return;
	            }
			}
		});
		buttonCookPotatos.setEnabled(false);
		buttonCookPotatos.setBounds(40, 359, 173, 39);
		frame.getContentPane().add(buttonCookPotatos);
		
		buttonAddOil = new JButton("\u041D\u0430\u043B\u0438\u0442\u044C \u043C\u0430\u0441\u043B\u043E");
		buttonAddOil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkBoxHaveOil.isSelected())
	            {
	                oil.setState(true);
	            }
				if (!oil.getState())
	            {
					JOptionPane.showMessageDialog(frame, "Масла нет, что добавлять?", "Ошибка логики",
							JOptionPane.ERROR_MESSAGE);
	            	return;
	            }
	            pan.InitOil();
	            for (int i = 0; i < 3; ++i)
	            {
	                pan.AddOil(oil.GetOil());
	            }
	            buttonCook.setEnabled(true);
	            checkBoxHaveOil.setEnabled(false);
	            JOptionPane.showMessageDialog(null, "Масло залили", "Кухня",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		buttonAddOil.setEnabled(false);
		buttonAddOil.setBounds(276, 227, 173, 39);
		frame.getContentPane().add(buttonAddOil);
		
		buttonAddPotatos = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C \u043A\u0430\u0440\u0442\u043E\u0448\u043A\u0443");
		buttonAddPotatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((int)numericUpDownPotatos.getValue() == 0)
	            {
	                if (potatos == null)
	                {
	                	JOptionPane.showMessageDialog(frame, "Картошки нет, что варить?", "Ошибка логики",
								JOptionPane.ERROR_MESSAGE);
	                	return;
	                }
	            }
	            else if (potatos == null)
	            {
	            	JOptionPane.showMessageDialog(frame, "Картошка грязная", "Ошибка логики",
							JOptionPane.ERROR_MESSAGE);
	                return;
	            }
	            if (potatos[0].getHave_skin())
	            {
	            	JOptionPane.showMessageDialog(frame, "Картошку нужно почистить", "Ошибка логики",
							JOptionPane.ERROR_MESSAGE);
	                return;
	            }
	            if (potatos[0].getHave_parts() < 10)
	            {
	            	JOptionPane.showMessageDialog(frame, "Картошку нужно нарезать", "Ошибка логики",
							JOptionPane.ERROR_MESSAGE);
	                return;
	            }

	            for (int i = 0; i < potatos.length; ++i)
	            {
	                pan.AddPotato(potatos[i]);
	            }
	            buttonCookPotatos.setEnabled(true);
	            JOptionPane.showMessageDialog(null, "Картошку добавили, можно готовить (Не забудьте, что готовится картошка очень быстро!)", "Кухня",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		buttonAddPotatos.setEnabled(false);
		buttonAddPotatos.setBounds(276, 277, 173, 39);
		frame.getContentPane().add(buttonAddPotatos);
		
		buttonGetPotatos = new JButton("\u0412\u044B\u043D\u0443\u0442\u044C \u043A\u0430\u0440\u0442\u043E\u0448\u043A\u0443");
		buttonGetPotatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				potatos = pan.GetPotatos();
	            dish.Init(potatos.length);
	            buttonPutPotatos.setEnabled(true);
	            JOptionPane.showMessageDialog(null, "Выкладываем вкусные чипсы на тарелку", "Кухня",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		buttonGetPotatos.setEnabled(false);
		buttonGetPotatos.setBounds(276, 359, 173, 39);
		frame.getContentPane().add(buttonGetPotatos);
		
		buttonPutPotatos = new JButton("\u0412\u044B\u043B\u043E\u0436\u0438\u0442\u044C \u043A\u0430\u0440\u0442\u043E\u0448\u043A\u0443");
		buttonPutPotatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < potatos.length; ++i)
	            {
	                dish.AddPotato(potatos[i]);
	            }
	            buttonAddSalt.setEnabled(true);
	            JOptionPane.showMessageDialog(null, "Домашние чипсы готовы! Соль добавить по вкусу", "Кухня",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		buttonPutPotatos.setEnabled(false);
		buttonPutPotatos.setBounds(498, 227, 173, 39);
		frame.getContentPane().add(buttonPutPotatos);
		
		buttonAddSalt = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C \u0441\u043E\u043B\u044C");
		buttonAddSalt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salt = new Salt();
	            salt.setCount((int)numericUpDownSalt.getValue());
	            if (salt.getCount() > 0)
	            {
	                dish.AddSalt(salt);
	                JOptionPane.showMessageDialog(null, "Соль добавлена", "Кухня",
							JOptionPane.INFORMATION_MESSAGE);
	            }
	            else
	            {
	            	JOptionPane.showMessageDialog(frame, "Соли нет, что добавлять?", "Ошибка логики",
							JOptionPane.ERROR_MESSAGE);
	            }
			}
		});
		buttonAddSalt.setEnabled(false);
		buttonAddSalt.setBounds(498, 277, 173, 39);
		frame.getContentPane().add(buttonAddSalt);
		
		JLabel label_2 = new JLabel("\u0418\u043D\u0433\u0440\u0435\u0434\u0438\u0435\u043D\u0442\u044B");
		label_2.setVerticalAlignment(SwingConstants.TOP);
		label_2.setHorizontalAlignment(JLabel.CENTER);
		label_2.setFont(font);
		label_2.setBorder(solidBorder);
		label_2.setBounds(21, 11, 157, 123);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u041A\u0440\u0430\u043D");
		label_3.setVerticalAlignment(SwingConstants.TOP);
		label_3.setHorizontalAlignment(JLabel.CENTER);
		label_3.setFont(font);
		label_3.setBorder(solidBorder);
		label_3.setBounds(188, 11, 278, 123);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\u041D\u043E\u0436");
		label_4.setVerticalAlignment(SwingConstants.TOP);
		label_4.setHorizontalAlignment(JLabel.CENTER);
		label_4.setFont(font);
		label_4.setBorder(solidBorder);
		label_4.setBounds(485, 11, 198, 123);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("\u041F\u043B\u0438\u0442\u0430");
		label_5.setVerticalAlignment(SwingConstants.TOP);
		label_5.setHorizontalAlignment(JLabel.CENTER);
		label_5.setFont(font);
		label_5.setBorder(solidBorder);
		label_5.setBounds(21, 163, 226, 248);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("\u041A\u0430\u0441\u0442\u0440\u044E\u043B\u044F");
		label_6.setVerticalAlignment(SwingConstants.TOP);
		label_6.setHorizontalAlignment(JLabel.CENTER);
		label_6.setFont(font);
		label_6.setBorder(solidBorder);
		label_6.setBounds(257, 163, 209, 248);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("\u0422\u0430\u0440\u0435\u043B\u043A\u0430");
		label_7.setVerticalAlignment(SwingConstants.TOP);
		label_7.setHorizontalAlignment(JLabel.CENTER);
		label_7.setFont(font);
		label_7.setBorder(solidBorder);
		label_7.setBounds(476, 163, 207, 248);
		frame.getContentPane().add(label_7);
				
	}
}
