package listener;

import java.util.Scanner;


/**
 * This will create an example of a listener mechanism
 */
public class TextProducer {
    TextListener listener = new ScreenWriter();
    TextListener listener2 = new DiscFileWriter();
    // TODO: add functionality for multiple listeners to tune in.

    public void startProducing() {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String s = input.nextLine();

            listener.actionPerformed(s);
            listener2.actionPerformed(s);

            if (s.equals("Quit")) {
                break;
            }
        }
    }
}
