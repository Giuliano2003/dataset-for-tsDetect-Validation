
package mySimple;

import java.util.Objects;

public class User extends Person {
    private int id;
    private boolean validator;
    private String NIP;
    private int id_shoppingCart;

    public User(int id, int age, String name, String email, String password, String PESEL, String NIP, int id_shoppingCart) {
        super(id, age, name, email, password, PESEL);
        this.NIP = NIP;
        this.id_shoppingCart = id_shoppingCart;
    }

    public int getId() {
        return super.getId();
    }

    public void setId(int id)  throws  Exception {
            super.setId(id);
    }

    public int getAge() {
        return super.getAge();
    }

    public void setAge(int age) throws Exception {
            super.setAge(age);
    }

    public String getName() {
        return super.getName();
    }

    public void setName(String name) throws Exception {
        super.setName(name);
    }

    public String getEmail() {
        return super.getEmail();
    }

    public void setEmail(String email) throws Exception {
                super.setEmail(email);
    }

    public String getPassword() {
        return super.getPassword();
    }

    public void setPassword(String password) {
        super.setPassword(password);
    }

    public String getPESEL() {
        return super.getPESEL();
    }

    public void setPESEL(String PESEL) throws Exception {
        super.setPESEL(PESEL);
    }

    public String getNIP() {
        return NIP;
    }

    public void setNIP(String NIP) throws  Exception{
            if (NIPValidator(NIP) == true) {
                this.NIP = NIP;
            } else {
                throw new RuntimeException("NIP should be 10 characters");
            }
    }

    public boolean NIPValidator(String NIP){
        if(NIP.length() != 10){
            validator = false;
            return validator;
        } validator = true;
        return validator;
    }

    public int getId_shoppingCart() {
        return id_shoppingCart;
    }

    public void setId_shoppingCart(int id_shoppingCart) throws  Exception{
            if (id_shoppingCart != getId_shoppingCart()) {
                throw new Exception("Id of shopping cart can't be changed");
            }
            this.id_shoppingCart = id_shoppingCart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && validator == user.validator && id_shoppingCart == user.id_shoppingCart && Objects.equals(NIP, user.NIP);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, validator, NIP, id_shoppingCart);
    }


}
