package it.bububear.thecassifier.main;

import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.assertNotNull;

class ApplicationTest {

    @Test
    public void test001ApplicationStartUP() {
        Application application = new Application();
        assertNotNull(application);
    }

}