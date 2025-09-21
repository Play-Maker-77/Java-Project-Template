import java.sql.Connection;
import java.sql.Statement;

public class NormalPlayer extends Player {

    int score;
    Division division;

    public NormalPlayer(String name, int age, int score, int division) {
        super(name, age);
        this.score = score;
        this.division = new Division(division);
    }

    public void savePlayer()
    {
        String insertData = "INSERT INTO Player (name, age, score, division) " +
                "VALUES ('" + name + "', " + age + ", " + score + ", '" + division.toString() + "')";

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

    public int getScore() {
        return score;
    }

    public String getDivision() {
        return division.divisionName;
    }

    @Override
    public String toString() {
        return
                super.toString()+
                " score : " + score + " | " +
                " division : " + division.toString();
    }
}
