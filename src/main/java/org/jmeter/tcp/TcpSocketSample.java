package org.jmeter.tcp;

/**
 * Hello world!
 *
 */

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

public class TcpSocketSample extends AbstractJavaSamplerClient{
    private SampleResult results;
    public void setupTest(JavaSamplerContext jsc){

    }
    public Arguments getDefaultParameters() {
                Arguments params = new Arguments();
                 params.addArgument("ip","127.0.0.1");
                 params.addArgument("port", "8080");
                 return params;
             }

    public SampleResult runTest(JavaSamplerContext arg0) {
        return results;
    }
}
