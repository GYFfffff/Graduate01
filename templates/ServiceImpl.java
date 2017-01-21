package ${basePkg}.service.impl;

import ${basePkg}.dao.I${className}DAO;
import ${basePkg}.domain.${className};
import ${basePkg}.page.PageResult;
import ${basePkg}.query.QueryObject;
import ${basePkg}.service.I${className}Service;

import java.util.List;

public class ${className}ServiceImpl implements I${className}Service {

    private I${className}DAO dao;

    public void setDao(I${className}DAO dao) {
        this.dao = dao;
    }

    public void save(${className} entity) {
        dao.save(entity);
    }

    public void update(${className} entity) {
        dao.update(entity);
    }

    public void delete(${className} entity) {
        dao.delete(entity);
    }

    public ${className} get(Long id) {
        return dao.get(id);
    }

    public List<${className}> getAll() {
        return dao.getAll();
    }

    public PageResult<${className}> getAllWithQuery(QueryObject qo) {
        return dao.getAllWithQuery(qo);
    }
}
