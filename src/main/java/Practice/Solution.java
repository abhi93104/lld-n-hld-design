package Practice;

import java.util.*;

class Solution {

    public Boolean dfs(int node, int[][] graph, Set<Integer> notSafeNodesList, Set<Integer> processedNode){
        for(int neighbhour : graph[node]){
            if(processedNode.contains(neighbhour)){
                notSafeNodesList.add(node);
                return false;
            }
            processedNode.add(neighbhour);
            if(!dfs(neighbhour, graph, notSafeNodesList, processedNode)){
                notSafeNodesList.add(node);
                return false;
            }
        }
        return true;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> safeNodeList = new ArrayList<>();
        Set<Integer> notSafeNodeList = new HashSet<>();

        Set<Integer> processedNode = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0;i < graph.length;i ++){
            if(graph[i].length == 0){
                safeNodeList.add(i);
            }
        }

        for(int i = 0;i<graph.length;i++){
            if(!processedNode.contains(i)){
                processedNode.add(i);
                dfs(i, graph, notSafeNodeList, processedNode);
            }
        }
        for(int i = 0;i<graph.length;i++){
            if(!notSafeNodeList.contains(i)){
                safeNodeList.add(i);
            }
        }
        return safeNodeList;

    }
}

