package class_pack;
import java.awt.Image;

public class Tacle {
	
	private Image image;
	private int x;
	private int y;
	private int width;
	private int height;
	
	private int state; //장애물의 상태
	
	//생성자
	public Tacle() {}
	public Tacle(Image img, int x, int y, int w, int h, int s) {
		this.image = img;
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
		this.state = s;
	}
	
	
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	
	
	
	
}
