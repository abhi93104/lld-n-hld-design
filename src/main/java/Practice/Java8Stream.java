package Practice;

import java.util.*;

public class Java8Stream {


    public static void main(String args[]){
        List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "6");

        //Convert list of string to even number list
        List<Integer> result1 = numbers.stream().map(Integer::valueOf).filter(y-> y%2==0).toList();
        System.out.println(result1);

        class bookDetails{
            String bookName; String authorFirstName; String authorSurName; Integer authorAge; String authorGender; Integer salary;
            bookDetails(String bookName, String authorFirstName, String authorSurName, Integer authorAge, String authorGender, Integer salary){
                this.bookName=bookName; this.authorFirstName=authorFirstName; this.authorSurName=authorSurName;
                this.authorAge=authorAge; this.authorGender=authorGender; this.salary=salary;
            }

            @Override
            public String toString(){
                return this.bookName + " | " + this.authorFirstName + " | " + this. authorSurName + " | " + this.authorAge + " | " + this.authorGender + " | " + this.salary;
            }

        }
        List<bookDetails> library = new ArrayList<>();
        library.add(new bookDetails("A","Shubham","Jain",56,"male",20000));
        library.add(new bookDetails("B","Anjali","Gupta",25,"female",40000));
        library.add(new bookDetails("C","Reema","Sharma",21,"female",30000));
        library.add(new bookDetails("CD","Seema","Kapoor",20,"female",20000));
        library.add(new bookDetails("D","Gaurav","Jain",54,"male",30000));
        library.add(new bookDetails("E","Ravi","Sharma",65,"male",40000));
        library.add(new bookDetails("E","Ravi2","Sharma",70,"male",140000));

        // Get the unique surnames in uppercase of the first 15 book authors that are 50 years old or older.
        List<String> result2 = library.stream()
                .filter(x -> x.authorAge>=50)
                .map(x-> x.authorSurName)
                .distinct()
                .limit(15)
                .map(String::toUpperCase)
                .toList();
        System.out.println(result2);


        //  Print out the sum of ages of all female authors younger than 25.
        Integer result3 = library.stream().filter(x-> x.authorGender.equals("female")).map(x-> x.authorAge).filter(y->y<25).reduce(0, Integer::sum);
        System.out.println(result3);


        //Return first author with a salary greater than 100000 . If no such employee exists, then null is returned.
        String result4 = library.stream().filter(x->x.salary>100000).map(x->x.authorFirstName).findFirst().orElse(null);


        List<Integer> list = Arrays.asList(10, 23, -4, 0, 18);
        // Sorting using collections(Descending)
        list.sort(Comparator.comparing(x->-x));
        System.out.println(list);
        Collections.sort(list, (o1,o2)->o2-o1);

        List<Integer> list2 = Arrays.asList(10, 23, -4, 0, 18);
        // Sorting using stream
        System.out.println(list2.stream().sorted().toList());
        System.out.println(list2.stream().sorted(Collections.reverseOrder()).toList());

        List<String> INPUT_NAMES = Arrays.asList("john", "mike", "usmon", "ken", "harry");
        Collections.sort(INPUT_NAMES);
        System.out.println(INPUT_NAMES);

        int[] A = {5,2,3,7,1,6,4};
        Arrays.sort(A);
        System.out.println(Arrays.toString(A));

        int[][] twoDim = { { 1, 2 }, { 3, 7 }, { 8, 9 }, { 4, 2 }, { 5, 3 } };
        Arrays.sort(twoDim, (o1, o2) -> o2[1] - o1[1]);
        System.out.println(Arrays.deepToString(twoDim));

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.remove(2);
        System.out.println(set.iterator().next());


        // TREEMAP
        SortedMap<bookDetails, Integer> treeMap = new TreeMap<>((o1, o2) -> o2.authorAge-o1.authorAge);
        treeMap.put(new bookDetails("A","Shubham","Jain",56,"male",20000), 1);
        treeMap.put(new bookDetails("B","Anjali","Gupta",25,"female",40000), 2);
        treeMap.put(new bookDetails("C","Reema","Sharma",21,"female",30000), 3);
        treeMap.put(new bookDetails("CD","Seema","Kapoor",20,"female",20000), 4);
        treeMap.put(new bookDetails("D","Gaurav","Jain",54,"male",30000), 5);
        treeMap.put(new bookDetails("E","Ravi","Sharma",65,"male",40000), 6);
        treeMap.put(new bookDetails("E","Ravi2","Sharma",70,"male",140000), 7);
        System.out.println(treeMap);

        SortedSet<bookDetails> sortedSet = new TreeSet<>((o1, o2)-> o2.salary-o1.salary);
        sortedSet.add(new bookDetails("A","Shubham","Jain",56,"male",20000));
        sortedSet.add(new bookDetails("B","Anjali","Gupta",25,"female",40000));
        sortedSet.add(new bookDetails("C","Reema","Sharma",21,"female",30000));
        sortedSet.add(new bookDetails("CD","Seema","Kapoor",20,"female",20000));
        sortedSet.add(new bookDetails("D","Gaurav","Jain",54,"male",30000));
        sortedSet.add(new bookDetails("E","Ravi","Sharma",65,"male",40000));
        sortedSet.add(new bookDetails("E","Ravi2","Sharma",70,"male",140000));
        System.out.println(sortedSet);

    }


}
