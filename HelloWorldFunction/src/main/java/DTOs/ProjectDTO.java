package DTOs;

public class ProjectDTO {
    private String title;
    private String description;
    private String manager;

    public ProjectDTO() {
    }

    public ProjectDTO(String title, String description, String manager) {
        this.title = title;
        this.description = description;
        this.manager = manager;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }
}
