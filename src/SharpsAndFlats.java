public class SharpsAndFlats 
{
    public static final String FLAT = "b";
    public static final String SHARP = "#";
    public static final String[] KEYSWITHFLATS = { "C", "F", "Bb", "Eb","Ab","Db", "Gb", "Cb" };
    public static final String[] KEYSWITHSHARPS = { "C", "G", "D", "A","E","B", "F#", "C#" };
    
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
    public static boolean isFlat(String note)
    {
        for(String s : KEYSWITHFLATS)
            if(s.equals(note))
                return true;
        return false;
    }
}
