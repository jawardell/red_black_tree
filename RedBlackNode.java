//http://www.sanfoundry.com/java-program-implement-red-black-tree/
//tooken from codebytes

/* Class Node */
class RedBlackNode
{
    RedBlackNode left, right;
    int element;
    int color;
    Student s;
    Faculty f;
    PhoneNumber p;

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
    
    /* Constructor for Student*/
    public RedBlackNode(Student s)
    {
        this( s, null, null );
    }
    
    /* Constructor */
    public RedBlackNode(Student s, RedBlackNode lt, RedBlackNode rt)
    {
        left = lt;
        right = rt;
        this.s = s;
        color = 1;
    }
    
     /* Constructor for Faculty*/
    public RedBlackNode(Faculty f)
    {
        this( f, null, null );
    }
    
    /* Constructor */
    public RedBlackNode(Faculty f, RedBlackNode lt, RedBlackNode rt)
    {
        left = lt;
        right = rt;
        this.f = f;
        color = 1;
    }

     /* Constructor for Phone Number */
    public RedBlackNode(PhoneNumber p)
    {
        this( p, null, null );
    }
    
    /* Constructor */
    public RedBlackNode(PhoneNumber p, RedBlackNode lt, RedBlackNode rt)
    {
        left = lt;
        right = rt;
        this.p = p;
        color = 1;
    }
    

}
