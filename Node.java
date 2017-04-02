package essentials;

import schooldatabase.Student;
import schooldatabase.Faculty;
import whocalled.PhoneNumber;

public class Node {
	private String data;//We could make this a generic type. I chose String because we will be sorting on name (maybe).
	private Node left, right;
	private Boolean isRed;
	public Node(String string) {
		this.string = string;
	}
	
	public Node getLeft() {
		if(!left == null) {
			return left;
		}
		else {
			return null;
		}
	}
	
	public Node getRight() {
		if(!right == null) {
			return right;
		}
		else {
			return null;
		}
	}
	
	public Node getRoot() {
		if(!root == null) {
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
