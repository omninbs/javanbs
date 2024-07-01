package omninbs.javanbs;

import java.io.FileOutputStream;
import java.io.IOException;

import omninbs.javanbs.model.NBSSong;
import omninbs.javanbs.model.NBSInstrument;
import omninbs.javanbs.model.NBSHeader;
import omninbs.javanbs.model.NBSLayer;
import omninbs.javanbs.model.NBSNote;

public class NBSWriter {
   public static void writeBytes(FileOutputStream fos, int value, int bytes, boolean signed) throws IOException {
      if (bytes == 1) {
         if (signed) {
            fos.write((byte) value);
         } else {
            fos.write(value & 0xFF);
         }
      } else {
         for (int i = bytes - 1; i >= 0; i--) {
            fos.write((value >> (8 * i)) & 0xFF);
         }
      }
   }
   
   public static void writeBytes(FileOutputStream fos, int data, int bytes) throws IOException {writeBytes(fos, data, bytes, true);}

   public static void writeString(FileOutputStream fos, String string) throws IOException {
      writeBytes(fos, string.length(), 4);

      for (int i = 0; i < string.length(); i++) {
         char c = string.charAt(i);

         fos.write((byte) c);
      }
   }

   public static void writeSong(FileOutputStream fos, NBSSong song, int version) throws IOException {
      song.getHeader().setVersion(version);

      song.getHeader().writeHeader(fos);

      for (NBSLayer layer : song.getLayers()) {
         layer.writeLayer(fos, version);
      }
      
      writeBytes(fos, song.getInstruments().size(), 1, false);
      for (NBSInstrument instrument : song.getInstruments()) {
         instrument.writeInstrument(fos, version);
      }
   }
}
