package usi.si.seart.src2abs;

import java.nio.file.Path;

public class Main {

	public static void main(String[] args) {
		try {
			Parser.Granularity granularity = Parser.Granularity.valueOf(args[0].toUpperCase());
			Path inputCodePath = Path.of(args[1]);
			Path outputCodePath = Path.of(args[2]);
			Path idiomsFilePath = Path.of(args[3]);
			new Abstractor().abstractCode(granularity, inputCodePath, outputCodePath, idiomsFilePath);
		} catch (ArrayIndexOutOfBoundsException ignored) {
			printIllegalArgumentError("Not enough arguments!");
		} catch (IllegalArgumentException ignored) {
			printIllegalArgumentError("Wrong granularity! Use: {method, class}");
		}
	}

	private static void printIllegalArgumentError(String error) {
		System.err.println("ERROR: " + error);
		System.out.println("-----------------------");
		System.out.println("src2abs usage:");
		System.out.println("1. Granularity {method, class}");
		System.out.println("2. Source Code file path input");
		System.out.println("3. Abstract Code file path output");
		System.out.println("4. Idiom file path");
		System.exit(1);
	}
}
