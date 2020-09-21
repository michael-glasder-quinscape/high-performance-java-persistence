package com.vladmihalcea.book.hpjp.hibernate.equality;

import de.conti.tires.oe.platform.common.base.Identifiable;
import org.junit.Ignore;
import org.junit.Test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Vlad Mihalcea
 */
public class DefaultEqualityTest
        extends AbstractEqualityCheckTest<DefaultEqualityTest.Post> {

    @Override
    protected Class<?>[] entities() {
        return new Class[]{
            Post.class
        };
    }

    @Test
    @Ignore
    public void testEquality() {
        Post post = new Post();
        post.setTitle("High-PerformanceJava Persistence");

        assertEqualityConsistency(Post.class, post);
    }

    @Entity(name = "Post")
    @Table(name = "post")
    public static class Post implements Identifiable<Long> {
        @Id
        @GeneratedValue
        private Long id;

        private String title;

        public Long getIdentifier() {
            return id;
        }

        public void setIdentifier(Long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
