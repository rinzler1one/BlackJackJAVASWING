import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class JDialogMessage {
    ///This class is responsible for creating a custom pop-up message using the JDialog class
    //fields
    int width;
    int height;
    String text;
    Component component;
    //constructor method
    public JDialogMessage(int width, int height, String text, Component component) {
        this.width = width;
        this.height = height;
        this.text = text;
        this.component = component;
    }

    //instance methods
    public void create(){
        JDialog message = new JDialog();
        message.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JLabel textLabel = new JLabel();
        textLabel.setText(text);
        textLabel.setVisible(true);
        message.add(textLabel);
        message.setSize(width, height);
        message.setLocationRelativeTo(component);
        message.setAlwaysOnTop(true);
        message.setVisible(true);
    }
}
