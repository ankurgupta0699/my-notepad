import java.awt.*;

public class Function_Color_Menu {
    GUI gui;

    Function_Color_Menu(GUI gui) {
        this.gui = gui;
    }

    public void setColor(String color) {
        switch (color) {
            case "BLACK":
                gui.window.getContentPane().setBackground(Color.BLACK);
                gui.textArea.setBackground(Color.BLACK);
                gui.textArea.setForeground(Color.WHITE);
                break;
            case "BLUE":
                gui.window.getContentPane().setBackground(Color.BLUE);
                gui.textArea.setBackground(Color.BLUE);
                gui.textArea.setForeground(Color.WHITE);
                break;
            case "WHITE":
                gui.window.getContentPane().setBackground(Color.WHITE);
                gui.textArea.setBackground(Color.WHITE);
                gui.textArea.setForeground(Color.BLACK);
                break;
            case "RED":
                gui.window.getContentPane().setBackground(Color.RED);
                gui.textArea.setBackground(Color.RED);
                gui.textArea.setForeground(Color.WHITE);
                break;
        }
    }

}
