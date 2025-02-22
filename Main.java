package org.fahad;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            if (args.length == 0 || args[0].equals("--help")) {
                System.out.println("Usage: ccwc [options] <path>");
                return;
            }

            if (!args[0].startsWith("-")) {
                var path = Path.of(args[0]);
                System.out.printf(
                        "%s %s %s %s%n", size(path), lines(path), wordsCount(path), path.getFileName()
                );
                return;
            }
            Path path = args.length < 2 ? readFromStInput() : Path.of(args[1]);
            switch (args[0]) {
                case "-c" -> printOutput(size(path), path);
                case "-l" -> printOutput(lines(path), path);
                case "-w" -> printOutput(wordsCount(path), path);
                case "-m" -> printOutput(characterCount(path), path);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }


    private static long size(Path path) throws IOException {
        if (fileDoesntExists(path)) return 0;
        return Files.size(path);
    }

    private static boolean fileDoesntExists(Path path) {
        if (!Files.exists(path)) {
            System.out.println("File does not exist");
            return true;
        }
        return false;
    }

    private static long lines(Path path) throws IOException {
        if (fileDoesntExists(path)) return 0;
        try (var lines = Files.lines(path)) {
            return lines.count();
        }
    }


    private static Path readFromStInput() throws IOException {
        String content;
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNextLine()) {
            sb.append(scanner.nextLine()).append("\n");
        }
        content = sb.toString();
        scanner.close();
        return Files.writeString(Path.of("temp.txt"), content);
    }

    private static long wordsCount(Path path) throws IOException {
        if (fileDoesntExists(path)) return 0;
        return Arrays.stream(Files.readString(path).split("\\s+")).filter(word -> !word.isBlank()).count();
    }

    private static int characterCount(Path path) throws IOException {
        if (fileDoesntExists(path)) return 0;
        return Files.readString(path).length();
    }

    private static void printOutput(long output, Path path) {
        System.out.println(output + " " + path.getFileName());
    }


}