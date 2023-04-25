package aufgabe3;

import aufgabe3.data.DebugData;

class DebugMain {
    public static void main(String[] args) {
        DebugData a = new DebugData(3.4, 5.6);
        DebugData b = new DebugData(1.0, 1.0);
        // Result should be approx. 5.18
        System.out.println(String.format("The distance between %s and %s is %g",
            a.str(), b.str(), a.distance(b)));
    }
}

/*
 * Error 1: Exception in thread "main" java.lang.Error: Unresolved compilation problems: 
        DebugData cannot be resolved to a type
        DebugData cannot be resolved to a type
        DebugData cannot be resolved to a type
        DebugData cannot be resolved to a type

        at aufgabe3.DebugMain.main(DebugMain.java:6)
 *  -> Import aufgabe3.data.DebugData
 * 
 * 
 * Error 2: ''
 * -> Make the class DebugData public
 * 
 * 
 * Error 3: DebugData Line 10: Constructor expected int which does not fit the fields given
 * -> Signature change to double
 * 
 * 
 * Error 4: Debugdata Line 16: Math.pow -> Math.sqrt(..., 2) cause Phytagoras
 * 
 * Error 5: DebugData Line 23: this.x -> this.y
 * 
 * Error 6: DebugData Line 36: Muss f statt g sein
 */