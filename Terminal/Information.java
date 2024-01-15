public class Information {
    private int attaque;
    private int defense;
    private int vie;
    
    public Information(int attaque, int defense, int vie){
        this.attaque = attaque;
        this.defense = defense;
        this.vie = vie;
    }

    public int getAttaque(){
        return this.attaque;
    }
    public int getDefense(){
        return this.defense;
    }
    public int getvie(){
        return this.vie;
    }
    public void setAttaque(int attaque){
        this.attaque = attaque;
    }
    public void setDefense(int defense){
        this.defense = defense;
    }
    public void setvie(int vie){
        this.vie = vie;
    }

}