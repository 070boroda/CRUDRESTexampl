package com.foxminded.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "groups")
public class Group implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "group_name")
    private String groupName;

    @JsonIgnore
    @OneToMany(mappedBy = "group", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Set<Student> students = new HashSet<Student>();

    @JsonIgnore
    @OneToMany(mappedBy = "group", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Set<Field> fields = new HashSet<Field>();

    public Group(Integer id) {
        super();
        this.id = id;
    }

    @Override
    public String toString() {
        return "Group [id=" + id + ", groupName=" + groupName + "]";
    }

}
