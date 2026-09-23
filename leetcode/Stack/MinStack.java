package Stack;
class MinStack {
    Stack <Integer> stack;
    Stack <Integer> minStack;

    public MinStack() {
        stack= new Stack<> ();
        minStack = new Stack<> ();
        
    }
    
    public void push(int value) {
        stack.push(value);
        if(minStack.isEmpty()){
            minStack.push(value);
        }else{
            minStack.push(Math.min(value,minStack.peek()));
        }
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
       return minStack.peek();
    }
}

/*
LeetCode 155 - Min Stack

Problem:
Design a stack that supports:
1. push()
2. pop()
3. top()
4. getMin()

All operations should work in O(1) time.

Approach:
Use a 2D vector.

Each element stores:
{value, minimum_so_far}

Example:
push(5) -> {5, 5}
push(3) -> {3, 3}
push(7) -> {7, 3}
push(2) -> {2, 2}

The second value always stores the minimum
element from the bottom up to the current position.

For getMin():
st.back()[1] gives the current minimum.

Time Complexity:
push    -> O(1)
pop     -> O(1)
top     -> O(1)
getMin  -> O(1)

Space Complexity:
O(n)

Important concept:
Instead of searching for the minimum every time,
store the minimum-so-far along with every element.
*/
