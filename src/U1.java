public class U1 extends Rocket {


    double launchExplosion = 5;
    double landingCrash = 1;


    public U1(){
        setRocketCost(100);
        setRocketWeight(10000);
        setMaxWeight(18000);
        setCurrentWeight(getRocketWeight());
    }





    /* This method generates a random number(1-100) and
     * return true if the launch explosion probability
     * is less than the random generated number
     */


    @Override
    public boolean launch(){
        double random = Math.random()*10+1;
        return launchExplosion*(double)this.currentWeight/this.maxWeight<=random;
    }


    /* This method generates a random number(1-100) and
     * return true if the landing crash probability
     * is less than the random generated number
     */

    @Override
    public boolean land(){
        double random = Math.random()*10+1;
        return landingCrash*(double)this.currentWeight/this.maxWeight<=random;
    }





}
