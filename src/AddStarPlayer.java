import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStarPlayer {
    private JTextField nameField;
    private JTextField ageField;
    private JTextField scoreField;
    private JPanel mainPanel;
    private JButton addButton;
    private JTextField winsField;


    public AddStarPlayer()
    {


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText(); // Getting the value of the name text field
                int age = Integer.parseInt(ageField.getText()); // Type casting, to change the string into int
                int score = Integer.parseInt(scoreField.getText());
                int maxWins = Integer.parseInt(winsField.getText());

                StarPlayer starPlayer = new StarPlayer(name,age,score,maxWins);
                starPlayer.savePlayer();
                nameField.setText("");
                ageField.setText("");
                scoreField.setText("");
                winsField.setText("");
            }
        });
    }


    public void Activate()
    {
        JFrame frame = new JFrame("Add Player");
        frame.setLocation(650,350);
        frame.setSize(500,300);
        frame.setContentPane(new AddStarPlayer().mainPanel);
        frame.setVisible(true);
    }
}
