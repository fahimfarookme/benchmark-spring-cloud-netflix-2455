package me.fahimfarook.benchmark;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.openjdk.jmh.Main;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.RunnerException;

public class BenchmarkRunner {

	public static void main(String[] args) throws RunnerException, IOException {
		Main.main(args);
	}
	
	@State(Scope.Benchmark)
	public static class Hash {
		public Set<String> keys = new HashSet<>(RandomUtil.randomList(20));
	}

	@Fork(value = 1, warmups = 1)
	@Benchmark
	@BenchmarkMode(Mode.All)
	public void submitted(final SubmittedVersion code, final Hash changed, final Blackhole blackhole) {
		final boolean ret = code.shouldUpdate(changed.keys);
		blackhole.consume(ret);
	}

	@Fork(value = 1, warmups = 1)
	@Benchmark
	@BenchmarkMode(Mode.All)
	public void suggested(final SuggestedVersoin code, final Hash changed, final Blackhole blackhole) {
		final boolean ret = code.shouldUpdate(changed.keys);
		blackhole.consume(ret);
	}

	@Fork(value = 1, warmups = 1)
	@Benchmark
	@BenchmarkMode(Mode.All)
	public void possibleSuggestion(final PossibleSuggestion code, final Hash changed, final Blackhole blackhole) {
		final boolean ret = code.shouldUpdate(changed.keys);
		blackhole.consume(ret);
	}
}
