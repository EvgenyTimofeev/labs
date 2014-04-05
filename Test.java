/**
 * Created by Администратор on 04.04.14.
 */
public class Test {
    public static void main(String[] args) {
        LinkedStack<Integer> myStack = new LinkedStack<Integer>();
        myStack.push(null);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.push(null);
        System.out.println(myStack);
        System.out.println("peek " + myStack.peek());
        System.out.println("pop " + myStack.pop());
        System.out.println("size " + myStack.size());
        System.out.println("is empty " + myStack.isEmpty());
    }
}
