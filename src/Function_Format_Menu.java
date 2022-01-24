import java.awt.*;

public class Function_Format_Menu {
    GUI gui;
    Font arial, comicSansMS, timesNewRoman;
    String selectedFont = null;
    public Function_Format_Menu(GUI gui) {
        this.gui = gui;
    }

    public void wordWrap() {
        if(!gui.WordWrapOn) {
            gui.WordWrapOn = true;
            gui.textArea.setLineWrap(true);
            gui.textArea.setWrapStyleWord(true);
            gui.iWrap.setText("Word Wrap : on");
        }
        else {
            gui.WordWrapOn = false;
            gui.textArea.setLineWrap(false);
            gui.textArea.setWrapStyleWord(false);
            gui.iWrap.setText("Word Wrap : off");
        }
    }

    public void createFont(int size) {
        arial = new Font("Arial",Font.PLAIN,size);
        comicSansMS = new Font("Comic Sans MS",Font.PLAIN,size);
        timesNewRoman = new Font("Times New Roman", Font.PLAIN, size);

        setFont(selectedFont);
    }

    public void setFont(String font) {
        selectedFont = font;

        switch(font) {
            case "arial" : gui.textArea.setFont(arial); break;
            case "CSMS" : gui.textArea.setFont(comicSansMS); break;
            case "TNR" : gui.textArea.setFont(timesNewRoman); break;
        }
    }
}
