import java.sql.Connection;
import java.sql.Statement;

public class StarPlayer extends Player {
    int highestScore;
    int maxWins;

    public StarPlayer(String name, int age, int score, int maxWins) {
        super(name, age);
        this.highestScore = score;
        this.maxWins = maxWins;
    }

    public void savePlayer()
    {
        String insertData = "INSERT INTO StarPlayer (name, age, highest_score, max_wins) " +
                "VALUES ('" + name + "', " + age + ", " + highestScore + ", " + maxWins + ")";

        try (Connection conn = ConnectionEssentials.getConnection(); Statement statement = conn.createStatement()){
            statement.execute(insertData);
            System.out.println("Player was added successfully");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getHighestScore() {
        return highestScore;
    }

    public int getMaxWins() {
        return maxWins;
    }

    @Override
    public String toString() {
        return
                super.toString()+
                        " Highest Score : " + highestScore + " | " +
                        " Max Wins : " + maxWins;
    }
}
