package me.fahimfarook.benchmark;

import java.util.ArrayList;
import java.util.List;

public class RandomUtil {

	private static final String KNOWLEDGE_BASE = "abcdefghijklmnopqrstuvwxyzABCDEFGIJKLMNOPQRSTUVWXYZ";

	public static List<String> randomList(int count) {
		final List<String> list = new ArrayList<>();
		while (count-- != 0) {
			list.add("eureka." + randomWord(10));
		}

		return list;
	}

	private static String randomWord(int count) {

		final StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * KNOWLEDGE_BASE.length());
			builder.append(KNOWLEDGE_BASE.charAt(character));
		}
		return builder.toString();
	}

	private RandomUtil() {
		throw new UnsupportedOperationException("Not supposed to be initalized!");
	}

}
