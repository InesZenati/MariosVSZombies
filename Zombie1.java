public class Zombie1 extends Zombie {
    public Zombie1( int v){
        super("ZombieSimple",10,v,new Information(2,0,-1,-1,10));
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