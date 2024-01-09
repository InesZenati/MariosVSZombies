public class BigMario extends Mario{
    public BigMario(){
        super("BigMario",100,new Information(6,0,-1,-1,20));
    }
    public void attaque(Plateau p){
        int [] pos = this.getPosition();
        for(int i=1;i<3;i++){
            if(p.getCase(pos[0], pos[1]+i).contientZombie()){
                Personnage z1 = p.getCase(pos[0],pos[1]+i).getPersonnage();
                z1.takeDamage(z1.getInfoActuelle().getvie()/2);
            }
        }
        /*if(p.getCase(pos[0],pos[1]+1).contientZombie() && p.getCase(pos[0],pos[1]+2).contientZombie()){
                Personnage z1 = p.getCase(pos[0],pos[1]+1).getPersonnage();
                z1.takeDamage(z1.getInfoActuelle().getvie()/2);
                Personnage z2 = p.getCase(pos[0],pos[1]+2).getPersonnage();
                z2.takeDamage(z2.getInfoActuelle().getvie()/2);
        }else if(p.getCase(pos[0],pos[1]+1).contientZombie()){
            Personnage z1 = p.getCase(pos[0],pos[1]+1).getPersonnage();
            z1.takeDamage(z1.getInfoActuelle().getvie()/2);
        }else if(p.getCase(pos[0],pos[1]+2).contientZombie()){
            Personnage z2 = p.getCase(pos[0],pos[1]+2).getPersonnage();
            z2.takeDamage(z2.getInfoActuelle().getvie()/2);
        }*/
    }  
    public boolean peutAttaquer(Plateau p){
        // System.out.println(1);
       int [] pos = this.getPosition();
        int li = pos[0];
        int col = pos[1];
       //  System.out.println(2);
       for(int i=1;i<3;i++){
           if(p.getCase(li,col+i).contientZombie2()){
             System.out.println(3);
               return true;
         }else{
             System.out.println("non");
         }
      //   System.out.println(5);
     } 
     return false;
    }

    public String estDevant(Plateau p){
        return"Bigmario";
    }


    public boolean aGagner(Plateau p){
        int [] pos = this.getPosition();
        if((p.getCase(pos[0],pos[1]+1).contientZombie()&&p.getCase(pos[0],pos[1]+2).contientZombie())){
            if(p.getCase(pos[0],pos[1]+1).getPersonnage().getInfoActuelle().getvie()<=0 && p.getCase(pos[0],pos[1]+2).getPersonnage().getInfoActuelle().getvie()<=0){
                p.removeZombie(pos[0],pos[1]+1);
                p.removeZombie(pos[0],pos[1]+2);
                return true;
            }
        }else if(p.getCase(pos[0],pos[1]+1).contientZombie()){
            if(p.getCase(pos[0],pos[1]+1).getPersonnage().getInfoActuelle().getvie()<=0){
                p.removeZombie(pos[0],pos[1]+1);
                return true;
            }
        }else if(p.getCase(pos[0],pos[1]+2).contientZombie()){
            if(p.getCase(pos[0],pos[1]+2).getPersonnage().getInfoActuelle().getvie()<=0){
                p.removeZombie(pos[0],pos[1]+2);
                return true;
            }
        }
        return false;
    }

    public String getImagePath(){
        return "BasicMario.png";
    }
        
}

