import java.util.ArrayList;
import java.lang.reflect.Method;
import java.lang.Class;
public class ChordTypes 
{
    public static final String[] CHROMATICSCALE = { "C", "Db", "D", "Eb","E","F", "Gb","G","Ab", "A", "Bb","B" };
    private MajorScale scale;
    public ChordTypes(String root)
    {
        if(root.equals("C#")) root = "Db";
        scale = new MajorScale(root);
    }
    private int getIndexOfChromatic(String note)
    {
        if(note.contains("#"))
        {
            MajorScale Cscale = new MajorScale("C");
            note = note.substring(0,1);
            int  noteAbove = Cscale.getNotes().indexOf(note) + 1;
            if(noteAbove > Cscale.getNotes().length())
                noteAbove = noteAbove-Cscale.getNotes().length();
            note = Cscale.getNotes().charAt(noteAbove) + "b";
            if(note.equals("Fb"))
                note= "F";
            if(note.equals("Cb"))
                note="C";
        }
        for(int i = 0; i<CHROMATICSCALE.length;i++)
            if(CHROMATICSCALE[i].equals(note))
                return i;
        return -1;
    }
    private int checkChangedNote(int interval)
    {
        if(interval < 0)
            return CHROMATICSCALE.length + interval;
        else if(interval > CHROMATICSCALE.length)
            return interval-CHROMATICSCALE.length;
        else
            return interval;
    }
    public ArrayList<String> major()
    {
        ArrayList<String> chord = new ArrayList<String>();
        for(int i = 1; i <=5; i+=2)
            chord.add(scale.getNote(i));
        return chord;
    }
    public ArrayList<String> minor()
    {
        int flatThree = getIndexOfChromatic(scale.getNote(3))-1;
        flatThree = checkChangedNote(flatThree);
        ArrayList<String> chord = new ArrayList<String>();
        chord.add(scale.getNote(1));
        chord.add(CHROMATICSCALE[flatThree]);
        chord.add(scale.getNote(5));
        return chord;
    }
    public ArrayList<String> augmented()
    {
        int sharpFive = getIndexOfChromatic(scale.getNote(5))+1;
        sharpFive = checkChangedNote(sharpFive);
        ArrayList<String> chord = new ArrayList<String>();
        chord.add(scale.getNote(1));
        chord.add(scale.getNote(3));
        chord.add(CHROMATICSCALE[sharpFive]);
        return chord;
    }
    public ArrayList<String> diminished()
    {
        int flatThree = getIndexOfChromatic(scale.getNote(3))-1;
        int flatFive = getIndexOfChromatic(scale.getNote(5))-1;
        flatThree = checkChangedNote(flatThree);
        flatFive = checkChangedNote(flatFive);
        ArrayList<String> chord = new ArrayList<String>();
        chord.add(scale.getNote(1));
        chord.add(CHROMATICSCALE[flatThree]);
        chord.add(CHROMATICSCALE[flatFive]);
        return chord;
    }
    public ArrayList<String> majorAdd9()
    {
        ArrayList<String> chord = major();
        chord.add(scale.getNote(2));
        return chord;
    }
    public ArrayList<String> minorAdd9()
    {
        ArrayList<String> chord = minor();
        chord.add(scale.getNote(2));
        return chord;
    }
    public ArrayList<String> sus4()
    {
        ArrayList<String> chord = new ArrayList<String>();
        chord.add(scale.getNote(1));
        chord.add(scale.getNote(4));
        chord.add(scale.getNote(5));
        return chord;
    }
    public ArrayList<String> sus2()
    {
        ArrayList<String> chord = new ArrayList<String>();
        chord.add(scale.getNote(1));
        chord.add(scale.getNote(2));
        chord.add(scale.getNote(5));
        return chord;
    }
    public ArrayList<String> major6()
    {
        ArrayList<String> chord = major();
        chord.add(scale.getNote(6));
        return chord;
    }
    public ArrayList<String> minor6()
    {
        ArrayList<String> chord = major();
        chord.add(scale.getNote(6));
        return chord;
    }
    public ArrayList<String> major7()
    {
        ArrayList<String> chord = major();
        chord.add(scale.getNote(7));
        return chord;
    }
    public ArrayList<String> major9()
    {
        ArrayList<String> chord = major7();
        chord.add(scale.getNote(2));
        return chord;
    }
    public ArrayList<String> minor7()
    {
        int flatSeven = getIndexOfChromatic(scale.getNote(7))-1;
        flatSeven = checkChangedNote(flatSeven);
        ArrayList<String> chord = minor();
        chord.add(CHROMATICSCALE[flatSeven]);
        return chord;
    }
    public ArrayList<String> minorMajor7()
    {
        ArrayList<String> chord = minor();
        chord.add(scale.getNote(7));
        return chord;
    }
    public ArrayList<String> minor7b5()
    {
        int flatSeven = getIndexOfChromatic(scale.getNote(7))-1;
        flatSeven = checkChangedNote(flatSeven);
        ArrayList<String> chord = diminished();
        chord.add(CHROMATICSCALE[flatSeven]);
        return chord;
    }
    public ArrayList<String> minor9()
    {
        ArrayList<String> chord = minor7();
        chord.add(scale.getNote(2));
        return chord;
    }
    public ArrayList<String> minor11()
    {
        ArrayList<String> chord = minor7();
        chord.add(scale.getNote(4));
        return chord;
    }
    public ArrayList<String> dominant7()
    {
        int flatSeven = getIndexOfChromatic(scale.getNote(7))-1;
        flatSeven = checkChangedNote(flatSeven);
        ArrayList<String> chord = major();
        chord.add(CHROMATICSCALE[flatSeven]);
        return chord;
    }
    public ArrayList<String> dominant7sus4()
    {
        int flatSeven = getIndexOfChromatic(scale.getNote(7))-1;
        flatSeven = checkChangedNote(flatSeven);
        ArrayList<String> chord = sus4();
        chord.add(CHROMATICSCALE[flatSeven]);
        return chord;
    }
    public ArrayList<String> aug7()
    {
        int flatSeven = getIndexOfChromatic(scale.getNote(7))-1;
        flatSeven = checkChangedNote(flatSeven);
        ArrayList<String> chord = augmented();
        chord.add(scale.getNote(7));
        return chord;
    }
    public ArrayList<String> dominant7b5()
    {
        int flatSeven = getIndexOfChromatic(scale.getNote(7))-1;
        int flatFive = getIndexOfChromatic(scale.getNote(5))-1;
        flatSeven = checkChangedNote(flatSeven);
        flatFive = checkChangedNote(flatFive);
        ArrayList<String> chord = new ArrayList<String>();
        chord.add(scale.getNote(1));
        chord.add(scale.getNote(3));
        chord.add(CHROMATICSCALE[flatFive]);
        chord.add(CHROMATICSCALE[flatSeven]);
        return chord;
    }
    public ArrayList<String> nine()
    {
        ArrayList<String> chord = dominant7();
        chord.add(scale.getNote(2));
        return chord;
    }
    public ArrayList<String> dominant7sharp9()
    {
        int sharpNine = getIndexOfChromatic(scale.getNote(2))+1;
        sharpNine = checkChangedNote(sharpNine);
        ArrayList<String> chord = dominant7();
        chord.add(CHROMATICSCALE[sharpNine]);
        return chord;
    }
    public ArrayList<String> dominant7flat9()
    {
        int flatNine = getIndexOfChromatic(scale.getNote(2))-1;
        flatNine = checkChangedNote(flatNine);
        ArrayList<String> chord = dominant7();
        chord.add(CHROMATICSCALE[flatNine]);
        return chord;
    }
    public ArrayList<String> eleven()
    {
        ArrayList<String> chord = nine();
        chord.add(scale.getNote(4));
        return chord;
    }
    public ArrayList<String> thirteen()
    {
        ArrayList<String> chord = nine();
        chord.add(scale.getNote(6));
        return chord;
    }
    public ArrayList<String> diminished7()
    {
        ArrayList<String> chord = diminished();
        chord.add(scale.getNote(6));
        return chord;
    }
    public Class asClass()
    {
        return (Class) this.getClass();
    }
}