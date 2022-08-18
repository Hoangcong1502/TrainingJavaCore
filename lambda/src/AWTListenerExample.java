import javafx.stage.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AWTListenerExample {
    public static void main(String[] args) {
        Frame screen = new Frame();
        Button button = new Button("Press me");
        screen.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Welcome to Java by Example",
                        "Java Sample",JOptionPane.INFORMATION_MESSAGE );
            }
        });
        screen.setSize(250,400);
        screen.isVisible();

    }
}
