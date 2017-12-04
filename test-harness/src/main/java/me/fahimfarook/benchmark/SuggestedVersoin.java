package me.fahimfarook.benchmark;

import java.util.Set;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

/**
 * Suggested version in review.
 * 
 * @author Fahim Farook
 *
 */
@State(Scope.Benchmark)
public class SuggestedVersoin {

	public boolean shouldUpdate(final Set<String> changedKeys) {
		assert changedKeys != null;

		for (final String key : changedKeys) {
			// property keys are not expected to be null.
			if (key.startsWith("eureka.client.service-url.") || 
				key.startsWith("eureka.client.availability-zones.") || 
				changedKeys.contains("eureka.client.region")) {
				return true;
			}
		}

		return false;
	}
}
