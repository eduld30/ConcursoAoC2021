import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {
    static int increased(ArrayList<Integer> arr) {
        int count = 0;

        for(int i = 1; i < arr.size(); i++) {
            if(arr.get(i) > arr.get(i - 1))
                count++;
        }
        return count;
    }

    static int increased2(ArrayList<Integer> arr) {
        int count = 0;

        for(int i = 0; i + 3 < arr.size(); i++) {
            int sum1 = arr.get(i) + arr.get(i + 1) + arr.get(i + 2);
            int sum2 = arr.get(i + 1) + arr.get(i + 2) + arr.get(i + 3);

            if(sum1 < sum2)
                count++;
        }
        return count;
    }

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Integer> arr = new ArrayList<Integer>();

        File file = new File("C:\\Users\\edulo\\Documents\\day1-input.txt");
        Scanner sc = new Scanner(file);
        while(sc.hasNext()) {
            arr.add(sc.nextInt());
        }
        sc.close();

        System.out.println(increased(arr));
        System.out.println(increased2(arr));
    }
}
