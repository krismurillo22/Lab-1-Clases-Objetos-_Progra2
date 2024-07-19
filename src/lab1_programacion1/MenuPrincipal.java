/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1_programacion1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Administrator
 */

public class MenuPrincipal {
    private static EmailAccount[] accounts = new EmailAccount[10]; // Arreglo de cuentas
    private static int accountCount = 0; // Número actual de cuentas
    private static EmailAccount cuentaActual = null;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MenuPrincipal::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Sistema de Correo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        mostrarMenuLogin(frame);

        frame.setVisible(true);
    }

    private static void mostrarMenuLogin(JFrame frame) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Sistema de Correo");
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton botonLogin = new JButton("LOGIN");
        botonLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login(frame);
            }
        });

        JButton botonCrearCuenta = new JButton("CREAR");
        botonCrearCuenta.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonCrearCuenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearCuenta(frame);
            }
        });

        panel.add(Box.createRigidArea(new Dimension(0, 50)));
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(botonLogin);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(botonCrearCuenta);

        frame.setContentPane(panel);
        frame.revalidate();
        frame.repaint();
    }

    private static void mostrarMenuPrincipal(JFrame frame) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Menú Principal");
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton botonVerInbox = new JButton("VER MI INBOX");
        botonVerInbox.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonVerInbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verInbox();
            }
        });

        JButton botonMandarCorreo = new JButton("MANDAR CORREO");
        botonMandarCorreo.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonMandarCorreo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mandarCorreo();
            }
        });

        JButton botonLeerCorreo = new JButton("LEER UN CORREO");
        botonLeerCorreo.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonLeerCorreo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leerCorreo();
            }
        });

        JButton botonLimpiarInbox = new JButton("LIMPIAR MI INBOX");
        botonLimpiarInbox.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonLimpiarInbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarInbox();
            }
        });

        JButton botonCerrarSesion = new JButton("CERRAR SESIÓN");
        botonCerrarSesion.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarSesion(frame);
            }
        });

        panel.add(Box.createRigidArea(new Dimension(0, 30)));
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(botonVerInbox);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(botonMandarCorreo);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(botonLeerCorreo);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(botonLimpiarInbox);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(botonCerrarSesion);

        frame.setContentPane(panel);
        frame.revalidate();
        frame.repaint();
    }

    private static void login(JFrame frame) {
        String email = JOptionPane.showInputDialog(frame, "Ingrese su correo electrónico:");
        if (email == null || email.trim().isEmpty()) {
            return;
        }

        String password = JOptionPane.showInputDialog(frame, "Ingrese su contraseña:");
        if (password == null || password.trim().isEmpty()) {
            return;
        }

        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getEmail().equals(email) && accounts[i].getPassword().equals(password)) {
                cuentaActual = accounts[i];
                JOptionPane.showMessageDialog(frame, "Inicio de sesión exitoso.");
                mostrarMenuPrincipal(frame);
                return;
            }
        }

        JOptionPane.showMessageDialog(frame, "Correo o contraseña incorrectos.");
    }

    private static void crearCuenta(JFrame frame) {
        if (accountCount >= accounts.length) {
            JOptionPane.showMessageDialog(frame, "No se pueden crear más cuentas.");
            return;
        }

        String email = JOptionPane.showInputDialog(frame, "Ingrese su correo electrónico:");
        if (email == null || email.trim().isEmpty()) {
            return;
        }

        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getEmail().equals(email)) {
                JOptionPane.showMessageDialog(frame, "Cuenta ya existe.");
                return;
            }
        }

        String password = JOptionPane.showInputDialog(frame, "Ingrese su contraseña:");
        if (password == null || password.trim().isEmpty()) {
            return;
        }

        accounts[accountCount++] = new EmailAccount(email, password, 10); // 10 es la capacidad del inbox
        cuentaActual = accounts[accountCount - 1];
        JOptionPane.showMessageDialog(frame, "Cuenta creada e inicio de sesión exitoso.");
        mostrarMenuPrincipal(frame);
    }

    private static void verInbox() {
        if (cuentaActual == null) {
            JOptionPane.showMessageDialog(null, "No hay ninguna cuenta activa.");
            return;
        }

        Email[] inbox = cuentaActual.getInbox();
        StringBuilder sb = new StringBuilder("Inbox:\n");
        for (Email email : inbox) {
            if (email != null) {
                sb.append(email.toString()).append("\n");
            }
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void mandarCorreo() {
        if (cuentaActual == null) {
            JOptionPane.showMessageDialog(null, "No hay ninguna cuenta activa.");
            return;
        }

        String destinatario = JOptionPane.showInputDialog(null, "Ingrese la dirección de correo del destinatario:");
        if (destinatario == null || destinatario.trim().isEmpty()) {
            return;
        }

        String asunto = JOptionPane.showInputDialog(null, "Ingrese el asunto del correo:");
        if (asunto == null || asunto.trim().isEmpty()) {
            return;
        }

        String contenido = JOptionPane.showInputDialog(null, "Ingrese el contenido del correo:");
        if (contenido == null || contenido.trim().isEmpty()) {
            return;
        }

        Email nuevoEmail = new Email(cuentaActual.getEmail(), destinatario, asunto, contenido);

        // Buscar la cuenta del destinatario
        boolean enviado = false;
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getEmail().equals(destinatario)) {
                if (accounts[i].receiveEmail(nuevoEmail)) {
                    enviado = true;
                    JOptionPane.showMessageDialog(null, "Correo enviado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "El inbox del destinatario está lleno.");
                }
                break;
            }
        }

        if (!enviado) {
            JOptionPane.showMessageDialog(null, "La dirección de correo del destinatario no existe.");
        }
    }

    private static void leerCorreo() {
        if (cuentaActual == null) {
            JOptionPane.showMessageDialog(null, "No hay ninguna cuenta activa.");
            return;
        }

        Email[] inbox = cuentaActual.getInbox();
        StringBuilder sb = new StringBuilder("Seleccione un correo para leer:\n");
        for (int i = 0; i < inbox.length; i++) {
            if (inbox[i] != null) {
                sb.append(i + 1).append(". ").append(inbox[i].getSubject()).append("\n");
            }
        }

        String input = JOptionPane.showInputDialog(null, sb.toString() + "\nIngrese el número del correo:");
        if (input == null || input.trim().isEmpty()) {
            return;
        }

        int index = Integer.parseInt(input) - 1;
        if (index < 0 || index >= inbox.length || inbox[index] == null) {
            JOptionPane.showMessageDialog(null, "Número de correo inválido.");
            return;
        }

        Email email = inbox[index];
        if (!email.isRead()) {
            email.markAsRead();
        }

        JOptionPane.showMessageDialog(null, "De: " + email.getSender() + "\nAsunto: " + email.getSubject() + "\nContenido: " + email.getContent());
    }

    private static void limpiarInbox() {
        if (cuentaActual == null) {
            JOptionPane.showMessageDialog(null, "No hay ninguna cuenta activa.");
            return;
        }

        cuentaActual.clearReadEmails();
        JOptionPane.showMessageDialog(null, "Inbox limpio: los correos leídos han sido eliminados.");
    }

    private static void cerrarSesion(JFrame frame) {
        cuentaActual = null;
        JOptionPane.showMessageDialog(frame, "Sesión cerrada.");
        mostrarMenuLogin(frame);
    }
}

