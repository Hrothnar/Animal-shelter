package re.st.animalshelter.entity.animal;

import re.st.animalshelter.enumeration.breed.CatBreed;
import re.st.animalshelter.utility.Distributor;

import javax.persistence.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity(name = "cats")
public class Cat extends Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private CatBreed breed;

    public Cat(int age, CatBreed breed) {
        this.age = age;
        this.breed = breed;
    }


    public Cat() {

    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public CatBreed getBreed() {
        return breed;
    }

    public void setBreed(CatBreed breed) {
        this.breed = breed;
    }

    @Override
    public String getGeneralInfo() {
        String years = Distributor.conjugate(this.age);
        return breed.getText() + ", возраст: " + age + years;
    }
}
