package glavny.inf.elte.hu.data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="audit")
public class AuditLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;
    
    @Basic
    @Column(name = "USER")
    private String user;

    @Basic
    @Column(name = "DATETIME")
    private long datetime;
    
    @Basic
    @Column(name = "TYPE")
    private ChangeType type;
    
    @Basic
    @Column(name = "CHANGE")
    private String change;
    
    public AuditLog(String user, long datetime, ChangeType type, String change) {
        setUser(user);
        setDatetime(datetime);
        setType(type);
        setChange(change);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    public long getDatetime() {
        return datetime;
    }
    
    public void setDatetime(long datetime) {
        this.datetime = datetime;
    }
    
    public ChangeType getType() {
        return type;
    }
    
    public void setType(ChangeType type) {
        this.type = type;
    }
    
    public String getChange() {
        return change;
    }
    
    public void setChange(String change) {
        this.change = change;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        long result = 1;
        result = prime * result + ((change == null) ? 0 : change.hashCode());
        result = prime * result + datetime;
        result = prime * result + id;
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((user == null) ? 0 : user.hashCode());
        return (int) result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AuditLog other = (AuditLog) obj;
        if (change == null) {
            if (other.change != null)
                return false;
        } else if (!change.equals(other.change))
            return false;
        if (datetime != other.datetime)
            return false;
        if (id != other.id)
            return false;
        if (type != other.type)
            return false;
        if (user == null) {
            if (other.user != null)
                return false;
        } else if (!user.equals(other.user))
            return false;
        return true;
    }
}