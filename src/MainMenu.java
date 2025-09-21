import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu {
    private JButton addPlayerButton;
    private JButton checkLeaderboardButton;
    private JPanel mainPanel;
    private JButton addStarPlayerButton;

    public MainMenu()
    {
        addPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddPlayer addPlayer = new AddPlayer();
                addPlayer.Activate();

            }
        });

        checkLeaderboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Leaderboard leaderboard = new Leaderboard();
                leaderboard.Activate();
            }
        });
        addStarPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddStarPlayer addStarPlayer = new AddStarPlayer();
                addStarPlayer.Activate();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Main Menu");
        frame.setLocation(650,350);
        frame.setSize(500,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new MainMenu().mainPanel);
        frame.setVisible(true);
    }
}
