// ========================== //
// Boolean Expressions        //
// ========================== //
/*
 * This code describes the logic for two light switches that control the same light.
 *
 * At the moment, the light will be on when either (or both) switches are up (`true`).
 *
 * Run the file to check that the light is off only when the upstairs and downstairs switches are both down.
 *
 * Update the definition for `lightOn` so that it returns `true` if exactly one switch is up, and `false` otherwise.
 */

class LightSwitch {
    static boolean lightOn(boolean upstairsUp, boolean downstairsUp) {
        // TODO: Edit this line only
        boolean on = upstairsUp || downstairsUp;

        return on;
    }

    // Do not edit these print lines
    public static void main(String[] args) {
        System.out.println("Light switch positions          | Light on");
        System.out.println("--------------------------------+---------");
        System.out.println("upstairs Up, downstairs Up\t| " + lightOn(true, true));
        System.out.println("upstairs Up, downstairs Down\t| " + lightOn(true, false));
        System.out.println("upstairs Down, downstairs Up\t| " + lightOn(false, true));
        System.out.println("upstairs Down, downstairs Down\t| " + lightOn(false, false));
    }
}

/*
 * Run the file to check that your code is correct.
 */
