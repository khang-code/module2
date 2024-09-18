public class Taco extends Meal {
    @Override
    public void prepareIngredients() {
        System.out.println("Getting ground beef and shells");
    }

    @Override
    public void cook() {
        System.out.println("Cooking ground beef in pan");

    }

    @Override
    public void cleanUp() {
        System.out.println("Throwing away paper plates");

    }
    @Override
    public void eat() {
        System.out.println("The tacos are tasty");
    }
}
