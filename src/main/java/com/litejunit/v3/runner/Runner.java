package com.litejunit.v3.runner;

import com.litejunit.v3.notification.RunNotifier;


public abstract class Runner {

	public abstract Description getDescription();

	public abstract void run(RunNotifier notifier);

	public int testCount() {
		return getDescription().testCount();
	}
}