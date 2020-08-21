package encryptdecrypt;

class UnicodeAlgorithm extends Algorithm {

    UnicodeAlgorithm(String in, int key) {
        super(in, key);
    }

    @Override
    char encodeChar(char actChar) {
        return (char) (actChar + key);
    }

    @Override
    char decodeChar(char actChar) {
        return (char) (actChar - key);
    }

    @Override
    String getEncoded() {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < in.length(); i++) {
            out.append(encodeChar(in.charAt(i)));
        }
        return out.toString();
    }

    @Override
    String getDecoded() {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < in.length(); i++) {
            out.append(decodeChar(in.charAt(i)));
        }
        return out.toString();
    }
}