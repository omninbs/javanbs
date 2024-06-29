package omninbs.javanbs.model;

public class NBSHeader {
   private int version;
   private int defaultInstruments;
   private int length;
   private int layerCount;
   private String name;
   private String author;
   private String originalAuthor;
   private String description;
   private int tempo;
   private int autoSaving;
   private int autoSavingDuration;
   private int timeSignature;
   private int minutesSpent;
   private int leftClicks;
   private int rightClicks;
   private int noteblocksAdded;
   private int noteblocksRemoved;
   private String songOrigin;
   private int looping;
   private int maxLoops;
   private int loopStart;
   
   public static List<NBSNote> readNotes(DataInputStream dis) throws IOException {
      
   }
   
   public void writeNotes(DataInputStream dis) throws IOException {
      
   }

       // Constructor
    public NBSHeader(String name) {
        this.name = name;
        this.version = 5;
        this.defaultInstruments = 15;
        this.length = 0;
        this.layerCount = 1;
        this.author = "";
        this.originalAuthor = "";
        this.description = "";
        this.tempo = 20;
        this.autoSaving = 0;
        this.autoSavingDuration = 0;
        this.timeSignature = 0;
        this.minutesSpent = 0;
        this.leftClicks = 0;
        this.rightClicks = 0;
        this.noteblocksAdded = 0;
        this.noteblocksRemoved = 0;
        this.songOrigin = "";
        this.looping = 0;
        this.maxLoops = 0;
        this.loopStart = 0;
    }


    // Setters
    public void setVersion(int version) {
        this.version = version;
    }

    public void setDefaultInstruments(int defaultInstruments) {
        this.defaultInstruments = defaultInstruments;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setLayerCount(int layerCount) {
        this.layerCount = layerCount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setOriginalAuthor(String originalAuthor) {
        this.originalAuthor = originalAuthor;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public void setAutoSaving(int autoSaving) {
        this.autoSaving = autoSaving;
    }

    public void setAutoSavingDuration(int autoSavingDuration) {
        this.autoSavingDuration = autoSavingDuration;
    }

    public void setTimeSignature(int timeSignature) {
        this.timeSignature = timeSignature;
    }

    public void setMinutesSpent(int minutesSpent) {
        this.minutesSpent = minutesSpent;
    }

    public void setLeftClicks(int leftClicks) {
        this.leftClicks = leftClicks;
    }

    public void setRightClicks(int rightClicks) {
        this.rightClicks = rightClicks;
    }

    public void setNoteblocksAdded(int noteblocksAdded) {
        this.noteblocksAdded = noteblocksAdded;
    }

    public void setNoteblocksRemoved(int noteblocksRemoved) {
        this.noteblocksRemoved = noteblocksRemoved;
    }

    public void setSongOrigin(String songOrigin) {
        this.songOrigin = songOrigin;
    }

    public void setLooping(int looping) {
        this.looping = looping;
    }

    public void setMaxLoops(int maxLoops) {
        this.maxLoops = maxLoops;
    }

    public void setLoopStart(int loopStart) {
        this.loopStart = loopStart;
    }

    // Getters
    public int getVersion() {
        return version;
    }

    public int getDefaultInstruments() {
        return defaultInstruments;
    }

    public int getLength() {
        return length;
    }

    public int getLayerCount() {
        return layerCount;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getOriginalAuthor() {
        return originalAuthor;
    }

    public String getDescription() {
        return description;
    }

    public int getTempo() {
        return tempo;
    }

    public int getAutoSaving() {
        return autoSaving;
    }

    public int getAutoSavingDuration() {
        return autoSavingDuration;
    }

    public int getTimeSignature() {
        return timeSignature;
    }

    public int getMinutesSpent() {
        return minutesSpent;
    }

    public int getLeftClicks() {
        return leftClicks;
    }

    public int getRightClicks() {
        return rightClicks;
    }

    public int getNoteblocksAdded() {
        return noteblocksAdded;
    }

    public int getNoteblocksRemoved() {
        return noteblocksRemoved;
    }

    public String getSongOrigin() {
        return songOrigin;
    }

    public int getLooping() {
        return looping;
    }

    public int getMaxLoops() {
        return maxLoops;
    }

    public int getLoopStart() {
        return loopStart;
    }
}
