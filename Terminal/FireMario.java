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
            }else{
                m.takeDamage(this.getInfoActuelle().getAttaque());
            }
            this.aGagner(p,m);
        }else if(p.getCase(pos[0],pos[1]+2).contientZombie()){
            Personnage m = p.getCase(pos[0],pos[1]+2).getPersonnage();
            if(m.getInfoActuelle().getDefense()>this.getInfoActuelle().getAttaque()){
                m.takeDamage(this.getInfoActuelle().getAttaque()/2);
            }else{
                m.takeDamage(this.getInfoActuelle().getAttaque());
            }        
            this.aGagner(p,m);
        }else if(p.getCase(pos[0],pos[1]+3).contientZombie()){
            Personnage m =p.getCase(pos[0],pos[1]+3).getPersonnage();
            if(m.getInfoActuelle().getDefense()>this.getInfoActuelle().getAttaque()){
                m.takeDamage(this.getInfoActuelle().getAttaque()/2);
            }else{
                m.takeDamage(this.getInfoActuelle().getAttaque());
            }
            this.aGagner(p,m);
        }       
    }

    public boolean peutAttaquer(Plateau p){
        // System.out.println(1);
       int [] pos = this.getPosition();
        int li = pos[0];
        int col = pos[1];
       //  System.out.println(2);
       for(int i=1;i<4;i++){
           if(p.getCase(li,col+i).contientZombie2()){
             //System.out.println(3);
               return true;
         }else{
             //System.out.println("non");
         }
      //   System.out.println(5);
     } 
     return false;
    }
    public String estDevant(Plateau p){
        return"Firemario";
    }
    public String getImagePath(){
        return "BasicMario.png";
    }
}
