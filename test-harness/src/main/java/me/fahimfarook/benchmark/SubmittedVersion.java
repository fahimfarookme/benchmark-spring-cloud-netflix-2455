package me.fahimfarook.benchmark;

import java.util.Set;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

/**
 * The submitted version of code by Fahim.
 * 
 * @author Fahim Farook
 *
 */
@State(Scope.Benchmark)
public class SubmittedVersion {

	public boolean shouldUpdate(final Set<String> changedKeys) {
		assert changedKeys != null;

		if (changedKeys.contains("eureka.client.region")) {
			return true;
		}

		for (final String key : changedKeys) {
			// property keys are not expected to be null.
			if (key.startsWith("eureka.client.service-url.") || key.startsWith("eureka.client.availability-zones.")) {
				return true;
			}
		}

		return false;
	}
}
