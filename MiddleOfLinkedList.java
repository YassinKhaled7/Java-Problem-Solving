import java.util.LinkedList;

public class MiddleOfLinkedList {
    public static void findMiddle(LinkedList<Integer> list) {
        int size = list.size();
        int mid = size / 2;

        if (size % 2 == 1) { 
            System.out.println("Middle Element: " + list.get(mid));
        } else { 
            System.out.println("Middle Elements: " + list.get(mid - 1) + ", " + list.get(mid));
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        findMiddle(list1);

        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(10);
        list2.add(20);
        list2.add(30);
        list2.add(40);
        list2.add(50);
        list2.add(60);
        findMiddle(list2);
    }
}
