package mySimple;

public class ShoppingCart {

    private int id;
    private int id_product;
    private double ammount;
    private int id_user;

    public ShoppingCart(int id, int id_product, double ammount, int id_user) {
        this.id = id;
        this.id_product= id_product;
        this.ammount = ammount;
        this.id_user = id_user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws  Exception {
        if (id != getId()) {
            throw new Exception("Id can't be changed");
        }this.id =id;
    }

    public double getAmmount() {
        return ammount;
    }

    public void setAmmount(double ammount) throws Exception {
        if (ammount < 0 ) {
            throw new Exception("Ammount should be positive number ");
        }this.ammount = ammount;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) throws Exception {
        if (id_user < 0 ) {
            throw new Exception("Ammount should be positive number ");
        }this.id_user = id_user;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) throws Exception {
        if (id_product < 0 ) {
            throw new Exception("Ammount should be positive number ");
        }this.id_product = id_product;
    }
}