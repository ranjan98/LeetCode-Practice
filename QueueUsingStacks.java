// Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

class MyQueue {

    Stack<Integer> first;
    Stack<Integer> second;
    /** Initialize your data structure here. */
    public MyQueue() {
        first = new Stack<>();
        second = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        first.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(this.second.empty()){
            while(!this.first.empty())
                this.second.push(this.first.pop());
        }
        return this.second.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(this.second.empty()){
            while(!this.first.empty())
                this.second.push(this.first.pop());
        }
        return this.second.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(this.first.empty() && this.second.empty())
            return true;
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
 
//  Runtime: 0 ms, faster than 100.00% of Java online submissions for Implement Queue using Stacks.
// Memory Usage: 36.9 MB, less than 55.01% of Java online submissions for Implement Queue using Stacks.
