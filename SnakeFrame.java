package Snake;

import javax.swing.*;

public class SnakeFrame extends JFrame {
    
    private SnakeModel model;
    private SnakePanel panel;

    public SnakeFrame() {

        model = new SnakeModel();
        panel = new SnakePanel(this);
        add(panel);

        setSize(model.getBoardWidth(), model.getBoardHeight());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Snake");
        setVisible(true);

    }

    public SnakeModel getModel() {
        return model;
    }
}
