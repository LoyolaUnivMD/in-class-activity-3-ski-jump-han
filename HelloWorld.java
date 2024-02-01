// Programmers: Hans van Lierop
// Course: CS212
// Due Date: Feb 2, 2024
// Lab Assignment: N/a
// Problem Statement: Figure out what speed a skier needs to achieve to reach a certain distance.
// Data In: Ski jump size, jumpers speed
// Data Out: Distance traveled, Number of points
// Credits: none

import java.util.Scanner;
import java.lang.Math;

class HelloWorld {
    public static void main(String[] args) {
        // Initialize scanner object
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the size of hill you would like (normal/large): ");
        // Take the user's input for hill size
        String hill_size = input.next();
        // While the user doesn't enter 'normal' or 'large' for hill size
        while (!hill_size.equalsIgnoreCase("normal") && !hill_size.equalsIgnoreCase("large")) {
            // Prompt again for the hill size
            System.out.println("Enter a valid hill size (normal/large): ");
            hill_size = input.next();
        }

        int height = 0, par = 0;
        double pointsPerMeter = 0.0;
        // Set variables of height, pointsPerMeter, and par based on the hill size
        if (hill_size.equalsIgnoreCase("normal")) {
            height = 46;
            pointsPerMeter = 2;
            par = 90;
        } else if (hill_size.equalsIgnoreCase("large")) {
            height = 70;
            pointsPerMeter = 1.8;
            par = 120;
        }

        // Prompt the user to enter the speed of the skier
        System.out.println("Enter the speed of the skier in meters/second: ");
        int speedMetersSecond = input.nextInt();
        // Prevent the user from entering a negative number
        while (speedMetersSecond < 0) {
            System.out.println("Enter a value greater than 0: ");
            speedMetersSecond = input.nextInt();
        }

        // Calculate the time in air, distance traveled, and points earned
        double timeInAir = Math.sqrt((2 * height) / 9.8);
        double distanceTraveled = speedMetersSecond * timeInAir;
        double points = 60 + (distanceTraveled - par) * pointsPerMeter;

        // Print distance traveled and points earned formatted to two decimal places
        System.out.println("The distance traveled is: " + String.format("%.2f", distanceTraveled));
        System.out.println("The number of points: " + String.format("%.2f", points));

        // Output message based on how many points they earned
        if (points > 60) {
            System.out.println("Great job for doing better than par!");
        } else if (points < 10) {
            System.out.println("What happened??");
        } else {
            System.out.println("Sorry you didn't go very far");
        }
    }
}
