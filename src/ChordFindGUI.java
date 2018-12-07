/*
 * ChordFindGUI.java
 *
 * Created on Jun 14, 2011, 2:29:06 PM
 */
/**
 *
 * @author Mike
 *This code is the main powerhorse for the program, it contains the GUI
 *A lot of this was generated by NetBeans (at least the setup part) save for a few custom changes
 *Sorry if this is an eyesore, I've learned IDEs tend to be...
 */
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.io.File;
import java.util.ArrayList;
import java.lang.reflect.Method;
import java.lang.Class;
import javax.sound.sampled.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class ChordFindGUI extends javax.swing.JFrame {

    /** Creates new form ChordFindGUI */
    public ChordFindGUI() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        chordInput = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        note1 = new javax.swing.JLabel();
        note2 = new javax.swing.JLabel();
        note3 = new javax.swing.JLabel();
        note4 = new javax.swing.JLabel();
        note5 = new javax.swing.JLabel();
        note6 = new javax.swing.JLabel();
        find = new javax.swing.JButton();
        noteInput = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        play = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel1.setText("Note");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 59, 35));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel2.setText("Type");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 70, 36));

        String[] methodString = new String[chords.length];
        for(int i = 0; i < chords.length; i++)
        methodString[i] = chords[i].toString();
        String[] chordString = stripAllMethods(methodString);
        alphabetize(chordString);
        chordInput.setModel(new javax.swing.DefaultComboBoxModel(chordString));
        getContentPane().add(chordInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel3.setText("Notes in that chord:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, -1));

        note1.setText("N/A");
        getContentPane().add(note1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, -1, -1));

        note2.setText("N/A");
        getContentPane().add(note2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, -1, -1));

        note3.setText("N/A");
        getContentPane().add(note3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, -1, -1));

        note4.setText("N/A");
        getContentPane().add(note4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, -1, -1));

        note5.setText("N/A");
        getContentPane().add(note5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, -1, -1));

        note6.setText("N/A");
        getContentPane().add(note6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, -1, -1));

        find.setText("Find");
        find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findActionPerformed(evt);
            }
        });
        getContentPane().add(find, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, -1, -1));

        noteInput.setText("A");
        getContentPane().add(noteInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 35, -1));

        jLabel4.setText("*Note: all keys with double #'s are automatically");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, 10));

        jLabel5.setText("changed to their enharmonic equivalent and larger");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jLabel6.setText("chords will omit commonly left out notes");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jLabel7.setText("       ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 30, -1));

        jLabel8.setText("     ");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, -1, -1));

        play.setText("Play");
        play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playActionPerformed(evt);
            }
        });
        getContentPane().add(play, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void findActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findActionPerformed
        key = noteInput.getText();
        if(key == null 
                || key.substring(0,1).compareToIgnoreCase("G") >= 1 
                || key.length() > 2)
        {
            JOptionPane.showMessageDialog(rootPane, "Has to be a note");
            return;
        }
        if(chordInput.getSelectedItem() == null)
        {
            JOptionPane.showMessageDialog(rootPane, "Gotta pick a chord");
            return;
        }
        key = key.substring(0,1).toUpperCase() + key.substring(1);
        list = new ChordTypes(key); 
        ArrayList<String> intervals= new ArrayList<String>();
        //for(int i =0; i<6;i++)
          //  intervals.add("N/A");
        String methodToCall = chordInput.getSelectedItem() + "";
        for(Method m : chords)
        {
            if(methodToCall.equals(m.getName()) && !m.isVarArgs())
            {
                Object obj = null;
                m.setAccessible(true);
                try {
                    obj = m.invoke(list, null);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(ChordFindGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(ChordFindGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex) {
                    Logger.getLogger(ChordFindGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                intervals = (ArrayList) obj;
                for(int i = intervals.size(); i <= 6; i++)
                    intervals.add("N/A");
            }
                
        }
        note1.setText(intervals.get(0));
        note2.setText(intervals.get(1));
        note3.setText(intervals.get(2));
        note4.setText(intervals.get(3));
        note5.setText(intervals.get(4));
        note6.setText(intervals.get(5));
    }//GEN-LAST:event_findActionPerformed

    
    /***
    *BUTTON METHOD
    ***/
    
    //Play button, plays the chord using the sound files in this folder
    private void playActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playActionPerformed
        ArrayList<String> intervals = new ArrayList<String>(0);
        intervals.add(note1.getText());
        intervals.add(note2.getText());
        intervals.add(note3.getText());
        intervals.add(note4.getText());
        intervals.add(note5.getText());
        intervals.add(note6.getText());
        //sets up key and figures out what notes to play based on chord requested
        for(int i = 0; i < intervals.size();i++)
        {
            String s = intervals.get(i);
           if(s.contains("#"))
            {
                int currentPlace = intervals.indexOf(s);
                MajorScale Cscale = new MajorScale("C");
                s = s.substring(0,1);
                int  noteAbove = Cscale.getNotes().indexOf(s) + 1;
                if(noteAbove > Cscale.getNotes().length())
                    noteAbove = noteAbove-Cscale.getNotes().length();
                s = Cscale.getNotes().charAt(noteAbove) + "b";
                if(s.equals("Fb"))
                    s= "F";
                if(s.equals("Cb"))
                    s="C";
                intervals.set(currentPlace, s);
            }
           if(s.contains("N/A"))
           {
               intervals.remove(s);
               i--;
           }   
        }
        if(intervals.isEmpty())
        {
            JOptionPane.showMessageDialog(rootPane, "There's nothing to play");
            return;
        }
        for(int i = 0; i < intervals.size(); i++)
        {
            File file = new File("C:\\Program Files\\ChordFinder\\"
                    +intervals.get(i)+".wav");
            //error handler for AudioPlayer
            AudioFormat format=null;
            try {
                format = AudioSystem.getAudioFileFormat(file).getFormat();
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(ChordFindGUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ChordFindGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            DataLine.Info info = new DataLine.Info(Clip.class, 
                format); // format is an AudioFormat object
            DataLine.Info lineInfo = new DataLine.Info(TargetDataLine.class, 
                format);
            if (!AudioSystem.isLineSupported(info)||!AudioSystem.isLineSupported(lineInfo)) {
                    JOptionPane.showMessageDialog(rootPane, "File error");
                    return;
                }
                // Obtain and open the line.
            try {
                player[i] = (Clip) AudioSystem.getLine(info);
                TargetDataLine line = AudioSystem.getTargetDataLine(format);
                //player[i].open(new AudioInputStream(line));
                //player[i].getBufferSize()
                player[i].open(format, getBytesFromFile(file) , 0, getBytesFromFile(file).length);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(ChordFindGUI.class.getName()).log(Level.SEVERE, null, ex);
            }catch (IOException ex) {
                Logger.getLogger(ChordFindGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            player[i].loop(0);
        }
    }//GEN-LAST:event_playActionPerformed
    
    
    /***
    *LIST METHODS
    ***/
    
    /*
    *Generates the choices for the user to choose based on the methods in ChordTypes.java
    */
    private String[] stripAllMethods(String[] chordMethods)
    {
        String[] newStrings = new String[chordMethods.length-9];
        for(int i = 0; i < chordMethods.length; i++)
        {
            int start = chordMethods[i].indexOf("s.");
            String s = chordMethods[i].substring(start+2, chordMethods[i].length()-2);
            //System.out.println(s);
            if(!s.contains("asClass") 
                    && !s.contains("getIndexOf") 
                    && !s.contains("Object")
                    && !s.contains("check"))
                newStrings[i] = s;
        }
        return newStrings;
    }
    /*
    *alphabetizes the list above
    */
    private void alphabetize(String[]theList)
    {
        for(int i = 1; i < theList.length; i++)
        {
            int min = i;
            for(int j = i+1; j<theList.length; j++)
            {
                if(theList[min].compareToIgnoreCase(theList[j]) >= 1)
                    min = j;
            }
            String temp = theList[i];
            theList[i] = theList[min];
            theList[min] = temp;   
        }
    }
    
    //AUTO-GENERATED CODE FOR READING SOUND BYTES
    // Returns the contents of the file in a byte array. 
    public static byte[] getBytesFromFile(File file) throws IOException {
        InputStream is = new FileInputStream(file);

        // Get the size of the file
        long length = file.length();

        // You cannot create an array using a long type.
        // It needs to be an int type.
        // Before converting to an int type, check
        // to ensure that file is not larger than Integer.MAX_VALUE.
        if (length > Integer.MAX_VALUE) {
            return null;
        }

        // Create the byte array to hold the data
        byte[] bytes = new byte[(int)length];

        // Read in the bytes
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
               && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
            offset += numRead;
        }

        // Ensure all the bytes have been read in
        if (offset < bytes.length) {
            throw new IOException("Could not completely read file "+file.getName());
        }
        // Close the input stream and return bytes
        is.close();
        return bytes;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ChordFindGUI().setVisible(true);
            }
        });
    }
    //Applet methodAccessor = new Applet();
    //END AUTO-GENERATED CODE
    
    //Defaults and list of objects to manipulate
    Clip[] player = new Clip[6];
    String key = "A";
    ChordTypes list = new ChordTypes(key);
    private Method[] chords = list.asClass().getMethods();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox chordInput;
    private javax.swing.JButton find;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel note1;
    private javax.swing.JLabel note2;
    private javax.swing.JLabel note3;
    private javax.swing.JLabel note4;
    private javax.swing.JLabel note5;
    private javax.swing.JLabel note6;
    private javax.swing.JTextField noteInput;
    private javax.swing.JButton play;
    // End of variables declaration//GEN-END:variables
}
