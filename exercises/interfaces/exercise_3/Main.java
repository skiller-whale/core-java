public class Main {
    public static void main(String[] args) {
        LightCircuit circuitboard = new LightCircuit();
        System.out.println("Light switch positions          | Light on");
        System.out.println("--------------------------------+---------");
        System.out.println("upstairs Up, downstairs Up\t| " + circuitboard.lightOn(true, true));
        System.out.println("upstairs Up, downstairs Down\t| " + circuitboard.lightOn(true, false));
        System.out.println("upstairs Down, downstairs Up\t| " + circuitboard.lightOn(false, true));
        System.out.println("upstairs Down, downstairs Down\t| " + circuitboard.lightOn(false, false));
    }
}
