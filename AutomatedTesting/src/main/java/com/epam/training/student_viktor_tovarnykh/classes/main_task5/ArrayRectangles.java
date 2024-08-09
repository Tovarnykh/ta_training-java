package com.epam.rd.qa.classes;

public class ArrayRectangles {

    private final Rectangle[] rectangleArray;

    public ArrayRectangles(int size) {
        if (size <= 0) throw new IllegalArgumentException();
        else {
            this.rectangleArray = new Rectangle[size];
        }
    }
    public ArrayRectangles(Rectangle... rectangles) {
        if (rectangles == null || rectangles.length == 0) {
            throw new IllegalArgumentException();
        } else {
            this.rectangleArray = rectangles;
        }
    }
    public boolean addRectangle(Rectangle rectangle) {
        for(int i = 0; i < rectangleArray.length; i++)
            if(rectangleArray[i] == null) {
                rectangleArray[i] = new Rectangle();
                return true;
            } return false;
    }
    public int size() {
        int amount=0;
        for (Rectangle rectangle : rectangleArray) {
            if (rectangle != null)
                amount++;
        }
        return amount;
    }
    public int indexMaxArea() {
        double max = 0;
        int maxInd = 0;
        for (Rectangle rectangle : rectangleArray) {
            if (rectangle.area() > max) {
                max = rectangle.area();
            }
        }
        for (int i = 0; i < rectangleArray.length; i++) {
            if (rectangleArray[i].area() == max) {
                maxInd = i;
                break;
            }
        }
        return maxInd;
    }
    public int indexMinPerimeter() {
        double min = rectangleArray[0].perimeter();
        int minInd = 0;
        for (int j = 1; j < rectangleArray.length; j++) {
            if (rectangleArray[j].perimeter() < min) {
                min = rectangleArray[j].perimeter();
            }
        }
        for (int i = 0; i < rectangleArray.length; i++) {
            if (rectangleArray[i].perimeter() == min) {
                minInd = i;
                break;
            }
        } return minInd;
    }
    public int numberSquares() {
        int sum = 0;
        for (Rectangle rectangle : rectangleArray) {
            if (rectangle.isSquare()) {
                sum++;
            }
        }
        return sum;
    }

}
