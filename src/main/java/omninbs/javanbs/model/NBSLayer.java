public class NBSLayer {
   private String name;
   private bool lock;
   private int volume;
   private int stereo;

   public NBSLayer(String name) {
      this.name = name;
      this.lock = false;
      this.volume = 100;
      this.stereo = 0;
   }

   // setters
   public void setName(String newName) {this.name = newName}

   public void setLock(bool newLock) {this.lock = lock}

   public void setVolume(int newVolume) {
      if (0 > newVolume || newVolume > 100) {throw new IllegalArgumentException("volume needs to be number between 0 and 100");}
      this.volume = newVolume;
   }

   public void setStereo(int newStereo) {
      if (-100 > newStereo || newStereo >  100) {throw new IllegalArgumentException("stereo needs to be a number between -100 and 100");}
      this.stereo = newStereo;
   }


   // getters
   public String getName() {return name}

   public String getLock() {return lock}

   public String getVolume() {return volume}

   public String getStereo() {return stereo}
}
