package org.pratyush.model.entity;

import lombok.*;
import org.hibernate.Hibernate;
import org.pratyush.constant.ColumnName;
import org.pratyush.constant.TableName;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = TableName.SYSTEM_CONFIG)
public class SystemConfigEntity {

    @Id
    @Column(name = ColumnName.NAME)
    private String name;

    @Column
    private String value;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SystemConfigEntity that = (SystemConfigEntity) o;
        return name != null && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
