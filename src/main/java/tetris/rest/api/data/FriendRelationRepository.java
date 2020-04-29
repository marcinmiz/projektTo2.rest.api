package tetris.rest.api.data;

import org.springframework.data.repository.CrudRepository;
import tetris.rest.api.model.entity.FriendRelation;

import javax.persistence.criteria.CriteriaBuilder;

public interface FriendRelationRepository extends CrudRepository<FriendRelation, Integer> {
}
