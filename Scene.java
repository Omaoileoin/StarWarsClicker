public class Scene {

	private static String image;
	private static int width = 1300;
	private static int height = 701;

	public static void draw() {
	StdDraw.picture(width/2, height/2, image);
	}

	public static void start() {
		StdDraw.setCanvasSize(width, height); 
		StdDraw.setXscale(0.0, width);
		StdDraw.setYscale(height, 0.0);
		image = "assets/DSbackground.jpg";
	}

	public static int getWidth() {
		return width;
	}

	public static int getHeight() {
		return height;
	}
}
