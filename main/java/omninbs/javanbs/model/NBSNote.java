import java.util.ArrayList;
import java.util.List;

public class NBSNote {
   private int volume;
   private int pitch;
   private int instrument;
   private int key;
   private int layer;
   private int tick;

   public NBSNote(int instrument, int key, int pitch, int volume) {
      instrument = instrument;
      key = key;
      pitch = pitch;
      volume = volume;

      layer = -1;
      tick = -1;
   }

   public static List<NBSNote> readNotes(DataInputStream dis) throws IOException {
      
   }
   
   public void writeNotes(DataInputStream dis) throws IOException {
      
   }
   

   // setters
   public void setVolume(int newVolume) {this.volume = newVolume}

   public void setVolume(int newPitch) {this.pitch = newPitch}

   public void setVolume(int newInstrument) {this.instrument = newInstrument}

   public void setVolume(int newKey) {this.key = newKey}

   public void setVolume(int newLayer) {this.layer = newLayer}

   public void setVolume(int newTick) {this.tick = newTick}


   // getters
   public int getVolume() {return volume;}

   public int getPitch() {return pitch;}

   public int getInstrument() {return instrument;}

   public int getKey() {return key;}

   public int getLayer() {return layer;}

   public int getTick() {return tick;}

}
