package Start;

import java.util.Stack;
import java.util.function.IntFunction;

public class StackList extends Stack<Number> {
    private StackList stack;
    private StackList() {stack = new StackList(); }

    public static void main(String[] args) {
        Stack<Number> stack = new Stack();
    }



    @Override
    public <T> T[] toArray(IntFunction<T[]> generator) {
        return super.toArray(generator);
    }
}
