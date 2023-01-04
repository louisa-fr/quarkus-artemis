package io.quarkus.it.artemis.jms.withdefault;

import org.junit.jupiter.api.Test;

import io.quarkus.it.artemis.jms.common.ArtemisJmsHelper;

abstract public class BaseArtemisProducerTest extends ArtemisJmsHelper {
    @Test
    void testDefault() throws Exception {
        receiveAndVerify("/artemis", createDefaultContext(), "test-jms-default");
    }

    @Test
    void testNamedOne() throws Exception {
        receiveAndVerify("/artemis/named-1", createNamedOneContext(), "test-jms-named-1");
    }

    @Test
    void testXADefault() throws Exception {
        receiveAndVerify("/artemis/xa", createDefaultContext(), "test-jms-default");
    }

    @Test
    void testXANamedOne() throws Exception {
        receiveAndVerify("/artemis/named-1/xa", createNamedOneContext(), "test-jms-named-1");
    }

    @Test
    void testRollbackDefault() {
        testRollback("/artemis/xa", createDefaultContext(), "test-jms-default");
    }

    @Test
    void testRollbackNamedOne() {
        testRollback("/artemis/named-1/xa", createNamedOneContext(), "test-jms-named-1");
    }
}
