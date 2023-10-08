package s36.Composition.lecture;

public class PC {

    // if we use extends of let's suppose Case class we can only
    // inherit one class, since Java follows single inheritance of class
    // that's why composition comes into the picture

    private Case theCase;
    private Monitor monitor;
    private Motherboard motherboard;

    public PC(Case theCase, Monitor monitor, Motherboard motherboard) {
        this.theCase = theCase;
        this.monitor = monitor;
        this.motherboard = motherboard;
    }

    public void powerUp(){
        theCase.pressPowerButton();
        drawLogo();
    }

    public void drawLogo(){
        // Fancy Graphics
        monitor.drawPixelAt(1200,50,"yellow");
    }
}
