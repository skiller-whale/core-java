/* INTERFACES
 * ----------
 *
 * This code describes the logic for two electrical circuits.
 *
 * These circuits should be used to wire an upstairs switch
 *      and a downstairs switch to control the same light.
 * The light should be off (`false`) only when the upstairs switch is up (`true`)
 *      and the downstairs switch is down (`false`):
 *
 *      Light switch positions          | Light on
 *      --------------------------------+---------
 *      upstairs Up, downstairs Up      | true
 *      upstairs Up, downstairs Down    | false
 *      upstairs Down, downstairs Up    | true
 *      upstairs Down, downstairs Down  | true
 *
 * 1. Implement an `AndCircuit` interface with a default method `and` that implements the AND logic gate.
 * 2. Define `lightOn` to implement this using only interface defaults.
 * 3. Use `AndCircuit` and `NotCircuit` to implement `LightCircuit`.
 */

interface NotCircuit {
    default boolean not(boolean p) {
        return !p;
    }
}

public class LightCircuit {
    public boolean lightOn(boolean upstairsUp, boolean downstairsUp) {
        return false;
    }
}
