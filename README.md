# javanbs

![Java](https://img.shields.io/badge/Java-11+-green)
![Code Style](https://img.shields.io/badge/code%20style-java--style--guide-brightgreen)
[![Maven Central](https://img.shields.io/maven-central/v/omninbs/javanbs.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:omninbs%20AND%20a:javanbs)


> A simple java library to read and write [.nbs files](https://opennbs.org/nbs)
> from [Open Note Block Studio](https://opennbs.org/).a

`javanbs` has all the functionality `pynbs` has, like iterating over Note Block Studio songs
``` java
import omninbs.javanbs.NBSReader;
import omninbs.javanbs.NBSNote;

for (NBSNote note : NBSReader.readSong("example.nbs").getNotes()) {
  System.out.print("tick: "); System.out.print(note.getTick());
  System.out.print("instrument: "); System.out.println(note.getInstrument());
}
```

or generating new songs programmatically
``` java
import omninbs.javanbs.NBSSong;
import omninbs.javanbs.NBSNote;

NBSSong song = new NBSSong("example (name)");
for (int i = 0; 0 < 10; i++) {
  song.addNote(new NBSNote(0, i+35, 0, 30, 0), i, 0));
}
```

## Installation

the package can note yet be installed with a package manager.

## Reading / Writing
You can use the omninbs.javanbs.NBSReader.readSong(String file) function to read an parse a specific NBS file of any version.
```java
NBSSong song = NBSReader.readSong("example.nbs");
```
This returns an NBSSong wich can then be written using NBSWriter.writeSong(file, song, optional(version))
```java
NBSWriter.writeSong("example.nbs", song, version);
```
where version = nil saves it in the newest version.

## Fields

#### Header

The first field is `header`, the file header. It contains information about
the file.

Attribute                   | Type    | Details
:---------------------------|:--------|:------------------------------------------------
`header.version`            | `int`   | The NBS version this file was saved on.
`header.defaultInstruments` | `int`   | The amount of instruments from vanilla Minecraft in the song.
`header.length`             | `int`   | The length of the song, measured in ticks.
`header.layerCount`         | `int`   | The ID of the last layer with at least one note block in it.
`header.name`               | `str`   | The name of the song.
`header.author`             | `str`   | The author of the song.
`header.originalAuthor`     | `str`   | The original song author of the song.
`header.description`        | `str`   | The description of the song.
`header.tempo`              | `int` | The tempo of the song.
`header.autoSaving`         | `bool`  | Whether auto-saving has been enabled.
`header.autoSaveDuration`   | `int`   | The amount of minutes between each auto-save.
`header.timeSignature`      | `int`   | The time signature of the song.
`header.minutesSpent`       | `int`   | The amount of minutes spent on the project.
`header.leftClicks`         | `int`   | The amount of times the user has left-clicked.
`header.rightClicks`        | `int`   | The amount of times the user has right-clicked.
`header.blocksAdded`        | `int`   | The amount of times the user has added a block.
`header.blocksRemoved`      | `int`   | The amount of times the user has removed a block.
`header.songOrigin`         | `str`   | The file name of the original MIDI or schematic.
`header.looping`            | `bool`  | Whether the song should loop back to the start after ending.
`header.maxLoops`           | `int`   | The amount of times to loop. 0 = infinite.
`header.loopStart`          | `int`   | The tick the song will loop back to at the end of playback.

#### Notes

The `notes` attribute holds a list of all the notes of the song in order.

Attribute         | Type  | Details
:---------------- |:------|:------------------------------------------------
`note.tick`       | `int` | The tick at which the note plays.
`note.layer`      | `int` | The ID of the layer in which the note is placed.
`note.instrument` | `int` | The ID of the instrument.
`note.key`        | `int` | The key of the note. (between 0 and 87)
`note.volume`   | `int` | The velocity of the note. (between 0 and 100)
`note.stereo`    | `int` | The stereo panning of the note. (between -100 and 100)
`note.pitch`      | `int` | The detune of the note, in cents. (between -1200 and 1200)

#### Layers

The `layers` attribute holds a list of all the layers of the song in order.

Attribute         | Type  | Details
:-----------------|:------|:------------------------
`layer.id`        | `int` | The ID of the layer.
`layer.name`      | `str` | The name of the layer.
`layer.lock`      | `bool`| Whether the layer is locked.
`layer.volume`    | `int` | The volume of the layer.
`layer.stereo`   | `int` | The stereo panning of the layer.

#### Instruments

The `instruments` attribute holds a list of all the custom instruments of the
song in order.

Attribute              | Type   | Details
:----------------------|:-------|:----------------------------------------------------------
`instrument.id`        | `int`  | The ID of the instrument.
`instrument.name`      | `str`  | The name of the instrument.
`instrument.file`      | `str`  | The name of the sound file of the instrument.
`instrument.pitch`     | `int`  | The pitch of the instrument. (between 0 and 87)
`instrument.piano` | `bool` | Whether the piano should automatically press keys with the instrument when the marker passes them.
