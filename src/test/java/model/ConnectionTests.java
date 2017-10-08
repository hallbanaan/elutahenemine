package model;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class ConnectionTests {

    @Test
    public void testIfInternetConnectionExists() {
        boolean result = Connection.internetConnectionExisting();
        assertTrue(result);
    }
}
