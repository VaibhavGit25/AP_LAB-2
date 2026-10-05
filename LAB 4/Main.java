import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> primes = Sieve.sieveOfEratosthenes(n);
        for (int p : primes) {
            System.out.print(p + " ");
        }
        sc.close();
        
    }
}