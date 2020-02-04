//This class handles the I/O and the first tokenization of the input
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class InputHandler {
    public String readInput() {
        String input = "";
        String path = "/Users/danish/Documents/Northern Illinois University/Assignments and Projects/513_Assignment_1/input.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {    //i wrote it as a parameter so it calls the close method automatically
            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {    //goes through every line
                content.append(line);
                content.append(System.lineSeparator());
            }
            input = content.toString(); //and the whole text is stored here
        } catch(Exception e) {
            System.out.println(e);
        }
        return input;   //and then returned
    }

    public String[][] tokenizer(String input) {
        StringTokenizer battleshipTokenizer = new StringTokenizer(input, "()\n");   //this tokenizer splits up the coordinates
        int lineCounter = 0;
        int gameCounter = 0;
        String[][] tokenizedInput = new String[3][8];   //2d array to store all input
        while(battleshipTokenizer.hasMoreTokens()) {
            if(lineCounter < 8) {   //one input has a set of 8 coordinates
                tokenizedInput[gameCounter][lineCounter] = battleshipTokenizer.nextToken();
                lineCounter++;
            } else {
                lineCounter = 0;
                gameCounter++;
                tokenizedInput[gameCounter][lineCounter] = battleshipTokenizer.nextToken();
                lineCounter++;
            }
        }
        return tokenizedInput;
    }
}
