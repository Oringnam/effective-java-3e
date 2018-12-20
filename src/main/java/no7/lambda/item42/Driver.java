package no7.lambda.item42;

import org.junit.Test;

/**
 * @author Jin Won Park, oringnam
 * @since 2018-12-20
 */
public class Driver {
    @Test
    public void abstractAnonymousDriver() {
        System.out.println(new TestAbstract<String>() {
            @Override
            public String testAbstractMethod() {
                return "testAbstract";
            }
        });
    }

    @Test
    public void abstractLambdaDriver() {
        //TestAbstract<String> testAbstract = () -> "testAbstract";
    }

    @Test
    public void interfaceLambdaDriver() {
        TestInterface<String> testInterface = () -> "testInterface";

        System.out.println(testInterface.testInterfaceMethod());
    }
}
