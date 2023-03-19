package ru.miroshka.hw1;

import ru.miroshka.hw1.figures.Circle;
import ru.miroshka.hw1.figures.Figure;
import ru.miroshka.hw1.figures.Square;
import ru.miroshka.hw1.figures.Triangle;

public class AppZ3 {
    private static final double CONST_DOUBLE = 3d;

    public static void main(String[] args) {
        Figure circle = new Circle.Builder().setRadius(CONST_DOUBLE).build();
        Figure square = new Square.Builder().setSide(CONST_DOUBLE).build();
        Figure triangle = new Triangle.Builder()
                .setSideA(CONST_DOUBLE)
                .setSideB(CONST_DOUBLE * 2)
                .setSideC(CONST_DOUBLE)
                .builde();

        printFigure(circle);
        printFigure(square);
        printFigure(triangle);
    }

    public static void printFigure(Figure figure) {
        System.out.println(figure);
        System.out.println();
    }

}
