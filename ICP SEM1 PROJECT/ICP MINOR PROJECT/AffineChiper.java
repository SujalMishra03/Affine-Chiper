//Name:Sujal Mishra
//Reg no: 2241013188
//Branch: Btech (Cse)
//Section: 2241026
import java.util.Scanner;
public class AffineChiper{
    public static void main(String[]Args){

        // INPUT BLOCK
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Plain Text: ");
        String inputstring = sc.nextLine();
        sc.close();
        String input_text = inputstring;


        String cipher = encrypt(input_text);
        String decrypted = decrypt(cipher);
        System.out.println("Ciphertext: " + cipher);
        System.out.println("Decrypted text: " + decrypted);

    }


    // ENCRYPTION CODE
    public static String encrypt(String plaintext) {
        int k1 = 7;
        int k2 = 2;
        char[] ciphertext = new char[plaintext.length()];

        for (int i = 0; i < plaintext.length(); i++) {
            char char_check = plaintext.charAt(i);
            if (Character.isUpperCase(char_check)){
                int alpha = plaintext.charAt(i) - 'A';
                int encrypted = (alpha * k1 + k2) % 26;
                ciphertext[i] = (char)(encrypted + 'A');

            } else {
                int alpha = plaintext.charAt(i) - 'a';
                int encrypted = (alpha * k1 + k2) % 26;
                ciphertext[i] = (char)(encrypted + 'a');
            }
        }
        return new String(ciphertext);
    }


    //DECRYPTION CODE
    public static String decrypt(String ciphertext) {
        int k1 = 7;
        int k2 = 2;
        char[] plaintext = new char[ciphertext.length()];

        int inverse = 0;
        for (int i = 0; i < 26; i++) {
            if ((k1 * i) % 26 == 1) {
                inverse = i;
                break;
            }
        }

        for (int i = 0; i < ciphertext.length(); i++) {
            char character_check = ciphertext.charAt(i);
            if (Character.isUpperCase(character_check)){
                int k3 = ciphertext.charAt(i) - 'A';
                int decrypted = ((k3 - k2 + 26)* inverse) % 26;
                plaintext[i] = (char)(decrypted + 'A');

            } else {
                int k3 = ciphertext.charAt(i) - 'a';
                int decrypted = ((k3 - k2 + 26)* inverse) % 26;
                plaintext[i] = (char)(decrypted + 'a');
            }
        }
        return new String(plaintext);
    }

}