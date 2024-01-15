public class FireMario  extends Mario{

    public FireMario(){
        super("FireMario",50,new Information(10,5,100));
    }

    public void attaque(Plateau p){
        int [] pos = this.getPosition();
        if(p.getCase(pos[0],pos[1]+1)!=null){
        if(p.getCase(pos[0],pos[1]+1).contientZombie()){
            Personnage m = p.getCase(pos[0],pos[1]+1).getPersonnage();
            if(m.getInfoActuelle().getDefense()>this.getInfoActuelle().getAttaque()){
                m.takeDamage(this.getInfoActuelle().getAttaque()/2);
                p.getJoueur().incrementerArgent(3);
            }else{
                m.takeDamage(this.getInfoActuelle().getAttaque());
                p.getJoueur().incrementerArgent(3);
            }
            this.aGagner(p,m);
        }
        }else if(p.getCase(pos[0],pos[1]+2)!=null){
            if(p.getCase(pos[0],pos[1]+2).contientZombie()){
            Personnage m = p.getCase(pos[0],pos[1]+2).getPersonnage();
            if(m.getInfoActuelle().getDefense()>this.getInfoActuelle().getAttaque()){
                m.takeDamage(this.getInfoActuelle().getAttaque()/2);
                p.getJoueur().incrementerArgent(3);
            }else{
                m.takeDamage(this.getInfoActuelle().getAttaque());
                p.getJoueur().incrementerArgent(3);
            }        
            this.aGagner(p,m);
        }
        }else if(p.getCase(pos[0],pos[1]+2)!=null){
        if(p.getCase(pos[0],pos[1]+3).contientZombie()){
            Personnage m =p.getCase(pos[0],pos[1]+3).getPersonnage();
            if(m.getInfoActuelle().getDefense()>this.getInfoActuelle().getAttaque()){
                m.takeDamage(this.getInfoActuelle().getAttaque()/2);
                p.getJoueur().incrementerArgent(3);
            }else{
                m.takeDamage(this.getInfoActuelle().getAttaque());
                p.getJoueur().incrementerArgent(3);
            }
            this.aGagner(p,m);
        }
        }       
    }

    public boolean peutAttaquer(Plateau p){
        int [] pos = this.getPosition();
        int li = pos[0];
        int col = pos[1];
        for(int i=1;i<4;i++){
            if(p.getCase(li,col+i)!=null){
                if(p.getCase(li,col+i).contientZombie()){
                    return true;
                }
            }
        }
        return false;
    }
   
    public String estDevant(Plateau p){
        return"Firemario";
    }
    public String getImagePath(){
        return "FireMario.png";
    }
}
