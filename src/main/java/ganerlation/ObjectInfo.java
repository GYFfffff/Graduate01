package ganerlation;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by GYF on 2017/1/19.
 */

/**
 * 封装代码生成器所需的数据
 */
@Getter@Setter@ToString
public class ObjectInfo {
    private String basePkg;     //包名
    private String className;   //类名
    private String objName;     //对象名，既类名第一个字母小写
    private String classCnName;     //类的中文名
    //key:方法名，value:方法的中文名
    private Map<String,String> map=new HashMap<String, String>();

    public ObjectInfo(Class clzz) throws Exception {
        this.basePkg=clzz.getPackage().getName();
        this.basePkg=basePkg.substring(0,basePkg.lastIndexOf("."));

        this.className=clzz.getSimpleName();

        this.objName=className.substring(0,1).toLowerCase()+className.substring(1);

        CnName classAnno = (CnName) clzz.getAnnotation(CnName.class);

        //若该类没有贴中文注解，则将对象名给它
        this.classCnName=classAnno==null?objName:classAnno.value();

        Field[] declaredFields = clzz.getDeclaredFields();
        for (Field field : declaredFields) {
            String fieldName = field.getName();
            CnName fieldAnno = field.getAnnotation(CnName.class);
            String fieldCnName=fieldAnno==null?fieldName:fieldAnno.value();

            map.put(fieldName,fieldCnName);
        }

    }
}
