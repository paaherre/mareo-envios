package sube.interviews.mareoenvios.DTO;

public class TopSentDTO {
    private int count;
    private String description;

    public TopSentDTO(int count, String description) {
        this.count = count;
        this.description = description;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
