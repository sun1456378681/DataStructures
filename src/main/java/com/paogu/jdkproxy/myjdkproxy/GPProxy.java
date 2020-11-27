package com.paogu.jdkproxy.myjdkproxy;

import com.paogu.jdkproxy.Person;

/**
 * xx类
 *
 * @author eric
 * @since 2020/11/19 9:51
 */
public class GPProxy {

    public static final String ln = "\r\n";

    private Person person;

    public static Object newProxyInstance(GPClassLoader classLoader, Class<?>[] interfaces, GpInvocationHandler h) {
//        String
        return null;
    }

    public static String gengrateSrc(Class<?>[] interfaces) {
        StringBuffer sb = new StringBuffer();
        sb.append("package com.paogu.jdkproxy.myjdkproxy;" + ln);
        sb.append("import com.paogu.jdkproxy.Person;" + ln);
        sb.append("import java.lang.reflect.*;" + ln);
        sb.append("public class $Proxy0 implements" + interfaces[0].getName() + "{" + ln);
//        sb.append()
        return null;
    }
}
