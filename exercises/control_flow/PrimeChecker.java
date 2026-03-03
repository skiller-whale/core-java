// ========================== //
// Prime Number Checker       //
// ========================== //

// Write code that finds whether a number is prime or not.
//
// To find whether a number `n` is prime, you can check whether it is
// divisible by any number between `2` and `n-1`.
//
// The program should print:
//  "<n> is prime" if the number is prime, and
//  "<n> is not prime" if the number is not prime.
//
class PrimeChecker {
    public static void main(String[] args) {
        // code goes here
        boolean isPrime = true;
        int n = 13; // You can change this number to test with different inputs

        // TODO: Check if `n` is prime and set `isPrime` accordingly

        // Print the result
        if (isPrime) {
            System.out.println(n + " is prime");
        } else {
            System.out.println(n + " is not prime");
        }
    }
}
