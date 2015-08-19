// Implement the "paint fill" function that one might see on many image editing programs.
// That is, given a screen (represented by a two-dimensional array of colors),
// a point, and a new color, fill in the surrounding area until the color changes from the original color.
//https://zh.wikipedia.org/wiki/Flood_fill
//这个题考的是flood fill算法
public class Solution {
  public void paintFill(int[][] screen, int x, int y, int newColor， int originalColor) {
    if(screen == null || screen.length == 0 || screen[0].length == 0 ||
    x >= screen.length || y >= screen[0].length) {
      return;
    }
    dfs(screen, x, y, newColor, originalColor);
  }
  private void dfs(int[][] screen, int xLoc, int yLoc, int newColor, int originalColor) {
    if((xLoc >= 0 && xLoc < screen.length) && (yLoc >= 0 && yLoc < screen[0].length)
    && screen[xLoc][yLoc] == originalColor && screen[xLoc][yLoc] != newColor) {
      screen[xLoc][yLoc] = newColor;
      dfs( screen, xLoc + 1, yLoc, newColor, originalColor );
      dfs( screen, xLoc - 1, yLoc, newColor, originalColor );
      dfs( screen, xLoc, yLoc + 1, newColor, originalColor );
      dfs( screen, xLoc, yLoc - 1, newColor, originalColor );
    }
  }
}
