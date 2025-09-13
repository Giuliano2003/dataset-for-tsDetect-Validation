package mySimple;

import java.util.Objects;

public class Product {
    private int id;
    private String title;
    private String description;
    private int id_user;

    public Product(int id, String title, String description, int id_user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.id_user = id_user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws  Exception {
        if (id != getId()) {
            throw new Exception("Id can't be changed");
        }this.id = id; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title)  { this.title = title; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) throws Exception {
        if(id_user <0){
            throw new Exception("Id_user can't be 0"); }
        this.id_user = id_user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && id_user == product.id_user && Objects.equals(title, product.title) && Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, id_user);
    }
}