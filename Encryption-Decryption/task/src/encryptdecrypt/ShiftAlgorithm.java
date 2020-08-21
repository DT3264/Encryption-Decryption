package encryptdecrypt;

class ShiftAlgorithm extends Algorithm {

    ShiftAlgorithm(String in, int key) {
        super(in, key);
    }

    @Override
    char encodeChar(char actChar) {
        int newChar = 0;
        if (actChar >= 'a' && actChar <= 'z') {
            newChar = actChar + key;
            while (newChar > 'z') newChar -= 26;
        } else if (actChar >= 'A' && actChar <= 'Z') {
            newChar = actChar + key;
            while (newChar > 'Z') newChar -= 26;
        }

        return (char) newChar;
    }

    @Override
    char decodeChar(char actChar) {
        int newChar = 0;
        if (actChar >= 'a' && actChar <= 'z') {
            newChar = actChar - key;
            while (newChar < 'a') newChar += 26;
        } else if (actChar >= 'A' && actChar <= 'Z') {
            newChar = actChar - key;
            while (newChar < 'A') newChar += 26;
        }

        return (char) newChar;
    }

    @Override
    String getEncoded() {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < in.length(); i++) {
            if (Character.isAlphabetic(in.charAt(i))) {
                out.append(encodeChar(in.charAt(i)));
            } else {
                out.append(in.charAt(i));
            }
        }
        return out.toString();
    }

    @Override
    String getDecoded() {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < in.length(); i++) {
            if (Character.isAlphabetic(in.charAt(i))) {
                out.append(decodeChar(in.charAt(i)));
            } else {
                out.append(in.charAt(i));
            }
        }
        return out.toString();
    }
}
