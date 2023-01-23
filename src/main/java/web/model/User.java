package web.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "name")
    @Pattern(regexp = "[A-Za-z]{2,15}", message = "Name should be between 2 and 20 letters")
    private String name;

    @Column(name = "surname")
    @Pattern(regexp = "[A-Za-z]{2,20}", message = "Surname should be between 2 and 20 letters")
    private String surname;

    @Column(name = "age")
    @Min(value = 0, message = "Age should be above 0")
    @Max(value = 127, message = "Age should be under 128")
    private byte age;

    @Column(name = "email")
    @Pattern(regexp = "([A-z0-9_.-]+)@([A-z0-9_.-]+).([A-z]{2,8})", message = "Enter correct email")
    private String email;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && userId.equals(user.userId) && name.equals(user.name) && surname.equals(user.surname) && email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, surname, age, email);
    }
}