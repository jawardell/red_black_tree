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
  
  public Node leftRotate(Node n1) {
    
     Node n2 = n1.left;
     n1.left = n2.right;
     n2.right = n1;
      
     return n2;
      
    
  }
  
  private void fix(){
    
  }
  
  public Node rotate(){
    
  }
  
  public Node rightRotate(Node n1) {
      
    Node n2 = n1.right;
    n1.right = n2.left;
    n2.left = n1;
    
    return n2;
  }
  
  public void traverse() {
    //print out the tree with some traversal
    System.out.print();
  }
  
  
  
  
  
}
