public class Function_Edit_Menu {
    GUI gui;

    public Function_Edit_Menu(GUI gui) {
        this.gui = gui;
    }

    public void undo() {
        gui.um.undo();
    }

    public void redo() {
        gui.um.redo();
    }
}
