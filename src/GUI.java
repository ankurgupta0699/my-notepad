import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    JFrame window;

    //TEXT AREA
    JTextArea textArea;
    JScrollPane scrollPane;
    boolean WordWrapOn = false;

    //MENU BAR
    JMenuBar menuBar;

    //FILE MENU
    JMenu menuFile, menuEdit, menuFormat, menuColor;
    JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;

    //EDIT MENU
    JMenuItem iUndo, iRedo;

    //FORMAT MENU
    JMenuItem iWrap, iFontArial, iFontCSMS, iFontTNR, iFontSize8, iFontSize12, iFontSize16, iFontSize20, iFontSize24, iFontSize28;
    JMenu menuFont, menuFontSize;

    //COLOR MENU
    JMenuItem colorWhite, colorBlack, colorBlue, colorRed;

    //INFO
    JMenuItem iInfo;

    Function_File_Menu file = new Function_File_Menu(this);
    Function_Edit_Menu edit = new Function_Edit_Menu(this);
    Function_Format_Menu format = new Function_Format_Menu(this);
    Function_Color_Menu color = new Function_Color_Menu(this);
    Function_Info_Tab info = new Function_Info_Tab(this);

    UndoManager um = new UndoManager();

    KeyShortcuts ks = new KeyShortcuts(this);

    public static void main(String[] args) {
        new GUI();
        System.out.println("ANKUR GUPTA");
    }

    public GUI() {
        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        createEditMenu();

        createFormatMenu();
        format.wordWrap();
        format.selectedFont = "arial";
        format.createFont(12);

        createColorMenu();
        color.setColor("WHITE");

        createInfo();

        window.setVisible(true);
    }

    public void createWindow() {
        window = new JFrame("myNotepad");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createTextArea() {
        textArea = new JTextArea();

        textArea.addKeyListener(ks);

        textArea.getDocument().addUndoableEditListener(
                e -> um.addEdit(e.getEdit())
        );

        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);
        // window.add(textArea);
    }

    public void createMenuBar() {
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);

        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);

        menuColor = new JMenu("Color");
        menuBar.add(menuColor);
    }

    public void createFileMenu() {
        iNew = new JMenuItem("New");
        iNew.addActionListener(this);
        iNew.setActionCommand("actionNew");
        menuFile.add(iNew);

        iOpen = new JMenuItem("Open");
        iOpen.addActionListener(this);
        iOpen.setActionCommand("actionOpen");
        menuFile.add(iOpen);

        iSave = new JMenuItem("Save");
        iSave.addActionListener(this);
        iSave.setActionCommand("actionSave");
        menuFile.add(iSave);

        iSaveAs = new JMenuItem("SaveAs");
        iSaveAs.addActionListener(this);
        iSaveAs.setActionCommand("actionSaveAs");
        menuFile.add(iSaveAs);

        iExit = new JMenuItem("Exit");
        iExit.addActionListener(this);
        iExit.setActionCommand("actionExit");
        menuFile.add(iExit);
    }

    public void createEditMenu() {
        iUndo = new JMenuItem("Undo");
        iUndo.addActionListener(this);
        iUndo.setActionCommand("actionUndo");
        menuEdit.add(iUndo);

        iRedo = new JMenuItem("Redo");
        iRedo.addActionListener(this);
        iRedo.setActionCommand("actionRedo");
        menuEdit.add(iRedo);

    }

    public void createFormatMenu() {
        //WORD WRAP=============================================
        iWrap = new JMenuItem("WordWrap : off");
        iWrap.addActionListener(this);
        iWrap.setActionCommand("actionWordWrap");
        menuFormat.add(iWrap);

        // FONT =================================================
        menuFont = new JMenu("Font");
        menuFormat.add(menuFont);

        iFontArial = new JMenuItem("Arial");
        iFontArial.addActionListener(this);
        iFontArial.setActionCommand("actionFontArial");
        menuFont.add(iFontArial);

        iFontCSMS = new JMenuItem("Comic Sans MS");
        iFontCSMS.addActionListener(this);
        iFontCSMS.setActionCommand("actionFontCSMS");
        menuFont.add(iFontCSMS);

        iFontTNR = new JMenuItem("Times New Roman");
        iFontTNR.addActionListener(this);
        iFontTNR.setActionCommand("actionFontTNR");
        menuFont.add(iFontTNR);

        // FONT SIZE==================================================
        menuFontSize = new JMenu("Font_size");
        menuFormat.add(menuFontSize);

        iFontSize8 = new JMenuItem("8");
        iFontSize8.addActionListener(this);
        iFontSize8.setActionCommand("actionFontSize8");
        menuFontSize.add(iFontSize8);

        iFontSize12 = new JMenuItem("12");
        iFontSize12.addActionListener(this);
        iFontSize12.setActionCommand("actionFontSize12");
        menuFontSize.add(iFontSize12);

        iFontSize16 = new JMenuItem("16");
        iFontSize16.addActionListener(this);
        iFontSize16.setActionCommand("actionFontSize16");
        menuFontSize.add(iFontSize16);

        iFontSize20 = new JMenuItem("20");
        iFontSize20.addActionListener(this);
        iFontSize20.setActionCommand("actionFontSize20");
        menuFontSize.add(iFontSize20);

        iFontSize24 = new JMenuItem("24");
        iFontSize24.addActionListener(this);
        iFontSize24.setActionCommand("actionFontSize24");
        menuFontSize.add(iFontSize24);

        iFontSize28 = new JMenuItem("28");
        iFontSize28.addActionListener(this);
        iFontSize28.setActionCommand("actionFontSize28");
        menuFontSize.add(iFontSize28);
    }

    public void createColorMenu() {
        colorBlack = new JMenuItem("Black");
        colorBlack.addActionListener(this);
        colorBlack.setActionCommand("actionColorBlack");
        menuColor.add(colorBlack);

        colorBlue = new JMenuItem("Blue");
        colorBlue.addActionListener(this);
        colorBlue.setActionCommand("actionColorBlue");
        menuColor.add(colorBlue);

        colorWhite = new JMenuItem("White");
        colorWhite.addActionListener(this);
        colorWhite.setActionCommand("actionColorWhite");
        menuColor.add(colorWhite);

        colorRed = new JMenuItem("Red");
        colorRed.addActionListener(this);
        colorRed.setActionCommand("actionColorRed");
        menuColor.add(colorRed);
    }

    public void createInfo() {
        iInfo = new JMenuItem("Info");
        iInfo.addActionListener(this);
        iInfo.setActionCommand("actionInfo");
        menuBar.add(iInfo);
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();
        switch (command) {
            case "actionNew": file.newFile(); break;
            case "actionOpen": file.open(); break;
            case "actionSave": file.save(); break;
            case "actionSaveAs": file.saveAs(); break;
            case "actionExit": System.out.println("Program RUN SUCCESS :)\n\t~Ankur Gupta"); file.exit(); break;
            case "actionUndo": edit.undo(); break;
            case "actionRedo": edit.redo(); break;
            case "actionWordWrap": format.wordWrap(); break;
            case "actionFontArial": format.setFont("arial"); break;
            case "actionFontCSMS": format.setFont("CSMS"); break;
            case "actionFontTNR": format.setFont("TNR"); break;
            case "actionFontSize8": format.createFont(8); break;
            case "actionFontSize12": format.createFont(12); break;
            case "actionFontSize16": format.createFont(16); break;
            case "actionFontSize20": format.createFont(20); break;
            case "actionFontSize24": format.createFont(24); break;
            case "actionFontSize28": format.createFont(28); break;
            case "actionColorBlack": color.setColor("BLACK"); break;
            case "actionColorBlue": color.setColor("BLUE"); break;
            case "actionColorWhite": color.setColor("WHITE"); break;
            case "actionColorRed": color.setColor("RED"); break;
            case "actionInfo": info.display() ; break;
        }
    }
}

//ADD CUSTOM COLOR(RGB) CHOOSE BY TAKING INPUT FROM USER IN A DIALOG BOX