package entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uIdentificator;
    private String name;
    private String description;
    private String dateAccomplishment;
    private String Accomplishment;
    private String category;
    private String dateCreation;

    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    private User user;

    @ManyToMany
    private Set<Category> categories;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getuIdentificator() {
        return uIdentificator;
    }

    public void setuIdentificator(String uIdentificator) {
        this.uIdentificator = uIdentificator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateAccomplishment() {
        return dateAccomplishment;
    }

    public void setDateAccomplishment(String dateAccomplishment) {
        this.dateAccomplishment = dateAccomplishment;
    }

    public String getAccomplishment() {
        return Accomplishment;
    }

    public void setAccomplishment(String accomplishment) {
        Accomplishment = accomplishment;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
