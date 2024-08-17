package notepad;

import java.time.LocalDateTime;
import action.Action;
import java.util.*;

public class Notepad {
    private int id = 1;
    private String notepad[];
    private Stack<Action> undoAction;
    private Stack<Action> redoAction;
    private Queue<String> clipBoard;
    private int capacity;

    public Notepad(int capacity) {
        notepad = new String[capacity];

        for (int i = 0; i < capacity; i++) {
            notepad[i] = "";
        }

        undoAction = new Stack<>();
        redoAction = new Stack<>();
        clipBoard = new LinkedList<>();
        this.capacity = capacity;
    }

    public void display() {
        for (int i = 0; i < this.capacity; i++) {
            System.out.println(notepad[i]);
        }
    }

    public void display(int startingLine, int endingLine) {

        if (startingLine <= 0 || startingLine > endingLine || endingLine > this.capacity) {
            System.out.println("unable to display,please check the input");
            return;
        }

        for (int i = startingLine - 1; i < endingLine; i++) {
            System.out.println(notepad[i]);
        }
    }

    public void insertLine(int lineNumber, String text) {
        if (lineNumber > capacity) {
            System.out.println("notepad limit crossed");
            return;
        }

        notepad[lineNumber - 1] = text;
        undoAction.push(new Action(id++, LocalDateTime.now(), true, lineNumber, text));
        display();
    }

    public void delete(int lineNumber) {
        if (lineNumber > capacity) {
            System.out.println("No such row to delete");
            return;
        }
        if (notepad[lineNumber - 1].isEmpty()) {
            System.out.println("No such row to delete");
            return;
        }

        redoAction.push(new Action(id++, LocalDateTime.now(), false, lineNumber, notepad[lineNumber - 1]));
        notepad[lineNumber - 1] = "";
        display();
    }

    public void delete(int startingLine, int endingLine) {
        if (startingLine > endingLine || endingLine > capacity) {
            System.out.println("unable to delete,please check the input");
            return;
        }

        for (int i = startingLine; i <= endingLine; i++) {
            delete(i);
        }

    }

    public void copy(int startingLine, int endingLine) {
        if (startingLine > endingLine || endingLine > this.capacity) {
            System.out.println("unable to copy");
            return;
        }

        String copyText = "";
        for (int i = startingLine - 1; i < endingLine; i++) {
            copyText += notepad[i] + "\n";
        }
        if (!copyText.isEmpty())
            clipBoard.add(copyText);
    }

    public void paste(int lineNumber) {
        if (clipBoard.isEmpty()) {
            System.out.println("nothing to paste");
            return;
        }

        String text = clipBoard.peek();
        insertLine(lineNumber, text);
    }

    public void undo() {
        if (this.undoAction.isEmpty()) {
            System.out.println("No action to undo");
            return;
        }

        Action action = this.undoAction.peek();
        this.undoAction.pop();

        delete(action.getLineNumber());
    }

    public void redo() {
        if (this.redoAction.isEmpty()) {
            System.out.println("No action to redo");
            return;
        }

        Action action = redoAction.peek();
        this.redoAction.pop();

        insertLine(action.getLineNumber(), action.getText());
    }

}
