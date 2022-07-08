//declaring Player class 

public class Player {

	//declaring Player variables

	private static String image;
	private static int width;
	private static int height;
	private static double x;
	private static double y;
	private static boolean isAttacking;

	//start method with Player graphics info

	public static void start() {
		image = "assets/aimer.png";
		width = 32;
		height = 32;
		x = Scene.getWidth() / 2;
		y = Scene.getHeight() / 2;
		isAttacking = false;
	}

	//draw method to draw Player to game area

	public static void draw() {
		StdDraw.picture(x + width / 2, y + height / 2, image);
	}

	//Player move conditions for mouse

	public static void move() {
		x = StdDraw.mouseX() - width / 2;
		y = StdDraw.mouseY() - height / 2;
	}

	//update method to call Player movement and attack

	public static void update() {
		move();
		attack();
	}

	//methods to get Player location to compare Player and Enemy locations

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

	public static boolean isAttacking() {
		return isAttacking;
	}

	public static void attack() {
		if ( StdDraw.mousePressed() ) {
			isAttacking = true;
		}
		else {
			isAttacking = false;
		}
	}
}