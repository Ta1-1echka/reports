package entity;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "reports", schema = "reports")

public class Reports {
    private int id;
    private Date startDate;
    private Date endDate;
    private String performer;
    private String activity;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "StartDate")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "EndDate")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "Performer")
    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    @Basic
    @Column(name = "Activity")
    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reports reports = (Reports) o;

        if (id != reports.id) return false;
        if (startDate != null ? !startDate.equals(reports.startDate) : reports.startDate != null) return false;
        if (endDate != null ? !endDate.equals(reports.endDate) : reports.endDate != null) return false;
        if (performer != null ? !performer.equals(reports.performer) : reports.performer != null) return false;
        if (activity != null ? !activity.equals(reports.activity) : reports.activity != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (performer != null ? performer.hashCode() : 0);
        result = 31 * result + (activity != null ? activity.hashCode() : 0);
        return result;
    }
}
