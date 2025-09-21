import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Comparator;

public class Leaderboard {
    private JPanel mainPanel;
    private JTextArea leaderBoard;
    private JComboBox<String> filter;

    public Leaderboard()
    {
        filter.addItem("Sort by name");
        filter.addItem("Sort by age");
        filter.addItem("Sort by score");
        filter.addItem("Sort by Max Wins");

        PlayersList playersList = new PlayersList();
        ArrayList<Player> playerDataList = playersList.fetchPlayersData();

        leaderBoard.setText("");
        int i = 1;
        for (Player player : playerDataList) {
            leaderBoard.append(i + "- " + player.toString() + "\n\n");
            i++;
        }

        filter.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selected = filter.getSelectedItem().toString();

                    switch (selected) {
                        case "Sort by name":
                            playerDataList.sort(Comparator.comparing(Player::getName));
                            break;

                        case "Sort by age":
                            playerDataList.sort(Comparator.comparingInt(Player::getAge));
                            break;

                        case "Sort by score":
                            playerDataList.sort((p1, p2) -> {
                                int score1 = 0;
                                int score2 = 0;

                                if (p1 instanceof NormalPlayer) {
                                    score1 = ((NormalPlayer) p1).getScore();
                                } else if (p1 instanceof StarPlayer) {
                                    score1 = ((StarPlayer) p1).getHighestScore();
                                }

                                if (p2 instanceof NormalPlayer) {
                                    score2 = ((NormalPlayer) p2).getScore();
                                } else if (p2 instanceof StarPlayer) {
                                    score2 = ((StarPlayer) p2).getHighestScore();
                                }

                                return Integer.compare(score2, score1);
                            });
                            break;
                        case "Sort by Max Wins":
                            playerDataList.sort((p1, p2) -> {
                                int wins1 = -1; // default for NormalPlayer
                                int wins2 = -1; // default for NormalPlayer

                                if (p1 instanceof StarPlayer) {
                                    wins1 = ((StarPlayer) p1).getMaxWins();
                                }
                                if (p2 instanceof StarPlayer) {
                                    wins2 = ((StarPlayer) p2).getMaxWins();
                                }

                                // Higher wins first
                                return Integer.compare(wins2, wins1);
                            });
                            break;
                    }


                    // refresh leaderboard after sorting
                    leaderBoard.setText("");
                    int i = 1;
                    for (Player player : playerDataList) {
                        leaderBoard.append(i + "- " + player.toString() + "\n\n");
                        i++;
                    }
                }
            }
        });

    }

    public void Activate()
    {
        JFrame frame = new JFrame("Add Player");
//        frame.setLocationRelativeTo(null);
        frame.setLocation(400,50);
        frame.setSize(800,800);
        frame.setContentPane(new Leaderboard().mainPanel);
        frame.setVisible(true);
    }


}
