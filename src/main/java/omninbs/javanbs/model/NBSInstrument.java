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
