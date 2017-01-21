package ${basePkg}.action;

import ${basePkg}.anno.RequestPermission;
import ${basePkg}.domain.${className};
import ${basePkg}.query.${className}QueryObject;
import ${basePkg}.service.I${className}Service;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.ServletActionContext;

import java.io.IOException;

public class ${className}Action extends BaseAction {

    @Setter
    private I${className}Service service;

    @Getter
    private ${className}QueryObject qo=new ${className}QueryObject();
    @Getter
    private ${className} ${objName} =new ${className}();

    @RequestPermission("${classCnName}查询")
    public String execute() throws Exception {
        put("pageResult",service.getAllWithQuery(qo));
        return "list";
    }
    @RequestPermission("${classCnName}删除")
    public String delete() throws IOException {
        ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
        try {
            if (${objName}.getId() != null) {
                service.delete(${objName});
                ServletActionContext.getResponse().getWriter().write("删除成功");
            }
        }catch (Exception e){
            e.printStackTrace();
            ServletActionContext.getResponse().getWriter().write("删除失败");
        }
        return NONE;
    }

    @RequestPermission("${classCnName}编辑")
    public String input(){
        if(${objName}.getId()!=null){
            ${objName} =service.get(${objName}.getId());
        }
        if(hasActionErrors()){
            //若有错误信息，说明上次操作失败，取出错误的EMPLOYEE并从SESSION域中去掉
            ${objName}= (${className}) getSession().get("DEPARTMENT_INPUT_ERROR");
            getSession().remove("DEPARTMENT_INPUT_ERROR");
        }
        return "input";
    }
    @RequestPermission("${classCnName}添加/修改")
    public String saveOrUpdate(){
        try {
            if (${objName}.getId() != null) {
                service.update(${objName});
                super.addActionMessage("修改成功");
            } else {
                service.save(${objName});
                super.addActionMessage("添加成功");
                System.out.println();
            }
        }catch (Exception e){
            e.printStackTrace();
            super.addActionError("修改失败");
            //如果发生错误，将当前Employee共享到SESSUION域中用于回显
            getSession().put("DEPARTMENT_INPUT_ERROR",${objName});
        }
        return SUCCESS;
    }

}
