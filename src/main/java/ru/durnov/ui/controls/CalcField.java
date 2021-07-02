package ru.durnov.ui.controls;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;

public class CalcField extends TextField {

    public CalcField(){
        super();
        this.setEditable(false);
        this.setAlignment(Pos.CENTER_LEFT);
    }
}
