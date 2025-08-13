package Practice;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.MutablePair;

import java.util.*;

public class JavaBasicPractice {

    /*
        Initialize the following and perform CRUD and length operations:
        1. Array
        2. Set
        3. Map
        4. List
        5. Stack
        6. Queue
     */

    public static void main(String args[]) {

        // Array
        int n = 10;
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int[] arr2 = new int[n];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 1;
        arr2[4] = 5;
        System.out.println(arr[2]);
        System.out.println(arr2[4]);
        arr[2] = 10;
        System.out.println(arr[2]);
        arr[2] = -1;
        System.out.println(arr.length);


        // Set

        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 6));
        Set<Integer> set3 = Set.of(1, 2, 3, 5, 6, 7);
        set.add(3);
        set.add(5);
        if (set.contains(5)) {
            System.out.println("Element present");
        } else {
            System.out.println("Element not present");
        }
        set.remove(5);
        if (set.contains(5)) {
            System.out.println("Element present");
        } else {
            System.out.println("Element not present");
        }
        if (set2.contains(6)) {
            System.out.println("Element present");
        } else {
            System.out.println("Element not present");
        }
        if (set3.contains(7)) {
            System.out.println("Element present");
        } else {
            System.out.println("Element not present");
        }

        //Map

        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> map2 = Map.of("1", 1, "2", 2, "3", 3);
        map.put("One", 1);
        if (map.containsKey("1")) {
            System.out.println("Present");
        } else {
            System.out.println("Not Present");
        }
        if (map.containsKey("One")) {
            System.out.println("Present");
        } else {
            System.out.println("Not Present");
        }
        if (map2.containsKey("1")) {
            System.out.println("Present");
        } else {
            System.out.println("Not Present");
        }
        for (Map.Entry<String, Integer> x : map.entrySet()) {
            System.out.println(x.getKey());
        }

        // List
        List<Integer> lt = new LinkedList<>();

        lt.add(1);
        lt.add(2);
        lt.add(1);
        lt.add(6);
        lt.add(7);
        lt.add(8);
        lt.add(9);
        lt.add(0);
        lt.add(11);

        for(int i : lt){
            System.out.println(i);
        }



        //Stack FILO
        Stack<Integer> st = new Stack<>();
        st.push(3);
        st.push(5);
        st.push(4);
        st.push(1);
        st.push(8);
        st.push(6);
        st.push(9);
        st.push(11);

        while(!st.isEmpty()){
            int e = st.pop();
            System.out.println(e);
        }



        //Queue FIFO
        Queue<Integer> queue = new LinkedList<>();
        queue.add(3);
        queue.add(5);
        queue.add(7);
        queue.add(23);
        queue.add(45);
        queue.add(67);
        queue.add(10);
        queue.size();
        while (!queue.isEmpty()){
            int e = queue.poll();
            System.out.println(e);
        }


        // Pair
        MutablePair<Integer, Integer> pair = new MutablePair<>(1,2);
        System.out.println(pair.getLeft() + ":" + pair.getRight());
        pair.setLeft(2);
        System.out.println(pair.getLeft() + ":" + pair.getRight());

        ImmutablePair<Integer, Integer> imPair = new ImmutablePair<>(99, 100);
        System.out.println(imPair.getLeft() + ":" +  imPair.getRight());
        long a=1;
        long b = 9;
        List<Long> l = new ArrayList<>();
        l.sort((o1, o2) -> o1 > o2 ? -1 : 1);

    }

}