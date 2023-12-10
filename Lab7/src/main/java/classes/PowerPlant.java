package classes;

//Builder: используется для создания объекта
// с большим количеством параметров и обеспечивает удобное и понятное использование.
//не совсем похож на то, что должно быьт
public class PowerPlant {
    private String id;
    private String name;
    private String capacity;

    public PowerPlant(String id, String name, String capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
    }

    public String getDetails() {
        return "Идентификатор электростанции: " + id + "\n" +
                "Название электростанции: " + name + "\n" +
                "Мощность электростанции: " + capacity + "\n";
    }


    public void setPower(String i) {
        this.capacity = i;
    }

    public String getPower() {
        return this.capacity;
    }


}
