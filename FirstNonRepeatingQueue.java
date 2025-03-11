import java.util.*;

public class FirstNonRepeatingQueue 
{
    public static int firstNonRepeating(Queue<Integer> queue) 
    {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : queue) 
        {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        for (int num : queue) 
        {
            if (freqMap.get(num) == 1)
                return num;
        }

        return -1;
    }

    public static void main(String[] args) 
    {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(4, 5, 1, 2, 5, 1, 4));
        System.out.println("First Non-Repeating: " + firstNonRepeating(queue));

        Queue<Integer> queue2 = new LinkedList<>(Arrays.asList(7, 7, 7));
        System.out.println("First Non-Repeating: " + firstNonRepeating(queue2));
    }
}
