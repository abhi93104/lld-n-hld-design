package Concurrency;

import org.junit.Assert;

import java.util.*;

public class MutiThreadSolution implements Runnable{

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    Stack<TreeNode> stackOdd = new Stack<>();
    Stack<TreeNode> stackEven = new Stack<>();
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> list = new ArrayList<>();


    public TreeNode insertData(int[] data){
        TreeNode root;
        root = new TreeNode(data[0]);
        root.left = new TreeNode(data[1]);
        root.right = new TreeNode(data[2]);

        root.right.left = new TreeNode(data[3]);
        root.right.right = new TreeNode(data[4]);

        root.right.left.left = new TreeNode(data[5]);
        root.right.left.right = new TreeNode(data[6]);
        return root;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        int height = 1;
        if(root != null){
            stackOdd.add(root);
        }
        while(!stackOdd.isEmpty() || !stackEven.isEmpty()){
            if(height % 2 == 0){
                TreeNode node = stackEven.pop();
                list.add(node.val);
                if(node.right != null){
                    stackOdd.add(node.right);
                }if(node.left != null) {
                    stackOdd.add(node.left);
                }
                if(stackEven.isEmpty()){
                    result.add(list);
                    list = new ArrayList<>();
                    height++;
                }
            }else{
                TreeNode node = stackOdd.pop();
                list.add(node.val);
                if(node.left != null){
                    stackEven.add(node.left);
                }if(node.right != null){
                    stackEven.add(node.right);
                }
                if(stackOdd.isEmpty()){
                    result.add(list);
                    list = new ArrayList<>();
                    height++;
                }
            }
        }
        return result;
    }

    @Override
    public void run() {
        TreeNode root;
        int[] data = new int[]{3,9,20,5,-11,15,7};
        root = insertData(data);
        List<List<Integer>> result = zigzagLevelOrder(root);

        Assert.assertArrayEquals(List.of(3,20,9,5,-11,7,15).toArray(), result.stream().flatMap(Collection::stream).toArray());
        System.out.printf("Test Passed at %s\n", new Date());
    }



    public static void main(String... args){
        int noOfThreads = 2;
        MutiThreadSolution mt = new MutiThreadSolution();
        for(int i=0;i<noOfThreads;i++) {
            Thread t = new Thread(mt, "Thread"+i);
            t.start();
        }

    }
}
