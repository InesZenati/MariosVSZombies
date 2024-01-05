public class BigMario extends Mario{
    public BigMario(){
        super("BigMario",100,new Information(6,0,-1,-1,20));
    }
    public void takeDamage(int degat){
        this.getInfoActuelle().setvie(this.getInfoActuelle().getvie() - degat);
    }

    public void attaque(Plateau p){
        int [] pos = this.getPosition();
        if(p.getCase(pos[0],pos[1]+1).contientZombie() && p.getCase(pos[0],pos[1]+2).contientZombie()){
            if(p.getCase(pos[0],pos[1]+1).getPersonnage().getName()=="ZombieSimple"){
                Zombie1 m = (Zombie1) p.getCase(pos[0],pos[1]+1).getPersonnage();
                    m.takeDamage(m.getInfoActuelle().getvie()/2);
            }
            else if(p.getCase(pos[0],pos[1]+1).getPersonnage().getName()=="ZombieAmélioré"){
                Zombie2 m = (Zombie2) p.getCase(pos[0],pos[1]+1).getPersonnage();
                m.takeDamage(m.getInfoActuelle().getvie()/2);
            }
            else if(p.getCase(pos[0],pos[1]+1).getPersonnage().getName()=="SuperZombie"){
                Zombie3 m = (Zombie3) p.getCase(pos[0],pos[1]+1).getPersonnage();
                m.takeDamage(m.getInfoActuelle().getvie()/2);
            }
            else if(p.getCase(pos[0],pos[1]+1).getPersonnage().getName()=="SuperMegaUltraZombie"){
                Zombie4 m = (Zombie4) p.getCase(pos[0],pos[1]+1).getPersonnage();
                 m.takeDamage(m.getInfoActuelle().getvie()/2);
            }
              if(p.getCase(pos[0],pos[1]+2).getPersonnage().getName()=="ZombieSimple"){
                Zombie1 m = (Zombie1) p.getCase(pos[0],pos[1]+2).getPersonnage();
                m.takeDamage(m.getInfoActuelle().getvie()/2);
            }
            else if(p.getCase(pos[0],pos[1]+2).getPersonnage().getName()=="ZombieAmélioré"){
                Zombie2 m = (Zombie2) p.getCase(pos[0],pos[1]+2).getPersonnage();
                m.takeDamage(m.getInfoActuelle().getvie()/2);
            }
            else if(p.getCase(pos[0],pos[1]+2).getPersonnage().getName()=="SuperZombie"){
                Zombie3 m = (Zombie3) p.getCase(pos[0],pos[1]+2).getPersonnage();
                m.takeDamage(m.getInfoActuelle().getvie()/2);
            }
            else if(p.getCase(pos[0],pos[1]+2).getPersonnage().getName()=="SuperMegaUltraZombie"){
                Zombie4 m = (Zombie4) p.getCase(pos[0],pos[1]+2).getPersonnage();
                m.takeDamage(m.getInfoActuelle().getvie()/2);
            }

        } 
        

        if(p.getCase(pos[0],pos[1]+1).contientZombie()){
            if(p.getCase(pos[0],pos[1]+1).getPersonnage().getName()=="ZombieSimple"){
                Zombie1 m = (Zombie1) p.getCase(pos[0],pos[1]+1).getPersonnage();
                    m.takeDamage(m.getInfoActuelle().getvie()/2);
            }
            else if(p.getCase(pos[0],pos[1]+1).getPersonnage().getName()=="ZombieAmélioré"){
                Zombie2 m = (Zombie2) p.getCase(pos[0],pos[1]+1).getPersonnage();
                m.takeDamage(m.getInfoActuelle().getvie()/2);
            }
            else if(p.getCase(pos[0],pos[1]+1).getPersonnage().getName()=="SuperZombie"){
                Zombie3 m = (Zombie3) p.getCase(pos[0],pos[1]+1).getPersonnage();
                m.takeDamage(m.getInfoActuelle().getvie()/2);
            }
            else if(p.getCase(pos[0],pos[1]+1).getPersonnage().getName()=="SuperMegaUltraZombie"){
                Zombie4 m = (Zombie4) p.getCase(pos[0],pos[1]+1).getPersonnage();
                 m.takeDamage(m.getInfoActuelle().getvie()/2);
            }
        }
        if(p.getCase(pos[0],pos[1]+2).contientZombie()){

            if(p.getCase(pos[0],pos[1]+2).getPersonnage().getName()=="ZombieSimple"){
                Zombie1 m = (Zombie1) p.getCase(pos[0],pos[1]+2).getPersonnage();
                m.takeDamage(m.getInfoActuelle().getvie()/2);
            }
            else if(p.getCase(pos[0],pos[1]+2).getPersonnage().getName()=="ZombieAmélioré"){
                Zombie2 m = (Zombie2) p.getCase(pos[0],pos[1]+2).getPersonnage();
                m.takeDamage(m.getInfoActuelle().getvie()/2);
            }
            else if(p.getCase(pos[0],pos[1]+2).getPersonnage().getName()=="SuperZombie"){
                Zombie3 m = (Zombie3) p.getCase(pos[0],pos[1]+2).getPersonnage();
                m.takeDamage(m.getInfoActuelle().getvie()/2);
            }
            else if(p.getCase(pos[0],pos[1]+2).getPersonnage().getName()=="SuperMegaUltraZombie"){
                Zombie4 m = (Zombie4) p.getCase(pos[0],pos[1]+2).getPersonnage();
                m.takeDamage(m.getInfoActuelle().getvie()/2);
            }
        }
    }  

    public boolean aGagner(Plateau p){
        int [] pos = this.getPosition();
        if((p.getCase(pos[0],pos[1]+1).contientZombie() || p.getCase(pos[0],pos[1]+2).contientZombie())){
           if(p.getCase(pos[0],pos[1]+1).getPersonnage().getInfoActuelle().getvie()<=0 && p.getCase(pos[0],pos[1]+2).getPersonnage().getInfoActuelle().getvie()<=0){
            p.removeZombie(pos[0],pos[1]+1);
            p.removeZombie(pos[0],pos[1]+2);
           }
           

            return true;
         }
        return false;
        }
}
