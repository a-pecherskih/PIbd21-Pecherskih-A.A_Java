import java.awt.Graphics;
import javax.swing.JPanel;


public class AirfieldPanel extends JPanel {
	private Airfield airfield;
	
	public AirfieldPanel(Airfield airfield){
		updateAirfieldPanel(airfield);
	}
	
	public void updateAirfieldPanel(Airfield airfield){
		this.airfield = airfield;
		repaint();
	}
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
		airfield.Draw(g);
	}
}
