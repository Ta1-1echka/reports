package service;

import dao.EntityDaoInterface;
import dao.ReportDaoImpl;
import entity.Reports;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implements crud method and some business logic
 */
@Service
public class ReportServiceImpl implements EntityDaoInterface<Reports> {

    @Autowired
    private ReportDaoImpl reportDao;

    @Override
    public Reports create(Reports entity) {
        return reportDao.create(entity);
    }

    @Override
    public Reports getById(int id) {
        return reportDao.getById(id);
    }

    @Override
    public void update(Reports entity) {
        reportDao.update(entity);
    }

    @Override
    public void delete(Reports entity) {
        reportDao.delete(entity);
    }

    @Override
    public List<Reports> getAllEntity() {
        return reportDao.getAllEntity();
    }

    public List<Reports> getAllEntityByPeriodAndPerformer(String start, String end, String performer)
    {
        return reportDao.getAllEntityByPeriodAndPerformer(start, end, performer);
    }

    public List<String> getAllPerformers()
    {
        return reportDao.getAllPerformers();
    }
}
