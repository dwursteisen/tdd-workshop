package mockito;

public class Data {

    private final String summary;
    private final String id;

    public Data(String summary, String id) {
        this.summary = summary;
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public String getId() {
        return id;
    }
}
