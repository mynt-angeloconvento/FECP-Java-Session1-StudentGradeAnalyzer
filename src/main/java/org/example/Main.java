package org.example;

import java.util.*;

public class Main {
    public static String calculateLetterGrade(int score) {
        String grade = "";
        if (score >= 90 && score <= 100)
            grade = "A";
        else if (score >= 80)
            grade = "B";
        else if (score >= 70)
            grade = "C";
        else if (score >= 60)
            grade = "D";
        else
            grade = "F";
        return grade;
    }

    public static float calculateAverage(int[] scores) {
        float sum = 0, average = 0;
        for (int score : scores) {
            sum += score;
        }
        average = sum / scores.length;
        return average;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] gradeCounts = new int[5];

        int num = 0;
        while (true) {
            System.out.print("Enter number of students: ");
            try {
                num = Integer.parseInt(scanner.nextLine());
                if (num <= 0) {
                    System.out.println("Number of students must be positive.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }

        String[] names = new String[num];
        int[] scores = new int[num];
        String[] topStudents = new String[num];
        int topStudentsCount = 0;
        int highestScore = -1;

        for (int i = 1; i <= num; i++) {
            System.out.printf("%nEnter name of student %d: ", i);
            String name = scanner.nextLine();
            names[i - 1] = name;

            int score = -1;
            while (true) {
                System.out.printf("Enter score for %s: ", name);
                try {
                    score = Integer.parseInt(scanner.nextLine());
                    if (score < 0 || score > 100) {
                        System.out.println("Score must be between 0 and 100.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                }
            }
            scores[i - 1] = score;

            if (score > highestScore) {
                highestScore = score;
                topStudentsCount = 0;
                topStudents[topStudentsCount] = name;
                topStudentsCount++;
            } else if (score == highestScore) {
                topStudents[topStudentsCount] = name;
                topStudentsCount++;
            }

            String letterGrade = (calculateLetterGrade(score));
            switch (letterGrade) {
                case "A":
                    gradeCounts[0]++;
                    break;
                case "B":
                    gradeCounts[1]++;
                    break;
                case "C":
                    gradeCounts[2]++;
                    break;
                case "D":
                    gradeCounts[3]++;
                    break;
                case "F":
                    gradeCounts[4]++;
                    break;
                default:
                    break;
            }
            System.out.printf("%s got grade: %s %n", name, letterGrade);
        }

        System.out.printf("%n----- Class Summary -----%n");
        System.out.printf("Average Score: %.2f %n", calculateAverage(scores));

        System.out.printf("Grade Counts: ");
        System.out.printf("A:%d ", gradeCounts[0]);
        System.out.printf("B:%d ", gradeCounts[1]);
        System.out.printf("C:%d ", gradeCounts[2]);
        System.out.printf("D:%d ", gradeCounts[3]);
        System.out.printf("F:%d %n", gradeCounts[4]);
        System.out.printf("Top Student(s): ");
        for (int i = 0; i < topStudentsCount; i++) {
            System.out.printf(topStudents[i]);
            if (i < topStudentsCount - 1)
                System.out.print(", ");
        }
        System.out.printf(" (%d) %n", highestScore);
    }
}
