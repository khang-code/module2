public class TemplateMethodDemo {
    public static void main(String[] args) {
        Meal meal1= new HamburgerMeal();
    meal1.doMeal();
        System.out.println();
    Meal meal2 = new Taco();
    meal2.doMeal();
    }
}
