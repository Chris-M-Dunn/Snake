package Snake;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class SnakePanel extends JPanel {

    SnakeFrame frame;
    Toolkit kit;

    public SnakePanel(SnakeFrame f) {

        frame = f;
        kit = Toolkit.getDefaultToolkit();

        Timer timer = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.getModel().moveSnake();
                frame.getModel().detectCollisions();
                frame.repaint();
                kit.sync();
            }
        });
        
        timer.start();
        addKeyListener(new KeyHandler());
        setPreferredSize(new Dimension(frame.getModel().getBoardHeight(), frame.getModel().getBoardWidth()));
        // frame.getModel().startGame();
        frame.getModel().generateApple();
        setFocusable(true);

    }

    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        setBackground(Color.BLACK);
        g.setColor(Color.WHITE);
        draw(g);

    }

    public void draw(Graphics g) {

        for (int i=0; i<frame.getModel().getNumCols(); i++) {
            g.drawLine(0, i*frame.getModel().getUnitSize(), frame.getModel().getBoardHeight(), i*frame.getModel().getUnitSize());
            g.drawLine(i*frame.getModel().getUnitSize(), 0, i*frame.getModel().getUnitSize(), frame.getModel().getBoardWidth());
        }

        g.setColor(Color.RED);
        g.fillOval(frame.getModel().getAppleX(), frame.getModel().getAppleY(), frame.getModel().getUnitSize(), frame.getModel().getUnitSize());

        g.setColor(Color.GREEN);
        for (int i=0; i<frame.getModel().getBodyLength(); i++) {
            g.fillRect(frame.getModel().getXCoordinates()[i], frame.getModel().getYCoordinates()[i], frame.getModel().getUnitSize(), frame.getModel().getUnitSize());
        }

    }

    public class KeyHandler extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            
            switch(e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    if (frame.getModel().getMovementDirection() != 'D') {
                        frame.getModel().setMovementDirection('U');;
                    }
                    break;

                case KeyEvent.VK_RIGHT:
                    if (frame.getModel().getMovementDirection() != 'L') {
                        frame.getModel().setMovementDirection('R');
                    }
                    break;

                case KeyEvent.VK_DOWN:
                    if (frame.getModel().getMovementDirection() != 'U') {
                        frame.getModel().setMovementDirection('D');
                    }
                    break;

                case KeyEvent.VK_LEFT:
                    if (frame.getModel().getMovementDirection() != 'R') {
                        frame.getModel().setMovementDirection('L');
                    }
                    break;
            }
        }
    }
}
