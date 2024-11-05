import javax.crypto.SecretKey;

public class Main {
    public static void main(String[] args) {
        MessageEncryption messageEncryption = new MessageEncryption();
        try {

            String message = "Hello, World!";
            System.out.println("Original Message: " + message);

            SecretKey secretKey = messageEncryption.generateSecretKey();


            String encryptedMessage = messageEncryption.encrypt(message, secretKey);
            System.out.println("Encrypted Message: " + encryptedMessage);

            String decryptedMessage = messageEncryption.decrypt(encryptedMessage, secretKey);
            System.out.println("Decrypted Message: " + decryptedMessage);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}