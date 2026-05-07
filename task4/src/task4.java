import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        String numsPath = args[0];
        ArrayList<Integer> nums = new ArrayList<>();
        try {
            Scanner inp = new Scanner(new File(numsPath));
            while(inp.hasNext()){
                nums.add(inp.nextInt());
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        int sum = 0;
        for (int num: nums) {
            sum+=num;
        }
        int srArf = sum/nums.size();
        int minRaz = 1999999999;
        int nearestToSrArf = 0;
        for (int num: nums) {
            if (Math.abs(num-srArf)<minRaz){
                minRaz = Math.abs(num-srArf);
                nearestToSrArf = num;
            }
        }
        int minSteps = 0;
        for (int num:nums) {
            minSteps+= Math.abs(num - nearestToSrArf);
        }
        if (minSteps>20){
            System.out.println("20 ходов недостаточно для приведения всех элементов массива к одному числу");
        } else{
            System.out.println(minSteps);
        }
    }
}
