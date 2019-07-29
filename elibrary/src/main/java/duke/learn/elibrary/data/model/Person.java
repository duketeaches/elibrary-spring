/**
 * 
 */
package duke.learn.elibrary.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Kazi
 *
 */
@Entity
@Table(name = "person")
public class Person implements Serializable {

    private static final long serialVersionUID = -7532024846471183103L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private String personId;

    @Column
    private String name;

    @Column
    private Integer age;

    @Column(name = "contact_number")
    private String contactNumber;

    public Person() {
    }

    /**
     * @param personId
     * @param name
     * @param age
     * @param contactNumber
     */
    public Person(String personId, String name, Integer age, String contactNumber) {
	super();
	this.personId = personId;
	this.name = name;
	this.age = age;
	this.contactNumber = contactNumber;
    }

    public String getPersonId() {
	return personId;
    }

    public void setPersonId(String personId) {
	this.personId = personId;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Integer getAge() {
	return age;
    }

    public void setAge(Integer age) {
	this.age = age;
    }

    public String getContactNumber() {
	return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
	this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
	return "Person [personId=" + personId + ", name=" + name + ", age=" + age + ", contactNumber=" + contactNumber
		+ "]";
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((personId == null) ? 0 : personId.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Person other = (Person) obj;
	if (personId == null) {
	    if (other.personId != null)
		return false;
	} else if (!personId.equals(other.personId))
	    return false;
	return true;
    }

}
