package omninbs.javanbs.model;

import omninbs.javanbs.model.NBSHeader;
import omninbs.javanbs.model.NBSNote;
import omninbs.javanbs.model.NBSLayer;
import omninbs.javanbs.model.NBSInstrument;

import java.io.DataInputStream;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class NBSSong {
   private NBSHeader header;
   private List<NBSInstrument> instruments;
   private List<NBSLayer> layers;
   private List<NBSNote> notes;

   public NBSSong(String name) {
      instruments = new ArrayList<>();
      layers = new ArrayList<>();
      notes = new ArrayList<>();
      header = new NBSHeader(name);
   }

   public void addNote(NBSNote newNote, int tick, int layer) {
      if (tick < 0) {throw new IllegalArgumentException("tickId can not be less then 0");}

      newNote.setTick(tick);
      newNote.setLayer(layer);

      for (int i = 0; i < notes.size(); i++) {
         NBSNote note = notes.get(i);
         
         if (note.getTick() == tick && note.getLayer() == layer) {throw new IllegalArgumentException("note already exists");}

         if ((note.getTick() == tick && note.getLayer() > layer) || (note.getTick() > tick)) {
            notes.add(i-1, newNote);
            break;
         }
      }
   }

   public void addLayer(NBSLayer newLayer, int id) {
      if (id < 0) {throw new IllegalArgumentException("layerId can not be less then 0");}

      newLayer.setId(id);
      
      for (int i = 0; i < layers.size(); i++) {
         NBSLayer layer = layers.get(i);
         if (id-1 == i) {throw new IllegalArgumentException("id already exists");}
         if (id == i) {layers.add(i-1, newLayer); break;}
      }
   }


   public void addInstrument(NBSInstrument newInstrument, int id) {
      if (id < 0) {throw new IllegalArgumentException("instrumentId can not be less then 0");}

      newInstrument.setId(id);
      
      for (int i = 0; i < layers.size(); i++) {
         NBSInstrument instrument = instruments.get(i);
         if (id-1 == i) {throw new IllegalArgumentException("id already exists");}
         if (id == i) {instruments.add(i-1, newInstrument); break;}
      }
   }

   public NBSHeader getHeader() {return header;}
   
   public List<NBSInstrument> getInstruments() {return instruments;}
   
   public List<NBSLayer> getLayers() {return layers;}
   
   public List<NBSNote> getNotes() {return notes;}


   public void setHeader(NBSHeader header) {this.header = header;}
}
