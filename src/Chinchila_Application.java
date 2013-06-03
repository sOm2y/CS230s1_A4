import java.awt.EventQueue;

/**@version 1.00a
 * @author sOm2y
 * This program is made by yyin888
 */
public class Chinchila_Application {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chinchila_GUI frame = new Chinchila_GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
