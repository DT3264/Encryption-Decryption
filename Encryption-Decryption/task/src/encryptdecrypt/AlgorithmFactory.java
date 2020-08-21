package encryptdecrypt;

class AlgorithmFactory {
    public static Algorithm newInstance(String type, String message, int key) {
        if (type.equals("unicode")) {
            return new UnicodeAlgorithm(message, key);
        } else {
            return new ShiftAlgorithm(message, key);
        }
    }
}