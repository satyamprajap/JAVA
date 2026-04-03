import java.awt.*;
import java.awt.event.*;

public class ColorApplet extends Frame {

    public ColorApplet() {
        setSize(300, 200);
        setTitle("Color Demo");

        // Close window properly
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });

        // Set background color
        setBackground(Color.lightGray);
    }

    public void paint(Graphics g) {

        // Red filled rectangle
        g.setColor(Color.red);
        g.fillRect(20, 20, 100, 60);

        // Blue filled oval
        g.setColor(Color.blue);
        g.fillOval(150, 20, 100, 60);

        // Black text
        g.setColor(Color.black);
        g.drawString("Color Demo", 100, 130);
    }

    public static void main(String[] args) {
        ColorApplet obj = new ColorApplet();
        obj.setVisible(true);
    }
}