package class_pack;
import java.awt.Image;

public class Jelly {
	
	private Image image;
	private int x;
	private int y;
	private int width;
	private int height;
	private int score;

	public Jelly() { }

	public Jelly(Image img, int x, int y, int w, int h, int s) {
		this.image = img;
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
		this.score = s;
	}
		
	public Image getImage() { return image; }
	public void setImage(Image img) { this.image = img; }
	public int getX() { return x; }
	public void setX(int x) { this.x = x; }
	public int getY() { return y; }
	public void setY(int y) { this.y = y; }
	public int getWidth() { return width; }
	public void setWidth(int width) { this.width = width; }
	public int getHeight() { return height; }
	public void setHeight(int height) { this.height = height; }
	public int getScore() { return score;}
	public void setScore(int score) {this.score = score;}
			
}
