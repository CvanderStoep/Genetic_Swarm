import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Input {
    private JTextField inpMazeSize;
    private JButton btnRun;
    private JPanel InputView;
    private JLabel lblMazeSize;

    public Input() {
        btnRun.addActionListener(new RunClicked());
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Input");
        frame.setContentPane(new Input().InputView);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    private class RunClicked implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            inpMazeSize.setText("doet nog niets");
            new Thread(() -> {
                Simulation.main(new String[]{"doet niets"});
            }).start();
        }
    }
}
