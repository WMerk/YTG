#YouTrackGantt Parser

## Update to Version 1.1
Als Trennzeichen wird nun auch "," akzeptiert. 

## Benutzung

Der Parser ist eine Konsolenanwendung. 
Aufruf:

`java -jar ytg.-1.x.jar <CSV Dateiname>`

## Hinweise

Wichtig!
In Version 1.0 wird nur ';' als Seperator für die CSV Datei unterstützt. YouTrack verwendet ',' als seperator. Tipp: mit Notepad++ öffnen und alle "," durch ";" ersetzen.

CSV Datei wird Zeilenweise eingelesen. Jeder Eintrag muss mit einem **"** beginnen.
Das Ergebnis wird in eine `result.csv` Datei geschrieben.
