//package dataStructures;

/**
 *	Class OrderedLinkedList.
 *
 *	This class functions as a linked list, but ensures items are stored in ascending order.
 *
 */
public class OrderedLinkedList
{

    /**************************************************************************
     * Constants
     *************************************************************************/

    /** return value for unsuccessful searches */
    private static final OrderedListNode NOT_FOUND = null;


    /**************************************************************************
     * Attributes
     *************************************************************************/

    /** current number of items in list */
    private int theSize;

    /** reference to list header node */
    private OrderedListNode head;

    /** reference to list tail node */
    private OrderedListNode tail;

    /** current number of modifications to list */
    private int modCount;


    /**************************************************************************
     * Constructors
     *************************************************************************/


    /**
     *	Create an instance of OrderedLinkedList.
     *
     */
    public OrderedLinkedList()
    {
        // empty this OrderedLinkedList
        clear();
    }


    /**************************************************************************
     * Methods
     *************************************************************************/


    /*
     *	Add the specified item to this OrderedLinkedList.
     *
     *	@param	obj		the item to be added
     */
    public boolean add(Comparable obj)
    {
        // TODO: Implement this method (8 points)
        OrderedListNode node = new OrderedListNode(obj);

        if(head.next == tail)
        {
            head.next = node;
            node.next = tail;
            tail.previousValue = node;
            modCount++;
            theSize++;
            return true;
        }
       // int result = node.theItem.compareTo(head.theItem);
        if(obj.compareTo(head.next.theItem) < 0)
        {
            node.next = head.next;
            head.next = node;
            modCount++;
            theSize++;
            return true;
        }
//This is from the inner class variables
        OrderedListNode current = head.next;
        OrderedListNode previous = head;
       // int currentValue = Integer.parseInt(node.theItem.toString());
        while(current != tail && (node.theItem).compareTo(current.theItem) >= 0)
        {
            previous = current;
            current = current.next;
        }
        previous.next = node;
        node.next = current;
        modCount++;
        theSize++;
        return true;
    }
    /*
     *	Remove the first occurrence of the specified item from this OrderedLinkedList.
     *
     *	@param	obj		the item to be removed
     */
    public boolean remove(Comparable obj) {
        // TODO: implement this method
        OrderedListNode nodeBeforeDelete = this.head;
        if (nodeBeforeDelete == null) { // List in empty
            return false;
        } else if (nodeBeforeDelete.getData() == obj) {
            this.head = this.head.getNext();
            modCount++;
            return true;
        }
        while (true) {
            OrderedListNode next = nodeBeforeDelete.getNext();
            if (next == null) { // No data found in list
                return false;
            } else if (next.getData() == obj) {
                break;
            }
            nodeBeforeDelete = next;
        }
        OrderedListNode next = nodeBeforeDelete.getNext();
        nodeBeforeDelete.next = next.getNext();
        next.next = null;
        modCount++; // look into where this actual;ly needs to go, MAybe after any return?
        theSize --; // also need to decrement the size of the list after we remove the obj
        return true;
    }
    /**
     *	Empty this OrderedLinkedList.
     */
    public void clear()
    {
        // reset header node
        head = new OrderedListNode("HEAD", null, null);
        // reset tail node
        tail = new OrderedListNode("TAIL", head, null);
        // header references tail in an empty LinkedList
        head.next = tail;
        // reset size to 0
        theSize = 0;
        // emptying list counts as a modification
        modCount++;
    }

    /**
     *	Return true if this OrderedLinkedList contains 0 items.
     */
    public boolean isEmpty()
    {
        return theSize == 0;
    }

    /**
     *	Return the number of items in this OrderedLinkedList.
     */
    public int size()
    {
        return theSize;
    }
    /*
     *	Return a String representation of this OrderedLinkedList.
     *
     *	(non-Javadoc)
     *	@see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        String s = "";
        OrderedListNode currentNode = head.next;
        while (currentNode != tail)
        {
            s += currentNode.theItem.toString();

            if (currentNode.next != tail)
            {
                s += ", ";
            }
            currentNode = currentNode.next;
        }
        return s;
    }
    /**************************************************************************
     * Inner Classes
     *************************************************************************/

    /**
     *	Nested class OrderedListNode.
     *
     *	Encapsulates the fundamental building block of an OrderedLinkedList
     *	contains a data item, and references to both the next and previous nodes
     *	in the list
     */

    // TODO: Implement the nested class OrderedListNode (5 points).  This nested class
    // should be similar to the nested class ListNode of the class LinkedList, but
    // should store a data item of type Comparable rather than Object.
    public static class OrderedListNode
    {
//comparable objects
        Comparable theItem;
        OrderedListNode next;
        OrderedListNode previousValue;
        OrderedListNode(Comparable ItemValue)
        {
            this(ItemValue, null, null);
        }
        OrderedListNode(Comparable ItemValue, OrderedListNode previousValue, OrderedListNode next)
        {
            this.theItem = ItemValue;
            this.next = next;
            this.previousValue = previousValue;
        }
//comparable getdata
        Comparable getData()
        {
            return theItem;
        }
        OrderedListNode getNext()
        {
            return next;
        }
        OrderedListNode getPrev()
        {
            return previousValue;
        }

    }
//creation of main methods
//    public static void main(String[] args)
//    {
////object for the class OrderedLinkedList
//        OrderedLinkedList listObj = new OrderedLinkedList();
//       listObj.add("aa");
//        listObj.add("bb");
//
//        listObj.add("cc");

//       listObj.add("dd");
//
//        listObj.add("ee");
//
//        listObj.add("ff");
//
//
//        System.out.println(listObj);
//        listObj.remove("cc");
//
//        System.out.println("This should remove 'cc' " + listObj);
//
//    }
}
