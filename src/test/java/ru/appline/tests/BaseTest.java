package ru.appline.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.runners.Parameterized;
import ru.appline.framework.utils.DriverManager;
import ru.appline.framework.utils.TestProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    private static String baseUrl;
    private static Properties properties = TestProperties.getInstance().getProperties();

    @BeforeAll
    public static void setUp() {
        baseUrl = properties.getProperty("app.url");
        DriverManager.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        DriverManager.getDriver().manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        DriverManager.getDriver().manage().window().maximize();
    }

    @BeforeEach
    public void refreshForParam() {
        DriverManager.getDriver().get(baseUrl);
    }

    @AfterAll
    public static void tearDown() {
        DriverManager.quitDriver();
    }
}
