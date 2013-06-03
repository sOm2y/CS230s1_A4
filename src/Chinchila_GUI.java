import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.DropMode;

/**
 * @version 1.00a
 * @author sOm2y This program is made by yyin888
 */
public class Chinchila_GUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewButton;
	private JCheckBox chckbxNewCheckBox;
	private JEditorPane dtrpnToBeOr_1;
	private JLabel lblUpdateTime;
	private JEditorPane dtrpnToBeOr;
	private JLabel lblNewLabel_4;
	private SwingWorker<Void, String> sw;

	/**
	 * Create the frame.
	 */
	public Chinchila_GUI() {
		setResizable(false);
		setTitle("ChinchilaWriter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 240, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("");
		label.setBackground(new Color(255, 239, 213));
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(
				"C:\\Users\\sOm2y\\Desktop\\\u6355\u83B7.PNG"));
		label.setBounds(0, 10, 319, 392);
		contentPane.add(label);

		JLabel lblBlackmenPerGeneration = new JLabel("Chinchila Per Generation");
		lblBlackmenPerGeneration.setFont(new Font("Buxton Sketch", Font.BOLD,
				16));
		lblBlackmenPerGeneration.setBounds(331, 20, 176, 23);
		contentPane.add(lblBlackmenPerGeneration);

		btnNewButton = new JButton("Start");
		btnNewButton.setActionCommand("Start");
		btnNewButton.addActionListener(this);
		btnNewButton.setForeground(new Color(240, 128, 128));
		btnNewButton.setBackground(new Color(255, 235, 205));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton.setBounds(331, 49, 93, 23);

		contentPane.add(btnNewButton);

		chckbxNewCheckBox = new JCheckBox("Parallel");
		chckbxNewCheckBox.setBackground(new Color(255, 235, 205));
		chckbxNewCheckBox.setBounds(439, 49, 103, 23);
		contentPane.add(chckbxNewCheckBox);

		dtrpnToBeOr = new JEditorPane();
		dtrpnToBeOr.setEnabled(false);
		dtrpnToBeOr.setBackground(new Color(255, 235, 205));
		dtrpnToBeOr.setEditable(false);
		dtrpnToBeOr.setBounds(331, 79, 331, 323);
		contentPane.add(dtrpnToBeOr);

		textField = new JTextField();
		textField.setText("2000");
		textField.setForeground(new Color(233, 150, 122));
		textField.setBackground(new Color(255, 235, 205));
		textField.setFont(new Font("Arial Black", Font.BOLD, 12));
		textField.setBounds(527, 19, 66, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		dtrpnToBeOr_1 = new JEditorPane();

		dtrpnToBeOr_1.setBackground(new Color(255, 235, 205));
		dtrpnToBeOr_1.setBounds(693, 79, 331, 323);
		contentPane.add(dtrpnToBeOr_1);

		JLabel lblNewLabel = new JLabel("Time");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(773, 10, 54, 15);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Generation");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setBounds(773, 32, 93, 15);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Generations/Second");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setBounds(773, 53, 150, 15);
		contentPane.add(lblNewLabel_2);

		lblUpdateTime = new JLabel("-");
		lblUpdateTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateTime.setBounds(936, 10, 54, 15);
		contentPane.add(lblUpdateTime);

		lblNewLabel_4 = new JLabel("-");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(936, 31, 54, 15);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("-");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(936, 53, 54, 15);
		contentPane.add(lblNewLabel_5);

	}

	public void actionPerformed(ActionEvent e) {
		
		JFrame frame = this;
		if (e.getSource() == btnNewButton) {
			if (btnNewButton.getActionCommand() == "Cancel") {
				sw.cancel(true);
				return;
			}

			final String tarContent = dtrpnToBeOr_1.getText();
			final String genContent = textField.getText();
			final int pop = Integer.parseInt(genContent);
			

			btnNewButton.setText("Cancel");
			btnNewButton.setActionCommand("Cancel");
			chckbxNewCheckBox.setEnabled(false);
			textField.setEnabled(false);
			dtrpnToBeOr_1.setEnabled(false);
			
			final boolean flag = chckbxNewCheckBox.isSelected();
			sw = new SwingWorker<Void, String>() {
				@Override
				protected Void doInBackground() throws Exception {
					Chinchila_Genetic_algorithm gal = new Chinchila_Genetic_algorithm();
					int x=0;
					int diffLagst = 0;
					int matchLagst =0;
					int genCounter=0;
					int[] curDiff = new int[pop];
					String[] curDNA = new String[pop];
					for(int i=0;i<pop;i++){
					String curChiChi = gal.generateRandomMonkey(
							tarContent.length(), gal.generateStrings());
					curDNA[i] = curChiChi;
				
					}
					while(!dtrpnToBeOr_1.getText().equals(dtrpnToBeOr.getText())){
						
						if (this.isCancelled())
							break;

						for (int i = 0; i < pop; i++) {
							
							
							if (diffLagst < gal.diff(tarContent, curDNA[i]))
								diffLagst = gal.diff(tarContent, curDNA[i]);
							curDiff[i] = gal.diff(tarContent, curDNA[i]);
							if(matchLagst<gal.match(tarContent, curDNA[i])){
								matchLagst=gal.match(tarContent, curDNA[i]);
								dtrpnToBeOr.setText(curDNA[i]);
							}
							
							
							
							
							if (i == (pop - 1)) {
								for (int j = 0; j < pop / 2; j++) {
									int mama = gal.randomParent(
											tarContent.length(), diffLagst,
											curDiff);
									int papa = gal.randomParent(
											tarContent.length(), diffLagst,
											curDiff);
									String mamaDNA = curDNA[mama];
									String papaDNA = curDNA[papa];
									gal.breeding(mamaDNA, papaDNA);
									curDNA[j] = mamaDNA;
									curDNA[j+pop/2] = papaDNA;
									System.out.println(j);
									
								}
								i=0;
//								
							lblNewLabel_4.setText(Integer.toString(genCounter++));
								
							}
							
						}
							if (x % 10 == 0) {

								publish(String.valueOf(x / 10));
							}

						
						x++;
						Thread.sleep(100);
					}
					dtrpnToBeOr.setBackground(Color.PINK);
					return null;
				}

				@Override
				protected void process(List<String> chunks) {
					// if (flag == true)
					lblUpdateTime.setText(chunks.get(0));

					super.process(chunks);
				}

				@Override
				protected void done() {
					lblUpdateTime.setText("Job done");

					btnNewButton.setText("Start");
					btnNewButton.setActionCommand("Start");
					chckbxNewCheckBox.setEnabled(true);
					textField.setEnabled(true);
					dtrpnToBeOr_1.setEnabled(true);
					
				}

			};

			try {
				if (pop < 1 || pop > 10000) {
					JOptionPane
							.showMessageDialog(frame,
									"CHINCHILAS CANNOT HAVE MORE THAN 10000 OR LESS THAN 1.");
					sw.cancel(true);
				}
				if (tarContent.length() > 300 || tarContent.length() < 1
						|| tarContent == null) {
					JOptionPane
							.showMessageDialog(frame,
									"CHINCHILA CANNOT TYPE MORE THAN 300 WORDS OR LESS THAN 1 WORDS!");
					sw.cancel(true);
				}
				byte[] b = tarContent.getBytes("US-ASCII");
				for (int i = 0; i < b.length; i++) {
					if (i != 10 && i != 13) {
						if (i < 32 && i > 126) {

							JOptionPane.showMessageDialog(frame,
									"CHINCHILA CAN ONLY READ ENGLISH!");
							sw.cancel(true);
							break;
						}
					}
				}
			} catch (Exception e1) {

			}
			sw.execute();
		}
	}
}