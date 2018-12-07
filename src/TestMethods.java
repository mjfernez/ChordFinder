/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mike
 *Tested to make sure major chords have the right data
 */
public class TestMethods {
    public static void main(String[]args)
    {
        MajorScale df = new MajorScale("A#");
        System.out.println(df.getNotes());
    }
}
