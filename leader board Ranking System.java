//leader board Ranking System
import java.util.Scanner;

class Player {
    String name;
    int score;

    // Constructor
    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

public class LeaderboardSystem {

    // Function to sort players based on score (Descending)
    public static void sortPlayers(Player[] players, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (players[i].score < players[j].score) {
                    Player temp = players[i];
                    players[i] = players[j];
                    players[j] = temp;
                }
            }
        }
    }

    // Function to display leaderboard
    public static void displayLeaderboard(Player[] players, int n) {
        System.out.println("\n===== Leaderboard =====");
        System.out.println("Rank\tName\tScore");

        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + "\t" + players[i].name + "\t" + players[i].score);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int n = sc.nextInt();
        sc.nextLine();

        Player[] players = new Player[n];

        // Input player data
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Player " + (i + 1));
            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Score: ");
            int score = sc.nextInt();
            sc.nextLine();

            players[i] = new Player(name, score);
        }

        // Sort players
        sortPlayers(players, n);

        // Display leaderboard
        displayLeaderboard(players, n);

        sc.close();
    }
}
