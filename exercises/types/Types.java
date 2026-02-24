// ========================================== //
// TYPES AND VARIABLES                        //
// ========================================== //
/*
 * It is possible to define variables with a type but without a value.
 * What do you think the following code will print?
 *
 * Compile and run the program to test your answer.
 *   Make sure there aren't any compilation errors.
 */

class Types {
    public static void main(String[] args) {
        String name = "Sealion Dion";
        int age = 25;
        boolean isEmployed;
        int salary;

        System.out.println(String.format("Name: %s, Age: %d, Employed: %b", name, age, isEmployed));
    }
}
