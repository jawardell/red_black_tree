//http://www.sanfoundry.com/java-program-implement-red-black-tree/
//taken from codebytes

/* Class Node */
class RedBlackNode {
   RedBlackNode left, right;
	long element;
	int color;
   
	public RedBlackNode(long theElement) {
		this(theElement, null, null);
	}

	

	/* Constructor */

	/* Constructor */
	public RedBlackNode(long theElement, RedBlackNode lt, RedBlackNode rt) {
		left = lt;
		right = rt;
		element = theElement;
		color = 1;
	}

}
