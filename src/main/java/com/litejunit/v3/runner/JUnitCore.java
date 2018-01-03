package com.litejunit.v3.runner;


import com.litejunit.v3.notification.RunListener;
import com.litejunit.v3.notification.RunNotifier;
import com.litejunit.v3.runners.InitializationError;
import com.litejunit.v3.runners.TestClassRunner;
import com.litejunit.v3.runners.TextListener;

public class JUnitCore {

    private RunNotifier notifier;

    public JUnitCore() {
        notifier = new RunNotifier();
    }

    public static void runClass(Class<?> clz) {
        try {
            TestClassRunner runner = new TestClassRunner(clz);
            JUnitCore core = new JUnitCore();
            core.addListener(new TextListener());
            Result result = core.run(runner);

        } catch (InitializationError e) {

            e.printStackTrace();
        }

    }

    public Result run(Runner runner) {
        Result result = new Result();
        RunListener listener = result.createListener();
        addListener(listener);
        try {
            notifier.fireTestRunStarted(runner.getDescription());
            runner.run(notifier);
            notifier.fireTestRunFinished(result);
        } finally {
            removeListener(listener);
        }
        return result;
    }

    public void addListener(RunListener listener) {
        notifier.addListener(listener);
    }

    public void removeListener(RunListener listener) {
        notifier.removeListener(listener);
    }
}
