package gq.vapu.czfclient.UI;

public class Config {
    public String name;
    public String description;
    public boolean isLocation = false;

    public Config(String name, String description, Boolean isLocation) {
        this.name = name;
        this.description = description;
        this.isLocation = isLocation;

    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
