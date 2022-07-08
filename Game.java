//importing to change font type, color, and size

import java.awt.Font;

//declaring Game class

public class Game {

	//declaring Game variables

	private static boolean gameOver = false;
	private static int score = 0;

	//starting main method

	public static void main(String[] args) {
		start();
		
		//while loop to continually update the Player and Enemy positions and draw them to the game area as long as gameOver == false

		while (gameOver == false) {
			update();
			render();
		}
	}

	//start method to call start methods from Scene, Enemy, and Player

	public static void start() {
		Scene.start();
		Enemy.start();
		Player.start();
	}

	//update method to call update methods from Player and Enemy

	public static void update() {
		Player.update();
		Enemy.update();
	}

	//render method to call draw methods from Scene, Enemy, and Player, and to place the score counter with the selected font, size, and color

	public static void render() {
		Scene.draw();
		Enemy.draw();
		Player.draw();
		Font font = new Font("News Gothic", Font.PLAIN, 30);
		StdDraw.setFont(font);
		StdDraw.setPenColor(StdDraw.RED);

		//moved text location slightly because of different font and size

		StdDraw.text(80,40, "Score: " + score);
		StdDraw.show(100);

		//gameOver when score = 20

		if (score == 20) {
			gameOver = true;
			StdDraw.text(650,300, "Congratulations! You have defended the Death Star!");
			StdDraw.show(100);
		}
	}
	
	//method to add 1 to the score each time the Enemy is attacked.
	
	public static void addScore() {
		score++;
	}
}