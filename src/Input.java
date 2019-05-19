import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Input {
    private JTextField inpMazeSize;
    private JButton btnRun;
    private JPanel InputView;
    private JLabel lblMazeSize;
    private JTextField inpNumberIndividuals;
    private JTextField inpNumberMoves;
    private JTextField inpNumberSimulations;

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
            btnRun.setEnabled(false);
            new Thread(() -> {
                Simulation.main(new String[]{inpMazeSize.getText(), inpNumberIndividuals.getText(),
                        inpNumberMoves.getText(), inpNumberSimulations.getText()});
            }).start();
        }
    }
}
