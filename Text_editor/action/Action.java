package action;

import java.time.*;

public class Action {
    private int actionId;
    private LocalDateTime localdateTime;
    private boolean isAddition;
    private int lineNumber;
    private String text;

    public Action(int actionId, LocalDateTime localdateTime, boolean isAddition, int lineNumber, String text) {
        this.actionId = actionId;
        this.localdateTime = localdateTime;
        this.isAddition = isAddition;
        this.lineNumber = lineNumber;
        this.text = text;
    }

    public Action() {

    }

    public int getActionId() {
        return this.actionId;
    }

    public void setActionId(int actionId) {
        this.actionId = actionId;
    }

    public LocalDateTime getLocalDateTime() {
        return this.localdateTime;
    }

    public boolean getIsAddition() {
        return this.isAddition;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    public String getText() {
        return this.text;
    }

}
