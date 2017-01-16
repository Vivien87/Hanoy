import java.util.Scanner;
import java.util.Stack;

public class TowerOfHanoi {
    static Stack<Integer> towerA = new Stack<Integer>();
    static Stack<Integer> towerB = new Stack<Integer>();
    static Stack<Integer> towerC = new Stack<Integer>();
    static int move_number = 0;
            
    public static char getTowerLetter(Stack<Integer> tower) {
        if (tower == towerA)
            return 'A';
        else if (tower == towerB)
            return 'B';
        else if (tower == towerC)
            return 'C';
            
        return 'C'; 
    }
    
    public static void TowerDisks(Stack<Integer> tower) {
        Stack<Integer> temp_tower = new Stack<Integer>();
        
        for (Stack<Integer> i = (Stack<Integer>)tower.clone(); !i.empty(); i.pop()) 
            temp_tower.push(new Integer(i.peek()));
            
        System.out.print("[");
        
        while (!temp_tower.empty()) {
            System.out.print("" + temp_tower.pop());
            
            if (!temp_tower.empty()) 
                System.out.print(", ");
        }
        
        System.out.println("]");
    }                              
   
    public static void CurrentState(Stack<Integer> t1, Stack<Integer> t2, Stack<Integer> t3) {
        System.out.println("<-- Move Number(disk): " + move_number);
      
        for (char i = 'A'; i < 'D'; i++) {
            System.out.print("" + i + ": ");
            if (getTowerLetter(t1) == i)
                TowerDisks(t1);
            else if (getTowerLetter(t2) == i)
                TowerDisks(t2);
            else
                TowerDisks(t3);
        }
        
        System.out.println("");                
    }
    
    public static void CurrentState(Stack<Integer> t1, Stack<Integer> t2, Stack<Integer> t3, char to, char from) {
        System.out.println("" + from + " -> " + to);
        CurrentState(t1, t2, t3);
    }    
    
    public static void moveDisks(int stack_size, Stack<Integer> source, Stack<Integer> location, Stack<Integer> repository) {
        if (stack_size == 1) {
            location.push(new Integer(source.pop()));
            
            move_number++;
            char to = getTowerLetter(location);
            char from = getTowerLetter(source);
            CurrentState(source, location, repository, to, from);
        }
        else {
            moveDisks(stack_size - 1, source, repository, location);
            
            location.push(source.pop());
            
            move_number++;
            char to = getTowerLetter(location);
            char from = getTowerLetter(source);
            CurrentState(source, location, repository, to, from);
            
            moveDisks(stack_size - 1, repository, location, source);
        }
    }        
            
    public static void main(String[] args) {
        System.out.print("How many disks on the tower? ");
        Scanner scanner = new Scanner(System.in);											
        int num_disks = scanner.nextInt();	
      
        for (int i = num_disks; i>= 1; i--)
            towerA.push(new Integer(i));
         
        CurrentState(towerA, towerB, towerC);  
        moveDisks(towerA.size(), towerA, towerC, towerB);
        
        System.out.println("Number of Moves: " + move_number);
   }
} 
