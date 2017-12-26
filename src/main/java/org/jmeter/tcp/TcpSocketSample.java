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

    public Arguments getDefaultParameters() {
                Arguments params = new Arguments();
                 params.addArgument("ip","127.0.0.1");
                 params.addArgument("port", "8080");
                 return params;
             }

    public void setupTest(JavaSamplerContext arg0){   //初始化
//        context = new ClassPathXmlApplicationContext("spring-consumer.xml");
//        service = (BankCardService) context.getBean("testTService");
//        req=new UnBindCardRequestBean();


    }
    public SampleResult runTest(JavaSamplerContext arg0) {
        results = new SampleResult();
        try {
            results.setSampleLabel("begin");
            results.sampleStart();
        }catch(Exception e){
            e.printStackTrace();
            results.setSuccessful(false);
            System.out.println("fail!"+e.toString()+"\n");
        }finally{
            results.sampleEnd();
        }
        return results;
    }

    public void teardownTest(JavaSamplerContext arg0){

    }


    public static void main(String[] args) {
        Arguments pram = new Arguments();
        pram.addArgument("id","10000000008");
        pram.addArgument("card", "342");
        pram.addArgument("channel", "344");
        JavaSamplerContext arg0 = new JavaSamplerContext(pram);
//        unBindCard test = new unBindCard();
//        test.setupTest(arg0);
//        SampleResult result = test.runTest(arg0);
//        result.setRequestHeaders(req.toString());
//        result.setResponseData("response:"+res,null);
//        result.setDataType(SampleResult.TEXT);
//        result.setRequestHeaders(req.toString());
//        System.out.println("request :   "+result.getRequestHeaders());
//        System.out.println("response:   "+result.getResponseDataAsString());
//        test.teardownTest(arg0);
    }

}
