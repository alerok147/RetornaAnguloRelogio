import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.util.GregorianCalendar;

public class RetornaAnguloRelogio {

	private JFrame frame;
	public JTextField txtHora;
	public JTextField txtMinuto;
	private JLabel lblResultado;
	private JLabel lblAngulo;
	public int hora, minuto;
	public double angulo;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RetornaAnguloRelogio window = new RetornaAnguloRelogio();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public RetornaAnguloRelogio() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 27));
		frame.setBounds(100, 100, 415, 484);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				try {
					
					hora = Integer.parseInt(txtHora.getText());
					minuto = Integer.parseInt(txtMinuto.getText());
					if ((hora > 24)||(minuto > 59)||(hora < 0)||(minuto < 0)) {
						JOptionPane.showMessageDialog(null, "Por favor, digite um número válido.", "Erro", 0);
					} else {
						if (hora > 12) {
								hora = hora - 12;
								angulo = (30 * hora) - (5.5 * minuto);
								angulo = Math.abs(angulo);
								lblResultado.setText(Double.toString(angulo));
								lblAngulo.setText("Ângulo entre potrenteiros:");
							} else {
								angulo = (30 * hora) - (5.5 * minuto);
								angulo = Math.abs(angulo);
								lblResultado.setText(Double.toString(angulo));
								lblAngulo.setText("Ângulo entre potrenteiros:");
							}
							
							if (angulo > 180) {
								angulo = 360 - angulo;
								lblResultado.setText(Double.toString(angulo));
								lblAngulo.setText("Ângulo entre potrenteiros:");
							} else {
								lblResultado.setText(Double.toString(angulo));
								lblAngulo.setText("Ângulo entre potrenteiros:");
							}
						}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Por favor, digite um número válido.","Erro", 0);
				}
			}
		});
		btnCalcular.setFont(new Font("Tahoma", Font.PLAIN, 27));
		btnCalcular.setBounds(34, 157, 156, 56);
		frame.getContentPane().add(btnCalcular);
		
		JLabel lblInsiraOHorrio = new JLabel("Insira o hor\u00E1rio:");
		lblInsiraOHorrio.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblInsiraOHorrio.setBounds(34, 11, 203, 69);
		frame.getContentPane().add(lblInsiraOHorrio);
		
		txtHora = new JTextField();
		txtHora.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtHora.setBounds(34, 95, 53, 35);
		frame.getContentPane().add(txtHora);
		txtHora.setColumns(10);
		
		txtMinuto = new JTextField();
		txtMinuto.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtMinuto.setColumns(10);
		txtMinuto.setBounds(173, 95, 53, 35);
		frame.getContentPane().add(txtMinuto);
		
		JLabel lblHoras = new JLabel("horas");
		lblHoras.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblHoras.setBounds(97, 95, 66, 35);
		frame.getContentPane().add(lblHoras);
		
		JLabel lblMinutos = new JLabel("minutos");
		lblMinutos.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblMinutos.setBounds(236, 95, 97, 35);
		frame.getContentPane().add(lblMinutos);
		
		lblAngulo = new JLabel("");
		lblAngulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAngulo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblAngulo.setBounds(34, 307, 332, 35);
		frame.getContentPane().add(lblAngulo);
		
		lblResultado = new JLabel("");
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setForeground(Color.RED);
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblResultado.setBounds(34, 369, 332, 35);
		frame.getContentPane().add(lblResultado);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				hora = 0;
				minuto = 0;
				angulo = 0;
				
				lblResultado.setText("");
				txtHora.setText("");
				txtMinuto.setText("");
				lblAngulo.setText("");
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 27));
		btnLimpar.setBounds(210, 157, 156, 56);
		frame.getContentPane().add(btnLimpar);
		
		JButton btnHorrioAtual = new JButton("Hor\u00E1rio Atual");
		btnHorrioAtual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GregorianCalendar horaG = new GregorianCalendar();
				hora = horaG.get(GregorianCalendar.HOUR);
				minuto = horaG.get(GregorianCalendar.MINUTE);
				txtHora.setText(Integer.toString(hora));
				txtMinuto.setText(Integer.toString(minuto));
			}
		});
		btnHorrioAtual.setFont(new Font("Tahoma", Font.PLAIN, 27));
		btnHorrioAtual.setBounds(34, 224, 332, 56);
		frame.getContentPane().add(btnHorrioAtual);
	}
}