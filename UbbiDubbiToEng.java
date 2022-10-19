
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nafea8846
 */
public class UbbiDubbiToEng {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException {
        URL dictionaryFile = new URL("https://github.com/dwyl/english-words/raw/master/words_alpha.txt");
        Scanner textInput = new Scanner(dictionaryFile.openStream());
        ArrayList<String> dictionary = new ArrayList<>();
        while (textInput.hasNext()) {
            String word = textInput.nextLine();
            dictionary.add(word);
        }

        Scanner input = new Scanner(System.in);
        String word = input.nextLine();
        word = word.toLowerCase();
        String translate = word;
        int location = word.indexOf("ub");
        while (location > -2) {
            if (dictionary.contains(translate)) {
                System.out.println(translate);
                break;  
            } else {
                if (translate.charAt(location + 2) == 'a' || translate.charAt(location + 2) == 'u' || translate.charAt(location + 2) == 'o' || translate.charAt(location + 2) == 'i' || translate.charAt(location + 2) == 'e') {
                    translate = translate.replaceFirst("ub", "");
                    location = translate.indexOf("ub");
                } else {
                    break;
                }
            }
        }

    }

}
