import java.util.Scanner;
import java.util.Stack;

/*Sample Input

3
{[()]}
{[(])}
{{[[(())]]}}
Sample Output

YES
NO
YES*/
public class StackBrackets {
	static String isBalanced(String s) {
     Stack<Character>stack=new Stack<>();
     char top=0;
     for(int i=0;i<s.length();i++) {
    	 if(!stack.isEmpty()) {
    		 top=stack.peek();
    	 }
    	 char c=s.charAt(i);
    	 stack.push(c);
     
     if(!stack.isEmpty()&& stack.size()>1) {
    	 if((top=='{' && stack.peek()=='}')||
    			 (top=='[' && stack.peek()==']')||
    			 (top=='(' && stack.peek()==')')) {
    		           stack.pop();
    		           stack.pop();
    	 }
     }
     }
        return stack.isEmpty() ? "YES":"NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            String s = in.next();
            String result = isBalanced(s);
            System.out.println(result);
        }
        in.close();
    }
}