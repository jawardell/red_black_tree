package essentials;

import schooldatabase.Student;
import schooldatabase.Faculty;
import whocalled.PhoneNumber;

public class Node {
	private String key;//We could make this a generic type. I chose String because we will be sorting on name (maybe).
	private Node left, right;
	public String[] data;
	private Boolean isRed;
	public Node(String key, String[] data) {
		Node(key, data, null, null);
	}
	
	public Node(String key, String[] data, Node left, Node right){
		this.left = left;
		this.right = right;
		isRed = false; //inserted node will be black first so initialize as black first
		this.key = key;
		this.data = data;
		
	}
	public Node getLeft() {
		if(left != null) {
			return left;
		}
		else {
			return null;
		}
	}
	
	public Node getRight() {
		if(right != null) {
			return right;
		}
		else {
			return null;
		}
	}
	
	public Node getRoot() {
		if(root != null) {
			return root;
		}
		else {
			return null;
		}
	}
	
	public boolean isRed() {
		return isRed;
	}
	
	public String getData() {
		return data;
	}
	
}
