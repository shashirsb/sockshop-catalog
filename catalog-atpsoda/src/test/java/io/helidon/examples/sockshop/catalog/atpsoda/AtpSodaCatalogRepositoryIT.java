/*
 * Copyright (c) 2020 Oracle and/or its affiliates.
 *
 * Licensed under the Universal Permissive License v 1.0 as shown at
 * http://oss.oracle.com/licenses/upl.
 */

package io.helidon.examples.sockshop.catalog.atpsoda;

import io.helidon.examples.sockshop.catalog.CatalogRepository;
import io.helidon.examples.sockshop.catalog.CatalogRepositoryTest;

import static io.helidon.examples.sockshop.catalog.atpsoda.AtpSodaProducers.*;

/**
 * Integration tests for {@link io.helidon.examples.sockshop.catalog.mongo.MongoCatalogRepository}.
 */
public class AtpSodaCatalogRepositoryIT extends CatalogRepositoryTest {
    @Override
    protected CatalogRepository getCatalogRepository() {
        String host = System.getProperty("db.host","localhost");
        int    port = Integer.parseInt(System.getProperty("db.port","27017"));

        return new AtpSodaCatalogRepository(socks(db(client(host, port)))).loadData();
    }
}
