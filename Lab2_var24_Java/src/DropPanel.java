import java.awt.Color;
import java.awt.Graphics;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;

import javax.swing.JPanel;


public class DropPanel extends JPanel implements DropTargetListener{
	private ITransport plane;

	public DropPanel() {
		new DropTarget(this, this);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (plane != null) {
			plane.drawPlane(g);
		}
	}
	
	public ITransport getPlane() {
		return plane;
	}
	
	public void setPlane(ITransport p) {
		this.plane = p;
	}
	
	@Override
	public void dragEnter(DropTargetDragEvent dtde) {
		if (dtde.getTransferable().isDataFlavorSupported(DataFlavor.stringFlavor)) {
			dtde.acceptDrag(DnDConstants.ACTION_COPY);
		} else {
			dtde.acceptDrag(DnDConstants.ACTION_NONE);
		}
	}

	@Override
	public void dragExit(DropTargetEvent dte) {}

	@Override
	public void dragOver(DropTargetDragEvent dtde) {}

	@Override
	public void drop(DropTargetDropEvent dtde) {
		try {
			Transferable transferable = dtde.getTransferable();
			if (transferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {
				switch ((String) transferable.getTransferData(DataFlavor.stringFlavor)) {
				case "Plane":
					plane = new Plane(7, 750, 1.50, 4100, Color.WHITE, Color.BLACK);
					break;
				case "LightPlane":
					plane = new LightPlane(7, 750, 1.50, 4100, Color.WHITE, true, true, Color.BLACK, Color.RED);
					break;
				}
				repaint();
			} else {
				dtde.rejectDrop();
			}
		} catch (Exception e) {
			dtde.rejectDrop();
		}
	}

	@Override
	public void dropActionChanged(DropTargetDragEvent dtde) {}
}
