/* INTERFACES
 * ----------
 *
 * This code describes the logic for two electrical circuits.
 *
 * These circuits should be used to wire an upstairs switch and a downstairs switch to control the same light.
 * The light should be off (`false`) only when the upstairs switch is up (`true`) and the downstairs switch is down (`false`).
 *
 * Define `lightOn` to implement this using only the default methods in each circuit interface.
 */

interface OrCircuit {
    default boolean or(boolean p, boolean q) {
        return p || q;
    }
}

interface NotCircuit {
    default boolean not(boolean p) {
        return !p;
    }
}

public class LightCircuit {
    public boolean lightOn(boolean upstairsUp, boolean downstairsUp) {/* Your code goes here */}
}
