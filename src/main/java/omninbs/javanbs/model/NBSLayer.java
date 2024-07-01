package omninbs.javanbs.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import omninbs.javanbs.NBSReader;
import omninbs.javanbs.NBSWriter;

public class NBSLayer {
   private String name;
   private boolean lock;
   private int volume;
   private int stereo;
   private int id;

   public NBSLayer(String name, int volume) {
      this.name = name;
      this.lock = false;
      this.volume = volume;
      this.stereo = 0;
   }


   public static NBSLayer readLayer(FileInputStream fis, int version) throws IOException {
      NBSLayer layer = new NBSLayer("", 100);

      layer.name = NBSReader.readString(fis);
      if (version >= 4) {layer.lock = NBSReader.readBytes(fis, 1) != 0;}
      else {layer.lock = false;}
      layer.volume = NBSReader.readBytes(fis, 1);
      if (version >= 2) {layer.stereo = NBSReader.readBytes(fis, 1);}
      else {layer.stereo = 0;}

      return layer;
   }
   
   public void writeLayer(FileOutputStream fos, int version) throws IOException {
      NBSWriter.writeString(fos, this.name);
      if (version >= 4) {NBSWriter.writeBytes(fos, this.lock ? 1 : 0, 1);}
      NBSWriter.writeBytes(fos, this.volume, 1);
      if (version >= 2) {NBSWriter.writeBytes(fos, this.stereo, 1);}
   }


   // setters
   public void setName(String newName) {this.name = newName;}

   public void setLock(boolean newLock) {this.lock = lock;}

   public void setVolume(int newVolume) {
      if (0 > newVolume || newVolume > 100) {throw new IllegalArgumentException("volume needs to be number between 0 and 100");}
      this.volume = newVolume;
   }

   public void setStereo(int newStereo) {
      if (-100 > newStereo || newStereo >  100) {throw new IllegalArgumentException("stereo needs to be a number between -100 and 100");}
      this.stereo = newStereo;
   }

   public void setId(int newId) {this.id = newId;}


   // getters
   public String getName() {return name;}

   public boolean getLock() {return lock;}

   public int getVolume() {return volume;}

   public int getStereo() {return stereo;}

   public int getId() {return id;}
}
