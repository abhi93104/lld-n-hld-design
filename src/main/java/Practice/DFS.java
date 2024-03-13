package Practice;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class DFS {

    int vertices;
    Map<String, LinkedList<String>> adjList;
    Map<String, Boolean> visitedNodes;
    public DFS(int vertices){
        this.vertices = vertices;
        adjList = new HashMap<>();
        visitedNodes = new HashMap<>();
    }

    public void insertInGraph(String start, String end){
        if(!adjList.containsKey(start)){
            adjList.put(start, new LinkedList<>());
        }
        adjList.get(start).add(end);
    }

    public void traverseInGraph(String source){
        visitedNodes.put(source, true);
        traverseUtils(source);
    }

    private void traverseUtils(String head){
        System.out.print(head +"->");
        for(String neighbour : adjList.get(head)) {
            if (!visitedNodes.containsKey(neighbour)) {
                visitedNodes.put(neighbour, true);
                traverseUtils(neighbour);
            }
        }
    }

    public static void main(String args[]){
        DFS dfs = new DFS(5);
        dfs.insertInGraph("1", "2");
        dfs.insertInGraph("1", "3");
        dfs.insertInGraph("2", "4");
        dfs.insertInGraph("3", "5");
        dfs.insertInGraph("4", "5");
        dfs.insertInGraph("5", "3");

        dfs.traverseInGraph("1");


    }

}
