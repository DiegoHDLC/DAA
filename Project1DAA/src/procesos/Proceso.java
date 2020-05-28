package procesos;

public class Proceso {
	public Proceso() {
		// TODO Auto-generated constructor stub
	}
	
	public static void dormir(int tiempoDormir) {
		try {
			Thread.sleep(tiempoDormir);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

}
