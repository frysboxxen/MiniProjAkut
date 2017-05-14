import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTable table;


	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		JButton btnStart = new JButton("Start");
		btnStart.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnPause = new JButton("Paus");
		btnPause.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnndraPrio = new JButton("Ändra Prio");
		btnndraPrio.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNewLabel = new JLabel("Itterarion:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblDoktor = new JLabel("Doktor:");
		lblDoktor.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblPatient = new JLabel("Patient:");
		lblPatient.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblInfo = new JLabel("Info:");
		lblInfo.setFont(new Font("Tahoma", Font.BOLD, 17));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnStart, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 105, Short.MAX_VALUE)
						.addComponent(btnPause, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
						.addComponent(btnndraPrio, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
						.addComponent(lblDoktor, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
						.addComponent(lblPatient, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
						.addComponent(lblInfo, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnStart)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnPause)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnndraPrio)
					.addPreferredGap(ComponentPlacement.RELATED, 477, Short.MAX_VALUE)
					.addComponent(lblInfo, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblDoktor, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPatient, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addGap(19))
		);
		panel.setLayout(gl_panel);
		String[] heading = {"Prioritet", "Namn", "Diagnos"};
		table = new JTable();
		
		JLabel lblK = new JLabel("Kö:");
		lblK.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		Box horizontalBox = Box.createHorizontalBox();
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		
		JLabel lblHosDoktor = new JLabel("Hos doktor:");
		lblHosDoktor.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblIReceptionen = new JLabel("I receptionen:");
		lblIReceptionen.setFont(new Font("Tahoma", Font.BOLD, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(56)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(horizontalBox, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblHosDoktor, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
							.addGap(215)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(horizontalBox_1, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblIReceptionen, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(table, GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
								.addComponent(lblK, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHosDoktor, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIReceptionen, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(horizontalBox, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblK))
						.addComponent(horizontalBox_1, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
					.addGap(20))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
