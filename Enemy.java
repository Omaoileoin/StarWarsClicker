//declaring class Enemy

public class Enemy {

	//declaring Enemy variables
	
	private static String image;
	private static int width;
	private static int height;
	private static double x;
	private static double y;
	private static long time;

	//draw method to draw Enemy to game area

	public static void draw() {
		StdDraw.picture(x + width /2, y + height /2, image);
	}

	//start method with Enemy graphics info

	public static void start() {
		image = "assets/xwing2.png";
		width = 200;
		height = 200;
		x = Math.random() * Scene.getWidth() - width;
		y = Math.random() * Scene.getHeight() - height;
		time = System.currentTimeMillis();
	}

	//move method that randomly moves enemy around game area

	public static void move() {
		x = Math.random() * Scene.getWidth() - width;
		y = Math.random() * Scene.getHeight() - height;
		time = System.currentTimeMillis();

		//containing Enemy to the game area
      	//less than game area size to prevent clipping off the screen

		if (x > 1250) {
			x = 1250;
		}
		if (x < 1) {
			x = 1;
		}
		if (y > 650) {
			y = 650;
		}
		if (y < 1) {
			y = 1;
		}
	}

	//update method that counts 1.5 seconds and then updates the Enemy position calling the Enemy.move method

	public static void update() {
		long now = System.currentTimeMillis();

		//time felt slightly too fast because of large scene, increased to 1500

		if (now - time > 1500) {
			Enemy.move();
		}

		//creating methods to add to the score if the Enemy and Player are touching and the Player is attacking

		if (Enemy.isTouching() && Player.isAttacking()) {
			Enemy.move();
			Game.addScore();
		}
	}

	//methods getting the Enemy position to compare to the Player position

	public static double getLeft() {
		return x;
	}

	public static double getTop() {
		return y;
	}

	public static double getBottom() {
		return y + height;
	}

	public static double getRight() {
		return x + width;
	}

	public static boolean isTouchingX() {
		return Player.getLeft() <= Enemy.getRight() && Enemy.getLeft() <= Player.getRight();
	}

	public static boolean isTouchingY() {
		return Player.getTop() <= Enemy.getBottom() && Enemy.getTop() <= Player.getBottom();
	}

	public static boolean isTouching() {
		return isTouchingX() && isTouchingY();
	}
}