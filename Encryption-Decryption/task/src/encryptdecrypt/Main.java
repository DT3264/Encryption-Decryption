package encryptdecrypt;

import java.io.*;
import java.util.Scanner;

public class Main {

    static Object[] handleArgs(String[] args) {
        String mode = "enc";
        int key = 0;
        String data = "";
        String in = "";
        String out = "";
        String algorithm = "shift";
        for (int i = 0; i < args.length; i+=2) {
            if (args[i].equals("-mode")) mode = args[i + 1];
            else if (args[i].equals("-key")) key = Integer.parseInt(args[i + 1]);
            else if (args[i].equals("-data")) data = args[i + 1];
            else if (args[i].equals("-in")) in = args[i + 1];
            else if (args[i].equals("-out")) out = args[i + 1];
            else if (args[i].equals("-alg")) algorithm = args[i + 1];
        }
        return new Object[]{mode, key, data, in, out, algorithm};
    }

    static String getData(String message, String inPath) throws FileNotFoundException {
        if (message.equals("")) {
            Scanner scanner = new Scanner(new FileInputStream(new File(inPath)));
            message = scanner.nextLine();
            scanner.close();
        }
        return message;
    }

    static PrintWriter getWriter(String outPath) throws FileNotFoundException {
        if (outPath.equals("")) return new PrintWriter(System.out);
        else return new PrintWriter(new File(outPath));
    }

    public static void main(String[] args) throws FileNotFoundException {
        Object[] arguments = handleArgs(args);
        String mode = arguments[0].toString();
        int key = Integer.parseInt(arguments[1].toString());
        String data = arguments[2].toString();
        String inPath = arguments[3].toString();
        String outPath = arguments[4].toString();
        String algorithm = arguments[5].toString();
        String message = getData(data, inPath);
        boolean decode = mode.equals("dec");
        PrintWriter writer = getWriter(outPath);
        Algorithm algo = AlgorithmFactory.newInstance(algorithm, message, key);
        writer.println(decode ? algo.getDecoded() : algo.getEncoded());
        writer.flush();
        writer.close();
    }
}





