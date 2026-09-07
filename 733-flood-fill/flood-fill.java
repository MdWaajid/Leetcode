class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];

        if (oldColor == color)
            return image;

        fill(image, sr, sc, oldColor, color);

        return image;
    }

    public void fill(int[][] image, int r, int c, int oldColor, int color) {
        if (r < 0 || r >= image.length ||
            c < 0 || c >= image[0].length ||
            image[r][c] != oldColor)
            return;

        image[r][c] = color;

        fill(image, r + 1, c, oldColor, color);
        fill(image, r - 1, c, oldColor, color);
        fill(image, r, c + 1, oldColor, color);
        fill(image, r, c - 1, oldColor, color);
    }
}