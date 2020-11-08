package com.ce.web;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
@RunWith(Cucumber.class)
@CucumberOptions( glue="com.ce.web", features = "src/test/resources", plugin = { "pretty",
        "html:target/site/cucumber-pretty",
        "json:target/cucumber.json" })
public class AppTest 
    extends TestCase
{
//    /**
//     * Create the test case
//     *
//     * @param testName name of the test case
//     */
//    public AppTest( String testName )
//    {
//        super( testName );
//    }
//
//    /**
//     * @return the suite of tests being tested
//     */
//    public static Test suite()
//    {
//        return new TestSuite( AppTest.class );
//    }
//
//    /**
//     * Rigourous Test :-)
//     */
//    public void testApp()
//    {
//        assertTrue( true );
//    }
}
