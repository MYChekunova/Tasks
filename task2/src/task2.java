import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        String ellipsePath = args[0];
        String dotsPath = args[1];
        File ellipseFile = new File(ellipsePath);
        File dotsFile = new File(dotsPath);
        ArrayList<String> ellipse = new ArrayList<>();
        try {
            Scanner inp = new Scanner(ellipseFile);
            while (inp.hasNext()){
                ellipse.add(inp.nextLine());
            }
            String [] coordinates = ellipse.get(0).split(" ");
            double ellipseX = Double.parseDouble(coordinates[0]);
            double ellipseY = Double.parseDouble(coordinates[1]);
            String [] radius = ellipse.get(1).split(" ");
            double radiusA = Double.parseDouble(radius[0]);
            double radiusB = Double.parseDouble(radius[1]);
            ArrayList<String> dots = new ArrayList<>();
            try {
                Scanner inp2 = new Scanner(dotsFile);
                while (inp2.hasNext()){
                    dots.add(inp2.nextLine());
                }
                for (String dot: dots) {
                    String [] dotCoordinates = dot.split(" ");
                    double x = Double.parseDouble(dotCoordinates[0]);
                    double y = Double.parseDouble(dotCoordinates[1]);
                    double rez = (x-ellipseX)*(x-ellipseX)/(radiusA*radiusA) + (y-ellipseY)*(y-ellipseY)/(radiusB * radiusB);
                    if (rez == 1.0){
                        System.out.println(0);
                    } else{
                        if (rez < 1.0){
                            System.out.println(1);
                        } else{
                            System.out.println(2);
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }



    }
}
