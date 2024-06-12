package listeners;

import models.Model;
import views.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonNew implements ActionListener {
    private Model model;
    private View view;
    public ButtonNew(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println("Klikk");
        view.hideButtons();
        if(!view.getGameTimer().isRunning()) {//Mängu aeg ei jookse
            view.getGameTimer().setSeconds(0);
            view.getGameTimer().setMinutes(0);
            view.getGameTimer().setRunning(true);
            view.getGameTimer().startTime();
        } else {
            view.getGameTimer().stopTime();
            view.getGameTimer().setRunning(false);
        }
        //TODO Siit jätkub õpilaste arendus

    }
}
