/*
 * Copyright (c) 2020 Oracle and/or its affiliates.
 *
 * Licensed under the Universal Permissive License v 1.0 as shown at
 * http://oss.oracle.com/licenses/upl.
 */

package io.helidon.examples.sockshop.catalog.atpsoda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;
import javax.inject.Inject;

import io.helidon.examples.sockshop.catalog.CatalogRepository;
import io.helidon.examples.sockshop.catalog.DefaultCatalogRepository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Indexes;
import com.mongodb.client.model.Sorts;
import org.bson.BsonDocument;
import org.bson.conversions.Bson;
import org.eclipse.microprofile.opentracing.Traced;

import io.helidon.examples.sockshop.catalog.atpsoda.AtpSodaProducers;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.or;



/**
 * An implementation of {@link io.helidon.examples.sockshop.catalog.CatalogRepository}
 * that that uses MongoDB as a backend data store.
 */
@ApplicationScoped
@Specializes
@Traced
public class AtpSodaCatalogRepository extends DefaultCatalogRepository {

    private MongoCollection<AtpSodaSock> socks;

    @Inject
    AtpSodaCatalogRepository(MongoCollection<AtpSodaSock> socks) {
        this.socks = socks;
    }

    @PostConstruct
    void init() {
        // loadData();
        // socks.createIndex(Indexes.hashed("id"));

        AtpSodaProducers asp = new AtpSodaProducers();
        asp.dbConnect();
    }

    // @Override
    // public Collection<? extends AtpSodaSock> getSocks(String tags, String order, int pageNum, int pageSize) {
    //     ArrayList<AtpSodaSock> results = new ArrayList<>();

    //     int skipCount = pageSize * (pageNum - 1);
    //     socks.find(tagsFilter(tags))
    //             .sort(Sorts.ascending(order))
    //             .skip(skipCount)
    //             .limit(pageSize)
    //             .forEach((Consumer<? super AtpSodaSock>) results::add);

    //     return results;
    // }

    // @Override
    // public AtpSodaSock getSock(String sockId) {
    //     return socks.find(eq("id", sockId)).first();
    // }

    // @Override
    // public long getSockCount(String tags) {
    //     return socks.countDocuments(tagsFilter(tags));
    // }

    // @Override
    // public Set<String> getTags() {
    //     Set<String> tags = new HashSet<>();
    //     socks.distinct("tag", String.class)
    //             .forEach((Consumer<? super String>) tags::add);
    //     return tags;
    // }

    // @Override
    // public CatalogRepository loadData() {
    //     if (this.socks.countDocuments() == 0) {
    //         this.socks.insertMany(loadSocksFromJson(AtpSodaSock.class));
    //     }
    //     return this;
    // }

    // /**
    //  * Helper method to create tags filter.
    //  *
    //  * @param tags a comma-separated list of tags; can be {@code null}
    //  *
    //  * @return a MongoDB filter for the specified tags
    //  */
    // private Bson tagsFilter(String tags) {
    //     if (tags != null && !"".equals(tags)) {
    //         List<Bson> filters = Arrays.stream(tags.split(","))
    //                 .map(tag -> eq("tag", tag))
    //                 .collect(Collectors.toList());
    //         return or(filters);
    //     }
    //     return new BsonDocument();
    // }
}
