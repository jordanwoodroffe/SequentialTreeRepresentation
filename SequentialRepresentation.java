import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


/**
 * Sequential Tree Representation implementation
 */
public class SequentialRepresentation<T> implements BSPTree<T> {



    private T[] treeArray;
    private int capacity = 10;


    /**
     * Constructs empty graph.
     */
    public SequentialRepresentation() {

        // Create a generic array with fixed array capacity
        this.treeArray = (T[])new Object[capacity];

    } // end of SequentialRepresentation()




    @Override
    public void setRootNode(T nodeLabel) {

        // set root node at the first element in array
//        for(int i = 0; i < treeArray.length; i ++){
//            if(treeArray[i] == nodeLabel){
//                throw new IllegalArgumentException("Rood node already exist.");
//            }
//        }

        treeArray[0] = nodeLabel;

    } // end of setRootNode()





    @Override
    public void splitNode(T srcLabel, T leftChild, T rightChild) {

        boolean find = false;

        for(int i = 0; i < treeArray.length; i ++){
            if( srcLabel.equals(treeArray[i])){
                if(2 * i + 1 > treeArray.length || 2 * i + 2 > treeArray.length);
                    treeArray = Arrays.copyOf(treeArray, treeArray.length + 2);

                set_left(leftChild, i);
                set_right(rightChild, i);
                find = true;
                break;
            }
        }

        if (find == false) {
            System.out.print("not in the array");
        }

    } // end of splitNode


    // Helper methods for splitNode
    public void set_left(T leftChild, int index){

        int newPosition = 2 * index + 1;
        treeArray[newPosition] = leftChild;

    }

    public void set_right(T rightChild, int index){

        int newPosition = 2 * index + 2;
        treeArray[newPosition] = rightChild;

    }// end of helper methods





    @Override
    public boolean findNode(T nodeLabel) {

        boolean yes = false;

        for(int i = 0; i < treeArray.length; i ++){
            if(nodeLabel.equals(treeArray[i])) {
                yes = true;
            }
        }

        return yes;
    } // end of findNode




    @Override
    public String findParent(T nodeLabel) {

        int parent_index;
        String parent_node = null;

        for (int i = 0; i < treeArray.length; i++) {
            if (nodeLabel.equals(treeArray[i])) {

                if(i == 0){
                    return (String)nodeLabel;
                }
                else if (i % 2 == 0) {

                    parent_index = (i - 2) / 2;
                    parent_node = String.valueOf(treeArray[parent_index]);

                } else {

                    parent_index = (i - 1) / 2;
                    parent_node = String.valueOf(treeArray[parent_index]);

                }
            }
        }
        return nodeLabel + " " + parent_node;

    }    // end of findParent






    @Override
    public String findChildren(T nodeLabel) {

        String leftChild = "Null";
        String rightChild = "Null";

        for(int i = 0; i < treeArray.length; i ++){


            if(nodeLabel.equals(treeArray[i])){
                leftChild = String.valueOf(treeArray[2 * i + 1]);
                rightChild = String.valueOf(treeArray[2 * i + 2]);
                break;
            }
            else{
                System.out.println("The source code is not in the array!");
            }

        }

        return nodeLabel + " " + leftChild + " " + rightChild;
    } // end of findParent






    @Override
    public void printInInorder(PrintWriter writer) {

        inOrder(0,writer);
        writer.print("\n");

    } // end of printInPreorder



    public void inOrder(int root_index,PrintWriter writer){

        if(treeArray[root_index] != null) {
            inOrder(2 * root_index + 1, writer);
            writer.print(String.valueOf(treeArray[root_index]+" "));
            inOrder(2 * root_index + 2, writer);

        }

    }// end of helper method


    @Override
    public void printInPreorder(PrintWriter writer) {

      preOrder(0,writer);
      writer.print("\n");

    } // end of printInInorder


    public void preOrder(int root_index,PrintWriter writer){

        if(treeArray[root_index] != null) {
            writer.print(String.valueOf(treeArray[root_index]+" "));
            preOrder(2 * root_index + 1, writer);
            preOrder(2 * root_index + 2, writer);
        }

    } // end of helper method

    @Override
    public void printInPostorder(PrintWriter writer) {

      postOrder(0,writer);
      writer.print("\n");

    } // end of printInPostorder


    public void postOrder(int root_index, PrintWriter writer){

        if(treeArray[root_index] != null) {
            postOrder(2 * root_index + 1, writer);
            postOrder(2 * root_index + 2, writer);
            writer.print(String.valueOf(treeArray[root_index]+" "));
        }

    }// end of helper method

} // end of class SequentialRepresentation
