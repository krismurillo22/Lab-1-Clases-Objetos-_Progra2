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
    EmailAccount cuentas;
    Email email;

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

        accounts[accountCount++] = new Account(email, password, 10); // 10 es la capacidad del inbox
        cuentaActual = accounts[accountCount - 1];
        JOptionPane.showMessageDialog(frame, "Cuenta creada e inicio de sesión exitoso.");
        mostrarMenuPrincipal(frame);
    }

    private static void verInbox() {
        // Código para ver el inbox
        JOptionPane.showMessageDialog(null, "Método para ver el inbox llamado.");
    }

    private static void mandarCorreo() {
        // Código para enviar un correo
        JOptionPane.showMessageDialog(null, "Método para enviar un correo llamado.");
    }

    private static void leerCorreo() {
        // Código para leer un correo
        JOptionPane.showMessageDialog(null, "Método para leer un correo llamado.");
    }

    private static void limpiarInbox() {
        // Código para limpiar el inbox
        JOptionPane.showMessageDialog(null, "Método para limpiar el inbox llamado.");
    }

    private static void cerrarSesion(JFrame frame) {
        cuentaActual = null;
        JOptionPane.showMessageDialog(frame, "Sesión cerrada.");
        mostrarMenuLogin(frame);
    }
}
