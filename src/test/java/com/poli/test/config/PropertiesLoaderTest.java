package com.poli.test.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.poli.sh.config.properties.PropertiesLoaderConstants;

public class PropertiesLoaderTest
{

    private com.poli.sh.config.properties.PropertiesLoader properties;
    private final String DATABASE_URL = "http://localhost:0000";

    @Test
    @Before
    public void loadProperties()
    {
        try
        {
            this.properties = com.poli.sh.config.properties.PropertiesLoader.getInstance();
            assertEquals(this.properties != null, true);
        }
        catch (RuntimeException e)
        {
            fail();
        }

    }

    @Test
    public void getPropertyByName()
    {
        String property = this.properties.getProperty(PropertiesLoaderConstants.DATABASE_ADDRESS);
        assertEquals(property != null, true);
        assertEquals(property, DATABASE_URL);
    }

}
