package nwu.hzk.p113;

/**
 * Created by hzk on 2018/10/30.
 */

public class Fruit {
    private String name;
    private int imageId;

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

    public Fruit(String name,int imageId){
        this.name = name;
        this.imageId = imageId;
    }
}
