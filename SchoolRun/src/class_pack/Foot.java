package class_pack;
import java.awt.Image;

public class Foot {
	Image image;
	int x;
	int y;
	int width;
	int height;
	
	public Foot() {}
	public Foot(Image i, int x, int y, int w, int h) {
		this.image = i;
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
	}
		
	public Image getImage() { return image; }
	public void setImage(Image image) { this.image = image; }
		
	public int getX() { return x; }
	public void setX(int x) { this.x = x; }
		
	public int getY() { return y; }
	public void setY(int y) { this.y = y; }
		
	public int getWidth() { return width; }
	public void setWidth(int width) { this.width = width; }
		
	public int getHeight() { return height; }
	public void setHeight(int height) { this.height = height; }
}
