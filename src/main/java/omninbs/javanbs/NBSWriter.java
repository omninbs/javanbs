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

   public static void writeSong(String file, NBSSong song) throws IOException { 
      writeSong(file, song, 5);
   }

   public static void writeSong(String file, NBSSong song, int version) throws IOException { 
   try (FileOutputStream fos = new FileOutputStream(file)) {
      song.getHeader().setVersion(version);

      song.getHeader().writeHeader(fos);
   
      
      int prevTick = -1; int prevLayer = -1;
      
      for (NBSNote note : song.getNotes()) {
         if (note.getTick() - prevTick > 0) {
            if (prevTick > -1) {writeBytes(fos, 0, 2);}
            writeBytes(fos, note.getTick() - prevTick, 2);
            prevLayer = -1;
         }

         writeBytes(fos, note.getLayer() - prevLayer, 2);

         writeBytes(fos, note.getInstrument(), 1);
         writeBytes(fos, note.getKey(), 1);

         if (version >= 4) {  
            writeBytes(fos, note.getVolume(), 1);
            writeBytes(fos, note.getStereo(), 1, false);
            writeBytes(fos, note.getPitch(), 2);
         }

         prevTick = note.getTick(); prevLayer = note.getLayer();
      }

      writeBytes(fos, 0, 2); writeBytes(fos, 0, 2);

      for (NBSLayer layer : song.getLayers()) {
         layer.writeLayer(fos, version);
      }
      
      writeBytes(fos, song.getInstruments().size(), 1, false);
      for (NBSInstrument instrument : song.getInstruments()) {
         instrument.writeInstrument(fos, version);
      }
   }}
}
