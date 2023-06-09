package com.codecool.embroidery;

import com.codecool.embroidery.consoleColors.ConsoleColors;

public class Embroidery {
    public static void main(String[] args) {
        printShape(drawRectangle(5, 5));
        System.out.println();
        printShape(drawRectangle(5, 5, 3));
        System.out.println();
        printShape(drawRectangle(5, 5, 3, 8));
        System.out.println();
        printShape(drawRectangle(7, 7, 8, 2, 2));
        System.out.println();
        printShape(drawTriangle(4));
        System.out.println();
        printShape(drawTriangle(4, 2));
        System.out.println();
        printShape(drawTriangle(4, 2, 6));
        System.out.println();
        printShape(drawChristmasTree(1));
        System.out.println();
        printShape(drawChristmasTree(2));
        System.out.println();
        printShape(drawChristmasTree(3));
        System.out.println();
        printShape(drawChristmasTree(4));
        System.out.println();
        printShape(drawChristmasTree(4, 2));
        System.out.println();
        printShape(drawChristmasTree(4, 4, 5));
        System.out.println();
        printShape(drawCircle(16));
        System.out.println();
        printShape(drawCircle(16, 8));
        System.out.println();
        printShape(drawCircle(3, 8, 3));
        System.out.println();
    }

    private static int[][] drawRectangle(int width, int height) {
        return drawRectangle(width, height, 1);
    }

    private static int[][] drawRectangle(int width, int height, int borderColor) {
        return drawRectangle(width, height, borderColor, 1);
    }

    private static int[][] drawRectangle(int width, int height, int borderColor, int fillColor) {
        return drawRectangle(width, height, borderColor, fillColor, 1);
    }

    private static int[][] drawRectangle(int width, int height, int borderColor, int fillColor, int borderWidth) {
        int[][] rectangle = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i < borderWidth || j < borderWidth || i >= height - borderWidth || j >= width - borderWidth) {
                    rectangle[i][j] = borderColor;
                } else {
                    rectangle[i][j] = fillColor;
                }
            }
        }
        return rectangle;
    }

    private static int[][] drawTriangle(int height) {
        return drawTriangle(height, 1);
    }

    private static int[][] drawTriangle(int height, int borderColor) {
        return drawTriangle(height, borderColor, 1);
    }

    private static int[][] drawTriangle(int height, int borderColor, int fillColor) {
        final int width = height * 2 - 1;
        final int empty = 0;
        int[][] triangle = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (j == height - 1 - i || j == height - 1 + i || i == height - 1) {
                    triangle[i][j] = borderColor;
                } else if (j > height - 1 - i && j < height - 1 + i) {
                    triangle[i][j] = fillColor;
                } else {
                    triangle[i][j] = empty;
                }
            }
        }
        return triangle;
    }

    private static int[][] drawChristmasTree(int blocks) {
        return drawChristmasTree(blocks, 1);
    }

    private static int[][] drawChristmasTree(int blocks, int borderColor) {
        return drawChristmasTree(blocks, borderColor, 1);
    }

    private static int[][] drawChristmasTree(int blocks, int borderColor, int fillColor) {
        final int heightOfBlocks = 3;
        final int height = blocks * heightOfBlocks;
        final int width = heightOfBlocks + blocks * 2;
        final int empty = 0;
        int[][] christmasTree = new int[height][width];
        for (int i = 0; i < blocks; i++) {
            for (int j = 0; j < heightOfBlocks; j++) {
                for (int k = 0; k < width; k++) {
                    if (k == width / 2 - j - i || k == width / 2 + j + i || (i + 1) * (j + 1) == height) {
                        christmasTree[i * heightOfBlocks + j][k] = borderColor;
                    } else if (k >= width / 2 - j - i && k <= width / 2 + j + i) {
                        christmasTree[i * heightOfBlocks + j][k] = fillColor;
                    } else {
                        christmasTree[i * heightOfBlocks + j][k] = empty;
                    }
                }
            }
        }
        return christmasTree;
    }

    private static int[][] drawCircle(int radius) {
        return drawCircle(radius, 1);
    }

    private static int[][] drawCircle(int radius, int borderColor) {
        return drawCircle(radius, borderColor, 1);
    }

    private static int[][] drawCircle(int radius, int borderColor, int fillColor) {
        final int empty = 0;
        final int height = 2 * radius;
        final double zeroPoint = radius - 0.5;
        int[][] circle = new int[height][height];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height; j++) {
                double aSquarePlusBSquare = Math.pow(i - zeroPoint, 2) + Math.pow(j - zeroPoint, 2);
                if (aSquarePlusBSquare <= Math.pow(zeroPoint, 2) + zeroPoint && aSquarePlusBSquare >= Math.pow(zeroPoint, 2) - zeroPoint) {
                    circle[i][j] = borderColor;
                } else if (aSquarePlusBSquare < Math.pow(zeroPoint, 2)) {
                    circle[i][j] = fillColor;
                } else {
                    circle[i][j] = empty;
                }
            }
        }
        return circle;
    }

    private static void printShape(int[][] shape) {
        String color;
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[0].length; j++) {
                color = setColor(shape[i][j]);
                System.out.print(ConsoleColors.setBackGroundColor("   ", color));
            }
            System.out.println();
        }
    }

    private static String setColor(int number) {
        String color;
        switch (number) {
            case 0:
                color = ConsoleColors.BLACK_BACKGROUND_BRIGHT;
                break;
            case 1:
                color = ConsoleColors.WHITE_BACKGROUND_BRIGHT;
                break;
            case 2:
                color = ConsoleColors.RED_BACKGROUND_BRIGHT;
                break;
            case 3:
                color = ConsoleColors.YELLOW_BACKGROUND_BRIGHT;
                break;
            case 4:
                color = ConsoleColors.CYAN_BACKGROUND_BRIGHT;
                break;
            case 5:
                color = ConsoleColors.GREEN_BACKGROUND_BRIGHT;
                break;
            case 6:
                color = ConsoleColors.BLUE_BACKGROUND_BRIGHT;
                break;
            case 7:
                color = ConsoleColors.PURPLE_BACKGROUND;
                break;
            case 8:
                color = ConsoleColors.PURPLE_BACKGROUND_BRIGHT;
                break;
            case 9:
                color = ConsoleColors.RED_BACKGROUND;
                break;
            default:
                color = ConsoleColors.WHITE_BACKGROUND;
        }
        return color;
    }
}
