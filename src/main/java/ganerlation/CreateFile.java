package ganerlation;


import com.gyf.graduate.util.XmlUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.text.MessageFormat;

/**
 * Created by GYF on 2017/1/19.
 */
public class CreateFile {
    private static Configuration cfg=new Configuration();

    //指定模板数据源
    static{
        try {
            cfg.setDirectoryForTemplateLoading(new File("templates"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 传入domain的Class对象自动生成对应文件
     * @param args
     */
    public static void main(String[] args) throws Exception {
        //createAllFile(SystemMenu.class);
    }

    public static void createAllFile(Class clzz) throws Exception {
        //生成实体类的数据
        ObjectInfo info=new ObjectInfo(clzz);
        createIDAO(info);
        createDAOImpl(info);
        createQueryObject(info);
        createIService(info);
        createServiceImpl(info);
        createAction(info);
        createListJsp(info);
        createListJs(info);
        createInputJsp(info);
        createInputJs(info);
        createHbmXml(info);
        addToDaoXml(info);
        addToServiceXml(info);
        addToActionXml(info);
    }

    private static void addToActionXml(ObjectInfo info) throws Exception {
        addToXml(info,"action.xml","src/main/resources/applicationContext-actions.xml");
    }

    private static void addToServiceXml(ObjectInfo info) throws Exception {
        addToXml(info,"service.xml","src/main/resources/applicationContext-services.xml");
    }

    private static void addToDaoXml(ObjectInfo info) throws Exception {
        addToXml(info,"dao.xml","src/main/resources/applicationContext-daos.xml");
    }
    
    private static void createHbmXml(ObjectInfo info) throws Exception {
        create(info,"hbm.xml","src/main/resources/domain/{2}.hbm.xml");
    }
    private static void createInputJs(ObjectInfo info) throws Exception {
        create(info,"input.js","src/main/webapp/js/view/{2}/input.js");
    }

    private static void createListJs(ObjectInfo info) throws Exception {
        create(info,"list.js","src/main/webapp/js/view/{2}/list.js");
    }

    private static void createInputJsp(ObjectInfo info) throws Exception {
        create(info,"input.jsp","src/main/webapp/WEB-INF/views/{2}/input.jsp");
    }

    private static void createListJsp(ObjectInfo info) throws Exception {
        create(info,"list.jsp","src/main/webapp/WEB-INF/views/{2}/list.jsp");
    }

    private static void createAction(ObjectInfo info) throws Exception {
        create(info,"Action.java","src/main/java/{0}/action/{1}Action.java");
    }

    private static void createServiceImpl(ObjectInfo info) throws Exception {
        create(info,"ServiceImpl.java","src/main/java/{0}/service/impl/{1}ServiceImpl.java");
    }

    private static void createIService(ObjectInfo info) throws Exception {
        create(info,"IService.java","src/main/java/{0}/service/I{1}Service.java");
    }

    private static void createQueryObject(ObjectInfo info) throws Exception {
        create(info,"QueryObject.java","src/main/java/{0}/query/{1}QueryObject.java");
    }

    private static void createDAOImpl(ObjectInfo info) throws Exception {
        create(info,"DAOImpl.java","src/main/java/{0}/dao/impl/{1}DAOImpl.java");
    }
    /**
     * 生成IDAO文件
     * @param info
     * @throws Exception
     */
    private static void createIDAO(ObjectInfo info) throws Exception {
        create(info,"IDAO.java","src/main/java/{0}/dao/I{1}DAO.java");
    }

    /**
     * 将生成的模板插入到对应的XML文件中
     * @param info
     * @param templateName
     * @param targerFileName
     * @throws Exception
     */
    private static void addToXml(ObjectInfo info,String templateName,String targerFileName) throws Exception {
        //获取模板
        Template template = cfg.getTemplate(templateName);

        //获取合并后的字符串
        StringWriter stringWriter=new StringWriter();
        template.process(info,stringWriter);
        //将合并后的字符串加入到对应文件中
        XmlUtil.mergeXML(new File(targerFileName),stringWriter.toString());
    }

    /**
     * 生成对应文件
     * @param info  对应实体类的数据对象
     * @param templateName  模板名称
     * @param OutFilePath   输出文件的路径
     * @throws Exception
     */
    private static void create(ObjectInfo info,String templateName,String OutFilePath) throws Exception {
        //获取模板
        Template template = cfg.getTemplate(templateName);
        File file=new File(MessageFormat.format(OutFilePath,info.getBasePkg().replace(".","/"),info.getClassName(),info.getObjName()));
        //若文件父文件夹不存在，则创建
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }

        //合成并输出文件
        template.process(info,new FileWriter(file));
    }

}
