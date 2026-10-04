public class Main {
    public static void main(String[] args) {
        boolean demoMode = false;
        for (String arg : args) {
            if ("--demo".equalsIgnoreCase(arg)) {
                demoMode = true;
                break;
            }
        }

        if (demoMode) {
            runDemo();
        } else {
            System.out.println("Run with '--demo' to execute T1-T7 test checks.");
        }
    }

    private static void runDemo() {
        System.out.println("BRIDGE PATTERN VERIFICATION SUITE");
        System.out.println();

        Renderer vector = new VectorRenderer();
        Renderer raster = new RasterRenderer();
        Renderer ascii = new AsciiRenderer();

        // T1: Circle (A1) with VectorRenderer (I1)
        Circle circle1 = new Circle(101, 2.0, vector);
        String expectedT1 = "[Vector] Circle #101 with radius 2.0";
        String actualT1 = circle1.execute();
        evaluateCheck("T1", "A1 with I1", expectedT1, actualT1, true);

        // T2: Circle (A1) with RasterRenderer (I2)
        Circle circle2 = new Circle(102, 2.0, raster);
        String expectedT2 = "[Raster] Circle #102 with pixels (radius: 2.0)";
        String actualT2 = circle2.execute();
        evaluateCheck("T2", "A1 with I2", expectedT2, actualT2, true);

        // T3: Square (A2) with VectorRenderer (I1)
        Square square1 = new Square(201, 3.0, vector);
        String expectedT3 = "[Vector] Square #201 with side 3.0";
        String actualT3 = square1.execute();
        evaluateCheck("T3", "A2 with I1", expectedT3, actualT3, true);

        // T4: Square (A2) with RasterRenderer (I2)
        Square square4 = new Square(202, 3.0, raster);
        String expectedT4 = "[Raster] Square #202 with pixels (side: 3.0)";
        String actualT4 = square4.execute();
        evaluateCheck("T4", "A2 with I2", expectedT4, actualT4, true);

        // T5: Runtime Switch on Same Object Reference
        System.out.println("--- Executing T5: Runtime Switch Verification ---");
        Circle t5Circle = new Circle(301, 2.0, vector);
        Shape originalRef = t5Circle;
        int originalId = t5Circle.getId();
        double originalRadius = t5Circle.getRadius();

        String resBefore = t5Circle.execute();
        System.out.println("Before switch execution: " + resBefore);

        // Dynamic implementation switch
        t5Circle.setImplementation(raster);
        Shape postSwitchRef = t5Circle;
        String resAfter = t5Circle.execute();
        System.out.println("After switch execution:  " + resAfter);

        boolean sameRef = (originalRef == postSwitchRef);
        boolean sameData = (originalId == t5Circle.getId()) && (originalRadius == t5Circle.getRadius());
        boolean correctOutputs = resBefore.equals("[Vector] Circle #301 with radius 2.0") &&
                resAfter.equals("[Raster] Circle #301 with pixels (radius: 2.0)");

        boolean t5Passed = sameRef && sameData && correctOutputs;
        System.out.println("Check T5 Details:");
        System.out.println("  - Reference Equality (==): " + sameRef);
        System.out.println("  - Unchanged ID & Data:      " + sameData);
        System.out.printf("[%s] T5: Dynamic implementation switch on same object reference\n\n",
                t5Passed ? "PASS" : "FAIL");

        // T6: Circle (A1) with AsciiRenderer (I3)
        Circle circle3 = new Circle(103, 2.0, ascii);
        String expectedT6 = "[ASCII] Circle #103 (o) r=2.0";
        String actualT6 = circle3.execute();
        evaluateCheck("T6", "A1 with I3", expectedT6, actualT6, true);

        // T7: Square (A2) with AsciiRenderer (I3)
        Square square3 = new Square(203, 3.0, ascii);
        String expectedT7 = "[ASCII] Square #203 [] s=3.0";
        String actualT7 = square3.execute();
        evaluateCheck("T7", "A2 with I7", expectedT7, actualT7, true);
    }

    private static void evaluateCheck(String id, String label, String expected, String actual, boolean printDetails) {
        boolean pass = expected.equals(actual);
        System.out.printf("[%s] %s: %s\n", pass ? "PASS" : "FAIL", id, label);
        if (printDetails) {
            System.out.println("   Expected: " + expected);
            System.out.println("   Actual:   " + actual);
        }
        System.out.println();
    }
}