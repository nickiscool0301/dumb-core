/*
An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and newColor. You should perform a flood fill on the image starting from 
the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel 
of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with newColor.

Return the modified image after performing the flood fill.
*/

var floodFill = function (image, sr, sc, newColor) {
  //return image if the current color is already a target color
  if (image[sr][sc] == newColor) return image;
  fill(image, sr, sc, image[sr][sc], newColor); //call fill operation
  return image;
};

//fill function to fill the starting pixel and 4-directionally pixels
var fill = function (image, sr, sc, currColor, newColor) {
  //check outbound conditions
  if (
    sr < 0 ||
    sc < 0 ||
    sr >= image.length ||
    sc >= image[0].length ||
    image[sr][sc] != currColor
  ) {
    return;
  }
  // set new color to the starting pixel
  image[sr][sc] = newColor;
  // set new color to 4-directional pixels
  fill(image, sr + 1, sc, currColor, newColor); //top
  fill(image, sr - 1, sc, currColor, newColor); //bottom
  fill(image, sr, sc + 1, currColor, newColor); //right
  fill(image, sr, sc - 1, currColor, newColor); //left
};

const image = [
  [1, 1, 1],
  [1, 1, 0],
  [1, 0, 1],
];
console.log(floodFill(image, 1, 1, 2));
