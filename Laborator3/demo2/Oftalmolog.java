package unibuc.demo2;

public class Oftalmolog extends Medic{
    protected String specializare;
    public Oftalmolog(String grad) {
        super(grad);
        specializare = "oftalmologie";
    }
    @Override
    protected void scrieReteta() {
        System.out.println("Reteta a fost scrisa de oftalmolog");
    }
    protected static void planificaConsultatie(){
        System.out.println("Consulatie la medic oftalmolog");
    }
    @Override
    protected String obtineInformatii() {
        return super.obtineInformatii() + " " + this.specializare;
    }
}
