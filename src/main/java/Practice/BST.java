package Practice;

public class BST {
    node root;
    class node{
        Double data;
        node left;
        node right;

        public node(Double data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public void insertInBST(Double data){
        this.root = this.insert(root, data);
    }

    private node insert(node head, Double data){
        if(head == null){
            return new node(data);
        }
        if(data < head.data){
            head.left = insert(head.left, data);
        }else{
            head.right = insert(head.right, data);
        }
        return head;
    }


    public void searchInBST(Double key){
        search(root, key);
    }

    private void search(node head, Double key){
        if(head == null){
            System.out.println("Key Not Found");
            return;
        }
        if(head.data.equals(key)){
            System.out.println("Key Found");
            return;
        }
        if(key < head.data){
            search(head.left, key);
        }else{
            search(head.right, key);
        }
    }

    public void inorderBST(){
        inorder(root);
    }

    private void inorder(node head){
        if(head == null){
            return;
        }
        inorder(head.left);
        System.out.println(head.data);
        inorder(head.right);
    }

    public void deleteInBST(Double key){
        root = delete(root, key);
    }

    private Double findSmallestElement(node head){
        if(head.left == null){
            return head.data;
        }
        return findSmallestElement(head.left);
    }
    private node delete(node head, Double key){
        if(head == null){
            return head;
        }
        if(key.equals(head.data)){
            if(head.left == null){
                head = head.right;
            }else if(head.right == null){
                head = head.left;
            }else{
                // find smallest element on the right side and replace it with key
                Double smallestValue = findSmallestElement(head.right);
                head.data = smallestValue;
                head.right = delete(head.right, smallestValue);
            }
        }else{
            if(key < head.data){
                head.left = delete(head.left, key);
            }else{
                head.right = delete(head.right, key);
            }
        }
        return head;
    }



    public static void main(String args[]){
        BST bst = new BST();
        bst.insertInBST(8.0);
        bst.insertInBST(3.0);
        bst.insertInBST(10.0);
        bst.insertInBST(1.0);
        bst.insertInBST(9.0);
        bst.insertInBST(5.0);
        bst.insertInBST(11.0);
        bst.insertInBST(4.0);
        bst.insertInBST(6.0);
        bst.insertInBST(7.0);
        bst.insertInBST(5.5);
        bst.insertInBST(5.6);


        bst.searchInBST(11.0);

        bst.inorderBST();
        System.out.println("------------------");
        bst.deleteInBST(5.0);
        bst.inorderBST();

    }

}

