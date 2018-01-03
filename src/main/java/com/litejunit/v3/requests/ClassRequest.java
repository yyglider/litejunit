/**
 *
 */
package com.litejunit.v3.requests;

import java.lang.reflect.Constructor;

import com.litejunit.v3.runner.Request;
import com.litejunit.v3.runner.Runner;
import com.litejunit.v3.runners.TestClassRunner;


public class ClassRequest extends Request {
    private final Class<?> fTestClass;

    public ClassRequest(Class<?> each) {
        fTestClass = each;
    }

    @Override
    public Runner getRunner() {
        Class runnerClass = getRunnerClass(fTestClass);
        try {
            Constructor constructor = runnerClass.getConstructor(Class.class);
            Runner runner = (Runner) constructor
                    .newInstance(new Object[]{fTestClass});
            return runner;
        } catch (Exception e) {
            return null;
        }
    }

    Class getRunnerClass(Class<?> testClass) {
        return TestClassRunner.class;
    }}
	
