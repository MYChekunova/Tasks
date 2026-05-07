public class task1 {
    public static void main(String[] args) {
        int n1 = Integer.parseInt(args[0]);
        int m1 = Integer.parseInt(args[1]);
        int n2 = Integer.parseInt(args[2]);
        int m2 = Integer.parseInt(args[3]);
        String way1 = "";
        String way2 = "";
        int k = 0;
        int i = 0;
        while (k != 1){
            int j = i+m1;
            String interval = "";
            while (i<j){
                int mod = i % n1 + 1;
                interval = interval.concat(String.valueOf(mod));
                i++;
            }
            k = Integer.parseInt(interval.substring(interval.length()-1));
            way1 = way1.concat(interval.substring(0,1));
            i--;
        }
        int l = 0;
        i = 0;
        while (l != 1){
            int j = i+m2;
            String interval = "";
            while (i<j){
                int mod = i % n2 + 1;
                interval = interval.concat(String.valueOf(mod));
                i++;
            }
            l = Integer.parseInt(interval.substring(interval.length()-1));
            way2 = way2.concat(interval.substring(0,1));
            i--;
        }
        String way = way1.concat(way2);
        System.out.println(way);
    }
}
