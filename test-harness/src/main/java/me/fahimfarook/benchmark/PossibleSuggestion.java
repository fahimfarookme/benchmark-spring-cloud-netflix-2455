package me.fahimfarook.benchmark;

import java.util.Set;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

/**
 * Possible suggestion.
 * 
 * @author Fahim Farook
 *
 */
@State(Scope.Benchmark)
public class PossibleSuggestion {

	public boolean shouldUpdate(final Set<String> changedKeys) {
		assert changedKeys != null;

		for (final String key : changedKeys) {
			// property keys are not expected to be null.
			if (key.startsWith("eureka.client.service-url.") || 
				key.startsWith("eureka.client.availability-zones.") || 
				"eureka.client.region".equals(key)) {
				return true;
			}
		}

		return false;
	}
}
