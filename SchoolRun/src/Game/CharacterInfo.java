package Game;

public class CharacterInfo {
	public static String runStr = "..//image//game_image//bong_1.gif";
	static String jumpStr = "..//image//game_image//bong_1_jump.png";
	static String doubleJumpStr = "..//image//game_image//bong_1_jump2.gif";
	static String fallStr = "..//image//game_image//bong_1_fall.png";
	static String hitStr = "..//image//game_image//bong_1_fall.png";
	static String slideStr = "..//image//game_image//bong_1_slide.png";
	
	public void setCharacter(String run, String jump, String doubleJump, String fall, String slide) {
		this.runStr = run;
		this.jumpStr = jump;
		this.doubleJumpStr = doubleJump;
		this.fallStr = fall;
		this.hitStr = fall;
		this.slideStr = slide;
	}
}
