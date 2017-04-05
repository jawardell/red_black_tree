//http://www.sanfoundry.com/java-program-implement-red-black-tree/
//tooken from codebytes

/* Class Node */
class RedBlackNode
{
    RedBlackNode left, right;
    int element;
    int color;

    /* Constructor */
    public RedBlackNode(int theElement)
    {
        this( theElement, null, null );
    }
    /* Constructor */
    public RedBlackNode(int theElement, RedBlackNode lt, RedBlackNode rt)
    {
        left = lt;
        right = rt;
        element = theElement;
        color = 1;
    }
}
