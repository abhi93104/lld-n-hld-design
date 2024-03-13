package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * The Main class implements an application that reads lines from the standard input
 * and prints them to the standard output.
 */
public class Main {

    public static final String RETURN_TRUE = "True";
    public static final String RETURN_FALSE = "False";
    public static final String RETURN_ERROR = "Error Thrown!";

    public static Boolean traverseInGraph(String source, Map<String, LinkedList<String>> adjList, Set<String> visitedNodes){

        Set<String> intermediateVisitedNodes = new HashSet<>();
        LinkedList<String> priorityList = new LinkedList<>();
        priorityList.add(source);
        if(visitedNodes.contains(source)){
            return Boolean.TRUE;
        }
        intermediateVisitedNodes.add(source);
        while(!priorityList.isEmpty()){
            String visit = priorityList.pop();
//            System.out.print(visit + "->");
            if(adjList.containsKey(visit)) {
                for (String neighbour : adjList.get(visit)) {
//                System.out.print(neighbour + ",");
                    if (intermediateVisitedNodes.contains(neighbour)) {
                        throw new IllegalArgumentException();
                    } else if (visitedNodes.contains(neighbour)) {
//                    System.out.println("Key Found");
                        return Boolean.TRUE;
                    } else {
                        priorityList.add(neighbour);
                        intermediateVisitedNodes.add(neighbour);
                        visitedNodes.add(neighbour);
                    }
                }
            }
//            System.out.println();
        }
        return Boolean.FALSE;
    }
    public static String DoLinkedListsIntersect(Map<String, LinkedList<String>> adjList, Set<String> traverseNodes){
        Set<String> visitedNodes = new HashSet<>();
        for(String node : traverseNodes){
            try {
                if (traverseInGraph(node, adjList, visitedNodes)) {
                    return RETURN_TRUE;
                }
            }catch (IllegalArgumentException iaex){
                return RETURN_ERROR;
            }

        }
        return RETURN_FALSE;
    }
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;

        Map<String, LinkedList<String>> adjList = new HashMap<>();
        List<Set<String>> traverseNodesList = new ArrayList<>();

        while ((line = in.readLine()) != null) {
            if(line.contains("->")){
                // System.out.println(line);
                String[] splitLine = line.split("->");
                adjList.put(splitLine[0], new LinkedList<>());
                adjList.get(splitLine[0]).add(splitLine[1]);
            }else{
                String[] nodes = line.split(",");
                traverseNodesList.add(Set.of(nodes));
            }
        }
        for(Set<String> traverseNodes : traverseNodesList){
            System.out.println(DoLinkedListsIntersect(adjList, traverseNodes));
        }
    }
}
