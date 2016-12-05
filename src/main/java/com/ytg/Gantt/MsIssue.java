package com.ytg.Gantt;

/**
 * Created by Waldemar on 01.12.2016.
 */
public class MsIssue {
    String Nr;

    public String getNr() {
        return Nr;
    }

    public void setNr(String nr) {
        Nr = nr;
    }

    public String getVorgangsmodus() {
        return Vorgangsmodus;
    }

    public void setVorgangsmodus(String vorgangsmodus) {
        Vorgangsmodus = vorgangsmodus;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDauer() {
        return Dauer;
    }

    public void setDauer(String dauer) {
        Dauer = dauer;
    }

    public String getGeplante_Dauer() {
        return Geplante_Dauer;
    }

    public void setGeplante_Dauer(String geplante_Dauer) {
        Geplante_Dauer = geplante_Dauer;
    }

    public String getEnde() {
        return Ende;
    }

    public void setEnde(String ende) {
        Ende = ende;
    }

    public String getVorgänger() {
        return Vorgänger;
    }

    public void setVorgänger(String vorgänger) {
        Vorgänger = vorgänger;
    }

    public String getRessourcennamen() {
        return Ressourcennamen;
    }

    public void setRessourcennamen(String ressourcennamen) {
        Ressourcennamen = ressourcennamen;
    }

    public String getGliederungsebene() {
        return Gliederungsebene;
    }

    public void setGliederungsebene(String gliederungsebene) {
        Gliederungsebene = gliederungsebene;
    }

    String Vorgangsmodus;
    String Name;
    String Dauer;
    String Geplante_Dauer;
    String Ende;
    String Vorgänger;
    String Ressourcennamen;
    String Gliederungsebene;
}

