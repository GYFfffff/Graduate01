package ${basePkg}.service;

import ${basePkg}.domain.${className};
import ${basePkg}.page.PageResult;
import ${basePkg}.query.QueryObject;

import java.util.List;

public interface I${className}Service {
    void save(${className} entity);
    void update(${className} entity);
    void delete(${className} entity);

    ${className} get(Long id);
    List<${className}> getAll();
    PageResult<${className}> getAllWithQuery(QueryObject qo);
}
