package utility;

import java.security.SecureRandom;

public final class Utility {

    private Utility() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    /**
     * Generates random alphanumeric string with customized length
     *
     * @param length length of the string to be generated
     * @return alphanumeric string
     */
    public static String generateUniqueCharacterString(int length) {
        String value = "abcdefghijklmnopqrstuvwxyz";
        SecureRandom secureRandom = new SecureRandom();

        StringBuilder generatedString = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randonSequence = secureRandom.nextInt(value.length());
            generatedString.append(value.charAt(randonSequence));
        }
        return generatedString.toString();
    }

}
