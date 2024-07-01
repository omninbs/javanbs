import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.InputStream;
import java.io.IOException;
import java.nio.file.Paths;

import omninbs.javanbs.NBSReader;
import omninbs.javanbs.NBSWriter;
import omninbs.javanbs.model.NBSSong;

public class NBSIOTest {
   
   @Test
   public void testSongIO() throws IOException {
      String testFile = "Megalovania.nbs";
      String output = "out.out";

      testFile = getClass().getClassLoader().getResource(testFile).getFile();
      output = Paths.get("src", "test", "resources", output).toString();
      
      System.out.println("SongIO test start!");

      NBSSong song = NBSReader.readSong(testFile);

      System.out.println("OG Reading done!");

      NBSWriter.writeSong(output, song);
      
      System.out.println("OG Writing done!");

      NBSReader.readSong(output);
      
      System.out.println("SH Reading done!");
   }
}
