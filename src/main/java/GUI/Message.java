package GUI;

import javax.swing.*;

public class Message {
    JFrame frame;
    public Message(String message) {
        frame = new JFrame();
        JOptionPane.showMessageDialog(frame, message);
    }
}