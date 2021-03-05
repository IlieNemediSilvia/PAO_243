package unibuc.demo2;

public class Dermatolog extends Medic{
    protected String specializare;
    public Dermatolog(String grad){
        super(grad);
        specializare = "dermatologie";
    }

    @Override
    protected void scrieReteta() {
        System.out.println("Reteta a fost scrisa de dermatolog");
    }
    protected static void planificaConsultatie(){
        System.out.println("Consulatie la medic dermatolog");
    }
    @Override
    protected String obtineInformatii() {
        return super.obtineInformatii() + " " + this.specializare;
    }
}
