package listener;

public class ScreenWriter implements TextListener {

    @Override
    public void actionPerformed(String s) {
        System.out.println("You typed: " + s);
    }
}