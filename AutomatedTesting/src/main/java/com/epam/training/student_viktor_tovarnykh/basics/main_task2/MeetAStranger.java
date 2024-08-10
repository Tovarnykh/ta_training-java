package com.epam.training.student_viktor_tovarnykh.basics.main_task2;

import java.util.Scanner;

public class MeetAStranger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        scanner.close();

        System.out.println("Hello, " + input);
    }
}
