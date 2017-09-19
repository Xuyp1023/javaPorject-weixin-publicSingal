package com.publicSignal.ipdf;

/*import icepdf.cr; */ 
import java.lang.reflect.Field;
import org.icepdf.core.application.ProductInfo;  
import org.icepdf.core.pobjects.Document;
import org.icepdf.core.pobjects.graphics.Padding;

public class MyDocument extends Document {
   static {  
       /* Class<?> clazzA = cr.class;  
        Field name;  
        Field tip;  */
  
        Class<?> clazzB = ProductInfo.class;  
        /*Field ver_c;  
        Field ver_d;  
        Field ver_e;  
        Field ver_f;  
        Field tertiary;  
        Field releaseType;  
        Field buildNo;  
        Field revision;  */
        
        Class<?> clazzC = Padding.class;  
        /*Field padding1;  
        Field padding3; */ 
        
        try {  
            
            /*padding1 = clazzC.getDeclaredField("padding1");  
            padding3 = clazzC.getDeclaredField("padding3");  
            padding3.setAccessible(true);
            padding1.setAccessible(true);
            padding1.set(padding1, new byte[]{});
            padding3.set(padding3, new byte[]{});*/
            Field[] fields = clazzC.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                field.set(field, new byte[]{});
            }
            
            Field[] clazzBFields = clazzB.getDeclaredFields();
            for (Field clazzBField : clazzBFields) {
                clazzBField.setAccessible(true);
                clazzBField.set(clazzBField, "");
            }
            /*name = clazzA.getDeclaredField("a");  
            name.setAccessible(true);  
  
            byte[] x = {};  
            name.set(name, x);  
  
            tip = clazzA.getDeclaredField("b");  
            tip.setAccessible(true);  
            tip.set(tip, x); */ 
            
           /* Method getVersion = clazzB.getDeclaredMethod("getVersion", String.class);
            getVersion.setAccessible(true);*/
            /*
            ver_c = clazzB.getDeclaredField("COMPANY");  
            ver_d = clazzB.getDeclaredField("PRODUCT");  
            ver_e = clazzB.getDeclaredField("PRIMARY");  
            ver_f = clazzB.getDeclaredField("SECONDARY");  
            tertiary = clazzB.getDeclaredField("TERTIARY");  
            releaseType = clazzB.getDeclaredField("RELEASE_TYPE");  
            buildNo = clazzB.getDeclaredField("BUILD_NO");  
            revision = clazzB.getDeclaredField("REVISION");  
            
         
           
            
  
            ver_c.setAccessible(true);  
            ver_d.setAccessible(true);  
            ver_e.setAccessible(true);  
            ver_f.setAccessible(true);  
            tertiary.setAccessible(true);  
            releaseType.setAccessible(true);  
            buildNo.setAccessible(true);  
            revision.setAccessible(true);  
            
            ver_c.set(ver_c, "");  
            ver_d.set(ver_d, "");  
            ver_e.set(ver_e, "");  
            ver_f.set(ver_f, "");  
            tertiary.set(tertiary, "");  
            releaseType.set(releaseType, "");  
            buildNo.set(buildNo, "");  
            revision.set(revision, "");  
            */
            
            
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}
