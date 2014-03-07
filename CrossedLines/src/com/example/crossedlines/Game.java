package com.example.crossedlines;

import java.util.Random;

public class Game {

	int thresHold = 10;

	public float startX;
	public float startY;

	public float currentX;
	public float currentY;

	public enum Way {UP, DOWN, LEFT, RIGHT}
	public Way way;	
	public int[][] gameArr = new int[8][8];	
	public Random random = new Random();
	public SelectedRect selecetedRect;

	public static Game instance;

	public static Game Instance() {
		return instance == null ? instance = new Game() : instance;
	}

	public Game() {
		createArray();
	}

	private void createArray() {
		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++)
				gameArr[i][j] = random.nextInt(6);
	}

	public void setWay(float firstX, float firstY, float secondX, float secondY) {
		if((secondX < (firstX - thresHold) && (secondY > (firstY - thresHold)) && (secondY < (firstY + thresHold)))) {
			Game.Instance().way = Way.LEFT;
		}
        else if((secondX > (firstX + thresHold) && (secondY > (firstY - thresHold)) && (secondY < (firstY + thresHold)))) {
            Game.Instance().way = Way.RIGHT;
        }
        else if((secondY < (firstY - thresHold) && (secondX > (firstX - thresHold)) && (secondX < (firstX + thresHold)))) {
            Game.Instance().way = Way.UP;
        }
        else if((secondY > (firstY + thresHold) && (secondX > (firstX - thresHold)) && (secondX < (firstX + thresHold)))) {
            Game.Instance().way = Way.DOWN;
        }

	}

	public void clearPreviousInfo() {
		way = null;
		selecetedRect = null;
	}

	public void selectStartRect(float x, float y) {
		Game.Instance().selecetedRect = new SelectedRect((int)(x/(GameSettings.Instance().width/GameSettings.Instance().rectsCount)), (int)(y/(GameSettings.Instance().width/GameSettings.Instance().rectsCount)));
	}

	public float getXDiffer() {
		return startX - currentX;
	}

	public float getYDiffer() {
		return startY - currentY;
	}

	public static class SelectedRect {		

		private int x;
		private int y;

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public SelectedRect(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

}