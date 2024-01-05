public class StarMario extends Mario{
    public StarMario(){
        super("StarMario",1000, new Information(10,10,-1,-1,200));
    }
    public void takeDamage(int degat){
        this.getInfoActuelle().setvie(this.getInfoActuelle().getvie() - degat);
    }

    public void attaque (Plateau p){
        int[] pos = this.getPosition();
        if(p.getCase(pos[0],pos[1]+1).contientMario()){
            Personnage m =  p.getCase(pos[0],pos[1]+1).getPersonnage();
            if(m.getInfoActuelle().getDefense()>this.getInfoActuelle().getAttaque()){
                m.takeDamage(this.getInfoActuelle().getAttaque()/2);
            }else{
                m.takeDamage(this.getInfoActuelle().getAttaque());
            }
        }
    }

}
