package org.monan.agent;

import java.lang.instrument.Instrumentation;

public class MonanAgent {


    public static void premain(String agentArgs, Instrumentation inst) {
        inst.addTransformer();
    }

}
