package Practice;

import java.util.*;

public class BFS {

    int vertices;
    Map<String, LinkedList<String>> adjList;
    public BFS(int vertices){
        this.vertices = vertices;
        adjList = new HashMap<>();
    }

    public void insertInGraph(String start, String end){
        if(!adjList.containsKey(start)){
            adjList.put(start, new LinkedList<>());
        }
        adjList.get(start).add(end);
    }

    public void searchInGraph(String source, String key){

        Set<String> visitedNodes = new HashSet<>();
        LinkedList<String> priorityList = new LinkedList<>();
        priorityList.add(source);
        visitedNodes.add(source);
        if(source.equals(key)){
            System.out.println("Key Found");
            return;
        }
        while(!priorityList.isEmpty()){
            String visit = priorityList.pop();
            System.out.print(visit + "->");
            for (String neighbour : adjList.get(visit)) {
                System.out.print(neighbour + ",");
                if (neighbour.equals(key)) {
                    System.out.println("Key Found");
                    return;
                }
                if (!visitedNodes.contains(neighbour)) {
                    priorityList.add(neighbour);
                    visitedNodes.add(neighbour);
                }
            }
            System.out.println();
        }
        System.out.println("Key not found");

    }



    public static void main(String args[]){
        BFS bfs = new BFS(5);
        bfs.insertInGraph("1", "2");
        bfs.insertInGraph("1", "3");
        bfs.insertInGraph("2", "4");
        bfs.insertInGraph("3", "5");
        bfs.insertInGraph("4", "5");
        bfs.insertInGraph("5", "3");

        bfs.searchInGraph("5", "2");


    }


}
