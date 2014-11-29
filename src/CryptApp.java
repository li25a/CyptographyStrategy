import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/** Ashley Li
 *
 */
public class CryptApp {
	private static BaseCipher cipherChoice = new CopyCipher();

	public static void main(String[] args) {
		createGui();
	}

	public static void createGui() {
		JFrame f = new JFrame("Cyptography app");
		JPanel tablePanel = new JPanel();
		JTextArea plainTxt = new JTextArea(10, 25);
		JTextArea cipherTxt = new JTextArea(10, 25);
		JButton encryptB = new JButton("encrypt");
		JButton decryptB = new JButton("decrypt");
		JLabel plainL = new JLabel("plain text");
		JLabel cipherL = new JLabel("cipher text");
		String[] algStrings = { "Copy", "Caesar", "Rail Fence", "Atbash", "Vigenere" };
		JComboBox<String> chooseAlg = new JComboBox<String>(algStrings);
		tablePanel.setPreferredSize(new Dimension(400, 400));
		tablePanel.add(plainL);
		tablePanel.add(plainTxt, BorderLayout.NORTH);
		tablePanel.add(cipherL);
		tablePanel.add(cipherTxt, BorderLayout.SOUTH);
		tablePanel.add(encryptB);
		tablePanel.add(decryptB);
		tablePanel.add(chooseAlg);

		encryptB.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String encrypted = getCipherChoice()
						.encrypt(plainTxt.getText());
				assert encrypted != null;
				cipherTxt.setText(encrypted);
			}
		});
		decryptB.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String decrypted = getCipherChoice().decrypt(
						cipherTxt.getText());
				assert decrypted != null;
				plainTxt.setText(decrypted);
			}
		});

		chooseAlg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				String selectedAlg = (String) chooseAlg.getSelectedItem();

				if (selectedAlg.equals("Copy")) {
					setCipherChoice(new CopyCipher());
				} else if (selectedAlg.equals("Caesar")) {
					setCipherChoice(new CaesarCipher());
				} else if (selectedAlg.equals("Rail Fence")) {
					setCipherChoice(new RailFenceCipher());
				}
				else if (selectedAlg.equals("Atbash")) {
					setCipherChoice(new AtbashCipher());
				}
				else if (selectedAlg.equals("Vigenere")) {
					setCipherChoice(new VigenereCipher());
				}
			}
		});

		f.getContentPane().add(tablePanel);
		f.pack();
		f.setVisible(true);
	}

	private static BaseCipher getCipherChoice() {
		return cipherChoice;
	}

	private static void setCipherChoice(BaseCipher cipherChoice) {
		CryptApp.cipherChoice = cipherChoice;
	}
}
