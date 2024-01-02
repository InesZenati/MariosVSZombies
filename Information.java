public class Information {
    private int attaque;
    private int defense;
    private int vie;
    private int posX;
    private int posY;
    
    public Information(int attaque, int defense, int posX, int posY, int vie){
        this.attaque = attaque;
        this.defense = defense;
        this.posX = posX;
        this.posY = posY;
        this.vie = vie;
    }

    public int getAttaque(){
        return this.attaque;
    }
    public int getDefense(){
        return this.defense;
    }
    public int getPosX(){
        return this.posX;
    }
    public int getPosY(){
        return this.posY;
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
    public void setPosX(int posX){
        this.posX = posX;
    }
    public void setPosY(int posY){
        this.posY = posY;
    }
    public void setvie(int vie){
        this.vie = vie;
    }

}