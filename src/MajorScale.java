public class MajorScale 
{
    private String[] scale = { "C", "D","E","F","G","A","B" };
    public static final String ORDEROFFLATS="BEADGCF";
    public static final String ORDEROFSHARPS="FCGDAEB"; 
    public MajorScale(){}
    public MajorScale(String startingNote)
    {
       if(startingNote.substring(0,1).compareTo("G") > 1)
           startingNote = "C";
       if(startingNote.equals("B#")) 
           startingNote = "C";
        startingNote.toUpperCase();
        changeRoot(startingNote);
        addAccidentals(startingNote);
    }
    public void changeRoot(String note)
    {
        if (SharpsAndFlats.getNumAccidentals(note)==-1)
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
        String[] newScale = new String[7];
        int index = 0;
        for(int i = 0; i< scale.length;i++)
            if(scale[i].equals(note.substring(0,1)))
                index = i;
        for(int i = index; i < scale.length;i++)
           newScale[i-index] = scale[i];
        for(int i = 0; i < index; i++)
            newScale[i+ (7-index)] = scale [i];
        scale = newScale;
    }
    public String getNotes()
    {
         String notes = "";
         for(String s : scale)
             notes += s;
         return notes;
    }
    public void addAccidentals(String startingNote)
    {
        if (SharpsAndFlats.getNumAccidentals(startingNote)==-1)
        {
            MajorScale Cscale = new MajorScale("C");
            startingNote = startingNote.substring(0,1);
            int  noteAbove = Cscale.getNotes().indexOf(startingNote) + 1;
            if(noteAbove > Cscale.getNotes().length())
                noteAbove = noteAbove-Cscale.getNotes().length();
            startingNote = Cscale.getNotes().charAt(noteAbove) + "b";
            if(startingNote.equals("Fb"))
                startingNote= "F";
            if(startingNote.equals("Cb"))
                startingNote="C";
        }
        int numAccidentals = SharpsAndFlats.getNumAccidentals(startingNote);
        String ref;
        if(SharpsAndFlats.isFlat(startingNote))
        {
            for(int i = 0; i < scale.length; i ++)
                for(int j = 0; j < numAccidentals; j ++)
                    if(scale[i].equals(ORDEROFFLATS.substring(j,j+1)))
                        scale[i] = scale[i] + "b";
        }
        else
        {
            for(int i = 0; i < scale.length; i ++)
                for(int j = 0; j < numAccidentals; j ++)
                    if(scale[i].equals(ORDEROFSHARPS.substring(j,j+1)))
                        scale[i] = scale[i] + "#";
        }
    }
    public String getNote(int interval)
    {
        return scale[interval-1];
    }
}
//class Tester
//{
//    public static void main(String[]args)
//    {
//        MajorScale g = new MajorScale("Cb");
//        System.out.println(g.getNotes());
//        System.out.println(g.getNote(3));
//    }
//
//}
