package security;

public class PasswordHash {
    public static String Hash(String password){
        long hash = 0;
        long prime = 2147483647; // prime number for hashing
        String key = "secure";

        for (int i = 0; i < key.length(); i++) {
            hash = hash * prime + key.charAt(i);
        }

        for (int i = 0; i < password.length(); i++) {
            hash = hash * prime + password.charAt(i);
        }

        return Long.toString(hash);
    }
}
