package com.ssp.support;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;

// TODO: Auto-generated Javadoc
/**
 * Stopwatch the elapsed/start time of the stop watch.
 */
public class StopWatch {

	/** The sw. */
	private static Stopwatch sw = Stopwatch.createStarted();

	/**
	 * Returns the start time of the stop watch.
	 *
	 * @return time in seconds
	 */
	public static long startTime() {
		return sw.elapsed(TimeUnit.MILLISECONDS);
	}

	/**
	 * Returns the elapsed time of the stop watch.
	 *
	 * @param startTime the start time
	 * @return elapsed time in seconds
	 */
	public static long elapsedTime(long startTime) {
		return (long) (sw.elapsed(TimeUnit.MILLISECONDS) - startTime) / 1000;
	}

}
