import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EstudianteForm {
    private JFrame frame;
    private JTextField nombreField;
    private JTextField apellidoField;
    private JTextField cedulaField;
    private JTextField edadField;
    private JTextArea resultadoArea;
    private JButton registrarButton;
    private JButton limpiarButton;

    public EstudianteForm() {

        frame = new JFrame("Registro de Estudiante");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);


        JLabel nombreLabel = new JLabel("Nombre:");
        nombreField = new JTextField(20);

        JLabel apellidoLabel = new JLabel("Apellido:");
        apellidoField = new JTextField(20);

        JLabel cedulaLabel = new JLabel("Cédula:");
        cedulaField = new JTextField(20);

        JLabel edadLabel = new JLabel("Edad:");
        edadField = new JTextField(20);

        registrarButton = new JButton("Registrar");
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarEstudiante();
            }
        });

        limpiarButton = new JButton("Limpiar");
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });

        resultadoArea = new JTextArea(5, 20);
        resultadoArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultadoArea);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        frame.add(nombreLabel, gbc);

        gbc.gridx = 1;
        frame.add(nombreField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(apellidoLabel, gbc);

        gbc.gridx = 1;
        frame.add(apellidoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(cedulaLabel, gbc);

        gbc.gridx = 1;
        frame.add(cedulaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        frame.add(edadLabel, gbc);

        gbc.gridx = 1;
        frame.add(edadField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(registrarButton, gbc);

        gbc.gridy = 5;
        frame.add(limpiarButton, gbc);

        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.BOTH;
        frame.add(scrollPane, gbc);


        frame.setVisible(true);
    }

    private void registrarEstudiante() {
        String nombre = nombreField.getText();
        String apellido = apellidoField.getText();
        String cedula = cedulaField.getText();
        int edad = Integer.parseInt(edadField.getText());

        Estudiante estudiante = new Estudiante(nombre, apellido, cedula, edad);
        resultadoArea.setText(estudiante.toString());
    }

    private void limpiarCampos() {
        nombreField.setText("");
        apellidoField.setText("");
        cedulaField.setText("");
        edadField.setText("");
        resultadoArea.setText("");
    }

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }


        new EstudianteForm();
    }
}
