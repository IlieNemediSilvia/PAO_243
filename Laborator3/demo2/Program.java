package unibuc.demo2;

public class Program {
    public static void main(String[] args) {
        Medic medic = new Medic("primar");
        System.out.println(medic.specializare);
        medic.scrieReteta();
        medic.planificaConsultatie(); //Medic.planificaConsultatie();
        System.out.println(medic.obtineInformatii());
        System.out.println("-----------------");
        Medic medic1 = new Dermatolog("primar");
        medic1.scrieReteta();
        medic1.planificaConsultatie(); //Medic.planificaConsultatie();
        System.out.println(medic1.obtineInformatii());
        System.out.println(medic1.specializare);
        System.out.println("-----------------");
        Dermatolog dermatolog = new Dermatolog("rezident");
        System.out.println(dermatolog.specializare);
        System.out.println(dermatolog.obtineInformatii());
        dermatolog.planificaConsultatie(); //Dermatolog.planificaConsultatie();
        System.out.println("-----------------");
        Medic medic2 = new Oftalmolog("specialist");
        System.out.println(medic2.specializare);
        medic2.planificaConsultatie();
        medic2.scrieReteta();
        System.out.println(medic2.obtineInformatii());
        System.out.println("-----------------");
        Oftalmolog oftalmolog = new Oftalmolog("specialist");
        System.out.println(oftalmolog.specializare);
        oftalmolog.planificaConsultatie();
        oftalmolog.scrieReteta();
        System.out.println(oftalmolog.obtineInformatii());

        Dermatolog medicDermatolog = (Dermatolog) medic;

    }
}
