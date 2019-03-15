public class Rocket implements SpaceShip{

    int rocketCost;
    int rocketWeight;
    int maxWeight;
    int currentWeight;



    public Rocket() {
    }



    public Rocket(int rocketCost, int rocketWeight, int maxWeight) {
        this.rocketCost = rocketCost;
        this.rocketWeight = rocketWeight;
        this.maxWeight = maxWeight;


    }


    public int getRocketCost() {
        return rocketCost;
    }

    public void setRocketCost(int rocketCost) {
        this.rocketCost = rocketCost;
    }

    public int getRocketWeight() {
        return rocketWeight;
    }

    public void setRocketWeight(int rocketWeight) {
        this.rocketWeight = rocketWeight;
    }


    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }


    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    @Override
    public boolean launch(){
        return true;
    }


    @Override
    public boolean land(){
        return true;
    }



    /* This method takes an item object
     * and updates the current weight of
     * the rocket
     */

    @Override
    public int carry(Item item){
        this.currentWeight += item.getWeight();
        return this.currentWeight;
    }


    /* This method takes an item object and
    *  returns true if the rocket can
    *  carry it, false if it will exceed the
    *  weight limit
     */

    @Override
    public boolean canCarry(Item item){
        if(item.getWeight()+this.currentWeight<=maxWeight){
            return true;
        }else{
            return false;
        }

    }

    @Override
    public String toString() {
        return "Rocket{" +
                "rocketCost=" + rocketCost +
                ", rocketWeight=" + rocketWeight +
                ", maxWeight=" + maxWeight +
                ", currentWeight=" + currentWeight +
                '}';
    }
}
