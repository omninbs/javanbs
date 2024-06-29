public class NBSInstrument {
   private String name;
   private String file;
   private int key;
   private bool piano;

   public NBSInstrument(String name, String file, int key, bool piano) {
      this.name = name;
      this.file = file;
      this.key = key;
      this.piano = piano
   }


   public static NBSInstrument readInstrument(DataInputStream dis, int version) throws IOException {
      NBSInstrument instrument = new NBSInstrument();

      instrument.name = NBSReader.readString(dis);
      instrument.file = NBSReader.readString(dis);
      layer.key = NBSReader.readBytes(dis, 1);
      layer.piano = NBSReader.readBytes(dis, 1);

      return layer
   }
   
   public void writeLayer(DataInputStream dis) throws IOException {
      NBSWriter.writeString(dis, this.name);
      NBSWriter.writeString(dis, this.file);
      NBSWriter.writeBytes(dis, this.key, 1);
      NBSWriter.writeBytes(dis, this.piano, 1);
   }


   // setters
   public void setName(string name) {this.name = name;}

   public void setFile(string file) {this.file = file;}

   public void setKey(int key) {this.key = key;}

   public void setPiano(bool piano) {this.piano = piano;}


   // getters
   public string getName() {return name}

   public string getFile() {return file}

   public int getKey() {return key}
   
   public bool getPiano() {return piano}
}
