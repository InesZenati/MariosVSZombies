public abstract class Zombie extends Personnage {
    private final int gain;
    private int vitesse;

    Zombie(String name,int g, int v, Information i){
        super(false,name);
        this.gain=g;
        this.vitesse=v;
        this.setInfoActuelle(i);
    }
    public int getGain(){
        return gain;
    }
    public int getVitesse(){
        return this.vitesse;
    }
    public void setVitesse(int v){
        this.vitesse=v;
    }
    @Override
    public String toString(){
        String v;
        switch (this.getVitesse()) {
            case 0:
                v = "lent";
                break;
            case 1 :
                v = "moyen";
                break;
            case 2 :
                v= "rapide";
                break;
            default: v= "non-defini";
                break;
        }
        int [] pos = this.getPosition();
        return this.getName() + " \n Point de vie :" + this.getInfoActuelle().getvie() + " \n Attaque :" + this.getInfoActuelle().getAttaque() + " \n Defense :" +
         this.getInfoActuelle().getDefense()+" \n Vitesse :"+v+" \n Gain :"+this.gain+" \n Position :"+pos[0]+", "+pos[1];
    }

    
    public String estDevant(Plateau p){
        int [] pos = this.getPosition();
        int li = pos[0];
        int col = pos[1]-1;
        if(pos[1]!=0){
        return("Zombie face à Mario :"+p.getCase(li,col).contientMario());
        }
        return ("Zombie face à sortie");
    }

    public boolean peutAttaquer(Plateau p){
        int [] pos = this.getPosition();
        int li = pos[0];
        int col = pos[1]-1;
        if(pos[1]!=0){
        if(p.getCase(li,col).contientMario()){
            return true;
        }}
        return false;
    }

    public void attaque(Plateau p){
        int [] pos = this.getPosition();
            Personnage m = p.getCase(pos[0],pos[1]-1).getPersonnage();
            if(m.getInfoActuelle().getDefense()>this.getInfoActuelle().getAttaque()){;
                m.takeDamage(this.getInfoActuelle().getAttaque()/2);
            }else{
                m.takeDamage(this.getInfoActuelle().getAttaque());
            }
            this.aGagner(p, m);
    }
    public void attaque(PlateauGUI pGui){
        Plateau p = pGui.getJeuGUI().getPlateau();
        int [] pos = this.getPosition();
            Personnage m = p.getCase(pos[0],pos[1]-1).getPersonnage();
            if(m.getInfoActuelle().getDefense()>this.getInfoActuelle().getAttaque()){;
                m.takeDamage(this.getInfoActuelle().getAttaque()/2);
            }else{
                m.takeDamage(this.getInfoActuelle().getAttaque());
            }
            this.aGagner(pGui,m);
    }
    public void moveZombie(Plateau plato) {;                 
        int li = this.getPosition()[0];
        int col = this.getPosition()[1];
        if(this.peutDeplacer(plato)&& plato.getPartieStatus()==0){ 
                
                this.removeZombie(li, col,plato);
                col=col-1;
                //sleep(100);
                this.placeZombie(li, col, plato);
                plato.affiche();
                peutDeplacer(plato);
                sleep(100);
            }
        }

    public void moveZombie(PlateauGUI p){
        Plateau plato = p.getJeuGUI().getPlateau();                
        int li = this.getPosition()[0];
        int col =this.getPosition()[1];
        if(this.peutDeplacer(plato)){ 
                p.updatePlateau();
                this.removeZombie(li, col,plato);
                col=col-1;
                //sleep(100);
                this.placeZombie(li, col, plato);
                p.updatePlateau();
               peutDeplacer(plato);
               sleep(100);
            }
        }
        
        
        public void placeZombie(int li, int col,Plateau plato ){   
            this.setPosition(li, col);
            plato.ajouter(this);
            plato.getCase(li, col).setZombie(this);
        }
    
        public void removeZombie(int li, int col,Plateau plato) {
            plato.retirer(plato.getCase(li, col).getPersonnage());
            plato.getCase(li, col).supprimerPerso();
        }


    public boolean peutDeplacer(Plateau p){ 
        int [] pos = this.getPosition();
        int col = pos[1];
        int li = pos[0];
        if((col>0)&&!p.getCase(li,col-1).contientMario()&& !p.getCase(li,col-1).contientZombie()){
            return true;
            }
        if(col==0){
            p.ZombieGagne();
        }
        return false;
    }

    public void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}  
    
