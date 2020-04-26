package listener;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.StandardOpenOption;

public class DiscFileWriter implements TextListener{


    @Override
    public void actionPerformed(String s)  {
        try {
            File file = new File("C:\\tmp\\file.txt");
            file.createNewFile();

            FileWriter writeFile = new FileWriter(file,true);
            writeFile.write(s+ "\n");
            writeFile.flush();
            writeFile.close();
        } catch (IOException e) {
            System.out.println("The DiscFileWriter failed to write. Here is what happened: " + e.getMessage());
        }
    }
}
