package omninbs.javanbs.model;

import java.io.DataInputStream;
import java.io.IOException;

import omninbs.javanbs.NBSReader;
import omninbs.javanbs.NBSWriter;

public class NBSInstrument {
   private String name;
   private String file;
   private int key;
   private boolean piano;
   private int id;

   public NBSInstrument(String name, String file, int key, boolean piano) {
      this.name = name;
      this.file = file;
      this.key = key;
      this.piano = piano;
   }


   public static NBSInstrument readInstrument(DataInputStream dis, int version) throws IOException {
      NBSInstrument instrument = new NBSInstrument(
         NBSReader.readString(dis),
         NBSReader.readString(dis),
         NBSReader.readBytes(dis, 1),
         NBSReader.readBytes(dis, 1) != 0
      );

      return instrument;
   }
   
   public void writeLayer(DataInputStream dis, int version) throws IOException {
      NBSWriter.writeString(dis, this.name);
      NBSWriter.writeString(dis, this.file);
      NBSWriter.writeBytes(dis, this.key, 1);
      NBSWriter.writeBytes(dis, this.piano ? 1 : 0, 1);
   }


   // setters
   public void setName(String name) {this.name = name;}

   public void setFile(String file) {this.file = file;}

   public void setKey(int key) {this.key = key;}

   public void setPiano(boolean piano) {this.piano = piano;}
   
   public void setId(int newId) {this.id = newId;}


   // getters
   public String getName() {return name;}

   public String getFile() {return file;}

   public int getKey() {return key;}
   
   public boolean getPiano() {return piano;}

   public int getId() {return id;}
}
