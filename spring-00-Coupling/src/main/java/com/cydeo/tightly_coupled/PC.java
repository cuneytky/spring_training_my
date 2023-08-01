package com.cydeo.tightly_coupled;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PC {
    /*
    PC directly couple DellCase
    ??? if I change the monitor diğerleride etkileniyor-->tightly couple
    bu istenmeyen durumdur. kolayca istediğimiz yerde değişiklik yapabilmeliyiz.
     */

    private DellCase theCase;
    private AcerMonitor monitor;
    private AsusMotherboard motherboard;

    public void powerUp() {
        theCase.pressPowerButton();
        drawLogo();
    }

    private void drawLogo() {
        monitor.drawPixelAt(1200, 50, "yellow");
    }
}
