package app;

import java.util.Random;
import java.util.Scanner;

public class SortTimes {
    
    public static void main(String[] args) {
        int n = 10000;
        int[] arr = new int[n];
        Random rand = new Random();
        
        // Generating 10,000 random numbers between 0 and 100,000
        for(int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(100001);
        }
        
        System.out.println("Create 10,000 random numbers from 0 to 100,000:");
        
        Scanner sc = new Scanner(System.in);
        
        // Infinite loop to keep taking user input until 'Quit' is entered
        while(true) {
            System.out.println("What is the method you want to sort (Selection, Insertion, Shell, Quit)?");
            String method = sc.nextLine();

            if(method.equalsIgnoreCase("Quit")) {
                System.out.println("Goodbye.");
                break;
            }
            
            // Clone the original array so each sort method works with the same unsorted array
            int[] tempArr = arr.clone(); 
            
            // Capture start time
            long startTime = System.currentTimeMillis();
            
            // Sort based on user's choice and calculate the time taken
            switch(method.toLowerCase()) {
                case "selection":
                    selectionSort(tempArr);
                    break;
                case "insertion":
                    insertionSort(tempArr);
                    break;
                case "shell":
                    shellSort(tempArr);
                    break;
                default:
                    System.out.println("Invalid input. Please choose from Selection, Insertion, Shell, or Quit.");
                    continue;
            }
            
            // Capture end time
            long endTime = System.currentTimeMillis();

            // Calculate and display the time taken for the sort operation
            double time = (endTime - startTime) / 1000.0;
            System.out.println("The time performance of " + method.toLowerCase() + " sort is " + time + " sec");
        }
        sc.close();
    }

    /**
     * Selection Sort algorithm
     * @param arr - array to be sorted
     */
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    /**
     * Insertion Sort algorithm
     * @param arr - array to be sorted
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    /**
     * Shell Sort algorithm
     * @param arr - array to be sorted
     */
    public static void shellSort(int[] arr) {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int key = arr[i];
                int j = i;
                while (j >= gap && arr[j - gap] > key) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = key;
            }
        }
    }
}
