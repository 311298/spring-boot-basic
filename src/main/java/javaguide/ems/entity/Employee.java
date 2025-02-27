package javaguide.ems.entity;


import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity // specify the class as jpa entity
@Table(name="employees") // table details
public class Employee {
    // @Table cannot be used without the @Entity
    /*
     if the table name is not provided then class name is considered
     as table name
     @Id -> designate that this member will uniquely identify the
     entity in the database
     @GeneratedValue -> used to specify the strategy used for
     generating primary key values for entities.
     The GenerationType. IDENTITY strategy is commonly used with
     databases that support auto-incrementing columns,
     such as MySQL and PostgreSQL
    */

    @Id // ?
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ?
    private Long id;

    @Column(name="first_name") // if don't specify then firstName will be mapped with table column
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email_id",
            nullable = false,
            unique = true)
//    @Nonnull -- > same as the not nullable = false
    private String email;
}
