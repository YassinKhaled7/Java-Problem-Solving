import java.util.*;

public class FirstNonRepeatingQueue {
    public static int firstNonRepeating(Queue<Integer> queue) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        // Count occurrences of each element
        for (int num : queue) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Find the first non-repeating element
        for (int num : queue) {
            if (freqMap.get(num) == 1) return num;
        }

        return -1; // If all elements repeat
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(4, 5, 1, 2, 5, 1, 4));
        System.out.println("First Non-Repeating: " + firstNonRepeating(queue)); // Output: 2

        Queue<Integer> queue2 = new LinkedList<>(Arrays.asList(7, 7, 7));
        System.out.println("First Non-Repeating: " + firstNonRepeating(queue2)); // Output: -1
    }
}
