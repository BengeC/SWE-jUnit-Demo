package calcSimpleExc;

// Exception-Klasse die vom Calculator geworfen wird.
// Ist eine checked Exception => muss gefangen oder deklariert werden
public class CalculationException  extends Exception{

	private static final long serialVersionUID = 1L;
	
	public CalculationException(String msg) {
		super(msg);
	}

	public CalculationException(String msg, Exception cause) {
		super(msg, cause);
	}
}
