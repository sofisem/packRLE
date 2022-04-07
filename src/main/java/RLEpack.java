import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.CmdLineException;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class RLEpack {
    @Option(name = "-z")
    private boolean pack;
    @Option(name = "-u")
    private boolean unpack;
    @Option(name = "-out")
    private String out;
    @Argument()
    private String file;

    private ArrayList<String> inputList = new ArrayList<>();
    private ArrayList<String> outputList = new ArrayList<>();

    public void main(String[] args) throws IOException {
        CmdLineParser par = new CmdLineParser(this);
        try {
            par.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("");
        }

        readFromFile(file);

        if (pack) {
            compress();
        } else decompress();

        writeToFile();
    }

    public void readFromFile(String file) {
        try (Scanner in = new Scanner(new File(file));) {
            File inputFile = new File(file);
            if (!inputFile.exists()) {
                inputFile.createNewFile();
            }
            while (in.hasNextLine()) {
                String current = in.nextLine();
                if (current.equals("")) break;
                inputList.add(current);
            }
        } catch (IOException e) {
            System.out.println("ERROR " + e);
        }

    }

    public void compress() {
        String text;

        for (int i = 0; i < inputList.size(); i++) {
            text = inputList.get(i);
            StringBuilder sb = new StringBuilder();
            for (int textIndex = 0; textIndex < text.length(); textIndex++) {
                int charCount = 1;
                while (textIndex < text.length() - 1 && text.charAt(textIndex) == text.charAt(textIndex + 1)) {
                    charCount++;
                    textIndex++;
                }
                if (charCount >= 2) {
                    sb.append(text.charAt(textIndex)).append(charCount);
                } else {
                    sb.append(text.charAt(textIndex));
                }
            }
            outputList.add(sb.toString());
        }

    }

    public void decompress() {
        String text;

        for (int i = 0; i < inputList.size(); i++) {
            text = inputList.get(i);
            StringBuilder sb = new StringBuilder();
            for (int textIndex = 0; textIndex < text.length(); textIndex++) {
                if (Character.isDigit(text.charAt(textIndex))) {
                    int charCount = Character.getNumericValue(text.charAt(textIndex));
                    while (charCount-- != 1) sb.append(text.charAt(textIndex - 1));
                } else {
                    sb.append(text.charAt(textIndex));
                }
            }
            outputList.add(sb.toString());
        }

    }

    public void writeToFile() {
        if (out == null) {
            out= "out" + file;
        }
        try (PrintWriter pw = new PrintWriter(out)) {
            File outFile = new File(out);
            if (!outFile.exists()) {
                outFile.createNewFile();
            }
            for (int i = 0; i < outputList.size(); i++) {
                pw.println(outputList.get(i));
            }
        } catch (IOException e) {
            System.out.println("ERROR " + e);
        }
    }




}
