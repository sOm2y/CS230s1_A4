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
	private JLabel lblNewLabel_5;
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
		contentPane.setBackground(new Color(0, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("");
		label.setBackground(new Color(255, 239, 213));
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon("Chinchila_DUDU.jpg"));
		label.setBounds(0, 10, 319, 392);
		contentPane.add(label);

		JLabel lblBlackmenPerGeneration = new JLabel("Chinchila Per Generation");
		lblBlackmenPerGeneration.setForeground(new Color(204, 204, 153));
		lblBlackmenPerGeneration.setFont(new Font("Buxton Sketch", Font.BOLD,
				16));
		lblBlackmenPerGeneration.setBounds(331, 20, 176, 23);
		contentPane.add(lblBlackmenPerGeneration);

		btnNewButton = new JButton("Start");
		btnNewButton.setActionCommand("Start");
		btnNewButton.addActionListener(this);
		btnNewButton.setForeground(new Color(255, 102, 102));
		btnNewButton.setBackground(new Color(204, 204, 153));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton.setBounds(331, 49, 93, 23);

		contentPane.add(btnNewButton);

		chckbxNewCheckBox = new JCheckBox("Parallel");
		chckbxNewCheckBox.setForeground(new Color(255, 102, 102));
		chckbxNewCheckBox.setBackground(new Color(204, 204, 153));
		chckbxNewCheckBox.setBounds(439, 49, 103, 23);
		contentPane.add(chckbxNewCheckBox);

		dtrpnToBeOr = new JEditorPane();
		dtrpnToBeOr.setEnabled(false);
		dtrpnToBeOr.setBackground(new Color(204, 204, 153));
		dtrpnToBeOr.setEditable(false);
		dtrpnToBeOr.setBounds(331, 79, 331, 323);
		contentPane.add(dtrpnToBeOr);

		textField = new JTextField();
		textField.setText("2000");
		textField.setForeground(new Color(233, 150, 122));
		textField.setBackground(new Color(204, 204, 153));
		textField.setFont(new Font("Arial Black", Font.BOLD, 12));
		textField.setBounds(527, 19, 66, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		dtrpnToBeOr_1 = new JEditorPane();
		dtrpnToBeOr_1.setText("To be or not to be, that is the question; Whether 'tis nobler in the mind to suffer The slings and arrows of outrageous fortune, Or to take arms against a sea of troubles, And by opposing, end them.");

		dtrpnToBeOr_1.setBackground(new Color(204, 204, 153));
		dtrpnToBeOr_1.setBounds(693, 79, 331, 323);
		contentPane.add(dtrpnToBeOr_1);

		JLabel lblNewLabel = new JLabel("Time");
		lblNewLabel.setForeground(new Color(204, 204, 153));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(773, 10, 54, 15);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Generation");
		lblNewLabel_1.setForeground(new Color(204, 204, 153));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setBounds(773, 32, 93, 15);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Generations/Second");
		lblNewLabel_2.setForeground(new Color(204, 204, 153));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setBounds(773, 53, 150, 15);
		contentPane.add(lblNewLabel_2);

		lblUpdateTime = new JLabel("-");
		lblUpdateTime.setForeground(new Color(204, 204, 153));
		lblUpdateTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateTime.setBounds(936, 10, 54, 15);
		contentPane.add(lblUpdateTime);

		lblNewLabel_4 = new JLabel("-");
		lblNewLabel_4.setForeground(new Color(204, 204, 153));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(936, 31, 54, 15);
		contentPane.add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("-");
		lblNewLabel_5.setForeground(new Color(204, 204, 153));
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

			final String tarContent = dtrpnToBeOr_1.getText();		//get input text
			final String genContent = textField.getText();			//generation of chinchila
			final int pop = Integer.parseInt(genContent);			//change string to int
			

			btnNewButton.setText("Cancel");
			btnNewButton.setActionCommand("Cancel");
			chckbxNewCheckBox.setEnabled(false);
			textField.setEnabled(false);
			dtrpnToBeOr_1.setEnabled(false);
			dtrpnToBeOr.setBackground(new Color(255, 235, 205));	
			
			final boolean flag = chckbxNewCheckBox.isSelected();
			
			sw = new SwingWorker<Void, String>() {
				@Override
				protected Void doInBackground() throws Exception {
					Chinchila_Genetic_algorithm gal = new Chinchila_Genetic_algorithm();
					int x=0;
					int diffLagst = 0;
					int matchLagst =0;
					int genCounter=0;
					int[] curDiff = new int[pop];			//set array size of  fitness for each chinchila 
					String[] curDNA = new String[pop];		//set random string array size
					
					for(int i=0;i<pop;i++){
					String curChiChi = gal.generateRandomMonkey(
							tarContent.length(), gal.generateStrings());
					curDNA[i] = curChiChi;
				
					}										//set random string to each chinchila DNA
					
					
					
					for (int i = 0; i < pop; i++) {	
							if (this.isCancelled())
								break;
							if(dtrpnToBeOr_1.getText().equals(dtrpnToBeOr.getText()))
								break;
							if (diffLagst < gal.diff(tarContent, curDNA[i]))	//find largest difference of this generation
								diffLagst = gal.diff(tarContent, curDNA[i]);		
							
							curDiff[i] = gal.diff(tarContent, curDNA[i]);		//store current difference to array
							
							if(matchLagst<gal.match(tarContent, curDNA[i])){	//find best match of this generation
								matchLagst=gal.match(tarContent, curDNA[i]);	//and set it on GUI
								dtrpnToBeOr.setText(curDNA[i]);					
							}	

							if (i == (pop - 1)) {		
								String newGeneDNA[]=new String[pop];
								int newGenIndex =0;//if it's the last chinchila of this generation
								for (int j = 0; j < pop / 2; j++) {
									
									int mama = gal.randomParent(				//select random mama and papa from this generation
											tarContent.length(), diffLagst,
											curDiff);
									int papa = gal.randomParent(
											tarContent.length(), diffLagst,
											curDiff);
									String mamaDNA = curDNA[mama];				//get string of this Index in curDNA array
									String papaDNA = curDNA[papa];
												
									curDNA[mama]= gal.breeding(mamaDNA);
									//newGenIndex++;
									curDNA[papa] = gal.breeding(papaDNA);	
									//newGenIndex++;
									//System.out.println(j);									
								}
							genCounter++;
							
							i=0;//recycle
							lblNewLabel_4.setText(Integer.toString(genCounter));					
							}							
						}
						
							if (x % 10 == 0) {
								publish(String.valueOf(x / 10));
								
							}
						
						
						//Thread.sleep(100);
					
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