/*
*This class gives back the chord tones for the possible ChordTypes
*given a major scale for a given root, it will construct proper chords
*for minor chords, we simply take major chords and 'flat' the third note
*/


import java.util.ArrayList;
import java.lang.reflect.Method;
import java.lang.Class;
public class ChordTypes 
{
    //all possible notes in Western music
    public static final String[] CHROMATICSCALE = { "C", "Db", "D", "Eb","E","F", "Gb","G","Ab", "A", "Bb","B" };
    private MajorScale scale;
    public ChordTypes(String root)
    {
        //for some reason, Java does not like C#, luckily Db is the same
        if(root.equals("C#")) root = "Db";
        scale = new MajorScale(root);
    }
    
    /*
    *Converts a String note to a number in the chromatic scale 
    *a chromatic scale can be thought of as a list from 0 to 11
    */
    private int getIndexOfChromatic(String note)
    {
        if(note.contains("#"))
        {
            MajorScale Cscale = new MajorScale("C");
            //cuts off all chars past the first two
            note = note.substring(0,1);
            int  noteAbove = Cscale.getNotes().indexOf(note) + 1;
            if(noteAbove > Cscale.getNotes().length())
                noteAbove = noteAbove-Cscale.getNotes().length();
            note = Cscale.getNotes().charAt(noteAbove) + "b";
            //fixes an issue where half-steps get assigned flats
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
    
    /*
    *ALL METHODS BELOW ARE FOR SPECIFIC CHORDS
    */
    
    //if root is 1, major chord is 1,3,5 in major scale
    public ArrayList<String> major()
    {
        ArrayList<String> chord = new ArrayList<String>();
        for(int i = 1; i <=5; i+=2)
            chord.add(scale.getNote(i));
        return chord;
    }
    //if root is 1, minor chord is 1,3b,5 in major scale
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
    //if root is 1, augmented chord is 1,3,5# in major scale
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
    //if root is 1, diminished chord is 1,3b,5b in major scale
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
    //if root is 1, major+9 chord is 1,3,5,2 in major scale
    public ArrayList<String> majorAdd9()
    {
        ArrayList<String> chord = major();
        chord.add(scale.getNote(2));
        return chord;
    }
    //if root is 1, minor+9 chord is 1,3b,5,2 in major scale
    public ArrayList<String> minorAdd9()
    {
        ArrayList<String> chord = minor();
        chord.add(scale.getNote(2));
        return chord;
    }
    //if root is 1, sus4 chord is 1,4,5 in major scale
    public ArrayList<String> sus4()
    {
        ArrayList<String> chord = new ArrayList<String>();
        chord.add(scale.getNote(1));
        chord.add(scale.getNote(4));
        chord.add(scale.getNote(5));
        return chord;
    }
    //if root is 1, sus2 chord is 1,2,5 in major scale
    public ArrayList<String> sus2()
    {
        ArrayList<String> chord = new ArrayList<String>();
        chord.add(scale.getNote(1));
        chord.add(scale.getNote(2));
        chord.add(scale.getNote(5));
        return chord;
    }
    //major chord plus the sixth
    public ArrayList<String> major6()
    {
        ArrayList<String> chord = major();
        chord.add(scale.getNote(6));
        return chord;
    }
    //minor chord plus the sixth
    public ArrayList<String> minor6()
    {
        ArrayList<String> chord = major();
        chord.add(scale.getNote(6));
        return chord;
    }
    //major chord plus the seventh
    public ArrayList<String> major7()
    {
        ArrayList<String> chord = major();
        chord.add(scale.getNote(7));
        return chord;
    }
    //major chord plus the ninth
    public ArrayList<String> major9()
    {
        ArrayList<String> chord = major7();
        chord.add(scale.getNote(2));
        return chord;
    }
    //minor chord plus the flat seventh
    public ArrayList<String> minor7()
    {
        int flatSeven = getIndexOfChromatic(scale.getNote(7))-1;
        flatSeven = checkChangedNote(flatSeven);
        ArrayList<String> chord = minor();
        chord.add(CHROMATICSCALE[flatSeven]);
        return chord;
    }
     //minor chord plus the major seventh
    public ArrayList<String> minorMajor7()
    {
        ArrayList<String> chord = minor();
        chord.add(scale.getNote(7));
        return chord;
    }
    //minor7 with flat 5
    public ArrayList<String> minor7b5()
    {
        int flatSeven = getIndexOfChromatic(scale.getNote(7))-1;
        flatSeven = checkChangedNote(flatSeven);
        ArrayList<String> chord = diminished();
        chord.add(CHROMATICSCALE[flatSeven]);
        return chord;
    }
    //minor with ninth (or 2)
    public ArrayList<String> minor9()
    {
        ArrayList<String> chord = minor7();
        chord.add(scale.getNote(2));
        return chord;
    }
    //minor with eleventh (or 4)
    public ArrayList<String> minor11()
    {
        ArrayList<String> chord = minor7();
        chord.add(scale.getNote(4));
        return chord;
    }
    //the canonical seventh chord, major plus flat seven
    public ArrayList<String> dominant7()
    {
        int flatSeven = getIndexOfChromatic(scale.getNote(7))-1;
        flatSeven = checkChangedNote(flatSeven);
        ArrayList<String> chord = major();
        chord.add(CHROMATICSCALE[flatSeven]);
        return chord;
    }
    //same as last chord with a fourth
    public ArrayList<String> dominant7sus4()
    {
        int flatSeven = getIndexOfChromatic(scale.getNote(7))-1;
        flatSeven = checkChangedNote(flatSeven);
        ArrayList<String> chord = sus4();
        chord.add(CHROMATICSCALE[flatSeven]);
        return chord;
    }
    //augmented chord with seventh
    public ArrayList<String> aug7()
    {
        int flatSeven = getIndexOfChromatic(scale.getNote(7))-1;
        flatSeven = checkChangedNote(flatSeven);
        ArrayList<String> chord = augmented();
        chord.add(scale.getNote(7));
        return chord;
    }
    //the canonical seventh chord,  with flat five
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
    //the canonical seventh chord, with extra nine (or 2)
    public ArrayList<String> nine()
    {
        ArrayList<String> chord = dominant7();
        chord.add(scale.getNote(2));
        return chord;
    }
    //the canonical seventh chord, with extra #nine (or 2)
    public ArrayList<String> dominant7sharp9()
    {
        int sharpNine = getIndexOfChromatic(scale.getNote(2))+1;
        sharpNine = checkChangedNote(sharpNine);
        ArrayList<String> chord = dominant7();
        chord.add(CHROMATICSCALE[sharpNine]);
        return chord;
    }
    //the canonical seventh chord, with extra flatnine (or 2)
    public ArrayList<String> dominant7flat9()
    {
        int flatNine = getIndexOfChromatic(scale.getNote(2))-1;
        flatNine = checkChangedNote(flatNine);
        ArrayList<String> chord = dominant7();
        chord.add(CHROMATICSCALE[flatNine]);
        return chord;
    }
    //just adding another third on top of the nine
    public ArrayList<String> eleven()
    {
        ArrayList<String> chord = nine();
        chord.add(scale.getNote(4));
        return chord;
    }
    //and more thirds!!
    public ArrayList<String> thirteen()
    {
        ArrayList<String> chord = nine();
        chord.add(scale.getNote(6));
        return chord;
    }
    //diminished chord with dimished 7 (double flat 7 or 6)
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
