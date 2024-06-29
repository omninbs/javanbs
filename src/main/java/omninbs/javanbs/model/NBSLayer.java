package omninbs.javanbs.model;

public class NBSLayer {
   private String name;
   private bool lock;
   private int volume;
   private int stereo;

   public NBSLayer(String name, int volume) {
      this.name = name;
      this.lock = false;
      this.volume = volume;
      this.stereo = 0;
   }


   public static NBSLayer readLayer(DataInputStream dis, int version) throws IOException {
      NBSLayer layer = new NBSLayer();

      layer.name = NBSReader.readString(dis);
      if (version >= 4) {layer.lock = NBSReader.readBytes(dis, 1);}
      else {layer.lock = false;}
      layer.volume = NBSReader.readBytes(dis, 1);
      if (version >= 2) {layer.panning = NBSReader.readBytes(dis, 1);}
      else {layer.panning = 0;}

      return layer;
   }
   
   public void writeLayer(DataInputStream dis) throws IOException {
      NBSWriter.writeString(dis, this.name);
      if (version >= 4) {NBSWriter.writeBytes(dis, this.lock, 1);}
      NBSWriter.writeBytes(dis, this.volume, 1);
      if (version >= 2) {NBSWriter.writeBytes(dis, this.panning, 1);}
   }


   // setters
   public void setName(String newName) {this.name = newName;}

   public void setLock(bool newLock) {this.lock = lock;}

   public void setVolume(int newVolume) {
      if (0 > newVolume || newVolume > 100) {throw new IllegalArgumentException("volume needs to be number between 0 and 100");}
      this.volume = newVolume;
   }

   public void setStereo(int newStereo) {
      if (-100 > newStereo || newStereo >  100) {throw new IllegalArgumentException("stereo needs to be a number between -100 and 100");}
      this.stereo = newStereo;
   }


   // getters
   public String getName() {return name;}

   public String getLock() {return lock;}

   public String getVolume() {return volume;}

   public String getStereo() {return stereo;}
}
