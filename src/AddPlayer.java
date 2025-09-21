import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class AddPlayer {
    private JTextField nameField;
    private JTextField ageField;
    private JTextField scoreField;
    private JPanel mainPanel;
    private JButton addButton;
    private JComboBox<Integer> divisionComboBox;

    public AddPlayer()
    {
        divisionComboBox.addItem(1);
        divisionComboBox.addItem(2);
        divisionComboBox.addItem(3);
        divisionComboBox.addItem(4);
        divisionComboBox.addItem(5);
        divisionComboBox.addItem(6);
        divisionComboBox.addItem(7);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText(); // Getting the value of the name text field
                int age = Integer.parseInt(ageField.getText()); // Type casting, to change the string into int
                int score = Integer.parseInt(scoreField.getText());
                int division = Integer.parseInt(Objects.requireNonNull(divisionComboBox.getSelectedItem()).toString());
                System.out.println(division);

                NormalPlayer newPlayer = new NormalPlayer(name,age,score,division);
                System.out.println(newPlayer.division.toString());
                newPlayer.savePlayer();
                nameField.setText("");
                ageField.setText("");
                scoreField.setText("");
                divisionComboBox.setSelectedIndex(0);

            }
        });
    }


    public void Activate()
    {
        JFrame frame = new JFrame("Add Player");
        frame.setLocation(650,350);
        frame.setSize(500,300);
        frame.setContentPane(new AddPlayer().mainPanel);
        frame.setVisible(true);
    }
}
