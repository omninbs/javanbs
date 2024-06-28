public class NBSHeader {
   public int classicLength;
   public int version;
   public int defaultInstruments;
   public int length;
   public int layer_count;
   public String name;
   public String author;
   public String originalAuthor;
   public String description;
   public int tempo;
   public int autoSaving;
   public int autoSavingDuration;
   public int timeSignature;
   public int minutesSpent;
   public int leftClicks;
   public int rightClicks;
   public int noteblocksAdded;
   public int noteblocksRemoved;
   public String songOrigin;
   public int looping;
   public int maxLoops;
   public int loopStart;
   
   public NBSHeader() {}
   
   public static List<NBSNote> readNotes(DataInputStream dis) throws IOException {
      
   }
   
   public void writeNotes(DataInputStream dis) throws IOException {
      
   }
}
