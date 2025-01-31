import java.util.Scanner;

public class TowerOfHanoi {
    public static void main(String[] args) {
        int n;
        
        // Getting input from user
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of disks:");
        n = sc.nextInt();
        towerOfHanoi(n, 'A', 'B', 'C');
    }
    public static void towerOfHanoi(int topN, char source, char auxiliary, char destination) {
        if (topN == 1) {
            System.out.println("Disk 1 from " + source + " to " + destination);
        } else {
            towerOfHanoi(topN - 1, source, destination, auxiliary);
            System.out.println("Disk " + topN + " from " + source + " to " + destination);
            towerOfHanoi(topN - 1, auxiliary, source, destination);
        }
    }
}
