import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;

	public Ventana() {
		this.setVisible(true);
		this.setTitle("Registro de Usuarios");
		this.setSize(1000, 700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		this.iniciarComponentes();
	}

	private void iniciarComponentes() {
		this.registroUsuarios();
		this.repaint();
		this.validate();
	}

	public void bordes(JPanel panel) {
		JLabel izquierda = new JLabel("    ");
		izquierda.setSize(300, 1);
		panel.add(izquierda, BorderLayout.WEST);

		JLabel derecha = new JLabel("    ");
		derecha.setSize(300, 1);
		panel.add(derecha, BorderLayout.EAST);

		JLabel abajo = new JLabel("    ");
		abajo.setSize(300, 1);
		panel.add(abajo, BorderLayout.SOUTH);

	}

	public void registroUsuarios() {
		JLabel blanco = new JLabel(" ");
		this.setSize(800, 700);
		this.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, this.getWidth() - 15, this.getHeight() - 38);
		panel.setBackground(Color.green);
		panel.setLayout(new BorderLayout());

		JLabel registro_tag = new JLabel("    Registro de Usuarios");
		registro_tag.setForeground(Color.red);
		registro_tag.setOpaque(false);
		registro_tag.setFont(new Font("", Font.ITALIC, 21));
		panel.add(registro_tag, BorderLayout.NORTH);

		this.bordes(panel);

		JPanel panel_centro = new JPanel();
		panel_centro.setBackground(Color.green);
		panel_centro.setLayout(new GridLayout(2, 2, 10, 10));
		panel.add(panel_centro, BorderLayout.CENTER);

		JPanel panel_datos = new JPanel();
		panel_datos.setLayout(new BorderLayout());
		panel_datos.setBackground(Color.decode("#74FFAD"));
		panel_centro.add(panel_datos);

		JLabel datos_gen_tag = new JLabel("  Datos Generales");
		datos_gen_tag.setFont(new Font("", Font.BOLD, 15));
		panel_datos.add(datos_gen_tag, BorderLayout.NORTH);

		JPanel datos_gen_centro = new JPanel();
		datos_gen_centro.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		datos_gen_centro.setOpaque(false);
		datos_gen_centro.setLayout(new GridLayout(7, 2, 5, 5));
		panel_datos.add(datos_gen_centro, BorderLayout.CENTER);
		this.bordes(panel_datos);

		JLabel nombre_tag = new JLabel("Nombre(s):", 0);
		nombre_tag.setFont(new Font("", Font.BOLD, 15));
		JTextField nombre_txt = new JTextField();

		JLabel aP_tag = new JLabel("Apellido Paterno:", 0);
		aP_tag.setFont(new Font("", Font.BOLD, 15));
		JTextField aP_txt = new JTextField();

		JLabel aM_tag = new JLabel("Apellido Maerno:", 0);
		aM_tag.setFont(new Font("", Font.BOLD, 15));
		JTextField aM_txt = new JTextField();

		JLabel fecha_tag = new JLabel("Fecha de nacimiento:", 0);
		fecha_tag.setFont(new Font("", Font.BOLD, 15));
		JTextField fecha_txt = new JTextField();

		JLabel sexo_tag = new JLabel("Sexo:", 0);
		sexo_tag.setFont(new Font("", Font.BOLD, 15));
		JRadioButton sexo_rb = new JRadioButton("Masculino");
		sexo_rb.setOpaque(false);
		JRadioButton sexo_rb2 = new JRadioButton("Femenino");
		sexo_rb2.setOpaque(false);
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(sexo_rb);
		grupo.add(sexo_rb2);

		JLabel nacionalidad_tag = new JLabel("Nacionalidad:", 0);
		nacionalidad_tag.setFont(new Font("", Font.BOLD, 15));

		String nacion[] = { "México", "Perú", "Estados Unidos" };
		JComboBox nacionalidad_txt = new JComboBox(nacion);

		Object arreglo[] = { nombre_tag, nombre_txt, aP_tag, aP_txt, aM_tag, aM_txt, fecha_tag, fecha_txt, sexo_tag,
				sexo_rb, blanco, sexo_rb2, nacionalidad_tag, nacionalidad_txt };

		for (int i = 0; i < arreglo.length; i++) {
			datos_gen_centro.add((Component) arreglo[i]);
		}

		JPanel panel_usuario = new JPanel();
		panel_usuario.setBackground(Color.decode("#FFA074"));
		panel_usuario.setLayout(new BorderLayout());
		panel_centro.add(panel_usuario);

		JLabel perfil_tag = new JLabel("  Perfíl del Usuario");
		perfil_tag.setFont(new Font("", Font.BOLD, 15));
		panel_usuario.add(perfil_tag, BorderLayout.NORTH);

		this.bordes(panel_usuario);

		JPanel perfil_centro = new JPanel();
		perfil_centro.setOpaque(false);
		perfil_centro.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		perfil_centro.setLayout(new BoxLayout(perfil_centro, BoxLayout.Y_AXIS));
		panel_usuario.add(perfil_centro, BorderLayout.CENTER);

		ImageIcon imagen_usuario = new ImageIcon(getClass().getResource("hombre.png"));
		JLabel user_img = new JLabel(" ");
		user_img.setSize(150, 150);
		user_img.setIcon(new ImageIcon(imagen_usuario.getImage().getScaledInstance(user_img.getWidth(),
				user_img.getHeight(), Image.SCALE_SMOOTH)));
		perfil_centro.add(user_img);

		blanco.setOpaque(false);
		perfil_centro.add(blanco);
		perfil_centro.add(blanco);

		JCheckBox mostrar_foto = new JCheckBox("Mostrar foto de perfil");
		mostrar_foto.setSelected(true);
		mostrar_foto.setOpaque(false);
		mostrar_foto.setFont(new Font("", Font.BOLD, 15));
		perfil_centro.add(mostrar_foto);

		JCheckBox mostrar_fecha = new JCheckBox("Mostrar fecha de nacimiento");
		mostrar_fecha.setSelected(false);
		mostrar_fecha.setOpaque(false);
		mostrar_fecha.setFont(new Font("", Font.BOLD, 15));
		perfil_centro.add(mostrar_fecha);

		JPanel panel_opcionales = new JPanel();
		panel_opcionales.setBackground(Color.decode("#FF7474"));
		panel_centro.add(panel_opcionales);

		JPanel panel_botones = new JPanel();
		panel_botones.setLayout(null);
		panel_botones.setBackground(Color.decode("#74FFAD"));
		panel_centro.add(panel_botones);

		JButton nuevo = new JButton("Nuevo");
		nuevo.setBounds(125, 50, 120, 40);
		nuevo.setForeground(Color.white);
		nuevo.setFont(new Font("", Font.BOLD, 15));
		nuevo.setBackground(Color.DARK_GRAY);
		panel_botones.add(nuevo);

		JButton guardar = new JButton("Guardar");
		guardar.setBounds(125, 120, 120, 40);
		guardar.setForeground(Color.white);
		guardar.setFont(new Font("", Font.BOLD, 15));
		guardar.setBackground(Color.DARK_GRAY);
		panel_botones.add(guardar);

		JButton salir = new JButton("Salir");
		salir.setBounds(125, 190, 120, 40);
		salir.setForeground(Color.white);
		salir.setFont(new Font("", Font.BOLD, 15));
		salir.setBackground(Color.DARK_GRAY);
		panel_botones.add(salir);

		this.add(panel);
	}
}
