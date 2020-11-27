package aop;

import com.aituigu.aop.Calculator;
import com.aituigu.aop.MainConfigOfAop;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * xx类
 *
 * @author eric
 * @since 2020/11/7 10:31
 */
public class AopTest {

    @Test
    public void test2() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAop.class);
        Calculator calculator = applicationContext.getBean(Calculator.class);
        calculator.div(1,0);
        applicationContext.close();
    }

}
