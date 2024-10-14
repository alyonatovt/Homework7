import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;
public class Solution {
    public static void main(String[] args) {
        Random random = new Random();
        int[] numbers = new int[15];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(101);
        }
        System.out.println(Arrays.toString(numbers));

        int n = numbers.length;
        for (int i = 1; i < n; i++) {
            int key = numbers[i];
            int j = i - 1;
            while (j >= 0 && numbers[j] > key) {
                numbers[j + 1] = numbers[j];
                j--;
            }
            numbers[j + 1] = key;
        }
        System.out.println(Arrays.toString(numbers));


        Scanner scanner = new Scanner(System.in);
        System.out.println("Запишіть число:");
        int target = scanner.nextInt();

        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] == target) {
                System.out.println("Індекс числа " + target + ": " + mid);
                break;
            } else if (numbers[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (left > right) {
            System.out.println("Число " + target + " не знайдено в масиві.");
        }
 }
}

