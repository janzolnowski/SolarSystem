import planets.AnimationPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serial;

import javax.swing.*;


public class AppFrame extends JFrame implements ActionListener {

	@Serial
	private static final long serialVersionUID = 1L;
	public JButton pauseButton = new JButton("Pause");
	public JButton slowButton = new JButton("Slower");
	public JButton fastButton = new JButton("Faster");
	public JTextField text = new JTextField(10);
	public AnimationPanel animArea;
	public JPanel panel;

	public AppFrame() throws IOException {
		setTitle("Solar system");
		setSize(900, 830);
		setResizable(true);
		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		initGUI();
	}

	public void initGUI() throws IOException {
		this.setLayout(new BorderLayout());

		animArea = new AnimationPanel();

		this.add(animArea, BorderLayout.CENTER);

		panel = new JPanel();
		this.add(panel, BorderLayout.SOUTH);

		panel.add(pauseButton);
		panel.add(slowButton);
		panel.add(fastButton);
		panel.add(text);
		pauseButton.addActionListener(this);
		slowButton.addActionListener(this);
		fastButton.addActionListener(this);
		text.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (source == pauseButton) {
			animArea.switchAnimationState();
		}
		if (source == slowButton){
			animArea.slower();
		}
		if(source == fastButton){
			animArea.faster();
		}
		if (source == text){
			try {
				String t = text.getText();
				double v = Double.parseDouble(t);
				animArea.changeSpeed(v);}
			catch (Exception e){
				System.err.println("Błąd");
			}
		}
	}
}