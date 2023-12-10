public class Pig {
    private String name, type, imageURL;

    public Pig(String name, String type,String imageURL) {
        this.name = name;
        this.type = type;
        this.imageURL=imageURL;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
    public String getImageURL(){
        return imageURL;
    }
}