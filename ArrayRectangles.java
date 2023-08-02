package com.epam.rd.qa.classes;


import java.io.IOException;

public class ArrayRectangles {
    private Rectangle[] rectangleArray;

    public ArrayRectangles(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Check your array!");
        }
        rectangleArray = new Rectangle[size];

    }

    public ArrayRectangles(Rectangle ... rectangle) {

        if (rectangle==null) {
            throw new IllegalArgumentException("Check your array!");
        }
        int rectangleLenght = rectangle.length;
        rectangleArray = new Rectangle[rectangleLenght];
        for(int i = 0; i < rectangleLenght; i++) {
            rectangleArray[i]=rectangle[i];
        }

        if ((rectangleArray == null) || (rectangleArray.length == 0)) {
            throw new IllegalArgumentException("Check your array!");
        }

    }

    public boolean addRectangle(Rectangle rectangle) {
        for (int i = 0; i < rectangleArray.length; i++) {
            if (rectangleArray[i] == null) {
                rectangleArray[i] = rectangle;
                return true;
            }
        }
        return false;
    }

    public int size() {
        int size = 0;
        for (Rectangle rectangle : rectangleArray) {
            if (rectangle != null) {
                size++;
            }
        }
        return size;
    }

    public int numberSquares() {
        int totalSquares = 0;
        for (Rectangle rectangle : rectangleArray) {
            if ((rectangle != null)&&(rectangle.getSideA()==rectangle.getSideB())) {
                totalSquares++;
            }
        }
        return totalSquares;
    }

    public int indexMaxArea(){
        if (rectangleArray == null) {
            throw new IllegalArgumentException("Empty array!");
        }
        int i=0;
        double max = rectangleArray[0].getSideA()*rectangleArray[0].getSideB();
        for (int j = 0; j < rectangleArray.length; j++) {
            if (rectangleArray[j]==null){
                continue;
            }
            double square = rectangleArray[j].getSideA()*rectangleArray[j].getSideB();
            if (square>max) {
                max = square;
                i = j;
            }
        }
        return i;
    }

    public int indexMinPerimeter (){
        if (rectangleArray == null) {
            throw new IllegalArgumentException("Empty array!");
        }
        int i=0;
        double min = 2*rectangleArray[0].getSideA()+2*rectangleArray[0].getSideB();
        for (int j = 0; j < rectangleArray.length; j++) {
            if (rectangleArray[j]==null){
                continue;
            }
            double perimetr = 2*rectangleArray[j].getSideA()+2*rectangleArray[j].getSideB();
            if (perimetr<min) {
                min = perimetr;
                i = j;
            }
        }
        return i;
    }
}
