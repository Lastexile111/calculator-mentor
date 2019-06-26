package ru.mentor.calculator;

import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        Calculator c = new CalculatorImpl();
        Scanner scanner = new Scanner(System.in);
        System.out.print("input: ");

        System.out.println( "output: "+ c.solve(scanner.nextLine()));
    }
}
