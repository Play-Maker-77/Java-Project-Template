import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class PlayersList {

    public ArrayList<Player> fetchPlayersData() {
        ArrayList<Player> playersList = new ArrayList<>();

        // --- Fetch Normal Players ---
        String fetchNormal = "SELECT * FROM Player";
        try (Connection conn = ConnectionEssentials.getConnection();
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery(fetchNormal)) {

            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                int score = rs.getInt("score");
                String division = rs.getString("division");

                NormalPlayer player = new NormalPlayer(name, age, score, convertDivision(division));
                playersList.add(player);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // --- Fetch Star Players ---
        String fetchStar = "SELECT * FROM StarPlayer";
        try (Connection conn = ConnectionEssentials.getConnection();
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery(fetchStar)) {

            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                int highestScore = rs.getInt("highest_score");
                int maxWins = rs.getInt("max_wins");

                StarPlayer star = new StarPlayer(name, age, highestScore, maxWins);
                playersList.add(star);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Players (Normal + Star) were fetched successfully");
        return playersList;
    }


    private int convertDivision(String divisionName) {
        if (divisionName.equalsIgnoreCase("Bronze")) {
            return 1;
        } else if (divisionName.equalsIgnoreCase("Silver")) {
            return 2;
        } else if (divisionName.equalsIgnoreCase("Gold")) {
            return 3;
        } else if (divisionName.equalsIgnoreCase("Platinum")) {
            return 4;
        } else if (divisionName.equalsIgnoreCase("Diamond")) {
            return 5;
        } else if (divisionName.equalsIgnoreCase("Champion")) {
            return 6;
        } else if (divisionName.equalsIgnoreCase("Ultimate Champion")) {
            return 7;
        } else {
            return 0; // or some default/error value if the name is invalid
        }
    }

}
