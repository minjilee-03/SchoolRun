package class_pack;
import java.awt.Image;

public class Character {
	private Image image; //캐릭터 이미지
	
	private int x = 160;
	private int y = 0;
	private int width = 80;
	private int height = 120;
	private int width2 = 120;
	
	
	private int alpha = 255; //투명도, 255=완전 불투명
	private int hp = 1000;
	
	
	private int countJump = 0;
	private boolean invincible = false;
	private boolean jump = false;
	private boolean fall = false;
	
	//생성자
	public Character() {}
	public Character(Image i, int x, int y, int w, int h) {
		this.image = i;
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
	}
	
	
	public Character(Image image) { this.image = image; }
	
	//getter, setter
	public Image getImage() { return image; }
	public void setImage(Image image) { this.image = image; }
	
	public int getX() { return x; }
	public void setX(int x) { this.x = x; }
	
	public int getY() { return y; }
	public void setY(int y) { this.y = y; }
	
	public int getWidth() { return width; }
	public void setWidth(int width) { this.width = width; }
	
	public int getWidth2() { return width; }
	public void setWidth2(int width) { this.width = width; }
	
	public int getHeight() { return height; }
	public void setHeight(int height) { this.height = height; }
	
	public int getAlpha() { return alpha; }
	public void setAlpha(int alpha) { this.alpha = alpha; }
	
	public int getHp() { return hp; }
	public void setHp(int hp) { this.hp = hp; }
	
	public int getCountJump() { return countJump; }
	public void setCountJump(int countJump) { this.countJump = countJump; }
	
	public boolean isInvincible() { return invincible; }
	public void setInvincible(boolean invincible) { this.invincible = invincible; }
	
	public boolean isJump() { return jump; }
	public void setJump(boolean jump) { this.jump = jump; }
	
	public boolean isFall() { return fall; }
	public void setFall(boolean fall) { this.fall = fall; }
	
	
	
	
	
	
	
	
	
}
