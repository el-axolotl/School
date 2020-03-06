package mastermind;

/**
 * Creates Marble Objects.
 * @author chris munoz & kim soto!
 *
 */
public class Marble {
	private MarbleColor color;
	
	public Marble(MarbleColor color) {
		this.color = color;
	}
	
	public MarbleColor getColor() {
		return color;
	}
}
