package org.jmeter.http;

/**
 * Hello world!
 *
 */

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.http.sampler.HTTPSampler;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
//import org.apache.log4j.Logger;

public class tcpSample extends AbstractJavaSamplerClient{
    private SampleResult results;

    public Arguments getDefaultParameters() {
                Arguments params = new Arguments();
                 params.addArgument("url","127.0.0.1");
                 params.addArgument("method", "get");
                 params.addArgument("port", "");
                 return params;
             }

    public void setupTest(JavaSamplerContext args){   //初始化
//        context = new ClassPathXmlApplicationContext("spring-consumer.xml");
//        service = (BankCardService) context.getBean("testTService");
//        req=new UnBindCardRequestBean();


    }
    public SampleResult runTest(JavaSamplerContext args) {
        SampleResult result = new SampleResult();
        HTTPSampler http_instance =  new HTTPSampler();
        http_instance.setDomain(args.getParameter("url"));
        http_instance.setPath("/");
        http_instance.setFollowRedirects(true);
        http_instance.setMethod(args.getParameter("method"));
        result.sampleStart();
        SampleResult sample_result =http_instance.sample();
        if  ("200".equals(sample_result.getResponseCode())) {
            result.setSuccessful(true);
            result.setResponseCode("200");
        }
        else{
            result.setSuccessful(false);
        }
        result.setRequestHeaders(sample_result.getRequestHeaders());
        result.sampleEnd();
        result.setResponseData(sample_result.getResponseDataAsString(), "utf-8");
        return result;
    }

    public void teardownTest(JavaSamplerContext arg0){

    }


    public static void main(String[] args) {

        Arguments pram = new Arguments();
        pram.addArgument("id","10000000008");
        pram.addArgument("card", "342");
        pram.addArgument("channel", "344");
        JavaSamplerContext arg0 = new JavaSamplerContext(pram);
        HTTPSampler http_instance =  new HTTPSampler();
        http_instance.setDomain("sina.com.cn");
        http_instance.setPath("/");
        http_instance.setFollowRedirects(true);
        http_instance.setMethod("GET");

        SampleResult result = new SampleResult();
        result.sampleStart();
        SampleResult sample_result =http_instance.sample();
        if  ("200".equals(sample_result.getResponseCode())) {
            result.setSuccessful(true);
            result.setResponseCode("200");
        }
        else{
            result.setSuccessful(false);

        }

        result.setRequestHeaders(sample_result.getRequestHeaders());

        result.setResponseData(sample_result.getResponseDataAsString(), "utf-8");
        System.out.println(result.getResponseDataAsString());
    }

}
