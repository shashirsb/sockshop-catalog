/*
 * Copyright (c) 2020 Oracle and/or its affiliates.
 *
 * Licensed under the Universal Permissive License v 1.0 as shown at
 * http://oss.oracle.com/licenses/upl.
 */

package io.helidon.examples.sockshop.catalog.atpsoda;

import javax.json.bind.annotation.JsonbTransient;

import io.helidon.examples.sockshop.catalog.Sock;

import org.bson.types.ObjectId;

/**
 * MongoDB treats {@link Sock#getId()} as object ID, which causes errors.
 * <p/>
 * We need to define an {@code ObjectId _id} field explicitly to avoid
 * that.
 */
public class AtpSodaSock extends Sock {

    /**
     * Construct {@code AtpSodaSock} instance.
     */
    public AtpSodaSock() {
    }
}
