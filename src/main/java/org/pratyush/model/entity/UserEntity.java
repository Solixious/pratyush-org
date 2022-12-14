package org.pratyush.model.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.pratyush.constant.ColumnName;
import org.pratyush.constant.TableName;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = TableName.USER)
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ColumnName.ID)
    private Long id;

    @Column(name = ColumnName.USER_NAME, unique = true, nullable = false)
    private String userName;

    @Column(name = ColumnName.EMAIL, unique = true, nullable = false)
    private String email;

    @Column(name = ColumnName.PASSWORD, nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = TableName.USER_ROLE, joinColumns = @JoinColumn(name = ColumnName.USER_ID),
            inverseJoinColumns = @JoinColumn(name = ColumnName.ROLE_ID))
    private Set<RoleEntity> roles;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserEntity that = (UserEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
