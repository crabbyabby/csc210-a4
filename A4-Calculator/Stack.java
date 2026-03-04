/**
 * Class to implement a stack
 * @author Abigail Lei
 * @version Spring 2026
 */
public class Stack<T> implements StackADT<T>{

    // Attributes
    private NodeSL<T> head;
    private int size;

    /**
     * Constructor for stack
     * sets head to null and size to 0
     */
    Stack() {
        this.head = null;
        this.size = 0;
    }

    /** Add item onto stack
     * @param value element to add */
    public void push(T value) {
        if (isEmpty()) {
            NodeSL<T> newNode = new NodeSL<T>(value, null);
            this.head = newNode;
            this.size++;
        } else {
            NodeSL<T> newNode = new NodeSL<T>(value, this.head);
            this.head = newNode;
            this.size++;
        }
    }

    /** Remove top item from the stack
     * @return element at top of stack */
    public T pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Cannot pop empty stack.");
        } else {
            T data = this.head.getData();
            this.head = this.head.getNext();
            this.size--;
            return data;
        }
    }

    /** Returns top item from the stack without removing
     * @return element at top of stack 
     * @throws IndexOutOfBoundsException if stack is empty
     */
    public T peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Cannot peek empty stack.");
        } else {
            return this.head.getData();
        }
    }

    /** Returns true if there are no elements to pop
     * @return true if stack is empty, false otherwise */
    public boolean isEmpty() {
        if (this.size == 0){
            return true;
        } else {
            return false;
        }
    }

    /** Returns number of elements in the stack
     * @return number of elements */
    public int size() {
        return this.size;
    }

    public void main(String[] args) {
        Stack<Integer> stacker = new Stack<Integer>();
        System.out.println(stacker.isEmpty());
        stacker.push(3);
        stacker.push(4);
        stacker.push(5);
        System.out.println(stacker.peek());
        System.out.println(stacker.size());
        System.out.println(stacker.pop());
        System.out.println(stacker.size());
        System.out.println(stacker.pop());
        System.out.println(stacker.pop());
    }
}
