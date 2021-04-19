package Game;

import src.Select_Thema;
import src.User;

public class MapInfo {
	User u1 = new User();
	
	public static String backStr;
	static String field1Str;
	static String field2Str;
	static String field3Str;
	static String field4Str;
	static String tacle1Str;
	static String tacle2Str;
	static String musicStr;
	public static int check = 0;
	
	public MapInfo() {
		u1.getAll();

		if(this.check == 0) {
			if (u1.play_stage == 1) {
				this.backStr = "..//image//game_image//stage1_back.jpg";
				this.field1Str = "..//image//game_image//book_field.png";
				this.field2Str = "..//image//game_image//book_field2.png";
				this.field3Str = "..//image//game_image//book_field3.png";
				this.field4Str = "..//image//game_image//book_field4.png";
				this.tacle1Str = "..//image//game_image//tacle01.png";
			 	this.tacle2Str = "..//image//game_image//tacle02.png";
			 	this.musicStr = "..\\music\\STAGE1.MP3";
			} else if(u1.play_stage == 2) {
				this.backStr = "..//image//game_image//stage2_back.jpg";
				this.field1Str = "..//image//game_image//ball_field.png";
				this.field2Str = "..//image//game_image//ball_field2.png";
				this.field3Str = "..//image//game_image//ball_field3.png";
				this.field4Str = "..//image//game_image//ball_field4.png";
				this.tacle1Str = "..//image//game_image//tacle_03.png";
				this.tacle2Str = "..//image//game_image//tacle_04.png";
				this.musicStr = "..\\music\\STAGE2.MP3";
			} else if(u1.play_stage == 3) {
				this.backStr = "..//image//game_image//stage3_back.jpg";
				this.field1Str = "..//image//game_image//cloud_field.png";
				this.field2Str = "..//image//game_image//cloud_field2.png";
				this.field3Str = "..//image//game_image//cloud_field3.png";
				this.field4Str = "..//image//game_image//cloud_field4.png";
				this.tacle1Str = "..//image//game_image//tacle_ring.png";
				this.tacle2Str = "..//image//game_image//tacle02_stick.png";
				this.musicStr = "..\\music\\STAGE3.MP3";
			}
		}
	}

	public void setMap(String back, String field1, String field2, String field3, String field4, String tacle1, String tacle2, String music) {
		this.backStr = back;
		this.field1Str = field1;
		this.field2Str = field2;
		this.field3Str = field3;
		this.field4Str = field4;
		this.tacle1Str = tacle1;
		this.tacle2Str = tacle2;
		this.musicStr = music;
	}
}
