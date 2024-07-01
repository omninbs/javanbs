import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.InputStream;
import java.io.IOException;

import omninbs.javanbs.NBSReader;
import omninbs.javanbs.model.NBSSong;

public class NBSReaderTest {
   
   @Test
   public void testReadSong() throws IOException {
      NBSSong song = NBSReader.readSong("test_cases/Megalovania.nbs");
   }
}
