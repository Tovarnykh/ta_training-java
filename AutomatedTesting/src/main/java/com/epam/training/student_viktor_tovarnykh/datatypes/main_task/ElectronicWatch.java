package com.epam.rd.autotasks.meetautocode;

import java.util.Scanner;

public class ElectronicWatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int givenSeconds = scanner.nextInt();

        scanner.close();

        int secondsInDay = givenSeconds % 86400;
        int hours = secondsInDay / 3600;
        int minutes = (secondsInDay % 3600) / 60;
        int seconds = secondsInDay % 60;

        System.out.format("%d:%02d:%02d", hours, minutes, seconds);

    }
}
