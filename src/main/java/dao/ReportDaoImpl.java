package dao;

import entity.Reports;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * DAO CRUD implementation of working with database by hibernate + additional operations
 */

@Repository
@Transactional(value = "transactionManager")
public class ReportDaoImpl implements EntityDaoInterface<Reports> {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    // Report creation
    @Override
    public Reports create(Reports entity) {
        hibernateTemplate.save(entity);
        return entity;
    }

    // Getting report by id
    @Override
    public Reports getById(int id) {
        return hibernateTemplate.get(Reports.class, id);
    }

    //Updating of report
    @Override
    public void update(Reports entity) {
        hibernateTemplate.update(entity);
    }

    //Report deletion
    @Override
    public void delete(Reports entity) {
        hibernateTemplate.delete(entity);
    }

    //Return all reports from database
    @Override
    public List<Reports> getAllEntity() {
        return hibernateTemplate.findByExample(new Reports());
    }

    //Finding all reports by start date, end date and performer if some of them have a value or not using hql request
    public List<Reports> getAllEntityByPeriodAndPerformer(String start, String end, String performer) {
        String hql = "from Reports r where";
        int n = 0;
        if (!start.equals(""))
            n++;
        if (!end.equals("")) {
            n++;
        }
        if (!performer.equals("")) {
            n++;
        }
        String params[] = new String[n];
        Object values[] = new Object[n];
        int i = 0;
        if (!start.equals("")) {
            params[i] = new String("start");
            values[i] = java.sql.Date.valueOf(start);
            i++;
            hql += " r.startDate >= :start ";
        }
        if (!end.equals("")) {
            if (!start.equals("")) hql += "and";
            params[i] = new String("end");
            values[i] = java.sql.Date.valueOf(end);
            i++;
            hql += " r.endDate <= :end ";
        }
        if (!performer.equals("")) {
            if (!start.equals("") || !end.equals(""))
                hql += "and";
            params[i] = new String("performer");
            values[i] = performer;
            hql += " r.performer = :performer ";
        }
        return (List<Reports>) hibernateTemplate.findByNamedParam(hql, params, values);
    }

    //Finding unique values of performers
    public List<String> getAllPerformers() {
        return (List<String>) hibernateTemplate.find("select distinct performer from Reports");
    }


}
