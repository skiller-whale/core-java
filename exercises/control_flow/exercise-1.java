// ========================== //
// Boolean Expressions        //
// ========================== //
/*
 * This code describes the logic for two light switches that control the same light.
 *
 * At the moment, the light will be on when either (or both) switches are on (`true`).
 *
 * Run the file to check that the last line of output says 'lightOn is true'.
 *
 * Update the definition for `lightOn` so that the value of `lightOn` is `true` if exactly one switch is on, and `false` otherwise.
 */

class LightSwitch {
    public static void main(String[] args) {
        boolean upstairsSwitchUp   = true;
        boolean downstairsSwitchUp = true;
        boolean lightOn = upstairsSwitchUp || downstairsSwitchUp;
        // Do not edit these print lines
        System.out.println("upstairsSwitchUp is " + upstairsSwitchUp);
        System.out.println("downtairsSwitchUp is " + downstairsSwitchUp);
        System.out.println("lightOn is " + lightOn);
    }
}

/*
 * Run the file to check that the last line of output now says 'lightOn is false'.
 *
 * Change the values of `upstairsSwitchUp` and `downstairsSwitchUp` and re-run the file to check your code.
 */
