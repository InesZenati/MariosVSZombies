public class FireMario  extends Mario{

    public FireMario(){
        super("FireMario",200,new Information(10,0,-1,-1,100));
    }

    public void attaque(Plateau p){
        int [] pos = this.getPosition();
        if(p.getCase(pos[0],pos[1]+1).contientZombie()){
                Personnage m = p.getCase(pos[0],pos[1]+1).getPersonnage();
                if(m.getInfoActuelle().getDefense()>this.getInfoActuelle().getAttaque()){
                    m.takeDamage(this.getInfoActuelle().getAttaque()/2);
                }
                else{
                    m.takeDamage(this.getInfoActuelle().getAttaque());
                }
        }else if(p.getCase(pos[0],pos[1]+2).contientZombie()){
            Personnage m1 = p.getCase(pos[0],pos[1]+2).getPersonnage();
            if(m1.getInfoActuelle().getDefense()>this.getInfoActuelle().getAttaque()){
                m1.takeDamage(this.getInfoActuelle().getAttaque()/2);
            }else{
                m1.takeDamage(this.getInfoActuelle().getAttaque());
            }        
        }else if(p.getCase(pos[0],pos[1]+3).contientZombie()){
            Personnage p3 =p.getCase(pos[0],pos[1]+3).getPersonnage();
            if(p3.getInfoActuelle().getDefense()>this.getInfoActuelle().getAttaque()){
                p3.takeDamage(this.getInfoActuelle().getAttaque()/2);
            }else{
                p3.takeDamage(this.getInfoActuelle().getAttaque());
            }
        }       
    }
   
}
