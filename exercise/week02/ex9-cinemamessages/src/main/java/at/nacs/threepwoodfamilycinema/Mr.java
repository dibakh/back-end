package at.nacs.threepwoodfamilycinema;

public class Mr implements Template {
    @Override
    public String title() {
        return "Mr.";
    }

    @Override
    public String getTemplate() {
        return "don’t forget our 20% discount on tickets this Friday!";
    }
}
