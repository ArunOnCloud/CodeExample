package ConceptImplementation;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class ScriptEngineExample {

	public static void main(String[] args) throws Exception {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        // JavaScript code in a String
        String script = "function run() { print('run called'); }";
        //String script = "function run() { console.log('run called'); }";

        // evaluate script
        engine.eval(script);

        Invocable inv = (Invocable) engine;

        // get Runnable interface object from engine. This interface methods
        // are implemented by script functions with the matching name.
        Runnable r = inv.getInterface(Runnable.class);

        // start a new thread that runs the script implemented
        // runnable interface
        Thread th = new Thread(r);
        th.start();
    }

}
