import java.awt.Color;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;


public class DataColor implements Transferable{
	public final static DataFlavor colorFlavor = new DataFlavor(java.awt.Color.class, "Color");
	private final static DataFlavor[] supportedFlavors = { colorFlavor };
	Color color;
	
	public DataColor(Color color) {
		this.color = color;
	}
	
	@Override
	public Object getTransferData(DataFlavor flavor)
			throws UnsupportedFlavorException, IOException {
		if (flavor.equals(colorFlavor))
			return color;
		else
			throw new UnsupportedFlavorException(flavor);
	}

	@Override
	public DataFlavor[] getTransferDataFlavors() {
		return (DataFlavor[]) supportedFlavors.clone();
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		// TODO Auto-generated method stub
		if (flavor.equals(colorFlavor))
			return true;
		return false;
	}
}
