package cogent.tutorial.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department implements Serializable, Comparable<Department> {

	private static final long serialVersionUID = 2973056534524677114L;

	@Id
	@Column(name = "DEPT_ID")
	private int id;
	
	@Column(name = "DEPT_NAME")
	private String name;
	
	@Column(name = "DEPT_OFFICE")
	private String office;
	
	@Column(name = "DEPT_MEETING_TIME")
	private String meetingTime;
	
	@OneToMany(mappedBy = "dept", cascade = CascadeType.ALL)
	private List<Employee> employees;
	
	public Department() {}

	public Department(int id, String name, String office, String meetingTime) {
		super();
		this.id = id;
		this.name = name;
		this.office = office;
		this.meetingTime = meetingTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getMeetingTime() {
		return meetingTime;
	}

	public void setMeetingTime(String meetingTime) {
		this.meetingTime = meetingTime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Department))
			return false;
		Department other = (Department) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", office=" + office + ", meetingTime=" + meetingTime + "]";
	}

	@Override
	public int compareTo(Department o) {
		return name.compareTo(o.name);
	}
	
	
}
