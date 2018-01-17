import java.awt.Graphics;
import javax.swing.JPanel;


public class PlanePanel extends DropPanel{
	private ITransport inter;
	
	public void updatePlane(ITransport inter){
		this.inter = inter;
		repaint();
	}
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
		if(inter != null){
			inter.drawPlane(g);
		}
	}
}
