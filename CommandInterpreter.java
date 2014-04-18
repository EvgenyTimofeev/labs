import java.io.*;
import java.util.zip.DataFormatException;

public class CommandInterpreter {
    public static void main(String[] args) {
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            if (args.length == 0) {
                File input = new File("input.txt");
                if (!input.exists()) input.createNewFile();
                in = new BufferedReader(new FileReader(input));
                out = new PrintWriter(new FileWriter(new File("output.txt")));
            } else {
                in = new BufferedReader(new FileReader(args[0]));
                out = new PrintWriter(new FileWriter(args[1]));
            }
            LinkedStack<Integer> myStack = new LinkedStack<Integer>();
            while (in.ready()) {
                String inputData = in.readLine();
                if (inputData.isEmpty()) continue;
                String[] str = inputData.split(" ");
                out.println("Command: " + inputData);
                if (str[0].equals("push")) {
                    myStack.push(Integer.parseInt(str[1]));
                } else if (str[0].equals("pop")) {
                    out.println("pop " + myStack.pop());
                } else if (str[0].equals("peek")) {
                    out.println("peek " + myStack.peek());
                } else if (str[0].equals("isEmpty")) {
                    out.println("is empty: " + myStack.isEmpty());
                } else if (str[0].equals("clear")) {
                    myStack.clear();
                } else if (str[0].equals("size")) {
                    out.println("size = " + myStack.size());
                } else if (str[0].equals("toString")) {
                    out.println("stack: " + myStack.toString());
                } else {
                    throw new DataFormatException("Unknown command " + str[0]);
                }
            }
        } catch (Exception e) {
            if (out != null) out.println(e);
            System.err.print(e);
        } finally {
            try {
                if (out != null) out.close();
                if (in != null) in.close();
            } catch (Exception e) {
                if (out != null) out.println(e);
                System.err.print(e);
            }
        }

    }
}
