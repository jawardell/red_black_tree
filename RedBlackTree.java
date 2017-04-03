package essentials;

import schooldatabase.Student;
import schooldatabase.Faculty;
import whocalled.PhoneNumber;
import Node.java;

public class RedBlackTree{
  
  protected Node root;
  protected int size;
  
  public RedBlackTree(Node root) {
    this.root = root;
  }
  
  public boolean insert(Node node) {
    //insert the node
    //order the tree
    //balance the tree
    //change the colors of the nodes
    //we could make this void
    return true;
  }
  
  public boolean remove(Node node) {
    //find the node
    //remove the node
    //order the tree
    //balance the tree
    //change the colors of the nodes
    //we could make this void
    return true;
  }
    
  private void fix(){
    
  }
  
  //http://www.sanfoundry.com/java-program-implement-red-black-tree/, method similar to here
  public Node rotate(){
    
    if(data < parent.element.value){
        if(data < parent.left)
            parent.left = leftRotate(parent.left)
        else
            parent.left = rightRotate(parent.left)   
        return parent.left;
    }
    
    else {
        if (data< parent.right.value)
          parent.right = rotateWithLeftChild(parent.right) 
        else
          parent.right = rotateWithRightChild(parent.right);
      return parent.right
    }
    
  }//end of rotate
  
  
  public Node rightRotate(Node n1) {
      
    Node n2 = n1.right;
    n1.right = n2.left;
    n2.left = n1;
    
    return n2;
  }//end of rightRotate
  
  public Node leftRotate(Node n1) {
    
     Node n2 = n1.left;
     n1.left = n2.right;
     n2.right = n1;
      
     return n2;
  }//end of leftRotate
  
  public void traverse() {
    //print out the tree with some traversal
    System.out.print();
  }//end of traverse
  
  
  
  
  
}
