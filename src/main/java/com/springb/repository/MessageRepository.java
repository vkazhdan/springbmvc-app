package com.springb.repository;

import com.springb.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *
 */
public interface MessageRepository extends CrudRepository<Message, Long> {

    /**
     * Find by text.
     *
     * @param text text
     * @return {@link Message} list
     */
    List<Message> findByTextContaining(String text);
}
