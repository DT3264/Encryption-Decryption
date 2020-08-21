package encryptdecrypt;

public abstract class Algorithm {
    String in;
    int key;

    Algorithm(String in, int key) {
        this.in = in;
        this.key = key;
    }

    abstract char decodeChar(char in);

    abstract char encodeChar(char in);

    abstract String getEncoded();

    abstract String getDecoded();
}
