package gtv.andrew.crossedlines;


public class GameSettings {	

	static GameSettings instance;

	public static GameSettings Instance() {
		return instance == null ? instance = new GameSettings() : instance;
	}

	public int height;
	public int width;

	public int rectsCount = 6;

	public int rectHorizontalStartPoint = 0;
	public int rectVerticalStartPoint = 100;

	public int colorsCount = 5;

	public int marginRect = 2;

	public int time = 60;
	
//	public double volume = 1;

	public int getRectSize() {
		return 	width/rectsCount;
	}
	
}