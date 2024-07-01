package omninbs.javanbs;

import java.io.FileInputStream;
import java.io.IOException;

import omninbs.javanbs.model.NBSSong;
import omninbs.javanbs.model.NBSInstrument;
import omninbs.javanbs.model.NBSHeader;
import omninbs.javanbs.model.NBSLayer;
import omninbs.javanbs.model.NBSNote;

public class NBSReader {
   public static int readBytes(FileInputStream fis, int bytes, boolean signed) throws IOException {
      if (bytes < 1 || bytes > 4) {
         throw new IllegalArgumentException("Number of bytes must be between 1 and 4.");
      }
   
      byte[] buffer = new byte[bytes];
      int bytesRead = fis.read(buffer);

      if (bytesRead != bytes) {
         throw new IOException("Unable to read the required number of bytes");
      }

      int result = 0;

      // Little-endian conversion
      for (int i = 0; i < bytes; i++) {
         result |= (buffer[i] & 0xFF) << (8 * i);
      }

      if (signed && bytes < 4) {
         int shift = 8 * (4 - bytes);
         result = (result << shift) >> shift;
      }
      
      System.out.println(result);

      return result;
   }

   public static int readBytes(FileInputStream fis, int bytes) throws IOException{return readBytes(fis, bytes, true);}

   public static String readString(FileInputStream fis) throws IOException {
      int len = readBytes(fis, 4);

      System.out.println(" - len - ");
      
      StringBuilder result = new StringBuilder();
      for (int i = 0; i < len; i++) {
         System.out.println("char!");
         int byteRead = fis.read();
         if (byteRead == -1) {
            break;
         }
         
         result.append((char) byteRead);
      }

      System.out.println(" - String - ");

      return result.toString();
   }

   public static NBSSong readSong(String file) throws IOException {
      NBSSong song = new NBSSong("");
      
      try (FileInputStream fis = new FileInputStream(file)) {
         System.out.println("header start!");
         song.setHeader(NBSHeader.readHeader(fis));
         System.out.println("notes start!");

         int field = 0; int tick = -1; int layer = -1; NBSNote note = new NBSNote(0, 0, 0, 0, 0);

         while (true) {
            if (field == 0) { 
               int tickJumps = readBytes(fis, 2);
               tick += tickJumps; 
               note.setTick(tick);
               if (tickJumps == 0) {break;}
            }
            else if (field == 1) {
               int layerJumps = readBytes(fis, 2);
               layer += layerJumps;
               note.setLayer(layer);
               if (layerJumps == 0) {field = -1; layer = -1;} else {note.setTick(tick);} // field = -1 + 1
            }
            else if (field == 2) {
               note.setKey(readBytes(fis, 1));
               note.setInstrument(readBytes(fis, 1));

               if (song.getHeader().getVersion() >= 4) {
                  note.setVolume(readBytes(fis, 1));
                  note.setStereo(readBytes(fis, 1, false) - 100);
                  note.setPitch(readBytes(fis, 2));
               }

               field = 0; // + 1
               song.getNotes().add(note);
               note = new NBSNote(0, 0, 0, 0, 0);
            }
            field += 1;
         }


         for (int i = 0; i < song.getHeader().getLayerCount(); i++) {
            song.getLayers().add(NBSLayer.readLayer(fis, song.getHeader().getVersion()));
         }

         for (int i = 0; i < readBytes(fis, 1, false); i++) {
            song.getInstruments().add(NBSInstrument.readInstrument(fis, song.getHeader().getVersion()));
         }
      }

      return song;
   }
}
