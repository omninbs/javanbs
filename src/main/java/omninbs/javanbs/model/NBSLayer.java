public class NBSLayer {
   private String name;
   private bool lock;
   private int volume;
   private int stereo;


   // setters
   public void setName(String newName) {this.name = newName}

   public void setLock(bool newLock) {this.lock = lock}

   public void setVolume(int newVolume) {this.volume = newVolume}

   public void setStereo(int newStereo) {this.stereo = newStereo}


   // getters
   public String getName() {return name}

   public String getLock() {return lock}

   public String getVolume() {return volume}

   public String getStereo() {return stereo}
}
