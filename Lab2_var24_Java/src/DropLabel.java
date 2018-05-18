import java.awt.Color;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class DropLabel extends JLabel implements DropTargetListener{

	public DropLabel(String s) {
		super(s);
		new DropTarget(this, this);
	}
	
	@Override
	public void dragEnter(DropTargetDragEvent arg0) {
		if (arg0.getTransferable().isDataFlavorSupported(DataColor.colorFlavor)) {
			arg0.acceptDrag(DnDConstants.ACTION_COPY);
		} else {
			arg0.acceptDrag(DnDConstants.ACTION_NONE);
		}
	}

	@Override
	public void dragExit(DropTargetEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dragOver(DropTargetDragEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drop(DropTargetDropEvent arg0) {
		try {
			Transferable transferable = arg0.getTransferable();
			if (transferable.isDataFlavorSupported(DataColor.colorFlavor)) {
				Color color = (Color) transferable.getTransferData(DataColor.colorFlavor);
				setBackground(color);
				ITransport plane = ((DropPanel) getLabelFor()).getPlane();
				if (plane != null)
					if (getText() == "Color") {
						plane.setMainColor(color);
					} else if (getText() == "DopColor") {
						if (plane instanceof LightPlane) {
							((LightPlane) plane).setDopColor(color);
						}
					}
				if (getLabelFor() instanceof JPanel) {
					((JPanel) getLabelFor()).repaint();
				}

			} else {
				arg0.rejectDrop();
			}
		} catch (Exception e) {
			arg0.rejectDrop();
		}	
	}

	@Override
	public void dropActionChanged(DropTargetDragEvent arg0) {}

}
