package laba4.model;

@En
public class Repair {
    private Long id;
    private String problemSubject;
    private String description;

    public Repair(Long id, String problemSubject, String description) {
        this.id = id;
        this.problemSubject = problemSubject;
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProblemSubject(String problemSubject) {
        this.problemSubject = problemSubject;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getProblemSubject() {
        return problemSubject;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Repair{" +
                "id=" + id +
                ", problemSubject='" + problemSubject + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
