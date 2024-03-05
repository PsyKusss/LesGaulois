package personnages;

public class Village {
	
    private String nom;
    private Chef chef;
    private Gaulois[] villageois;
    private int nbVillageois;
    
    public Village(String nom) {
         this.nom = nom;
    }
    public void setChef(Chef chef) {
         this.chef = chef;
    }
    public String getNom() {
         return nom;
	}
    
    public Village(String nom, int nbVillageoisMaximum) {
        this.nom = nom;
        this.villageois = new Gaulois[nbVillageoisMaximum]; 
        this.nbVillageois = 0;
    }
    public void ajouterHabitant(Gaulois gaulois) {
        if (nbVillageois < villageois.length) {
            villageois[nbVillageois] = gaulois;
            nbVillageois++;
            System.out.println(gaulois.getNom() + " a rejoint le village !");
        } else {
            System.out.println("Le village est plein, impossible d'ajouter un nouveau villageois.");
        }
    }
    public Gaulois trouverHabitant(int position) {
        if (position >= 0 && position < nbVillageois) {
            return villageois[position];
        } else {
            System.out.println("Aucun villageois trouvé à cette position.");
            return null;
        }
    }
    public void afficherVillageois() {
        System.out.println("Dans le village du chef " + chef.getNom() + " vivent les légendaires gaulois : ");
        
        for (int i = 0; i < nbVillageois; i++) {
            if (villageois[i] != null) {
                System.out.println(villageois[i].getNom());
            }
        }
    }


    public static void main(String[] args) {
    	Village village = new Village("Village des Irréductibles", 30);       
    	Chef abraracourcix = new Chef("Abraracourcix", 6,village);
    	village.setChef(abraracourcix);
        Gaulois asterix = new Gaulois("Astérix", 8);
        village.ajouterHabitant(asterix);
        Gaulois obelix = new Gaulois("Obélix", 25);
        village.ajouterHabitant(obelix);
        village.afficherVillageois();
    }
}