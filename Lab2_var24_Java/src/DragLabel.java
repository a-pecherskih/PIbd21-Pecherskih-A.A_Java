import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;

import javax.swing.JLabel;


public class DragLabel  extends JLabel implements DragGestureListener, DragSourceListener{
	DragSource dragSource;
	
	public DragLabel(String text) {
		super(text);
		dragSource = new DragSource();
		dragSource.createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_COPY_OR_MOVE, this);
	}
	
	@Override
	public void dragDropEnd(DragSourceDropEvent arg0) {}

	@Override
	public void dragEnter(DragSourceDragEvent arg0) {}

	@Override
	public void dragExit(DragSourceEvent arg0) {}

	@Override
	public void dragOver(DragSourceDragEvent arg0) {}

	@Override
	public void dropActionChanged(DragSourceDragEvent arg0) {}

	@Override
	public void dragGestureRecognized(DragGestureEvent arg0) {
		Transferable transfer = new StringSelection(getText());
		dragSource.startDrag(arg0, DragSource.DefaultCopyDrop, transfer, this);		
	}
}
