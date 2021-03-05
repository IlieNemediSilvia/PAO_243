package unibuc.demo2;

public class Medic {
    protected String grad;
    protected String specializare;

    public Medic(String grad){
        this.grad = grad;
        this.specializare = "generalist";
    }
    protected void scrieReteta(){
        System.out.println("Reteta a fost scrisa de medic");
    }
    protected static void planificaConsultatie(){
        System.out.println("Consulatie la medic generalist");
    }
    protected String obtineInformatii(){
        return "Medic " + grad;
    }
}
