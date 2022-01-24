public class Function_Info_Tab {
    GUI gui;
    public Function_Info_Tab(GUI gui) {
        this.gui = gui;
    }

    public void display() {
        gui.file.newFile();
        gui.textArea.setText("MADE BY~ \nANKUR GUPTA\n10618210005\nCSE-E  5TH SEM");
        gui.format.createFont(24);
        gui.format.setFont("CSMS");
        gui.color.setColor("BLACK");
    }
}
