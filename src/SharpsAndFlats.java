/*
*Helper class that is effectively the circle of firths
*for any note, returns info on the key
*/

public class SharpsAndFlats 
{
    public static final String FLAT = "b";
    public static final String SHARP = "#";
    public static final String[] KEYSWITHFLATS = { "C", "F", "Bb", "Eb","Ab","Db", "Gb", "Cb" };
    public static final String[] KEYSWITHSHARPS = { "C", "G", "D", "A","E","B", "F#", "C#" };
    
    /*
    *Returns number of flats (or sharps) in a given key
    *example, Key of G has one sharp (f#)
    */
    public static int getNumAccidentals(String note)
    {
        for(int i = 0; i < KEYSWITHFLATS.length; i++)
            if(note.equalsIgnoreCase(KEYSWITHFLATS[i]))
                return i;
               
        for(int i = 0; i < KEYSWITHSHARPS.length; i++)
            if(note.equalsIgnoreCase(KEYSWITHSHARPS[i]))
                return i;
        return -1;
    }
    //Since sharps and flats are equivalent I chose to stick with flats
    //this method returns true if the key has flats, false if it has sharps
    public static boolean isFlat(String note)
    {
        for(String s : KEYSWITHFLATS)
            if(s.equals(note))
                return true;
        return false;
    }
}
