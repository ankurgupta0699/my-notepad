import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Function_File_Menu {
    GUI gui;
    String fileName;
    String fileAddress;

    public Function_File_Menu(GUI gui) {
        this.gui = gui;
        fileName = null;
        fileAddress = null;
    }

    public void newFile() {
        gui.textArea.setText("");
        gui.window.setTitle("NewFile");
        fileName = null;
        fileAddress = null;

    }
    public void open() {
        FileDialog fd = new FileDialog(gui.window,"open",FileDialog.LOAD);
        fd.setVisible(true);

        fileName = fd.getFile();

        if(fileName!=null) {
            fileAddress = fd.getDirectory();
            gui.window.setTitle(fileName);
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileAddress+fileName));
            gui.textArea.setText("");
            String line;
            while((line = br.readLine()) != null) {
                gui.textArea.append(line + "\n");
            }
            br.close();
        } catch (Exception e) {
            System.out.println("CANNOT OPEN FILE!!");
        }
    }
    public void save() {
        if(fileName==null) {
            saveAs();
        }
        else {
            try {
                FileWriter fw = new FileWriter(fileAddress+fileName);
                fw.write(gui.textArea.getText());
                fw.close();
            } catch(Exception e) {
                System.out.println("CANNOT SAVE! something wrong..!");
            }
        }
    }
    public void saveAs() {
        FileDialog fd = new FileDialog(gui.window,"SaveAs",FileDialog.SAVE);
        fd.setVisible(true);

        fileName = fd.getFile();
        if(fileName!=null) {
            fileAddress = fd.getDirectory();
            gui.window.setTitle(fileName);
        }

        try {
            FileWriter fw = new FileWriter(fileAddress + fileName);
            fw.write(gui.textArea.getText());
            fw.close();
        } catch(Exception e) {
            System.out.println("CANNOT SAVE! something wrong..in SaveAs!");
        }
    }

    public void exit() {
        System.exit(0);
    }
}
