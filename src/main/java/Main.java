public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        Player player = new Player(1, "Nikolay", 100);
        Player player1 = new Player(2, "Vitaliy", 50);
        Player player2 = new Player(3, "Kirill", 200);

        game.register(player);
        game.register(player1);

        System.out.println(game.round("Nikolay", "Kirill"));
    }
}
