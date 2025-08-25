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


        // Very Basic but Important:

        Integer ii = 0;
        //Integer to String
        String si = ii.toString();
        //String to Integer
        Integer sii = Integer.valueOf(si);

        char cc = 'a';
        //Char to String
        String sc = Character.toString(cc);
        //Char to Integer
        int cint = (int)cc;
        //Ascii number to Value
        char cChar = (char)cint;

        // char[] to String:
        String testS = "This is a string";
        char[] testArr = testS.toCharArray();
        String.valueOf(testArr);
        int[] smallestNoArray = new int[]{1,2,3,4,5,6};
        System.out.println(Arrays.toString(smallestNoArray));

        List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "6");
        List<Integer> list = Arrays.asList(10, 23, -4, 0, 18);

        int[] A = {5,2,3,7,1,6,4};
        Arrays.sort(A);

        int[][] twoDim = { { 1, 2 }, { 3, 7 }, { 8, 9 }, { 4, 2 }, { 5, 3 } };
        Arrays.sort(twoDim, (o1, o2) -> o2[1] - o1[1]);
        System.out.println(Arrays.deepToString(twoDim));

        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 6));



        // Array
        System.out.println("Array");
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
        System.out.println("\n\n\nSet");
        Set<Integer> set = new HashSet<>();
        Set<Integer> set4 = new HashSet<>(Arrays.asList(1, 2, 3, 6));
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


        System.out.println("\n\n\nMap");
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

        // LinkedList

        System.out.println("\n\n\nLinkedList");
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

        // remove an element from LinkedList
        int removeInt = 7;
        int updateInt = 9;
        Iterator<Integer> it = lt.iterator(); // Can be used to traverse List, Set, Stack.
        ListIterator<Integer> lit = lt.listIterator(); // ListIterator specially designed to traverse List;
        while(lit.hasNext()){
            if(lit.next() == removeInt){
                lit.remove();
            }else if(lit.next() == updateInt){
                lit.set(99);
            }
        }

        for(int i : lt){
            System.out.println(i);
        }



        //Stack FILO
        System.out.println("\n\n\nStack");
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
        System.out.println("\n\n\nQueue");
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
        System.out.println("\n\n\nPair");
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



        // String Manipulation

        System.out.println("\n\n\nString Manipulation");
        String s = "This is a string";
        System.out.println(s.length());
        System.out.println(s.charAt(2));
        System.out.println(s.contains("is"));

        char[] cArray = s.toCharArray();

        for(char c : s.toCharArray()){
            System.out.print(c);
        }
        System.out.println();


        StringBuilder sb = new StringBuilder();
        sb.append("Hello");
        sb.append(" ");
        sb.append("World");
        String result = sb.toString();
        System.out.println(result);




        // Rough



    }

}