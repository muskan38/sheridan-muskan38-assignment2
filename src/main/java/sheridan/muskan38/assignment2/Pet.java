package sheridan.muskan38.assignment2;

import jakarta.persistence.*;

@Entity
@Table(name = "pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private PetKind kind = PetKind.DOG;

    @Enumerated(EnumType.STRING)
    private PetSex sex = PetSex.FEMALE;

    private boolean vaccinated;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PetKind getKind() {
        return kind;
    }

    public void setKind(PetKind kind) {
        this.kind = kind;
    }

    public PetSex getSex() {
        return sex;
    }

    public void setSex(PetSex sex) {
        this.sex = sex;
    }

    public boolean isVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
