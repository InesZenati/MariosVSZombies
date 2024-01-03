public abstract class Zombie extends Personnage {
    private final int gain;
    private int vitesse;
    private final Information InfoInitiale;

    Zombie(String name,int g, int v, Information i){
        super(false,name);
        this.gain=g;
        this.vitesse=v;
        this.InfoInitiale=i;
        this.setInfoActuelle(i);
    }
    public int getVitesse(){
        return this.vitesse;
    }
    public void setVitesse(int v){
        this.vitesse=v;
    }
    public Information getInfoInitiale(){
        return this.InfoInitiale;
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
        return this.getName() + " \n Point de vie :" + this.getInfoActuelle().getvie() + " \n Attaque :" + this.getInfoActuelle().getAttaque() + " \n Defense :" +
         this.getInfoActuelle().getDefense()+" \n Vitesse :"+v+" \n Gain :"+this.gain;
    }


    public void takeDamage(int degat){
        this.getInfoActuelle().setvie(this.getInfoActuelle().getvie() - degat);
    }
    public boolean peutAttaquer(Plateau p){
        int [] pos = this.getPosition();
        if(p.getCase(pos[0],pos[1]-1).contientMario()){
            return true;
        }
        return false;
    }

    public void attaquer(Plateau p){
        int [] pos = this.getPosition();
        if(p.getCase(pos[0],pos[1]-1).contientMario()){
            if(p.getCase(pos[0],pos[1]-1).getPersonnage().getName()=="BasicMario"){
                BasicMario m = (BasicMario) p.getCase(pos[0],pos[1]-1).getPersonnage();
                if(m.getInfoActuelle().getDefense()>this.getInfoActuelle().getAttaque()){
                    m.takeDamage(this.getInfoActuelle().getAttaque()/2);
                }
                else{
                    m.takeDamage(this.getInfoActuelle().getAttaque());
                }
            }
            else if(p.getCase(pos[0],pos[1]-1).getPersonnage().getName()=="FireMario"){
                FireMario m = (FireMario) p.getCase(pos[0],pos[1]-1).getPersonnage();
                if(m.getInfoActuelle().getDefense()>this.getInfoActuelle().getAttaque()){
                    m.takeDamage(this.getInfoActuelle().getAttaque()/2);
                }
                else{
                    m.takeDamage(this.getInfoActuelle().getAttaque());
                }
            }
            else if(p.getCase(pos[0],pos[1]-1).getPersonnage().getName()=="WallBrick"){
                WallBrick m = (WallBrick) p.getCase(pos[0],pos[1]-1).getPersonnage();
                if(m.getInfoActuelle().getDefense()>this.getInfoActuelle().getAttaque()){
                    m.takeDamage(this.getInfoActuelle().getAttaque()/2);
                }
                else{
                    m.takeDamage(this.getInfoActuelle().getAttaque());
                }
                m.takeDamage(this.getInfoActuelle().getAttaque());
            }
            else if(p.getCase(pos[0],pos[1]-1).getPersonnage().getName()=="BigMario"){
                BigMario m = (BigMario) p.getCase(pos[0],pos[1]-1).getPersonnage();
                if(m.getInfoActuelle().getDefense()>this.getInfoActuelle().getAttaque()){
                    m.takeDamage(this.getInfoActuelle().getAttaque()/2);
                }
                else{
                    m.takeDamage(this.getInfoActuelle().getAttaque());
                }
            }
            else if(p.getCase(pos[0],pos[1]-1).getPersonnage().getName()=="SuperMario"){
                StarMario m =(StarMario) p.getCase(pos[0],pos[1]-1).getPersonnage();
               if(m.getInfoActuelle().getDefense()>this.getInfoActuelle().getAttaque()){
                    m.takeDamage(this.getInfoActuelle().getAttaque()/2);
                }
                else{
                    m.takeDamage(this.getInfoActuelle().getAttaque());
                }
            }
        }
    }
    
} 
    

