import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day2 {
    
    static int submarinePos(ArrayList<Integer> forward, ArrayList<Integer> up, ArrayList<Integer> down) {
        int horizontal = 0;
        int depth = 0;

        for(int i: forward)
            horizontal += i;

        for(int i: up)
            depth -= i;

        for(int i: down)
            depth += i;

        return horizontal * depth;
    }

    static int submarinePos2(ArrayList<String> instructions) {
        int horizontal = 0;
        int depth = 0;
        int aim = 0;

        for(String s: instructions) {
            if(s.charAt(0) == 'f') {
                horizontal += Character.getNumericValue(s.charAt(8));
                depth += Character.getNumericValue(s.charAt(8)) * aim;
            } else if(s.charAt(0) == 'd') {
                aim += Character.getNumericValue(s.charAt(5));
            } else {
                aim -= Character.getNumericValue(s.charAt(3));
            }
        }
        return horizontal * depth;
    }

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Integer> forward = new ArrayList<Integer>();
        ArrayList<Integer> up = new ArrayList<Integer>();
        ArrayList<Integer> down = new ArrayList<Integer>();
        ArrayList<String>  instructions = new ArrayList<String>();

        File file = new File("C:\\Users\\edulo\\Documents\\day2-input.txt");
        Scanner sc = new Scanner(file);
        while(sc.hasNext()) {
            String s = sc.nextLine();
            if(s.charAt(0) == 'f')
                forward.add(Character.getNumericValue(s.charAt(8)));
            else if(s.charAt(0) == 'u')
                up.add(Character.getNumericValue(s.charAt(3)));
            else   
                down.add(Character.getNumericValue(s.charAt(5)));
        }
        sc.close();

        File file2 = new File("C:\\Users\\edulo\\Documents\\day2-input.txt");
        Scanner sc2 = new Scanner(file2);
        while(sc2.hasNext()) {
            instructions.add(sc2.nextLine());
        }
        sc2.close();

        System.out.println(submarinePos(forward, up, down));
        System.out.println(submarinePos2(instructions));
    }
}
