public class BasicMario extends Mario{
    BasicMario(){
        super("BasicMario",10,new Information(2,0,-1,-1,10));
    }
    public void attaque(Zombie z){
       
    }
    public void takeDamage(int degat){
        this.getInfoActuelle().setvie(this.getInfoActuelle().getvie() - degat);
    }

    public void attaque (Plateau p){
        int[] pos = this.getPosition();
        if(p.getCase(pos[0],pos[1]+1).contientMario()){
            if(p.getCase(pos[0],pos[1]+1).getPersonnage().getName()=="ZombieSimple"){
                Zombie1 m = (Zombie1) p.getCase(pos[0],pos[1]+1).getPersonnage();
                if(m.getInfoActuelle().getDefense()>this.getInfoActuelle().getAttaque()){
                    m.takeDamage(this.getInfoActuelle().getAttaque()/2);
                }
                else{
                    m.takeDamage(this.getInfoActuelle().getAttaque());
                }
         }
            else if(p.getCase(pos[0],pos[1]+1).getPersonnage().getName()=="ZombieAmélioré"){
                Zombie2 m = (Zombie2) p.getCase(pos[0],pos[1]+1).getPersonnage();
                if(m.getInfoActuelle().getDefense()>this.getInfoActuelle().getAttaque()){
                    m.takeDamage(this.getInfoActuelle().getAttaque()/2);
                }
                else{
                    m.takeDamage(this.getInfoActuelle().getAttaque());
                }
            }
            else if(p.getCase(pos[0],pos[1]+1).getPersonnage().getName()=="SuperZombie"){
                Zombie3 m = (Zombie3) p.getCase(pos[0],pos[1]+1).getPersonnage();
                if(m.getInfoActuelle().getDefense()>this.getInfoActuelle().getAttaque()){
                    m.takeDamage(this.getInfoActuelle().getAttaque()/2);
                }
                else{
                    m.takeDamage(this.getInfoActuelle().getAttaque());
                }
            }
            else if(p.getCase(pos[0],pos[1]+1).getPersonnage().getName()=="SuperMegaUltraZombie"){
                Zombie4 m = (Zombie4) p.getCase(pos[0],pos[1]+1).getPersonnage();
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
